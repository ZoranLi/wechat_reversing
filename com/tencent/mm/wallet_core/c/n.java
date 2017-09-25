package com.tencent.mm.wallet_core.c;

import java.util.UUID;

public final class n {
    private static boolean wEi = false;
    private static int wEj = -1;
    private static String wEk = "";

    public static boolean ccc() {
        return wEi;
    }

    public static int ccd() {
        return wEj;
    }

    public static String cce() {
        return wEk;
    }

    public static void CH(int i) {
        if (!wEi) {
            wEi = true;
            wEj = i;
            wEk = UUID.randomUUID().toString();
        }
    }

    public static void ccf() {
        wEi = false;
        wEj = -1;
        wEk = "";
    }
}
