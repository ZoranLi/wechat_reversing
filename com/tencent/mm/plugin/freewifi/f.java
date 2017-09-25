package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class f {
    private WifiManager aPM = ((WifiManager) ab.getContext().getSystemService("wifi"));
    private Context context;
    public Condition fuI = this.lQU.newCondition();
    public Lock lQU = new ReentrantLock();
    private BroadcastReceiver lQX;
    private int lRh = 10;

    public f(Context context) {
        this.context = context;
    }

    public final int avR() {
        if (3 == this.aPM.getWifiState()) {
            return 0;
        }
        this.lQX = new BroadcastReceiver(this) {
            final /* synthetic */ f lRj;

            {
                this.lRj = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    w.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=" + intExtra);
                    if (intExtra == 3) {
                        try {
                            this.lRj.lQU.lock();
                            this.lRj.fuI.signalAll();
                        } finally {
                            this.lRj.avP();
                            this.lRj.lQU.unlock();
                        }
                    }
                }
            }
        };
        try {
            this.lQU.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.context.registerReceiver(this.lQX, intentFilter);
            this.aPM.setWifiEnabled(true);
            if (this.fuI.await((long) this.lRh, TimeUnit.SECONDS)) {
                return 0;
            }
            avP();
            this.lQU.unlock();
            return 1;
        } catch (InterruptedException e) {
            return 2;
        } finally {
            avP();
            this.lQU.unlock();
        }
    }

    public final void avP() {
        try {
            this.context.unregisterReceiver(this.lQX);
        } catch (IllegalArgumentException e) {
        }
    }
}
