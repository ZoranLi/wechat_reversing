package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.w;

public class SnsAdNativeLandingPagesScrollView extends NestedScrollView {
    private int qxL = 0;
    private int qxM = 0;
    private int qxN = 50;
    private am qxO = null;
    private long qxP = System.currentTimeMillis();
    private Runnable qxQ = new Runnable(this) {
        final /* synthetic */ SnsAdNativeLandingPagesScrollView qxR;

        {
            this.qxR = r1;
        }

        public final void run() {
            int scrollY = this.qxR.getScrollY();
            w.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", new Object[]{Integer.valueOf(this.qxR.qxM), Integer.valueOf(scrollY)});
            if (scrollY != this.qxR.qxM) {
                if (this.qxR.qxO != null) {
                    this.qxR.qxO;
                    this.qxR.qxL;
                }
                this.qxR.qxP = System.currentTimeMillis();
            }
            if (this.qxR.qxM - scrollY == 0) {
                if (this.qxR.qxO != null) {
                    this.qxR.qxO;
                    this.qxR.qxM;
                    this.qxR.qxL;
                }
                this.qxR.qxL = this.qxR.qxM;
            }
            this.qxR.qxM = this.qxR.getScrollY();
            w.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", new Object[]{Integer.valueOf(this.qxR.qxM), Integer.valueOf(scrollY)});
            this.qxR.postDelayed(this.qxR.qxQ, (long) this.qxR.qxN);
        }
    };

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        w.w("SnsAdNativeLandingPagesScrollView", "onScrollChanged x %d,y %d,oldx %d,oldy %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
    }

    public final void fling(int i) {
        super.fling(i / 3);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }
}
