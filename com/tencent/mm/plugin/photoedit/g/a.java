package com.tencent.mm.plugin.photoedit.g;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static String Cx(String str) {
        return e.gSy + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), str});
    }

    public static int ad(float f) {
        return (int) ((ab.getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = 1;
        while (options.outWidth / i4 > i) {
            i4++;
        }
        while (i3 / i4 > i2) {
            i4++;
        }
        return i4;
    }
}
