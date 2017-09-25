package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    private WifiManager aPM;
    public Activity activity;
    public Condition fuI;
    private long hto;
    public Lock lQU;
    public boolean lQV = false;
    public boolean lQW = false;
    private BroadcastReceiver lQX;
    public String ssid;

    public interface a {
        void mF(int i);

        void onSuccess();
    }

    public a(String str, Activity activity) {
        this.activity = activity;
        this.hto = 15000;
        this.ssid = str;
        this.lQU = new ReentrantLock();
        this.fuI = this.lQU.newCondition();
        this.aPM = (WifiManager) ab.getContext().getSystemService("wifi");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final com.tencent.mm.plugin.freewifi.a.a r9) {
        /*
        r8 = this;
        r3 = 1;
        r1 = 0;
        r4 = new com.tencent.mm.plugin.freewifi.a$1;
        r4.<init>(r8, r9);
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r2 = "connectivity";
        r0 = r0.getSystemService(r2);
        r0 = (android.net.ConnectivityManager) r0;
        r0 = r0.getNetworkInfo(r3);
        r0 = r0.isConnected();
        if (r0 == 0) goto L_0x002e;
    L_0x001e:
        r0 = r8.ssid;
        r2 = com.tencent.mm.plugin.freewifi.model.d.aww();
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x002e;
    L_0x002a:
        r4.onSuccess();
    L_0x002d:
        return;
    L_0x002e:
        r0 = java.lang.Thread.currentThread();
        r2 = android.os.Looper.getMainLooper();
        r2 = r2.getThread();
        if (r0 != r2) goto L_0x0045;
    L_0x003c:
        r0 = new java.lang.RuntimeException;
        r1 = "ConnectNetworkHelper组件不能在主线程中运行。";
        r0.<init>(r1);
        throw r0;
    L_0x0045:
        r0 = new com.tencent.mm.plugin.freewifi.a$2;
        r0.<init>(r8);
        r8.lQX = r0;
        r0 = r8.lQU;	 Catch:{ all -> 0x0165 }
        r0.lock();	 Catch:{ all -> 0x0165 }
        r0 = new android.content.IntentFilter;	 Catch:{ all -> 0x0165 }
        r0.<init>();	 Catch:{ all -> 0x0165 }
        r2 = "android.net.wifi.STATE_CHANGE";
        r0.addAction(r2);	 Catch:{ all -> 0x0165 }
        r2 = "android.net.conn.CONNECTIVITY_CHANGE";
        r0.addAction(r2);	 Catch:{ all -> 0x0165 }
        r2 = r8.activity;	 Catch:{ all -> 0x0165 }
        r3 = r8.lQX;	 Catch:{ all -> 0x0165 }
        r2.registerReceiver(r3, r0);	 Catch:{ all -> 0x0165 }
        r0 = r8.aPM;	 Catch:{ all -> 0x0165 }
        r0 = r0.isWifiEnabled();	 Catch:{ all -> 0x0165 }
        if (r0 != 0) goto L_0x00a0;
    L_0x0071:
        r0 = new com.tencent.mm.plugin.freewifi.e;	 Catch:{ all -> 0x0165 }
        r2 = r8.activity;	 Catch:{ all -> 0x0165 }
        r0.<init>(r2);	 Catch:{ all -> 0x0165 }
        r0 = r0.avR();	 Catch:{ all -> 0x0165 }
        r2 = "MicroMsg.FreeWifi.ConnectNetworkHelper";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0165 }
        r5 = "enable ret = ";
        r3.<init>(r5);	 Catch:{ all -> 0x0165 }
        r3 = r3.append(r0);	 Catch:{ all -> 0x0165 }
        r3 = r3.toString();	 Catch:{ all -> 0x0165 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);	 Catch:{ all -> 0x0165 }
        if (r0 == 0) goto L_0x00a0;
    L_0x0094:
        r4.mF(r0);	 Catch:{ all -> 0x0165 }
        r8.avP();
        r0 = r8.lQU;
        r0.unlock();
        goto L_0x002d;
    L_0x00a0:
        r0 = r8.ssid;	 Catch:{ all -> 0x0165 }
        r0 = com.tencent.mm.plugin.freewifi.model.d.wH(r0);	 Catch:{ all -> 0x0165 }
        if (r0 == 0) goto L_0x00b8;
    L_0x00a8:
        r8.avP();	 Catch:{ all -> 0x0165 }
        r4.mF(r0);	 Catch:{ all -> 0x0165 }
        r8.avP();
        r0 = r8.lQU;
        r0.unlock();
        goto L_0x002d;
    L_0x00b8:
        r0 = r1;
    L_0x00b9:
        r1 = r8.lQV;	 Catch:{ InterruptedException -> 0x010c }
        if (r1 == 0) goto L_0x00c1;
    L_0x00bd:
        r1 = r8.lQW;	 Catch:{ InterruptedException -> 0x010c }
        if (r1 != 0) goto L_0x0150;
    L_0x00c1:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ InterruptedException -> 0x010c }
        r0 = r8.fuI;	 Catch:{ InterruptedException -> 0x010c }
        r6 = r8.hto;	 Catch:{ InterruptedException -> 0x010c }
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x010c }
        r0 = r0.await(r6, r1);	 Catch:{ InterruptedException -> 0x010c }
        if (r0 == 0) goto L_0x0150;
    L_0x00d1:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ InterruptedException -> 0x010c }
        r2 = r6 - r2;
        r6 = r8.hto;	 Catch:{ InterruptedException -> 0x010c }
        r6 = r6 - r2;
        r8.hto = r6;	 Catch:{ InterruptedException -> 0x010c }
        r1 = "MicroMsg.FreeWifi.ConnectNetworkHelper";
        r5 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x010c }
        r6 = "costMillis=";
        r5.<init>(r6);	 Catch:{ InterruptedException -> 0x010c }
        r2 = r5.append(r2);	 Catch:{ InterruptedException -> 0x010c }
        r3 = "; left timeout=";
        r2 = r2.append(r3);	 Catch:{ InterruptedException -> 0x010c }
        r6 = r8.hto;	 Catch:{ InterruptedException -> 0x010c }
        r2 = r2.append(r6);	 Catch:{ InterruptedException -> 0x010c }
        r2 = r2.toString();	 Catch:{ InterruptedException -> 0x010c }
        com.tencent.mm.sdk.platformtools.w.i(r1, r2);	 Catch:{ InterruptedException -> 0x010c }
        r2 = r8.hto;	 Catch:{ InterruptedException -> 0x010c }
        r6 = 0;
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x014d;
    L_0x0107:
        r2 = r8.hto;	 Catch:{ InterruptedException -> 0x010c }
    L_0x0109:
        r8.hto = r2;	 Catch:{ InterruptedException -> 0x010c }
        goto L_0x00b9;
    L_0x010c:
        r0 = move-exception;
        r1 = "MicroMsg.FreeWifi.ConnectNetworkHelper";
        r2 = "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s";
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0165 }
        r5 = 0;
        r6 = r8.activity;	 Catch:{ all -> 0x0165 }
        r6 = r6.getIntent();	 Catch:{ all -> 0x0165 }
        r6 = com.tencent.mm.plugin.freewifi.m.y(r6);	 Catch:{ all -> 0x0165 }
        r3[r5] = r6;	 Catch:{ all -> 0x0165 }
        r5 = 1;
        r6 = r8.activity;	 Catch:{ all -> 0x0165 }
        r6 = r6.getIntent();	 Catch:{ all -> 0x0165 }
        r6 = com.tencent.mm.plugin.freewifi.m.z(r6);	 Catch:{ all -> 0x0165 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0165 }
        r3[r5] = r6;	 Catch:{ all -> 0x0165 }
        r5 = 2;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0165 }
        r3[r5] = r0;	 Catch:{ all -> 0x0165 }
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ all -> 0x0165 }
        r0 = -17;
        r4.mF(r0);	 Catch:{ all -> 0x0165 }
        r8.avP();
        r0 = r8.lQU;
        r0.unlock();
        goto L_0x002d;
    L_0x014d:
        r2 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        goto L_0x0109;
    L_0x0150:
        if (r0 != 0) goto L_0x0161;
    L_0x0152:
        r0 = -16;
        r4.mF(r0);	 Catch:{ all -> 0x0165 }
    L_0x0157:
        r8.avP();
        r0 = r8.lQU;
        r0.unlock();
        goto L_0x002d;
    L_0x0161:
        r4.onSuccess();	 Catch:{ all -> 0x0165 }
        goto L_0x0157;
    L_0x0165:
        r0 = move-exception;
        r8.avP();
        r1 = r8.lQU;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.a.a(com.tencent.mm.plugin.freewifi.a$a):void");
    }

    private void avP() {
        try {
            this.activity.unregisterReceiver(this.lQX);
        } catch (IllegalArgumentException e) {
        }
    }
}
