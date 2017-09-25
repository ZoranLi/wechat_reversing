package com.tencent.d.a.c;

public class d {
    private static d wZA = null;
    public String wZB = a.wZy;

    public static d cfK() {
        if (wZA != null) {
            return wZA;
        }
        d dVar;
        synchronized (d.class) {
            if (wZA == null) {
                wZA = new d();
            }
            dVar = wZA;
        }
        return dVar;
    }
}
