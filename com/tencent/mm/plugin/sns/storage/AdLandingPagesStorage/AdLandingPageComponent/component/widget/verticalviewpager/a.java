package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;

public final class a implements OnTouchListener {
    private float jzV = Float.MIN_VALUE;
    private DummyViewPager qlu;
    private float qlv = Float.MIN_VALUE;

    public a(DummyViewPager dummyViewPager) {
        this.qlu = dummyViewPager;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        new StringBuilder("onTouchEvent , action ").append(motionEvent.getAction()).append(", e.rawY ").append(motionEvent.getRawY()).append(",lastMotionY ").append(this.qlv).append(",downY ").append(this.jzV);
        switch (motionEvent.getAction()) {
            case 0:
                this.jzV = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                if (this.qlu.yT) {
                    try {
                        AdLandingViewPager adLandingViewPager = this.qlu;
                        if (adLandingViewPager.yT) {
                            VelocityTracker velocityTracker = adLandingViewPager.fk;
                            velocityTracker.computeCurrentVelocity(1000, (float) adLandingViewPager.yQ);
                            int a = (int) y.a(velocityTracker, adLandingViewPager.fl);
                            adLandingViewPager.yI = true;
                            int bP = adLandingViewPager.bP();
                            int scrollX = adLandingViewPager.getScrollX();
                            b bgI = adLandingViewPager.bgI();
                            adLandingViewPager.a(adLandingViewPager.a(bgI.position, ((((float) scrollX) / ((float) bP)) - bgI.zn) / bgI.zm, a, (int) (adLandingViewPager.yN - adLandingViewPager.xC)), true, true, a);
                            adLandingViewPager.cz();
                            adLandingViewPager.yT = false;
                        } else {
                            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
                        }
                    } catch (Exception e) {
                    }
                }
                this.jzV = Float.MIN_VALUE;
                this.qlv = Float.MIN_VALUE;
                break;
            case 2:
                if (this.jzV == Float.MIN_VALUE && this.qlv == Float.MIN_VALUE) {
                    this.jzV = motionEvent.getRawY();
                    break;
                }
                float rawY = motionEvent.getRawY() - (this.qlv == Float.MIN_VALUE ? this.jzV : this.qlv);
                this.qlv = motionEvent.getRawY();
                float f = rawY / 2.0f;
                new StringBuilder("scrollX ").append(this.qlu.getScrollX()).append(",basescrollX ").append(this.qlu.bgK());
                if (this.qlu.getScrollX() == this.qlu.bgK()) {
                    if (z.h(view, (-f) > 0.0f ? 1 : -1)) {
                        new StringBuilder("scroll vertically  ").append(f).append(", move.lastMotionY ").append(motionEvent.getY());
                        break;
                    }
                    this.qlu.bgJ();
                    a(view, motionEvent, f);
                    c(view, motionEvent);
                    return false;
                } else if (a(view, motionEvent, f)) {
                    return false;
                }
                break;
        }
        return view.onTouchEvent(motionEvent);
    }

    private boolean a(View view, MotionEvent motionEvent, float f) {
        if (!this.qlu.yT) {
            return false;
        }
        boolean z;
        float scrollX;
        float scrollX2 = (float) (((int) (((float) this.qlu.getScrollX()) - f)) - this.qlu.bgK());
        float scrollX3 = (float) (this.qlu.getScrollX() - this.qlu.bgK());
        if (Math.abs(scrollX2 + scrollX3) < Math.abs(scrollX2 - scrollX3)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            scrollX = (float) (this.qlu.getScrollX() - this.qlu.bgK());
        } else {
            scrollX = f;
        }
        AdLandingViewPager adLandingViewPager = this.qlu;
        if (adLandingViewPager.yT) {
            adLandingViewPager.yN += scrollX;
            float scrollX4 = ((float) adLandingViewPager.getScrollX()) - scrollX;
            int bP = adLandingViewPager.bP();
            float f2 = ((float) bP) * adLandingViewPager.yE;
            b bVar = (b) adLandingViewPager.eh.get(0);
            b bVar2 = (b) adLandingViewPager.eh.get(adLandingViewPager.eh.size() - 1);
            scrollX2 = bVar.position != 0 ? bVar.zn * ((float) bP) : ((float) bP) * adLandingViewPager.yD;
            scrollX3 = bVar2.position != adLandingViewPager.yr.getCount() + -1 ? bVar2.zn * ((float) bP) : f2;
            if (scrollX4 >= scrollX2) {
                scrollX2 = scrollX4 > scrollX3 ? scrollX3 : scrollX4;
            }
            adLandingViewPager.yN += scrollX2 - ((float) ((int) scrollX2));
            adLandingViewPager.scrollTo((int) scrollX2, adLandingViewPager.getScrollY());
            adLandingViewPager.ab((int) scrollX2);
            MotionEvent obtain = MotionEvent.obtain(adLandingViewPager.qll, SystemClock.uptimeMillis(), 2, adLandingViewPager.yN, 0.0f, 0);
            adLandingViewPager.fk.addMovement(obtain);
            obtain.recycle();
            new StringBuilder("fake drag, diff ").append(f).append(",step ").append(scrollX).append(",scrollX ").append(this.qlu.getScrollX());
            c(view, motionEvent);
            return true;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    private static void c(View view, MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(0);
        view.dispatchTouchEvent(obtain);
    }
}
