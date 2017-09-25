package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;

public class LogoWebViewWrapper extends LinearLayout {
    private Context context;
    private int iE;
    WebView kuN;
    private int lpD;
    FrameLayout saC;
    private boolean saD = false;
    private int saE;
    private int saF;
    private c saG;
    private int saH = 0;
    boolean saI = false;
    boolean saJ = false;
    int saK = 0;
    a saL;
    b saM;
    private boolean saN = false;
    private int saO = -1;

    public interface a {
        void bxF();
    }

    public interface b {
        void W(int i, boolean z);
    }

    final class c implements Runnable {
        private final long duration;
        final /* synthetic */ LogoWebViewWrapper saP;
        private final Interpolator saQ;
        private final int saR;
        private final int saS;
        boolean saT = true;
        private int saU = -1;
        private long startTime = -1;

        public c(LogoWebViewWrapper logoWebViewWrapper, int i, int i2, long j) {
            this.saP = logoWebViewWrapper;
            this.saS = i;
            this.saR = i2;
            this.saQ = logoWebViewWrapper.saJ ? new AccelerateInterpolator() : new DecelerateInterpolator();
            this.duration = j;
        }

        public final void run() {
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                long j = 500;
                if (this.duration > 0) {
                    j = Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / this.duration, 1000), 0);
                }
                this.saU = this.saS - Math.round(this.saQ.getInterpolation(((float) j) / 1000.0f) * ((float) (this.saS - this.saR)));
                this.saP.wh(this.saU);
                if (this.saP.saM != null) {
                    this.saP.saM.W(this.saU, false);
                }
            }
            if (this.saT && this.saR != this.saU) {
                z.a(this.saP, this);
            }
        }
    }

    public LogoWebViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    @TargetApi(11)
    public LogoWebViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        setOrientation(1);
        this.iE = ViewConfiguration.get(this.context).getScaledTouchSlop();
    }

    public final FrameLayout bxD() {
        if (this.saC == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getId() == R.h.ccN) {
                    this.saC = (FrameLayout) childAt;
                    break;
                }
            }
        }
        return this.saC;
    }

    public final void iQ(boolean z) {
        this.saI = z;
        if (this.saI) {
            this.saD = false;
            this.saH = 0;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.saI && !this.saN) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.saD = false;
            this.saH = 0;
            return false;
        } else if (action == 2 && this.saD) {
            return true;
        } else {
            switch (action) {
                case 0:
                    if (bxE()) {
                        this.saE = (int) motionEvent.getY();
                        this.lpD = (int) motionEvent.getY();
                        this.saF = (int) motionEvent.getX();
                        this.saD = false;
                        this.saH = 0;
                        this.saN = true;
                        break;
                    }
                    break;
                case 2:
                    if (bxE()) {
                        int y = (int) motionEvent.getY();
                        action = (int) motionEvent.getX();
                        int i = y - this.saE;
                        int i2 = action - this.saF;
                        if (Math.abs(i) > this.iE && Math.abs(i) > Math.abs(i2) && i > 0) {
                            this.saE = y;
                            this.saF = action;
                            if (this.saH != 1) {
                                this.saH++;
                                break;
                            }
                            this.saD = true;
                            w.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
                            if (this.saL != null) {
                                this.saL.bxF();
                                break;
                            }
                        }
                    }
                    break;
            }
            return this.saD;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.saI && !this.saN) {
            return false;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        int i;
        switch (motionEvent.getAction()) {
            case 0:
                this.saN = true;
                if (!bxE()) {
                    return false;
                }
                this.saE = (int) motionEvent.getY();
                this.lpD = (int) motionEvent.getY();
                this.saF = (int) motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.saD && !this.saN) {
                    return false;
                }
                this.saD = false;
                i = -this.saK;
                long abs = (long) Math.abs(getScrollY());
                long abs2 = Math.abs(abs - ((long) Math.abs(this.saK)));
                if (abs2 >= abs) {
                    abs = 300;
                } else {
                    abs = (long) ((((float) abs2) / ((float) abs)) * 300.0f);
                }
                K(i, abs);
                post(new Runnable(this) {
                    final /* synthetic */ LogoWebViewWrapper saP;

                    {
                        this.saP = r1;
                    }

                    public final void run() {
                        this.saP.saN = false;
                    }
                });
                return true;
            case 2:
                if (!this.saD) {
                    return false;
                }
                this.saE = (int) motionEvent.getY();
                this.saF = (int) motionEvent.getX();
                int min = Math.min(this.lpD - this.saE, 0) >> 1;
                int height = getHeight();
                if (this.saO < 0) {
                    this.saO = (int) TypedValue.applyDimension(1, 60.0f, this.context.getResources().getDisplayMetrics());
                }
                i = ((int) Math.sqrt((double) ((this.saO >> 1) * Math.abs(min)))) << 1;
                if (i <= Math.abs(min)) {
                    min = -i;
                } else if (Math.abs(min) > height) {
                    min = -height;
                }
                wh(min);
                if (this.saM != null) {
                    this.saM.W(min, true);
                }
                return true;
            default:
                return false;
        }
    }

    private boolean bxE() {
        return this.kuN.getView().getScrollY() == 0;
    }

    public final void wh(int i) {
        int height = getHeight();
        scrollTo(0, Math.min(height, Math.max(-height, i)));
    }

    public final void K(int i, long j) {
        if (this.saG != null) {
            Runnable runnable = this.saG;
            runnable.saT = false;
            runnable.saP.removeCallbacks(runnable);
        }
        int scrollY = getScrollY();
        w.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[]{Integer.valueOf(scrollY), Integer.valueOf(i)});
        if (scrollY != i) {
            this.saG = new c(this, scrollY, i, j);
            post(this.saG);
        }
    }
}
