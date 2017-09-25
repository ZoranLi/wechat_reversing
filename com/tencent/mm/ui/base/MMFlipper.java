package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class MMFlipper extends ViewGroup {
    private Interpolator eW;
    private VelocityTracker fk;
    private int iE;
    private int kVI;
    protected int vhF;
    protected int vhG;
    public boolean vhI;
    protected int vje;
    private int vjf;
    private boolean vjg;
    public b vjh;
    public a vji;
    int vjj;
    int vjk;
    private float yN;
    private float yO;
    private Scroller yw;

    public interface a {
        void cN(int i, int i2);
    }

    public interface b {
        void sh(int i);
    }

    private static class c implements Interpolator {
        private float oIj;

        public c() {
            this.oIj = 1.3f;
            this.oIj = 0.0f;
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (f2 * f2)) + 1.0f;
        }
    }

    public MMFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context);
    }

    public MMFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vjf = 0;
        this.kVI = 0;
        this.vjg = false;
        this.vhI = true;
        this.vjj = -123454321;
        this.vjk = -123454321;
        init(context);
    }

    private void init(Context context) {
        this.eW = new c();
        this.yw = new Scroller(context, this.eW);
        this.vhG = -1;
        int i = this.vjf;
        this.vhF = i;
        this.vje = i;
        this.iE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        long NA = bg.NA();
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                w.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:" + measuredWidth);
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
        w.v("MicroMsg.MMFlipper", "use " + bg.aB(NA) + " ms, flipper onLayout changed:" + z + " Left,Top,Right,Bottom:" + i + "," + i2 + "," + i3 + "," + i4);
    }

    protected void onMeasure(int i, int i2) {
        long NA = bg.NA();
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.vji != null) {
            this.vji.cN(size, size2);
        }
        this.vjj = size;
        this.vjk = size2;
        int childCount = getChildCount();
        for (size2 = 0; size2 < childCount; size2++) {
            getChildAt(size2).measure(i, i2);
        }
        scrollTo(this.vhF * size, 0);
        w.v("MicroMsg.MMFlipper", "flipper onMeasure:" + size + "," + MeasureSpec.getSize(i2) + " childCount:" + childCount + ", use " + bg.aB(NA));
    }

    private void zQ(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (getWidth() * max) - getScrollX();
            this.yw.startScroll(getScrollX(), 0, width, 0, com.tencent.mm.bg.a.W(getContext(), (int) (((float) Math.abs(width)) * 1.3f)));
            if (this.vhF != max) {
                this.vjg = true;
                this.vje += max - this.vhF;
            }
            this.vhG = this.vhF;
            this.vhF = max;
            invalidate();
        }
    }

    public final void Af(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.vjg = false;
        if (!this.yw.isFinished()) {
            this.yw.abortAnimation();
        }
        this.vhG = this.vhF;
        this.vhF = max;
        scrollTo(max * getWidth(), 0);
    }

    public final void Ag(int i) {
        this.vje = i;
    }

    public final void Ah(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.vjg = false;
        if (!this.yw.isFinished()) {
            this.yw.abortAnimation();
        }
        if (this.vjh != null) {
            this.vjh.sh(max);
        }
        this.vhG = this.vhF;
        this.vhF = max;
        this.vje = max;
        scrollTo(max * getWidth(), 0);
    }

    public final int bRR() {
        w.d("MicroMsg.MMFlipper", "cur screen is %d", Integer.valueOf(this.vhF));
        return this.vhF;
    }

    public void computeScroll() {
        this.yw.getCurrX();
        if (this.yw.computeScrollOffset()) {
            scrollTo(this.yw.getCurrX(), this.yw.getCurrY());
            postInvalidate();
        } else if (this.vjg) {
            this.vjg = false;
            if (this.vjh != null) {
                this.vjh.sh(this.vje);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        }
        this.fk.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        motionEvent.getY();
        switch (action) {
            case 0:
                if (!this.yw.isFinished()) {
                    this.yw.abortAnimation();
                }
                this.yN = x;
                return true;
            case 1:
            case 3:
                VelocityTracker velocityTracker = this.fk;
                velocityTracker.computeCurrentVelocity(1000);
                action = (int) velocityTracker.getXVelocity();
                if (action > 600 && this.vhF > 0) {
                    zQ(this.vhF - 1);
                } else if (action >= -600 || this.vhF >= getChildCount() - 1) {
                    action = getWidth();
                    zQ((getScrollX() + (action / 2)) / action);
                } else {
                    zQ(this.vhF + 1);
                }
                if (this.fk != null) {
                    this.fk.recycle();
                    this.fk = null;
                }
                this.kVI = 0;
                this.yN = 0.0f;
                this.yO = 0.0f;
                return true;
            case 2:
                action = (int) (this.yN - x);
                this.yN = x;
                scrollBy(action, 0);
                return true;
            default:
                return true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.vhI) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (getChildCount() == 1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.kVI != 0) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.yN = x;
                this.yO = y;
                this.kVI = this.yw.isFinished() ? 0 : 1;
                break;
            case 1:
            case 3:
                this.kVI = 0;
                break;
            case 2:
                boolean z;
                action = (int) Math.abs(this.yN - x);
                int abs = (int) Math.abs(this.yO - y);
                w.v("MicroMsg.MMFlipper", "xDif = " + action + ", yDif = " + abs);
                if (action <= this.iE || abs >= this.iE) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    this.kVI = 0;
                    break;
                }
                this.kVI = 1;
                break;
                break;
        }
        if (this.kVI == 0) {
            return false;
        }
        return true;
    }
}
