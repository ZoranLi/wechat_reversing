package com.google.android.gms.c;

import android.content.Context;
import java.util.regex.Pattern;

public final class t {
    private static Pattern aAl = null;

    public static boolean J(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int ca(int i) {
        return i / 1000;
    }

    public static boolean cb(int i) {
        return (i % 1000) / 100 == 3;
    }
}
