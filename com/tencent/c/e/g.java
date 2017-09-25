package com.tencent.c.e;

public final class g {
    private static boolean wSw;
    private static f wSx;

    static {
        wSw = false;
        wSx = new h();
        wSw = false;
        wSx = new h();
    }

    public static void i(Throwable th) {
        bS(th);
    }

    public static void bS(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Exception) {
            new StringBuilder().append(obj);
        } else {
            obj.toString();
        }
    }

    public static void bT(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Exception) {
            new StringBuilder().append(obj);
        } else {
            obj.toString();
        }
    }

    public static void Vi(String str) {
        bU(str);
    }

    public static void d(String str) {
        bU(str);
    }

    public static void bU(Object obj) {
        if (obj != null) {
            obj.toString();
        }
    }
}
