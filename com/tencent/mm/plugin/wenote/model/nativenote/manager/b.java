package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class b {
    private static float svh = Float.MAX_VALUE;
    private static float svi = Float.MAX_VALUE;
    private static int svj = -1;

    public static int wR(int i) {
        return Math.round(((float) i) / bBu());
    }

    private static float bBu() {
        float f;
        synchronized (b.class) {
            if (svi == Float.MAX_VALUE) {
                Display defaultDisplay = ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                svi = displayMetrics.density * ab.getContext().getResources().getConfiguration().fontScale;
            }
            f = svi;
        }
        return f;
    }
}
