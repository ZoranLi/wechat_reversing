package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.mm.bm.a.c;
import com.tencent.mm.bm.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;

public class MMSwitchBtn extends View {
    private int maxHeight;
    private int maxWidth;
    private int mxB;
    private Paint nSe = new Paint(1);
    private float qPg;
    private float qPh;
    private RectF wwA = new RectF();
    private RectF wwB = new RectF();
    private b wwC = new b(this);
    public a wwD;
    private long wwl;
    private int wwm;
    private int wwn;
    private int wwo;
    private boolean wwp = false;
    private boolean wwq = false;
    private int wwr;
    private int wws = 80;
    private int wwt = e.CTRL_INDEX;
    private float wwu;
    private float wwv;
    private int www;
    private int wwx;
    private int wwy;
    public boolean wwz = false;

    public interface a {
        void bK(boolean z);
    }

    private class b extends Animation {
        int direction = 0;
        float wip = 0.0f;
        long wwE = 0;
        final /* synthetic */ MMSwitchBtn wwF;

        public b(final MMSwitchBtn mMSwitchBtn) {
            this.wwF = mMSwitchBtn;
            setInterpolator(new AccelerateDecelerateInterpolator());
            setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ b wwH;

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    boolean z = true;
                    if (this.wwH.wwF.wwz != (this.wwH.direction == 1)) {
                        MMSwitchBtn mMSwitchBtn = this.wwH.wwF;
                        if (this.wwH.direction != 1) {
                            z = false;
                        }
                        mMSwitchBtn.wwz = z;
                        this.wwH.wwF.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 wwI;

                            {
                                this.wwI = r1;
                            }

                            public final void run() {
                                if (this.wwI.wwH.wwF.wwD != null) {
                                    this.wwI.wwH.wwF.wwD.bK(this.wwI.wwH.wwF.wwz);
                                }
                            }
                        });
                    }
                    this.wwH.wwF.wwp = false;
                }
            });
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (this.direction == 0) {
                this.wwF.wwB.left = this.wip - (((float) this.wwE) * f);
            } else {
                this.wwF.wwB.left = this.wip + (((float) this.wwE) * f);
            }
            this.wwF.caF();
            this.wwF.invalidate();
        }
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.wwr = getResources().getDimensionPixelSize(c.aXV);
        this.wwu = (float) getResources().getDimensionPixelSize(c.wzT);
        this.wwv = (float) getResources().getDimensionPixelSize(c.wzS);
        this.www = getResources().getColor(com.tencent.mm.bm.a.b.white);
        this.wwx = getResources().getColor(com.tencent.mm.bm.a.b.wzN);
        this.wwy = getResources().getColor(com.tencent.mm.bm.a.b.wzO);
        this.mxB = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final void lS(boolean z) {
        if (this.wwz != z) {
            clearAnimation();
            this.wwz = z;
            caE();
            this.wwp = false;
            invalidate();
        }
        setContentDescription(z ? getContext().getString(h.wAr) : getContext().getString(h.wAs));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.maxWidth = i3 - i;
        this.maxHeight = i4 - i2;
        this.wwn = (this.maxWidth - ((int) (this.wwv * 2.0f))) - (this.wwr * 2);
        this.wwm = this.wwn / 2;
        this.wwo = getResources().getDimensionPixelSize(c.wzR);
        if (this.wwo < this.maxHeight) {
            this.wwA.top = (float) ((this.maxHeight - this.wwo) / 2);
            this.wwA.bottom = this.wwA.top + ((float) this.wwo);
        } else {
            this.wwA.top = 0.0f;
            this.wwA.bottom = (float) this.maxHeight;
        }
        this.wwA.left = 0.0f;
        this.wwA.right = (float) this.maxWidth;
        caE();
        this.nSe.setStyle(Style.FILL);
        this.nSe.setColor(this.wwx);
    }

    private void caE() {
        if (this.wwo < this.maxHeight) {
            this.wwB.top = (float) (((this.maxHeight - this.wwo) / 2) + this.wwr);
            this.wwB.bottom = (this.wwB.top + ((float) this.wwo)) - ((float) (this.wwr * 2));
        } else {
            this.wwB.top = (float) this.wwr;
            this.wwB.bottom = (float) (this.maxHeight - this.wwr);
        }
        if (this.wwz) {
            this.wwB.left = (float) (this.wwn + this.wwr);
            this.wwB.right = (float) (this.maxWidth - this.wwr);
            return;
        }
        this.wwB.left = (float) this.wwr;
        this.wwB.right = (float) (((int) (this.wwv * 2.0f)) + this.wwr);
    }

    private void caF() {
        if (this.wwB.left < ((float) this.wwr)) {
            this.wwB.left = (float) this.wwr;
        }
        if (this.wwB.left > ((float) (this.wwn + this.wwr))) {
            this.wwB.left = (float) (this.wwn + this.wwr);
        }
        this.wwB.right = this.wwB.left + ((float) ((int) (this.wwv * 2.0f)));
    }

    private void lT(boolean z) {
        this.wwp = true;
        this.wwC.reset();
        if (z) {
            this.wwC.wwE = (((long) this.wwn) - ((long) this.wwB.left)) + ((long) this.wwr);
            this.wwC.direction = 1;
        } else {
            this.wwC.wwE = (long) this.wwB.left;
            this.wwC.direction = 0;
        }
        this.wwC.wip = this.wwB.left;
        this.wwC.setDuration((((long) this.wws) * this.wwC.wwE) / ((long) this.wwn));
        startAnimation(this.wwC);
    }

    private void dw(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void bZX() {
        if (this.wwB.left > ((float) this.wwm)) {
            lT(true);
        } else {
            lT(false);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.wwp && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    clearAnimation();
                    this.qPg = motionEvent.getX();
                    this.qPh = motionEvent.getY();
                    this.wwl = SystemClock.elapsedRealtime();
                    this.wwq = false;
                    break;
                case 1:
                    if (SystemClock.elapsedRealtime() - this.wwl < ((long) this.wwt)) {
                        lT(!this.wwz);
                    } else {
                        bZX();
                    }
                    dw(false);
                    this.wwq = false;
                    break;
                case 2:
                    float x;
                    if (this.wwq) {
                        dw(true);
                        x = motionEvent.getX() - this.qPg;
                        RectF rectF = this.wwB;
                        rectF.left = x + rectF.left;
                        caF();
                    } else {
                        float x2 = motionEvent.getX() - this.qPg;
                        x = motionEvent.getY() - this.qPh;
                        if (Math.abs(x2) >= ((float) this.mxB) / 10.0f) {
                            if (x == 0.0f) {
                                x = 1.0f;
                            }
                            if (Math.abs(x2 / x) > 3.0f) {
                                z = true;
                            }
                        }
                        if (z) {
                            this.wwq = true;
                            dw(true);
                        }
                    }
                    this.qPg = motionEvent.getX();
                    this.qPh = motionEvent.getY();
                    break;
                case 3:
                    if (this.wwq) {
                        bZX();
                    }
                    dw(false);
                    this.wwq = false;
                    break;
            }
            if (this.wwq) {
                invalidate();
            }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        this.nSe.setColor(this.wwx);
        this.nSe.setAlpha(255);
        canvas.drawRoundRect(this.wwA, this.wwu, this.wwu, this.nSe);
        this.nSe.setColor(this.wwy);
        this.nSe.setAlpha(Math.min(255, (int) (255.0f * ((this.wwB.left - ((float) this.wwr)) / ((float) this.wwn)))));
        canvas.drawRoundRect(this.wwA, this.wwu, this.wwu, this.nSe);
        this.nSe.setColor(this.www);
        canvas.drawRoundRect(this.wwB, this.wwv, this.wwv, this.nSe);
    }
}
