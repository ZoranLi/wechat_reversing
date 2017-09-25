package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.z;
import android.util.DisplayMetrics;

public final class g extends LinearLayoutManager {
    public g(Context context) {
    }

    public final void a(RecyclerView recyclerView, int i) {
        p anonymousClass1 = new z(this, recyclerView.getContext()) {
            final /* synthetic */ g miu;

            public final PointF aW(int i) {
                return this.miu.aW(i);
            }

            protected final float a(DisplayMetrics displayMetrics) {
                return 50.0f / ((float) displayMetrics.densityDpi);
            }
        };
        anonymousClass1.aaG = i;
        a(anonymousClass1);
    }
}
