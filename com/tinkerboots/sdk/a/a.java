package com.tinkerboots.sdk.a;

import com.tinkerboots.sdk.a.a.b;

public final class a {
    private static volatile a xmo;
    public b xmn;
    public long xmp = 10800000;
    public final com.tinkerboots.sdk.a.b.a xmq = com.tinkerboots.sdk.a.b.a.chV();
    public boolean xmr;

    private a(b bVar) {
        this.xmn = bVar;
    }

    public static a a(b bVar) {
        if (xmo != null) {
            throw new RuntimeException("tinker server client is already init");
        }
        if (xmo == null) {
            synchronized (com.tinkerboots.sdk.a.b.a.class) {
                if (xmo == null) {
                    xmo = new a(bVar);
                }
            }
        }
        return xmo;
    }
}
