package com.tencent.d.a.c;

public final class f {
    public static boolean mA(String str) {
        return str == null || str.length() <= 0;
    }

    public static String mz(String str) {
        return str == null ? "" : str;
    }

    public static long fb(long j) {
        return ((System.nanoTime() - j) / 1000) / 1000;
    }
}
