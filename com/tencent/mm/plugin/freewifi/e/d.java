package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    private String fEN;
    private String fGV;
    private int lUb;

    private static class a {
        public static d lUc = new d();
    }

    public final synchronized boolean j(int i, String str, String str2) {
        boolean z = true;
        synchronized (this) {
            boolean z2;
            w.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", new Object[]{Integer.valueOf(i), str, str2});
            if (i == 1 || i == 2 || i == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (m.wx(str) || m.wx(str2)) {
                    z = false;
                } else if (str.equals(this.fEN) && str2.equals(this.fGV) && this.lUb != i) {
                    z = false;
                } else {
                    this.lUb = i;
                    this.fEN = str;
                    this.fGV = str2;
                }
            }
        }
        return z;
    }
}
