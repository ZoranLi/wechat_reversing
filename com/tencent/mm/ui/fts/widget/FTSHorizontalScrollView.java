package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.HorizontalScrollView;
import com.tencent.mm.sdk.platformtools.w;

public class FTSHorizontalScrollView extends HorizontalScrollView {
    private Rect mwW = new Rect();
    private View wio;
    private float wip;
    private long wiq;
    private OnClickListener wir;

    public FTSHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.wio = getChildAt(0);
        }
        super.onFinishInflate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        if (motionEvent == null) {
            return super.onTouchEvent(motionEvent);
        }
        w.i("MicroMsg.FTSHorizontalScrollView", "MotionEvent x: %.2f %d", new Object[]{Float.valueOf(motionEvent.getX()), Integer.valueOf(motionEvent.getAction())});
        switch (motionEvent.getAction()) {
            case 0:
                this.wip = motionEvent.getX();
                are();
                break;
            case 1:
                if (this.wio.getLeft() <= -100 && this.wir != null && System.currentTimeMillis() - this.wiq > 2000) {
                    w.i("MicroMsg.FTSHorizontalScrollView", "onClickMore!");
                    setTag("more-swipe");
                    this.wir.onClick(this);
                    this.wiq = System.currentTimeMillis();
                }
                if (this.mwW.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    Animation translateAnimation = new TranslateAnimation((float) this.wio.getLeft(), 0.0f, (float) this.mwW.left, 0.0f);
                    translateAnimation.setDuration(1000);
                    this.wio.setAnimation(translateAnimation);
                    this.wio.layout(this.mwW.left, this.mwW.top, this.mwW.right, this.mwW.bottom);
                    this.mwW.setEmpty();
                    scrollBy(-this.mwW.left, 0);
                }
                this.wip = 0.0f;
                break;
            case 2:
                if (this.wip == 0.0f) {
                    this.wip = motionEvent.getX();
                }
                float f = this.wip;
                float x = motionEvent.getX();
                int i2 = (((int) (f - x)) * 2) / 3;
                if (this.wio.getLeft() - i2 >= 0) {
                    i2 = -this.wio.getLeft();
                }
                scrollBy(i2, 0);
                this.wip = x;
                int measuredWidth = this.wio.getMeasuredWidth() - getWidth();
                int scrollX = getScrollX();
                boolean z = scrollX == 0 || measuredWidth == scrollX;
                if (z) {
                    if (this.mwW.isEmpty()) {
                        this.mwW.set(this.wio.getLeft(), this.wio.getTop(), this.wio.getRight(), this.wio.getBottom());
                    }
                    this.wio.layout(this.wio.getLeft() - i2, this.wio.getTop(), this.wio.getRight() - i2, this.wio.getBottom());
                }
                w.i("MicroMsg.FTSHorizontalScrollView", "distanceX %d preX %.2f nowX %.2f  isNeedMoveResult %b getX %d", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(x), Boolean.valueOf(z), Integer.valueOf(this.wio.getLeft())});
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean are() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        IBinder windowToken = getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            w.e("MicroMsg.FTSHorizontalScrollView", "hide VKB exception %s", new Object[]{e});
            hideSoftInputFromWindow = false;
        }
        w.v("MicroMsg.FTSHorizontalScrollView", "hide VKB result %B", new Object[]{Boolean.valueOf(hideSoftInputFromWindow)});
        return hideSoftInputFromWindow;
    }
}
