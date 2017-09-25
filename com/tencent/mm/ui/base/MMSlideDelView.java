package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;

public class MMSlideDelView extends ViewGroup {
    private VelocityTracker fk;
    private final int iE;
    public f jVY;
    public c jVZ;
    public d jWb;
    public boolean lPM = true;
    private ae mHandler = new ae();
    private int nhN;
    private boolean srW = false;
    long time;
    private boolean vml = false;
    private b vmm;
    private Runnable vmn;
    private long vmo;
    private boolean vmp = false;
    private a vmq = null;
    private float yN;
    private float yO;
    private final Scroller yw;

    class b implements Runnable {
        final /* synthetic */ MMSlideDelView vmr;

        b(MMSlideDelView mMSlideDelView) {
            this.vmr = mMSlideDelView;
        }

        public final void run() {
            w.v("MicroMsg.MMSlideDelView", "checkfortap");
            this.vmr.setPressed(true);
        }
    }

    public interface c {
        int cb(View view);
    }

    public interface d {
        public static final Set<MMSlideDelView> mVd = new HashSet();

        void a(MMSlideDelView mMSlideDelView, boolean z);

        boolean aFg();

        void aFh();

        void aFi();
    }

    public interface e {
        void aQ(Object obj);
    }

    public interface f {
        void s(View view, int i);
    }

    private class g {
        int kWf;
        final /* synthetic */ MMSlideDelView vmr;

        public g(MMSlideDelView mMSlideDelView) {
            this.vmr = mMSlideDelView;
        }
    }

    private class a extends g implements Runnable {
        final /* synthetic */ MMSlideDelView vmr;

        public a(MMSlideDelView mMSlideDelView) {
            this.vmr = mMSlideDelView;
            super(mMSlideDelView);
        }

        public final void run() {
            Object obj = (this.vmr.hasWindowFocus() && this.vmr.getWindowAttachCount() == this.kWf) ? 1 : null;
            if (obj != null && !this.vmr.srW) {
                w.i("MicroMsg.MMSlideDelView", "is long press");
                if (this.vmr.getParent() != null) {
                    this.vmr.vmp = true;
                    this.vmr.performLongClick();
                }
            }
        }
    }

    public static d bSo() {
        return new d() {
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                if (z) {
                    mVd.add(mMSlideDelView);
                } else {
                    mVd.remove(mMSlideDelView);
                }
            }

            public final boolean aFg() {
                return mVd.size() > 0;
            }

            public final void aFh() {
                for (MMSlideDelView mMSlideDelView : mVd) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bSs();
                    }
                }
                mVd.clear();
            }

            public final void aFi() {
                for (MMSlideDelView mMSlideDelView : mVd) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bSr();
                    }
                }
                mVd.clear();
            }
        };
    }

    public MMSlideDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yw = new Scroller(context, new LinearInterpolator());
        this.iE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.vmo = (long) ViewConfiguration.getLongPressTimeout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() >= 2) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    childAt.layout(i5, 0, i5 + measuredWidth, i4 - i2);
                    i5 += measuredWidth;
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (getChildCount() >= 2) {
            int size = MeasureSpec.getSize(i);
            try {
                getChildAt(0).measure(i, i2);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            int max = Math.max(0, getChildAt(0).getMeasuredHeight());
            LayoutParams layoutParams = getChildAt(1).getLayoutParams();
            View childAt = getChildAt(1);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                try {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), MeasureSpec.makeMeasureSpec(max, 1073741824));
                } catch (ArrayIndexOutOfBoundsException e2) {
                }
                max = Math.max(max, childAt.getMeasuredHeight());
            }
            setMeasuredDimension(resolveSize(size, i), resolveSize(max, i2));
        }
    }

    public final void setView(View view) {
        if (getChildCount() == 2) {
            removeViewAt(0);
        }
        addView(view, 0, new LayoutParams(-1, -2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.lPM) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.jWb.aFg() && !this.vml) {
            w.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
            this.vmp = false;
            this.jWb.aFh();
        }
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        }
        this.fk.addMovement(motionEvent);
        if (this.vmp) {
            return false;
        }
        switch (action) {
            case 0:
                if (getContext() instanceof MMActivity) {
                    ((MMActivity) getContext()).aHf();
                }
                this.srW = false;
                if (!this.yw.isFinished()) {
                    this.yw.abortAnimation();
                }
                this.time = System.currentTimeMillis();
                if (this.jVZ != null) {
                    this.nhN = this.jVZ.cb(this);
                }
                if (this.vmm == null) {
                    this.vmm = new b(this);
                }
                this.mHandler.postDelayed(this.vmm, (long) ViewConfiguration.getTapTimeout());
                this.yN = x;
                this.yO = y;
                if (this.vmq == null) {
                    this.vmq = new a(this);
                }
                g gVar = this.vmq;
                gVar.kWf = gVar.vmr.getWindowAttachCount();
                this.mHandler.postDelayed(this.vmq, this.vmo);
                return true;
            case 1:
                bSp();
                if (this.srW || ((!isPressed() && System.currentTimeMillis() - this.time >= 200) || this.jVY == null || this.vml)) {
                    setPressed(false);
                } else {
                    setPressed(true);
                    if (this.vmn != null) {
                        removeCallbacks(this.vmn);
                    }
                    this.vmn = new Runnable(this) {
                        final /* synthetic */ MMSlideDelView vmr;

                        {
                            this.vmr = r1;
                        }

                        public final void run() {
                            this.vmr.setPressed(false);
                            w.v("MicroMsg.MMSlideDelView", "onClick");
                            this.vmr.jVY.s(this.vmr, this.vmr.nhN);
                            this.vmr.bSr();
                        }
                    };
                    this.mHandler.postDelayed(this.vmn, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (this.srW) {
                    bSq();
                }
                hg();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.vmq);
                return true;
            case 2:
                int i = (int) (this.yN - x);
                action = (int) (this.yO - y);
                int scrollX = getScrollX();
                if (!this.srW) {
                    boolean z;
                    if (i >= 0 && Math.abs(i) >= this.iE / 3) {
                        if (action == 0) {
                            action = 1;
                        }
                        if (Math.abs(i / action) > 3) {
                            z = true;
                            if (z || this.vml) {
                                this.srW = true;
                                dw(true);
                            }
                        }
                    }
                    z = false;
                    this.srW = true;
                    dw(true);
                }
                if (this.srW) {
                    View childAt = getChildAt(1);
                    if (!(childAt == null || childAt.isShown())) {
                        childAt.setVisibility(0);
                    }
                    bSp();
                    setPressed(false);
                    dw(true);
                    if (scrollX + i < 0) {
                        action = -scrollX;
                    } else if (scrollX + i > getChildAt(1).getWidth()) {
                        action = getChildAt(1).getWidth() - scrollX;
                    } else {
                        action = i;
                    }
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacks(this.vmq);
                    }
                    scrollBy(action, 0);
                }
                this.yN = x;
                this.yO = y;
                return true;
            case 3:
                bSp();
                setPressed(false);
                if (this.srW) {
                    bSq();
                }
                hg();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.vmq);
                return true;
            default:
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.vmq);
                return true;
        }
    }

    private void hg() {
        if (this.fk != null) {
            this.fk.clear();
            this.fk = null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        w.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
        this.vmp = false;
        super.onWindowFocusChanged(z);
    }

    private void bSp() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.vmm);
        }
    }

    private void bSq() {
        setPressed(false);
        if (this.vml) {
            bSs();
            return;
        }
        MMSlideDelView mMSlideDelView;
        VelocityTracker velocityTracker = this.fk;
        velocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) velocityTracker.getXVelocity();
        int scrollX;
        int width;
        if (xVelocity < -600) {
            scrollX = getScrollX();
            width = getChildAt(1).getWidth() - scrollX;
            this.jWb.a(this, true);
            this.vml = true;
            this.yw.startScroll(scrollX, 0, width, 0, 100);
            mMSlideDelView = this;
        } else if (xVelocity > 600) {
            bSs();
            if (this.fk != null) {
                this.fk.recycle();
                this.fk = null;
            }
            this.srW = false;
            dw(false);
        } else {
            scrollX = getScrollX();
            xVelocity = getChildAt(1).getWidth();
            width = xVelocity - scrollX;
            if (scrollX > xVelocity / 2) {
                this.jWb.a(this, true);
                this.vml = true;
                this.yw.startScroll(scrollX, 0, width, 0, 100);
                mMSlideDelView = this;
            } else {
                this.vml = false;
                this.jWb.a(this, false);
                this.yw.startScroll(scrollX, 0, -scrollX, 0, 100);
                mMSlideDelView = this;
            }
        }
        mMSlideDelView.invalidate();
        if (this.fk != null) {
            this.fk.recycle();
            this.fk = null;
        }
        this.srW = false;
        dw(false);
    }

    private void dw(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void bSr() {
        this.jWb.a(this, false);
        this.vml = false;
        scrollTo(0, 0);
        invalidate();
    }

    public final void bSs() {
        int scrollX = getScrollX();
        this.jWb.a(this, false);
        this.vml = false;
        this.yw.startScroll(scrollX, 0, -scrollX, 0, 100);
        invalidate();
    }

    public void computeScroll() {
        if (this.yw.computeScrollOffset()) {
            scrollTo(this.yw.getCurrX(), this.yw.getCurrY());
            postInvalidate();
        }
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }
}
