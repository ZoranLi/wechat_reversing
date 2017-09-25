package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

class RadarSpecialSmoothScrollView extends ScrollView {
    private Rect fv = new Rect();
    private RadarSpecialTableLayout oIg;
    private TranslateAnimation oIh;
    private a oIi = new a();
    private float yO;

    private static class a implements Interpolator {
        private float oIj = 1.3f;

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (((f2 * (this.oIj + 1.0f)) + this.oIj) * (f2 * f2)) + 1.0f;
        }
    }

    public RadarSpecialSmoothScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.oIg = (RadarSpecialTableLayout) getChildAt(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oIg == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.yO = motionEvent.getY();
                break;
            case 1:
                this.yO = 0.0f;
                if (aVN()) {
                    ZB();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY();
                if (this.yO == 0.0f) {
                    this.yO = y;
                }
                if (aVM()) {
                    int i = (int) (this.yO - y);
                    scrollBy(0, i);
                    if (this.fv.isEmpty()) {
                        this.fv.set(this.oIg.getLeft(), this.oIg.getTop(), this.oIg.getRight(), this.oIg.getBottom());
                    }
                    this.oIg.m(this.oIg.getLeft(), this.oIg.getTop() - (i / 2), this.oIg.getRight(), this.oIg.getBottom() - (i / 2));
                } else {
                    scrollBy(0, ((int) (this.yO - y)) / 2);
                }
                this.yO = y;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ZB() {
        this.oIh = new TranslateAnimation(0.0f, 0.0f, (float) (this.oIg.getTop() - this.fv.top), 0.0f);
        this.oIh.setInterpolator(this.oIi);
        this.oIh.setDuration((long) Math.abs(this.oIg.getTop() - this.fv.top));
        this.oIg.startAnimation(this.oIh);
        this.oIg.m(this.fv.left, this.fv.top, this.fv.right, this.fv.bottom);
        this.fv.setEmpty();
    }

    public boolean aVN() {
        return !this.fv.isEmpty();
    }

    public boolean aVM() {
        int measuredHeight = this.oIg.getMeasuredHeight() - getHeight();
        int scrollY = getScrollY();
        if (scrollY == 0 || scrollY == measuredHeight) {
            return true;
        }
        return false;
    }
}
