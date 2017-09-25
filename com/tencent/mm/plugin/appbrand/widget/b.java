package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.mm.R;

public final class b {
    public static int bG(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return context.getResources().getDimensionPixelSize(R.f.aWR);
        }
        return context.getResources().getDimensionPixelSize(R.f.aWS);
    }
}
