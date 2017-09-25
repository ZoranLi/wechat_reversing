package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.content.d;
import android.view.Display;
import android.view.WindowManager;

public final class ab {
    public static int[] cP(Context context) {
        int i;
        int i2;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            Point point = new Point();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
                i = point.x;
                i2 = point.y;
            } else {
                defaultDisplay.getSize(point);
                i = point.x;
                i2 = point.y;
            }
        } else {
            i = defaultDisplay.getWidth();
            i2 = defaultDisplay.getHeight();
        }
        return new int[]{i, i2};
    }

    public static void cQ(Context context) {
        d.k(context).b(new Intent("com.tencent.mm.adlanding.set_uioption"));
    }
}
