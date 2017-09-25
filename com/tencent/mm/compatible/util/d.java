package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;

public final class d {
    public static boolean eo(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean ep(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean eq(int i) {
        return VERSION.SDK_INT > i;
    }
}
