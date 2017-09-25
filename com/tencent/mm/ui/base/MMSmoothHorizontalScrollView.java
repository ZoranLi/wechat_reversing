package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class MMSmoothHorizontalScrollView extends HorizontalScrollView {
    private Interpolator eW = new DecelerateInterpolator();
    private Rect fv = new Rect();
    private TranslateAnimation oIh;
    private View vms;
    private float yN;

    public MMSmoothHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFadingEdgeLength(0);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.vms = getChildAt(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        int i2 = 0;
        if (this.vms == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.yN = motionEvent.getX();
                break;
            case 1:
            case 3:
                this.yN = 0.0f;
                if (this.fv.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    this.oIh = new TranslateAnimation((float) this.vms.getLeft(), (float) this.fv.left, 0.0f, 0.0f);
                    this.oIh.setInterpolator(this.eW);
                    this.oIh.setDuration((long) Math.abs(this.vms.getLeft() - this.fv.left));
                    this.vms.startAnimation(this.oIh);
                    this.vms.layout(this.fv.left, this.fv.top, this.fv.right, this.fv.bottom);
                    this.fv.setEmpty();
                    break;
                }
                break;
            case 2:
                float x = motionEvent.getX();
                if (this.yN == 0.0f) {
                    this.yN = x;
                }
                int i3 = ((int) (this.yN - x)) / 2;
                scrollBy(i3, 0);
                this.yN = x;
                int measuredWidth = this.vms.getMeasuredWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight());
                int scrollX = getScrollX();
                if (scrollX == 0 || scrollX == measuredWidth) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    if (this.fv.isEmpty()) {
                        this.fv.set(this.vms.getLeft(), this.vms.getTop(), this.vms.getRight(), this.vms.getBottom());
                    }
                    this.vms.layout(this.vms.getLeft() - i3, this.vms.getTop(), this.vms.getRight() - i3, this.vms.getBottom());
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
