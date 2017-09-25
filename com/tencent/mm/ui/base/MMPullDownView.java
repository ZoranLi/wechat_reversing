package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.k;

public class MMPullDownView extends FrameLayout implements OnGestureListener {
    private static int vlM = 400;
    private static final int vlP = Color.parseColor("#00000000");
    public int bgColor;
    public Context context;
    private GestureDetector nlD;
    private int vhF;
    private int vjf;
    public d vlA;
    private View vlB;
    private View vlC;
    private int vlD;
    private int vlE;
    private int vlF;
    private boolean vlG;
    public f vlH;
    public boolean vlI;
    public k vlJ;
    public boolean vlK;
    public a vlL;
    private ae vlN;
    boolean vlO;
    public boolean vlQ;
    private int vlR;
    public int vlS;
    public b vlT;
    public g vln;
    public e vlo;
    public int vlp;
    private int vlq;
    private boolean vlr;
    private boolean vls;
    private boolean vlt;
    private boolean vlu;
    public boolean vlv;
    private boolean vlw;
    private boolean vlx;
    private boolean vly;
    public c vlz;
    private Scroller yw;

    public interface a {
        boolean aqA();
    }

    public interface b {
        void aqr();
    }

    public interface c {
        boolean ako();
    }

    public interface d {
        boolean akn();
    }

    public interface e {
        boolean akm();
    }

    public interface f {
        void an(float f);

        void biK();
    }

    public interface g {
        boolean akp();
    }

    public MMPullDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vjf = 1;
        this.vlr = false;
        this.vls = false;
        this.vlt = false;
        this.vlu = false;
        this.vlv = true;
        this.vlw = false;
        this.vlx = true;
        this.vly = true;
        this.vlE = 4;
        this.vlF = 4;
        this.vlG = false;
        this.vlI = true;
        this.vlK = false;
        this.vlN = new ae(this) {
            final /* synthetic */ MMPullDownView vlU;

            {
                this.vlU = r1;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (this.vlU.vlD) {
                    case 0:
                        if (this.vlU.vln != null) {
                            this.vlU.vlv = this.vlU.vln.akp();
                        }
                        if (this.vlU.vlv && this.vlU.vlB.getVisibility() == 0) {
                            this.vlU.scrollTo(0, this.vlU.vlp);
                            break;
                        }
                    case 1:
                        if (this.vlU.vlo != null) {
                            this.vlU.vlv = this.vlU.vlo.akm();
                        }
                        if (this.vlU.vlv && this.vlU.vlC.getVisibility() == 0) {
                            this.vlU.scrollTo(0, this.vlU.vlp);
                            break;
                        }
                }
                w.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", Integer.valueOf(this.vlU.vlD), Boolean.valueOf(this.vlU.vlv));
            }
        };
        this.vlO = false;
        this.vlQ = false;
        this.bgColor = Color.parseColor("#ffffffff");
        this.vlR = Integer.MIN_VALUE;
        this.vlS = this.bgColor;
        this.yw = new Scroller(context, new AccelerateInterpolator());
        this.vhF = this.vjf;
        this.nlD = new GestureDetector(context, this);
        this.vlJ = new k(context);
        this.context = context;
    }

    public void akF() {
        View inflate = inflate(this.context, h.cbU, null);
        View inflate2 = inflate(this.context, h.cbU, null);
        addView(inflate, 0, new LayoutParams(-1, -2));
        addView(inflate2, new LayoutParams(-1, -2));
    }

    public final void kO(boolean z) {
        w.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.vlx), bg.bJZ());
        this.vlx = z;
    }

    public final void kP(boolean z) {
        w.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.vly), bg.bJZ());
        this.vly = z;
    }

    public final void kQ(boolean z) {
        this.vlE = z ? 0 : 4;
        if (this.vlC != null) {
            this.vlC.setVisibility(this.vlE);
        }
        w.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", Boolean.valueOf(z), bg.bJZ());
    }

    public final void kR(boolean z) {
        this.vlF = z ? 0 : 4;
        if (this.vlB != null) {
            this.vlB.setVisibility(this.vlF);
        }
        w.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b], stack[%s]", Boolean.valueOf(z), bg.bJZ());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (!this.vlG) {
            akF();
            this.vlG = true;
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                try {
                    childAt.layout(0, i5, childAt.getMeasuredWidth(), i5 + measuredHeight);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MMPullDownView", e, "childCount: %d, i:%d, childHeight:%d", Integer.valueOf(childCount), Integer.valueOf(i6), Integer.valueOf(measuredHeight));
                }
                i5 += measuredHeight;
            }
        }
        this.vlB = getChildAt(0);
        this.vlC = getChildAt(getChildCount() - 1);
        this.vlB.setVisibility(this.vlF);
        this.vlC.setVisibility(this.vlE);
        this.vlp = this.vlB.getHeight();
        this.vlq = this.vlC.getHeight();
        this.vlR = this.vlp;
        if (!this.vlw && this.vlp != 0) {
            this.vlw = true;
            scrollTo(0, this.vlp);
        }
    }

    public void computeScroll() {
        if (this.yw.computeScrollOffset()) {
            scrollTo(this.yw.getCurrX(), this.yw.getCurrY());
            postInvalidate();
        } else if (this.vlu) {
            w.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
            this.vlu = false;
            this.vlN.sendEmptyMessageDelayed(0, (long) vlM);
        }
        this.yw.isFinished();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.vlL != null) {
            this.vlL.aqA();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                if (getScrollY() - this.vlp < 0) {
                    this.vlr = true;
                }
                if (getScrollY() > this.vlq) {
                    this.vls = true;
                }
                bSl();
                break;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        k kVar = this.vlJ;
        if (kVar.wmK != null) {
            kVar.wmJ.onTouchEvent(motionEvent);
        }
        if (!this.vlv) {
            return z;
        }
        if (this.vlA == null) {
            this.vlr = false;
        } else {
            this.vlr = this.vlA.akn();
        }
        if (this.vlz == null) {
            this.vls = false;
        } else {
            this.vls = this.vlz.ako();
        }
        if (this.vlF == 0) {
            if (this.vlx) {
                this.vlB.setVisibility(4);
            } else {
                this.vlB.setVisibility(0);
            }
        }
        if (this.vlE == 0) {
            if (this.vly) {
                this.vlC.setVisibility(4);
            } else {
                this.vlC.setVisibility(0);
            }
        }
        if (motionEvent.getAction() == z) {
            bSl();
            return super.dispatchTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 3) {
            bSl();
            return this.vlK ? super.dispatchTouchEvent(motionEvent) : false;
        } else if (this.nlD.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
            this.vlO = z;
            return super.dispatchTouchEvent(motionEvent);
        } else {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMPullDownView", e, "", new Object[0]);
                return z;
            }
        }
    }

    public final void kS(boolean z) {
        w.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.vlu), Boolean.valueOf(this.vlv), Boolean.valueOf(this.vlx), Integer.valueOf(getScrollY()), bg.bJZ());
        if (z) {
            if (this.vlx) {
                this.yw.startScroll(0, getScrollY(), 0, this.vlp + (-getScrollY()), m.CTRL_INDEX);
            } else {
                if (this.vlB != null && this.vlB.getVisibility() == 4) {
                    this.yw.startScroll(0, getScrollY(), 0, this.vlp + (-getScrollY()), m.CTRL_INDEX);
                }
                if (this.vlB != null && this.vlB.getVisibility() == 0) {
                    this.yw.startScroll(0, getScrollY(), 0, -getScrollY(), m.CTRL_INDEX);
                }
                this.vlD = 0;
                this.vlu = true;
                this.vlv = false;
            }
            postInvalidate();
        } else if (!this.vlv) {
            this.vlv = true;
            this.vlu = false;
            if (this.vlB != null && this.vlB.getVisibility() == 0) {
                scrollTo(0, this.vlp);
            }
        }
    }

    public final void kT(boolean z) {
        w.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.vlu), Boolean.valueOf(this.vlv), Boolean.valueOf(this.vly), Integer.valueOf(getScrollY()), bg.bJZ());
        if (z) {
            if (this.vly) {
                this.yw.startScroll(0, getScrollY(), 0, this.vlq - getScrollY(), m.CTRL_INDEX);
            } else {
                if (this.vlC != null && this.vlC.getVisibility() == 4) {
                    this.yw.startScroll(0, getScrollY(), 0, this.vlq - getScrollY(), m.CTRL_INDEX);
                }
                if (this.vlC != null && this.vlC.getVisibility() == 0) {
                    this.yw.startScroll(0, getScrollY(), 0, this.vlq + (this.vlq - getScrollY()), m.CTRL_INDEX);
                }
                this.vlD = 1;
                this.vlu = true;
                this.vlv = false;
            }
            postInvalidate();
            return;
        }
        if (!this.vlv) {
            this.vlv = true;
            this.vlu = false;
        }
        if (this.vlC != null && this.vlC.getVisibility() == 0) {
            w.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
            scrollTo(0, this.vlp);
        }
    }

    private void bSl() {
        if (this.vlH != null) {
            this.vlH.biK();
        }
        if (getScrollY() - this.vlp < 0) {
            if (this.vlx) {
                this.yw.startScroll(0, getScrollY(), 0, this.vlp + (-getScrollY()), m.CTRL_INDEX);
            } else {
                if (this.vlB.getVisibility() == 4) {
                    this.yw.startScroll(0, getScrollY(), 0, this.vlp + (-getScrollY()), m.CTRL_INDEX);
                }
                if (this.vlB.getVisibility() == 0) {
                    this.yw.startScroll(0, getScrollY(), 0, -getScrollY(), m.CTRL_INDEX);
                }
                this.vlD = 0;
                this.vlu = true;
                this.vlv = false;
            }
            postInvalidate();
        }
        if (getScrollY() > this.vlq) {
            if (this.vly) {
                this.yw.startScroll(0, getScrollY(), 0, this.vlq - getScrollY(), m.CTRL_INDEX);
            } else {
                if (this.vlC.getVisibility() == 4) {
                    this.yw.startScroll(0, getScrollY(), 0, this.vlq - getScrollY(), m.CTRL_INDEX);
                }
                if (this.vlC.getVisibility() == 0) {
                    this.yw.startScroll(0, getScrollY(), 0, this.vlq + (this.vlq - getScrollY()), m.CTRL_INDEX);
                }
                this.vlD = 1;
                this.vlu = true;
                this.vlv = false;
            }
            postInvalidate();
        }
        this.vlt = false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.yw.isFinished()) {
            this.yw.abortAnimation();
        }
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        w.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", Float.valueOf(f), Float.valueOf(f2));
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i = -1;
        if (this.vlH != null) {
            this.vlH.an(f2);
        }
        if (f2 > 0.0f) {
            this.vlt = true;
        } else {
            this.vlt = false;
        }
        int i2;
        if (this.vls && (this.vlt || getScrollY() - this.vlp > 0)) {
            if (!this.vlI) {
                if (this.vlC.getVisibility() != 0) {
                    return true;
                }
                if (this.vlt && getScrollY() >= this.vlp * 2) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            w.v("check", "moveUp:" + i + " distanceY:" + f2 + " scrollY:" + getScrollY());
            if (getScrollY() + i < this.vlp && !this.vlt) {
                i = this.vlp - getScrollY();
            } else if (!this.vlI && getScrollY() + i >= this.vlp * 2) {
                i = (this.vlp * 2) - getScrollY();
            }
            scrollBy(0, i);
            return true;
        } else if (!this.vlr || (this.vlt && getScrollY() - this.vlp >= 0)) {
            return false;
        } else {
            if (!this.vlI) {
                if (this.vlB.getVisibility() != 0) {
                    return true;
                }
                if (!this.vlt && getScrollY() <= 0) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            if (getScrollY() + i > this.vlp) {
                i = this.vlp - getScrollY();
            } else if (!this.vlI && getScrollY() + i < 0) {
                i = -getScrollY();
            }
            scrollBy(0, i);
            return true;
        }
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.vlT != null) {
            this.vlT.aqr();
        }
        if (this.vlQ) {
            if (this.vlR == Integer.MIN_VALUE) {
                this.vlR = this.vlp;
                w.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.vlR);
            }
            if (i2 <= this.vlR && this.vlS != vlP) {
                setBackgroundResource(com.tencent.mm.s.a.f.bhc);
                this.vlS = vlP;
                w.d("MicroMsg.MMPullDownView", "onScrollChanged full");
            } else if (i2 > this.vlR && this.vlS != this.bgColor) {
                w.d("MicroMsg.MMPullDownView", "onScrollChanged white");
                setBackgroundColor(this.bgColor);
                this.vlS = this.bgColor;
            }
        }
    }
}
