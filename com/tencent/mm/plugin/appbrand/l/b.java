package com.tencent.mm.plugin.appbrand.l;

public final class b {
    public static String aM(Object obj) {
        return "Token@" + (obj != null ? Integer.valueOf(obj.hashCode()) : "null");
    }

    public static String aF(long j) {
        return "Token@" + j;
    }
}
