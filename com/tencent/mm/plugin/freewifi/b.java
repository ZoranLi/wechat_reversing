package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    private WifiManager aPM;
    private Context context;
    public Condition fuI;
    private long hto = 15000;
    public Lock lQU;
    public boolean lQV = false;
    public boolean lQW = false;
    private BroadcastReceiver lQX;
    public String ssid;

    public b(String str, Context context) {
        this.ssid = str;
        this.lQU = new ReentrantLock();
        this.fuI = this.lQU.newCondition();
        this.aPM = (WifiManager) context.getSystemService("wifi");
        this.context = context;
    }

    public final int avQ() {
        if (((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.aww())) {
            return 0;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
        }
        this.lQX = new BroadcastReceiver(this) {
            final /* synthetic */ b lRa;

            {
                this.lRa = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                NetworkInfo networkInfo;
                if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                    networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo != null) {
                        w.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[]{this.lRa.ssid, m.wA("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString()});
                    }
                    if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.lRa.ssid.equals(m.wy(networkInfo.getExtraInfo()))) {
                        try {
                            this.lRa.lQU.lock();
                            this.lRa.lQV = true;
                            w.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                            this.lRa.fuI.signalAll();
                        } finally {
                            this.lRa.lQU.unlock();
                        }
                    }
                } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo != null) {
                        w.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[]{this.lRa.ssid, m.wA("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString()});
                    }
                    if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.lRa.ssid.equals(m.wy(networkInfo.getExtraInfo()))) {
                        try {
                            this.lRa.lQU.lock();
                            this.lRa.lQW = true;
                            w.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                            this.lRa.fuI.signalAll();
                        } finally {
                            this.lRa.lQU.unlock();
                        }
                    }
                }
            }
        };
        try {
            int avR;
            this.lQU.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.context.registerReceiver(this.lQX, intentFilter);
            if (!this.aPM.isWifiEnabled()) {
                avR = new f(this.context).avR();
                w.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = " + avR);
                if (avR != 0) {
                    return avR;
                }
            }
            avR = d.wH(this.ssid);
            if (avR != 0) {
                avP();
                avP();
                this.lQU.unlock();
                return avR;
            }
            boolean z = false;
            while (true) {
                if (!this.lQV || !this.lQW) {
                    long currentTimeMillis = System.currentTimeMillis();
                    z = this.fuI.await(this.hto, TimeUnit.MILLISECONDS);
                    if (!z) {
                        break;
                    }
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    this.hto -= currentTimeMillis;
                    w.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + currentTimeMillis + "; left timeout=" + this.hto);
                    this.hto = this.hto > 0 ? this.hto : 3000;
                } else {
                    break;
                }
            }
            if (!z) {
                return -16;
            }
            avP();
            this.lQU.unlock();
            return 0;
        } catch (InterruptedException e) {
            w.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[]{e.getMessage()});
            return -17;
        } finally {
            avP();
            this.lQU.unlock();
        }
    }

    private void avP() {
        try {
            this.context.unregisterReceiver(this.lQX);
        } catch (IllegalArgumentException e) {
        }
    }
}
