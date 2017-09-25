package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewGroup;

public final class f {
    public static float cE(View view) {
        return (float) Math.abs((view.getRight() - view.getLeft()) / 2);
    }

    public static float cF(View view) {
        return (float) Math.abs((view.getBottom() - view.getTop()) / 2);
    }

    public static int a(ViewGroup viewGroup, float f, float f2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(viewGroup.getChildAt(childCount), f, f2)) {
                return childCount;
            }
        }
        return -1;
    }

    public static boolean c(View view, float f, float f2) {
        if (f < ((float) view.getLeft()) || f > ((float) view.getRight()) || f2 < ((float) view.getTop()) || f2 > ((float) view.getBottom())) {
            return false;
        }
        return true;
    }
}
