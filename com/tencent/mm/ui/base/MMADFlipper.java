package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.w;

public class MMADFlipper extends ViewGroup {
    private VelocityTracker fk;
    private int iE;
    private int kVI;
    private Context mContext;
    private Interpolator vhE;
    private int vhF;
    private int vhG;
    private boolean vhH;
    private boolean vhI;
    private float yN;
    private float yO;
    private Scroller yw;

    public MMADFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMADFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kVI = 0;
        this.vhH = false;
        this.vhI = true;
        this.mContext = context;
        this.vhE = new LinearInterpolator();
        this.yw = new Scroller(this.mContext, this.vhE);
        this.iE = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
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
                if (action > 600) {
                    if (bRJ()) {
                        this.vhF--;
                        zQ(this.vhF);
                    }
                    this.vhH = true;
                } else if (action < -600) {
                    if (bRJ()) {
                        this.vhF++;
                        zQ(this.vhF);
                    }
                    this.vhH = true;
                } else {
                    action = getWidth();
                    zQ((getScrollX() + (action / 2)) / action);
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

    private boolean bRJ() {
        if (getChildCount() > 1) {
            return true;
        }
        return false;
    }

    private void zQ(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (max * getWidth()) - getScrollX();
            this.yw.startScroll(getScrollX(), 0, width, 0, a.W(getContext(), Math.abs(width) * 2));
            invalidate();
        }
        w.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", new Object[]{Integer.valueOf(this.vhF), Integer.valueOf(this.vhG), Integer.valueOf(i)});
        this.vhG = i;
    }

    public void computeScroll() {
        if (this.yw.computeScrollOffset()) {
            scrollTo(this.yw.getCurrX(), this.yw.getCurrY());
            postInvalidate();
        } else if (this.vhH) {
            this.vhH = false;
            if (this.vhF <= 0) {
                this.vhF = getChildCount() > 1 ? getChildCount() - 2 : getChildCount();
                zR(this.vhF * getWidth());
            } else if (this.vhF >= getChildCount() - 1) {
                this.vhF = 1;
                zR(this.vhF * getWidth());
            }
        }
    }

    @TargetApi(14)
    private void zR(int i) {
        if (VERSION.SDK_INT >= 14) {
            setScrollX(i);
        } else if (this.yw != null) {
            this.yw.setFinalX(i);
        }
    }
}
