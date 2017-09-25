package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bg;

public final class n {
    public static String dz(String str) {
        if (str == null || p.gRl.gPZ == 2 || p.gRl.gQk == 1) {
            return str;
        }
        if (p.gRl.gPZ == 1) {
            if (str.toString().contains("\n")) {
                return str.toString().replace("\n", " ");
            }
            return str;
        } else if (VERSION.SDK_INT == 16 && str.toString().contains("\n") && bg.ap(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0) {
            return str.toString().replace("\n", " ");
        } else {
            return str;
        }
    }
}
