package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;

public final class b {
    public static final int amc = e.amc;
    private static final b amd = new b();

    b() {
    }

    public static Intent bN(int i) {
        return e.bO(i);
    }

    public static b jg() {
        return amd;
    }

    public static boolean k(Context context, int i) {
        return e.k(context, i);
    }

    public static int w(Context context) {
        int w = e.w(context);
        return e.k(context, w) ? 18 : w;
    }

    public static void x(Context context) {
        e.x(context);
    }
}
