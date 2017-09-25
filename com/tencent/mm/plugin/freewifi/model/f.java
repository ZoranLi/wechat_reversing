package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.w;

public final class f {
    private b lTk;

    private static class a {
        public static f lTl = new f();
    }

    public static final class b {
        public long lTc;
        public String lTm;
        public String lTn;
        public String lTo;
        public boolean lTp = false;

        public b(String str, String str2, String str3, long j) {
            this.lTm = m.wy(str);
            this.lTn = str2;
            this.lTo = str3;
            this.lTc = j;
        }
    }

    public final synchronized void awx() {
        if (this.lTk != null) {
            w.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[]{this.lTk.lTm, this.lTk.lTn});
        } else {
            w.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
        }
        this.lTk = null;
        w.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory is null.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(android.net.wifi.WifiInfo r8) {
        /*
        r7 = this;
        r6 = 1;
        r0 = 0;
        monitor-enter(r7);
        if (r8 == 0) goto L_0x0017;
    L_0x0005:
        r1 = r8.getSSID();	 Catch:{ all -> 0x00b7 }
        if (r1 == 0) goto L_0x0017;
    L_0x000b:
        r1 = r8.getBSSID();	 Catch:{ all -> 0x00b7 }
        if (r1 == 0) goto L_0x0017;
    L_0x0011:
        r1 = r8.getMacAddress();	 Catch:{ all -> 0x00b7 }
        if (r1 != 0) goto L_0x0022;
    L_0x0017:
        r1 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r2 = "WifiInfo got Currently is null. Cannot compared with last WifiInfo.";
        com.tencent.mm.sdk.platformtools.w.i(r1, r2);	 Catch:{ all -> 0x00b7 }
    L_0x0020:
        monitor-exit(r7);
        return r0;
    L_0x0022:
        r1 = r7.lTk;	 Catch:{ all -> 0x00b7 }
        if (r1 == 0) goto L_0x00ad;
    L_0x0026:
        r1 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r2 = "last WifiInfo stored in memmory : ssid=%s, bssid=%s ";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b7 }
        r4 = 0;
        r5 = r7.lTk;	 Catch:{ all -> 0x00b7 }
        r5 = r5.lTm;	 Catch:{ all -> 0x00b7 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b7 }
        r4 = 1;
        r5 = r7.lTk;	 Catch:{ all -> 0x00b7 }
        r5 = r5.lTn;	 Catch:{ all -> 0x00b7 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b7 }
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ all -> 0x00b7 }
        r1 = r8.getSSID();	 Catch:{ all -> 0x00b7 }
        r1 = com.tencent.mm.plugin.freewifi.m.wy(r1);	 Catch:{ all -> 0x00b7 }
        r2 = r7.lTk;	 Catch:{ all -> 0x00b7 }
        r2 = r2.lTm;	 Catch:{ all -> 0x00b7 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x00b7 }
        if (r1 == 0) goto L_0x0060;
    L_0x0052:
        r1 = r8.getBSSID();	 Catch:{ all -> 0x00b7 }
        r2 = r7.lTk;	 Catch:{ all -> 0x00b7 }
        r2 = r2.lTn;	 Catch:{ all -> 0x00b7 }
        r1 = r1.equalsIgnoreCase(r2);	 Catch:{ all -> 0x00b7 }
        if (r1 != 0) goto L_0x0020;
    L_0x0060:
        r3 = r8.getMacAddress();	 Catch:{ all -> 0x00b7 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00b7 }
        r1 = 22;
        if (r0 <= r1) goto L_0x0079;
    L_0x006a:
        if (r3 == 0) goto L_0x0075;
    L_0x006c:
        r0 = "02:00:00:00:00:00";
        r0 = r3.equals(r0);	 Catch:{ all -> 0x00b7 }
        if (r0 == 0) goto L_0x0079;
    L_0x0075:
        r3 = com.tencent.mm.plugin.freewifi.m.awe();	 Catch:{ all -> 0x00b7 }
    L_0x0079:
        r0 = new com.tencent.mm.plugin.freewifi.model.f$b;	 Catch:{ all -> 0x00b7 }
        r1 = r8.getSSID();	 Catch:{ all -> 0x00b7 }
        r1 = com.tencent.mm.plugin.freewifi.m.wy(r1);	 Catch:{ all -> 0x00b7 }
        r2 = r8.getBSSID();	 Catch:{ all -> 0x00b7 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00b7 }
        r0.<init>(r1, r2, r3, r4);	 Catch:{ all -> 0x00b7 }
        r7.lTk = r0;	 Catch:{ all -> 0x00b7 }
        r0 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r1 = "new WifiInfo stored in memmory : ssid=%s, bssid=%s ";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00b7 }
        r3 = 0;
        r4 = r7.lTk;	 Catch:{ all -> 0x00b7 }
        r4 = r4.lTm;	 Catch:{ all -> 0x00b7 }
        r2[r3] = r4;	 Catch:{ all -> 0x00b7 }
        r3 = 1;
        r4 = r7.lTk;	 Catch:{ all -> 0x00b7 }
        r4 = r4.lTn;	 Catch:{ all -> 0x00b7 }
        r2[r3] = r4;	 Catch:{ all -> 0x00b7 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);	 Catch:{ all -> 0x00b7 }
        r0 = r6;
        goto L_0x0020;
    L_0x00ad:
        r0 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r1 = "last WifiInfo stored in memmory is null.";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ all -> 0x00b7 }
        goto L_0x0060;
    L_0x00b7:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.f.a(android.net.wifi.WifiInfo):boolean");
    }

    public final synchronized b awy() {
        return this.lTk;
    }

    public final synchronized void awz() {
        if (this.lTk != null) {
            b bVar;
            b bVar2 = this.lTk;
            if (bVar2.lTp) {
                bVar = bVar2;
            } else {
                bVar = new b(bVar2.lTm, bVar2.lTn, bVar2.lTo, bVar2.lTc);
                bVar.lTp = true;
            }
            this.lTk = bVar;
        }
    }
}
