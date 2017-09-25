package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.w;

public final class f extends e implements a {
    private String lRc = this.intent.getStringExtra("free_wifi_passowrd");

    public f(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        w.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), this.lRc});
    }

    public final void connect() {
        final c cVar = new c(this.ssid, this.lUd, this.lRc);
        j.awA();
        j.awF().awp().post(new Runnable(this) {
            final /* synthetic */ f lUi;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r8 = this;
                r5 = 1;
                r1 = 0;
                r2 = r0;
                r0 = new com.tencent.mm.plugin.freewifi.e.f$1$1;
                r0.<init>(r8);
                r3 = new com.tencent.mm.plugin.freewifi.c$1;
                r3.<init>(r2, r0);
                r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
                r4 = "connectivity";
                r0 = r0.getSystemService(r4);
                r0 = (android.net.ConnectivityManager) r0;
                r0 = r0.getNetworkInfo(r5);
                r0 = r0.isConnected();
                if (r0 == 0) goto L_0x0035;
            L_0x0025:
                r0 = r2.ssid;
                r4 = com.tencent.mm.plugin.freewifi.model.d.aww();
                r0 = r0.equals(r4);
                if (r0 == 0) goto L_0x0035;
            L_0x0031:
                r3.onSuccess();
            L_0x0034:
                return;
            L_0x0035:
                r0 = java.lang.Thread.currentThread();
                r4 = android.os.Looper.getMainLooper();
                r4 = r4.getThread();
                if (r0 != r4) goto L_0x004c;
            L_0x0043:
                r0 = new java.lang.RuntimeException;
                r1 = "ConnectNetworkHelper组件不能在主线程中运行。";
                r0.<init>(r1);
                throw r0;
            L_0x004c:
                r0 = new com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper$2;
                r0.<init>(r2);
                r2.lQX = r0;
                r0 = new android.content.IntentFilter;
                r0.<init>();
                r4 = "android.net.wifi.STATE_CHANGE";
                r0.addAction(r4);
                r4 = "android.net.wifi.supplicant.STATE_CHANGE";
                r0.addAction(r4);
                r4 = r2.lQU;	 Catch:{ all -> 0x012f }
                r4.lock();	 Catch:{ all -> 0x012f }
                r4 = r2.activity;	 Catch:{ all -> 0x012f }
                r5 = r2.lQX;	 Catch:{ all -> 0x012f }
                r4.registerReceiver(r5, r0);	 Catch:{ all -> 0x012f }
                r0 = r2.aPM;	 Catch:{ all -> 0x012f }
                r0 = r0.isWifiEnabled();	 Catch:{ all -> 0x012f }
                if (r0 != 0) goto L_0x00a7;
            L_0x0078:
                r0 = new com.tencent.mm.plugin.freewifi.e;	 Catch:{ all -> 0x012f }
                r4 = r2.activity;	 Catch:{ all -> 0x012f }
                r0.<init>(r4);	 Catch:{ all -> 0x012f }
                r0 = r0.avR();	 Catch:{ all -> 0x012f }
                r4 = "MicroMsg.FreeWifi.ConnectSsidPasswordHelper";
                r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012f }
                r6 = "enable ret = ";
                r5.<init>(r6);	 Catch:{ all -> 0x012f }
                r5 = r5.append(r0);	 Catch:{ all -> 0x012f }
                r5 = r5.toString();	 Catch:{ all -> 0x012f }
                com.tencent.mm.sdk.platformtools.w.i(r4, r5);	 Catch:{ all -> 0x012f }
                if (r0 == 0) goto L_0x00a7;
            L_0x009b:
                r3.mF(r0);	 Catch:{ all -> 0x012f }
                r2.avP();
                r0 = r2.lQU;
                r0.unlock();
                goto L_0x0034;
            L_0x00a7:
                r0 = r2.ssid;	 Catch:{ all -> 0x012f }
                r4 = r2.lRc;	 Catch:{ all -> 0x012f }
                r5 = 3;
                r6 = 0;
                r0 = com.tencent.mm.plugin.freewifi.model.d.d(r0, r4, r5, r6);	 Catch:{ all -> 0x012f }
                if (r0 == 0) goto L_0x00c3;
            L_0x00b3:
                r2.avP();	 Catch:{ all -> 0x012f }
                r3.mF(r0);	 Catch:{ all -> 0x012f }
                r2.avP();
                r0 = r2.lQU;
                r0.unlock();
                goto L_0x0034;
            L_0x00c3:
                r0 = r2.connected;	 Catch:{ InterruptedException -> 0x00e6 }
                if (r0 != 0) goto L_0x0143;
            L_0x00c7:
                r0 = r2.lRb;	 Catch:{ InterruptedException -> 0x00e6 }
                if (r0 != 0) goto L_0x0143;
            L_0x00cb:
                r0 = r2.fuI;	 Catch:{ InterruptedException -> 0x00e6 }
                r4 = r2.hto;	 Catch:{ InterruptedException -> 0x00e6 }
                r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x00e6 }
                r0 = r0.await(r4, r1);	 Catch:{ InterruptedException -> 0x00e6 }
            L_0x00d5:
                if (r0 != 0) goto L_0x0127;
            L_0x00d7:
                r0 = -16;
                r3.mF(r0);	 Catch:{ all -> 0x012f }
            L_0x00dc:
                r2.avP();
                r0 = r2.lQU;
                r0.unlock();
                goto L_0x0034;
            L_0x00e6:
                r0 = move-exception;
                r1 = "MicroMsg.FreeWifi.ConnectSsidPasswordHelper";
                r4 = "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s";
                r5 = 3;
                r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x012f }
                r6 = 0;
                r7 = r2.activity;	 Catch:{ all -> 0x012f }
                r7 = r7.getIntent();	 Catch:{ all -> 0x012f }
                r7 = com.tencent.mm.plugin.freewifi.m.y(r7);	 Catch:{ all -> 0x012f }
                r5[r6] = r7;	 Catch:{ all -> 0x012f }
                r6 = 1;
                r7 = r2.activity;	 Catch:{ all -> 0x012f }
                r7 = r7.getIntent();	 Catch:{ all -> 0x012f }
                r7 = com.tencent.mm.plugin.freewifi.m.z(r7);	 Catch:{ all -> 0x012f }
                r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x012f }
                r5[r6] = r7;	 Catch:{ all -> 0x012f }
                r6 = 2;
                r0 = r0.getMessage();	 Catch:{ all -> 0x012f }
                r5[r6] = r0;	 Catch:{ all -> 0x012f }
                com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);	 Catch:{ all -> 0x012f }
                r0 = -17;
                r3.mF(r0);	 Catch:{ all -> 0x012f }
                r2.avP();
                r0 = r2.lQU;
                r0.unlock();
                goto L_0x0034;
            L_0x0127:
                r0 = r2.connected;	 Catch:{ all -> 0x012f }
                if (r0 == 0) goto L_0x0139;
            L_0x012b:
                r3.onSuccess();	 Catch:{ all -> 0x012f }
                goto L_0x00dc;
            L_0x012f:
                r0 = move-exception;
                r2.avP();
                r1 = r2.lQU;
                r1.unlock();
                throw r0;
            L_0x0139:
                r0 = r2.lRb;	 Catch:{ all -> 0x012f }
                if (r0 == 0) goto L_0x00dc;
            L_0x013d:
                r0 = -18;
                r3.mF(r0);	 Catch:{ all -> 0x012f }
                goto L_0x00dc;
            L_0x0143:
                r0 = r1;
                goto L_0x00d5;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.e.f.1.run():void");
            }
        });
    }
}
