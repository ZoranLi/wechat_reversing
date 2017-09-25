package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class RadarSpecialGridView extends RadarSpecialSmoothScrollView {
    protected a oIc = null;
    protected RadarSpecialTableLayout oId = null;
    private int oIe = 0;
    private int oIf = 0;

    public interface a {
        void e(int i, View view);
    }

    public final /* bridge */ /* synthetic */ void ZB() {
        super.ZB();
    }

    public final /* bridge */ /* synthetic */ boolean aVM() {
        return super.aVM();
    }

    public final /* bridge */ /* synthetic */ boolean aVN() {
        return super.aVN();
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public RadarSpecialGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        aVL();
    }

    public RadarSpecialGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aVL();
    }

    private void aVL() {
        this.oId = new RadarSpecialTableLayout(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.oId.setLayoutParams(layoutParams);
        this.oId.setStretchAllColumns(true);
        this.oId.setShrinkAllColumns(true);
        this.oId.setGravity(80);
        addView(this.oId);
    }

    public final void a(a aVar) {
        if (this.oIc == null) {
            this.oIc = aVar;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int scrollX;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            scrollX = (getScrollX() + childAt.getWidth()) - this.oIf;
            this.oIf = childAt.getWidth();
            if (scrollX <= 0) {
                scrollX = 0;
            }
        } else {
            scrollX = getScrollX();
        }
        if (getChildCount() > 0) {
            View childAt2 = getChildAt(0);
            int scrollY = (getScrollY() + childAt2.getHeight()) - this.oIe;
            this.oIe = childAt2.getHeight();
            if (scrollY > 0) {
                i5 = scrollY;
            }
        } else {
            i5 = getScrollY();
        }
        scrollTo(scrollX, i5);
    }
}
