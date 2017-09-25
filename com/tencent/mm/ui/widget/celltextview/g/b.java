package com.tencent.mm.ui.widget.celltextview.g;

import android.content.Context;

public final class b {
    public static float f(Context context, float f) {
        if (context == null || f < 0.0f) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density * f;
    }
}
