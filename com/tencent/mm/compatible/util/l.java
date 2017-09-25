package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.mm.sdk.platformtools.bg;

public final class l {
    public static boolean qq() {
        if (bg.ap(Build.MANUFACTURER, "").toLowerCase().indexOf("samsung".toLowerCase()) >= 0) {
            return true;
        }
        return false;
    }
}
