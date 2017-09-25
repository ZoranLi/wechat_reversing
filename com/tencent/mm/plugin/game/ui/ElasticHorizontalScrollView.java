package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.w;

public class ElasticHorizontalScrollView extends HorizontalScrollView {
    private static int mwS = 82;
    private Interpolator eW;
    protected LinearLayout jjg;
    private int mwT;
    private boolean mwU;
    private float mwV;
    private Rect mwW = new Rect();
    private float x;

    public ElasticHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            w.i("MicroMsg.ElasticHorizontalScrollView", "Get the first child of ElasticHorizontalScrollView.");
            if (childAt instanceof LinearLayout) {
                this.jjg = (LinearLayout) childAt;
                w.i("MicroMsg.ElasticHorizontalScrollView", "The first child of ElasticHorizontalScrollView is a instance of LinearLayout.");
            }
        }
        if (this.jjg == null) {
            w.i("MicroMsg.ElasticHorizontalScrollView", "The first child of ElasticHorizontalScrollView is null, so create a LinearLayout for it.");
            this.jjg = new LinearLayout(getContext());
            this.jjg.setLayoutParams(new LayoutParams(-2, -2, 3));
        }
        super.onFinishInflate();
        this.mwT = b.a(getContext(), (float) mwS);
        this.eW = new DecelerateInterpolator();
        setSmoothScrollingEnabled(true);
        this.x = -10000.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        int i2 = 0;
        if (motionEvent != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.x = motionEvent.getX();
                    this.mwV = this.x;
                    break;
                case 1:
                case 3:
                    this.mwU = motionEvent.getX() > this.mwV;
                    if (this.mwW.isEmpty()) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.jjg.startAnimation(a((float) this.jjg.getLeft(), this.jjg.getLeft() - this.mwW.left));
                        this.jjg.layout(this.mwW.left, this.mwW.top, this.mwW.right, this.mwW.bottom);
                        this.mwW.setEmpty();
                    } else {
                        this.jjg.startAnimation(a((float) aBO(), this.mwT >> 1));
                        scrollBy(aBO(), 0);
                    }
                    this.x = -10000.0f;
                    break;
                case 2:
                    float f = this.x;
                    float x = motionEvent.getX();
                    int i3 = (int) (f - x);
                    if (i3 >= 2 || i3 <= -2) {
                        if (this.x != -10000.0f) {
                            int measuredWidth = this.jjg.getMeasuredWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight());
                            int scrollX = getScrollX();
                            if (scrollX == 0 || measuredWidth == scrollX) {
                                i2 = 1;
                            }
                            if (i2 != 0) {
                                if (this.mwW.isEmpty()) {
                                    this.mwW.set(this.jjg.getLeft(), this.jjg.getTop(), this.jjg.getRight(), this.jjg.getBottom());
                                }
                                this.jjg.layout(this.jjg.getLeft() - i3, this.jjg.getTop(), this.jjg.getRight() - i3, this.jjg.getBottom());
                            }
                        } else {
                            this.mwV = x;
                        }
                        this.x = x;
                        break;
                    }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private TranslateAnimation a(float f, int i) {
        TranslateAnimation translateAnimation = new TranslateAnimation(f, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration((long) Math.abs(i));
        translateAnimation.setInterpolator(this.eW);
        return translateAnimation;
    }

    private int aBO() {
        int scrollX;
        if (this.mwU) {
            scrollX = getScrollX() % this.mwT;
            return scrollX / (this.mwT >> 1) == 0 ? -scrollX : this.mwT - scrollX;
        } else {
            scrollX = (getScrollX() + getWidth()) % this.mwT;
            return scrollX / (this.mwT >> 1) == 0 ? -scrollX : this.mwT - scrollX;
        }
    }
}
