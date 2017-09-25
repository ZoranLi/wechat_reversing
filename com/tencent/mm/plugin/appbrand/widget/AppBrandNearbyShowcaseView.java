package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.bg.a;

public final class AppBrandNearbyShowcaseView extends FrameLayout {
    public int dO = a.fromDPToPix(getContext(), 25);
    public int jqD = a.fromDPToPix(getContext(), 19);

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void Yf() {
        if (getChildCount() > 0) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = childAt.getLayoutParams();
                LayoutParams layoutParams2 = childAt.getLayoutParams();
                int i = this.dO;
                layoutParams2.height = i;
                layoutParams.width = i;
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams3.gravity |= 5;
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin = this.jqD * childCount;
            }
            requestLayout();
            invalidate();
        }
    }

    public final void iI(int i) {
        if (i >= 0 && i != getChildCount()) {
            if (i > getChildCount()) {
                int childCount = i - getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View imageView = new ImageView(getContext());
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dO, this.dO);
                    layoutParams.gravity = 16;
                    addViewInLayout(imageView, 0, layoutParams, true);
                }
            } else if (i < getChildCount()) {
                removeViewsInLayout(0, getChildCount() - i);
            }
            Yf();
        }
    }
}
