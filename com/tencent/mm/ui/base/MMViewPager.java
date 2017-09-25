package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager extends WxViewPager {
    private int abb;
    private int abc;
    private VelocityTracker fk;
    private ae handler = new ae(Looper.getMainLooper());
    private GestureDetector iXs;
    private int jYp;
    private int jYq;
    private boolean miI = false;
    private OverScroller miJ;
    private RectF miL = new RectF();
    private float miN;
    private float miO;
    private boolean miP = false;
    private boolean miQ = false;
    private boolean miR = false;
    private boolean miS = false;
    private MultiTouchImageView mjb;
    private float mwV = 0.0f;
    private float qEv = 0.0f;
    private boolean qEw = false;
    private boolean qEx = false;
    private boolean qEy = false;
    private OnTouchListener rlX;
    public b vnA;
    private final int vnB = 60;
    private final int vnC = 500;
    private k vnm;
    private boolean vnn = false;
    private boolean vno = false;
    private boolean vnp = false;
    private boolean vnq = false;
    private boolean vnr = false;
    private int vns = 0;
    private a vnt;
    public e vnu;
    public c vnv;
    public android.support.v4.view.ViewPager.e vnw = null;
    private float vnx = 0.0f;
    private MotionEvent vny;
    private long vnz = 0;

    private abstract class a {
        protected boolean miY = false;
        final /* synthetic */ MMViewPager vnD;

        public abstract void play();

        public a(MMViewPager mMViewPager) {
            this.vnD = mMViewPager;
        }

        public final boolean azf() {
            return this.miY;
        }
    }

    public interface b {
        void C(float f, float f2);

        void D(float f, float f2);
    }

    public interface c {
        void auf();
    }

    private class d extends SimpleOnGestureListener {
        final /* synthetic */ MMViewPager vnD;

        private d(MMViewPager mMViewPager) {
            this.vnD = mMViewPager;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (this.vnD.vnu != null) {
                this.vnD.vnu.ahA();
            }
            return true;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            if (this.vnD.miJ != null) {
                this.vnD.miJ.forceFinished(true);
            }
            return super.onDown(motionEvent);
        }

        public final void onLongPress(MotionEvent motionEvent) {
            this.vnD.qEy = true;
            if (this.vnD.vnv != null) {
                this.vnD.vnv.auf();
            }
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            if (this.vnD.mjb == null) {
                return false;
            }
            if (this.vnD.mjb.getScale() <= this.vnD.mjb.pbn) {
                this.vnD.mjb.F(f.i(motionEvent, 0), f.j(motionEvent, 0));
            } else {
                this.vnD.mjb.E(f.i(motionEvent, 0), f.j(motionEvent, 0));
            }
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            w.d("MicroMsg.MMViewPager", "onFling");
            MultiTouchImageView g = ((t) this.vnD.yr).nk(this.vnD.ys);
            if (g != null) {
                w.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
                g = g;
                float scale = g.getScale() * ((float) g.imageWidth);
                float scale2 = g.getScale() * ((float) g.imageHeight);
                if (g.vom || g.von || ((int) scale) > this.vnD.jYp || ((int) scale2) > this.vnD.jYq) {
                    float f3;
                    r6 = new float[9];
                    g.getImageMatrix().getValues(r6);
                    float f4 = r6[2];
                    float f5 = f4 + scale;
                    float f6 = r6[5];
                    float f7 = f6 + scale2;
                    w.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(MMViewPager.b(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2));
                    if (((float) Math.round(f4)) >= this.vnD.miL.left || ((float) Math.round(f5)) <= this.vnD.miL.right) {
                        f3 = 0.0f;
                    } else {
                        f3 = f;
                    }
                    if (((float) Math.round(f6)) >= this.vnD.miL.top || ((float) Math.round(f7)) <= this.vnD.miL.bottom) {
                        f2 = 0.0f;
                    }
                    int i = (int) (this.vnD.miL.right - scale);
                    int i2 = (int) (scale + this.vnD.miL.right);
                    int i3 = (int) (this.vnD.miL.bottom - scale2);
                    int i4 = (int) (this.vnD.miL.bottom + scale2);
                    if (f3 >= 0.0f) {
                        if (Math.abs(f3) >= ((float) this.vnD.vns)) {
                            f3 = (float) this.vnD.vns;
                        }
                        f6 = f3;
                    } else {
                        f6 = Math.abs(f) >= ((float) this.vnD.vns) ? (float) (-this.vnD.vns) : f;
                    }
                    if (f2 >= 0.0f) {
                        if (Math.abs(f2) >= ((float) this.vnD.vns)) {
                            f2 = (float) this.vnD.vns;
                        }
                    } else if (Math.abs(f2) >= ((float) this.vnD.vns)) {
                        f2 = (float) (-this.vnD.vns);
                    }
                    this.vnD.miJ.fling(this.vnD.miJ.getCurrX(), this.vnD.miJ.getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                    if ((!MMViewPager.b(motionEvent, motionEvent2) || f4 < 0.0f) && (MMViewPager.b(motionEvent, motionEvent2) || f5 > ((float) this.vnD.jYp))) {
                        return false;
                    }
                }
            }
            if (this.vnD.miI) {
                return false;
            }
            return MMViewPager.a(this.vnD, motionEvent, motionEvent2, f);
        }
    }

    public interface e {
        void ahA();

        void azc();
    }

    private class f extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMViewPager vnD;

        public f(MMViewPager mMViewPager) {
            this.vnD = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.vnD.handler.post(new Runnable(this) {
                final /* synthetic */ f vnE;

                {
                    this.vnE = r1;
                }

                public final void run() {
                    this.vnE.vnD.mjb.getImageMatrix().getValues(this.vnE.mja);
                    float scale = ((float) this.vnE.vnD.mjb.imageHeight) * this.vnE.vnD.mjb.getScale();
                    float f = this.vnE.mja[5] + scale;
                    float d = (float) this.vnE.vnD.jYq;
                    if (scale < ((float) this.vnE.vnD.jYq)) {
                        d = (((float) this.vnE.vnD.jYq) / 2.0f) + (scale / 2.0f);
                    }
                    d -= f;
                    if (d <= 0.0f) {
                        this.vnE.miY = true;
                    } else if (Math.abs(d) <= 5.0f) {
                        this.vnE.miY = true;
                    } else {
                        d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.vnE.vnD.mjb.G(0.0f, d);
                }
            });
        }
    }

    private class g extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMViewPager vnD;

        public g(MMViewPager mMViewPager) {
            this.vnD = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.vnD.handler.post(new Runnable(this) {
                final /* synthetic */ g vnF;

                {
                    this.vnF = r1;
                }

                public final void run() {
                    float d;
                    float b;
                    this.vnF.vnD.mjb.getImageMatrix().getValues(this.vnF.mja);
                    float scale = this.vnF.vnD.mjb.getScale() * ((float) this.vnF.vnD.mjb.imageWidth);
                    float scale2 = this.vnF.vnD.mjb.getScale() * ((float) this.vnF.vnD.mjb.imageHeight);
                    float f = this.vnF.mja[2];
                    float f2 = this.vnF.mja[5];
                    float f3 = this.vnF.mja[2] + scale;
                    float f4 = this.vnF.mja[5] + scale2;
                    float d2 = (float) this.vnF.vnD.jYq;
                    float b2 = (float) this.vnF.vnD.jYp;
                    if (scale2 < ((float) this.vnF.vnD.jYq)) {
                        d2 = (((float) this.vnF.vnD.jYq) / 2.0f) - (scale2 / 2.0f);
                        d = (((float) this.vnF.vnD.jYq) / 2.0f) + (scale2 / 2.0f);
                    } else {
                        float f5 = d2;
                        d2 = 0.0f;
                        d = f5;
                    }
                    d2 -= f2;
                    d -= f4;
                    if (d2 >= 0.0f) {
                        if (d > 0.0f) {
                            d2 = d;
                        } else {
                            d2 = 0.0f;
                        }
                    }
                    if (scale < ((float) this.vnF.vnD.jYp)) {
                        d = (((float) this.vnF.vnD.jYp) / 2.0f) - (scale / 2.0f);
                        b = (((float) this.vnF.vnD.jYp) / 2.0f) + (scale / 2.0f);
                    } else {
                        b = b2;
                        d = 0.0f;
                    }
                    d -= f;
                    b -= f3;
                    if (d >= 0.0f) {
                        if (b > 0.0f) {
                            d = b;
                        } else {
                            d = 0.0f;
                        }
                    }
                    if (Math.abs(d) > 5.0f || Math.abs(d2) > 5.0f) {
                        if (d >= 0.0f) {
                            d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            d = (-((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                        if (d2 >= 0.0f) {
                            d2 = ((float) (((double) Math.abs(d2)) - Math.pow(Math.sqrt((double) Math.abs(d2)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            d2 = (-((float) (((double) Math.abs(d2)) - Math.pow(Math.sqrt((double) Math.abs(d2)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                    } else {
                        this.vnF.miY = true;
                    }
                    this.vnF.vnD.mjb.G(d, d2);
                }
            });
        }
    }

    private class h extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMViewPager vnD;

        public h(MMViewPager mMViewPager) {
            this.vnD = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.vnD.handler.post(new Runnable(this) {
                final /* synthetic */ h vnG;

                {
                    this.vnG = r1;
                }

                public final void run() {
                    this.vnG.vnD.mjb.getImageMatrix().getValues(this.vnG.mja);
                    float f = this.vnG.mja[2];
                    float scale = this.vnG.vnD.mjb.getScale() * ((float) this.vnG.vnD.mjb.imageWidth);
                    if (scale < ((float) this.vnG.vnD.jYp)) {
                        scale = (((float) this.vnG.vnD.jYp) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.vnG.miY = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.vnG.miY = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.vnG.vnD.mjb.G(scale, 0.0f);
                }
            });
        }
    }

    private class i extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMViewPager vnD;

        public i(MMViewPager mMViewPager) {
            this.vnD = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.vnD.handler.post(new Runnable(this) {
                final /* synthetic */ i vnH;

                {
                    this.vnH = r1;
                }

                public final void run() {
                    this.vnH.vnD.mjb.getImageMatrix().getValues(this.vnH.mja);
                    float scale = ((float) this.vnH.vnD.mjb.imageWidth) * this.vnH.vnD.mjb.getScale();
                    float f = this.vnH.mja[2] + scale;
                    float b = (float) this.vnH.vnD.jYp;
                    if (scale < ((float) this.vnH.vnD.jYp)) {
                        b = (((float) this.vnH.vnD.jYp) / 2.0f) + (scale / 2.0f);
                    }
                    b -= f;
                    if (b <= 0.0f) {
                        this.vnH.miY = true;
                    } else if (Math.abs(b) <= 5.0f) {
                        this.vnH.miY = true;
                    } else {
                        b = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.vnH.vnD.mjb.G(b, 0.0f);
                }
            });
        }
    }

    private class j extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMViewPager vnD;

        public j(MMViewPager mMViewPager) {
            this.vnD = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.vnD.handler.post(new Runnable(this) {
                final /* synthetic */ j vnI;

                {
                    this.vnI = r1;
                }

                public final void run() {
                    this.vnI.vnD.mjb.getImageMatrix().getValues(this.vnI.mja);
                    float f = this.vnI.mja[5];
                    float scale = this.vnI.vnD.mjb.getScale() * ((float) this.vnI.vnD.mjb.imageHeight);
                    if (scale < ((float) this.vnI.vnD.jYq)) {
                        scale = (((float) this.vnI.vnD.jYq) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.vnI.miY = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.vnI.miY = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.vnI.vnD.mjb.G(0.0f, scale);
                }
            });
        }
    }

    public static class k extends ae {
        long mjh;
        WeakReference<MMViewPager> vnJ;

        public k(WeakReference<MMViewPager> weakReference) {
            this.vnJ = weakReference;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            removeMessages(message.what);
            if (this.vnJ != null) {
                MMViewPager mMViewPager = (MMViewPager) this.vnJ.get();
                if (mMViewPager != null && message.what == 1) {
                    if (mMViewPager.vnt == null || mMViewPager.vnt.azf()) {
                        mMViewPager.azd();
                        return;
                    }
                    mMViewPager.vnt.play();
                    sendEmptyMessageDelayed(message.what, this.mjh);
                }
            }
        }
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MotionEvent motionEvent) {
        if (mMViewPager.fk == null) {
            mMViewPager.fk = VelocityTracker.obtain();
        }
        mMViewPager.fk.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                mMViewPager.mwV = motionEvent.getX();
                mMViewPager.qEv = motionEvent.getY();
                break;
            case 1:
                mMViewPager.qEy = false;
                if (mMViewPager.qEx) {
                    if (mMViewPager.vnA != null) {
                        mMViewPager.vnA.C(0.0f, 0.0f);
                    }
                    mMViewPager.qEw = false;
                    return true;
                } else if (mMViewPager.qEw) {
                    if (mMViewPager.vnu != null) {
                        mMViewPager.vnu.azc();
                    }
                    mMViewPager.qEw = false;
                    return true;
                }
                break;
            case 2:
                float x = motionEvent.getX() - mMViewPager.mwV;
                float y = motionEvent.getY() - mMViewPager.qEv;
                VelocityTracker velocityTracker = mMViewPager.fk;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (mMViewPager.vnA != null) {
                    mMViewPager.vnA.D(x, y);
                    if ((Math.abs(x) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || mMViewPager.qEy) && !mMViewPager.qEw) {
                        mMViewPager.qEw = false;
                    } else {
                        mMViewPager.vnA.C(x, y);
                        mMViewPager.qEw = true;
                    }
                    if (y > 200.0f) {
                        mMViewPager.qEx = false;
                    } else {
                        mMViewPager.qEx = true;
                    }
                }
                if (mMViewPager.fk != null) {
                    mMViewPager.fk.recycle();
                    mMViewPager.fk = null;
                    break;
                }
                break;
        }
        return false;
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MotionEvent motionEvent, MotionEvent motionEvent2, float f) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean b = b(motionEvent, motionEvent2);
        x = Math.abs(x);
        y = Math.abs(y);
        if (Math.abs(f) <= 500.0f || x < 60.0f || x < y) {
            return false;
        }
        if (b) {
            mMViewPager.onKeyDown(21, null);
        } else {
            mMViewPager.onKeyDown(22, null);
        }
        return true;
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MultiTouchImageView multiTouchImageView, MotionEvent motionEvent) {
        if (mMViewPager.fk == null) {
            mMViewPager.fk = VelocityTracker.obtain();
        }
        mMViewPager.fk.addMovement(motionEvent);
        float j;
        float sqrt;
        switch (motionEvent.getAction() & 255) {
            case 0:
                w.d("MicroMsg.MMViewPager", "ACTION_DOWN");
                multiTouchImageView.bSN();
                float[] fArr = new float[9];
                multiTouchImageView.getImageMatrix().getValues(fArr);
                if (((float) Math.round(fArr[5])) < mMViewPager.miL.top) {
                    mMViewPager.vnn = true;
                } else {
                    mMViewPager.vnn = false;
                }
                mMViewPager.mwV = motionEvent.getX();
                mMViewPager.qEv = motionEvent.getY();
                mMViewPager.miO = 0.0f;
                mMViewPager.miN = multiTouchImageView.getScale();
                mMViewPager.miI = false;
                mMViewPager.vnz = System.currentTimeMillis();
                return false;
            case 1:
                w.d("MicroMsg.MMViewPager", "ACTION_UP");
                mMViewPager.vno = false;
                mMViewPager.vnp = false;
                mMViewPager.qEy = false;
                if ((mMViewPager.miR || mMViewPager.miS || mMViewPager.vnq || mMViewPager.vnr) && (mMViewPager.miP || mMViewPager.miQ)) {
                    mMViewPager.vnt = new g(mMViewPager);
                    mMViewPager.aze();
                    mMViewPager.miR = false;
                    mMViewPager.miS = false;
                    mMViewPager.vnq = false;
                    mMViewPager.vnr = false;
                    mMViewPager.miP = false;
                    mMViewPager.miQ = false;
                } else {
                    if (mMViewPager.vnq || mMViewPager.miR) {
                        mMViewPager.vnq = false;
                        mMViewPager.miR = false;
                        mMViewPager.vnt = new h(mMViewPager);
                        mMViewPager.aze();
                    }
                    if (mMViewPager.vnr || mMViewPager.miS) {
                        mMViewPager.vnr = false;
                        mMViewPager.miS = false;
                        mMViewPager.vnt = new i(mMViewPager);
                        mMViewPager.aze();
                    }
                    if (mMViewPager.miP) {
                        mMViewPager.miP = false;
                        mMViewPager.vnt = new j(mMViewPager);
                        mMViewPager.aze();
                    }
                    if (mMViewPager.miQ) {
                        mMViewPager.miQ = false;
                        mMViewPager.vnt = new f(mMViewPager);
                        mMViewPager.aze();
                    }
                }
                mMViewPager.miO = 0.0f;
                mMViewPager.miN = multiTouchImageView.getScale();
                if (mMViewPager.qEx) {
                    if (mMViewPager.vnA != null) {
                        mMViewPager.vnA.C(0.0f, 0.0f);
                    }
                    mMViewPager.qEw = false;
                    return false;
                } else if (!mMViewPager.qEw || mMViewPager.vnn) {
                    return false;
                } else {
                    if (mMViewPager.vnu != null) {
                        mMViewPager.vnu.azc();
                    }
                    mMViewPager.qEw = false;
                    return true;
                }
            case 2:
                w.d("MicroMsg.MMViewPager", "ACTION_MOVE");
                float i;
                if (f.H(motionEvent) == 2) {
                    mMViewPager.miI = true;
                    i = f.i(motionEvent, 0) - f.i(motionEvent, 1);
                    j = f.j(motionEvent, 0) - f.j(motionEvent, 1);
                    sqrt = (float) Math.sqrt((double) ((i * i) + (j * j)));
                    if (mMViewPager.miO == 0.0f) {
                        mMViewPager.miO = sqrt;
                    } else {
                        sqrt /= mMViewPager.miO;
                        if (mMViewPager.miI) {
                            multiTouchImageView.f(sqrt * mMViewPager.miN, i + f.i(motionEvent, 1), j + f.j(motionEvent, 1));
                        }
                    }
                    return true;
                }
                j = motionEvent.getX() - mMViewPager.mwV;
                sqrt = motionEvent.getY() - mMViewPager.qEv;
                VelocityTracker velocityTracker = mMViewPager.fk;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (!(mMViewPager.vnA == null || mMViewPager.vnn || mMViewPager.miI || mMViewPager.miN > multiTouchImageView.pbn)) {
                    mMViewPager.vnA.D(j, sqrt);
                    if ((Math.abs(j) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || mMViewPager.qEy) && !mMViewPager.qEw) {
                        mMViewPager.qEw = false;
                    } else {
                        mMViewPager.vnA.C(j, sqrt);
                        mMViewPager.qEw = true;
                    }
                    if (sqrt > 200.0f) {
                        mMViewPager.qEx = false;
                    } else {
                        mMViewPager.qEx = true;
                    }
                }
                if (mMViewPager.fk != null) {
                    mMViewPager.fk.recycle();
                    mMViewPager.fk = null;
                }
                if (mMViewPager.vny == null) {
                    return false;
                }
                if (mMViewPager.vny.getAction() != 0 && mMViewPager.vny.getAction() != 2 && mMViewPager.vny.getAction() != 5 && mMViewPager.vny.getAction() != 261) {
                    return false;
                }
                boolean z;
                float i2 = f.i(mMViewPager.vny, 0) - f.i(motionEvent, 0);
                j = f.j(mMViewPager.vny, 0) - f.j(motionEvent, 0);
                if (mMViewPager.miI || mMViewPager.qEw) {
                    z = true;
                } else if (i2 == 0.0f && j == 0.0f) {
                    z = true;
                } else {
                    View Al = ((t) mMViewPager.yr).Al(mMViewPager.ys);
                    float[] fArr2 = new float[9];
                    mMViewPager.mjb.getImageMatrix().getValues(fArr2);
                    float scale = mMViewPager.mjb.getScale() * ((float) mMViewPager.mjb.imageWidth);
                    float scale2 = mMViewPager.mjb.getScale() * ((float) mMViewPager.mjb.imageHeight);
                    float f = fArr2[2];
                    float f2 = f + scale;
                    float f3 = fArr2[5];
                    float f4 = f3 + scale2;
                    if (((int) scale) > mMViewPager.jYp || ((int) scale2) > mMViewPager.jYq) {
                        if (((int) scale) > mMViewPager.jYp || ((int) scale2) <= mMViewPager.jYq) {
                            if (((int) scale) <= mMViewPager.jYp || ((int) scale2) > mMViewPager.jYq) {
                                if (Math.abs(j) > Math.abs(i2)) {
                                    sqrt = 0.0f;
                                    i = 0.0f;
                                    if (i2 != 0.0f) {
                                        mMViewPager.vnp = true;
                                        if (i2 < 0.0f) {
                                            if (f > mMViewPager.miL.left) {
                                                mMViewPager.miR = true;
                                            }
                                            if (f <= mMViewPager.miL.left || f2 < ((float) mMViewPager.jYp)) {
                                                sqrt = i2;
                                            } else if (f > mMViewPager.miL.left && f < ((float) mMViewPager.jYp) * 0.3f) {
                                                sqrt = 0.3f * i2;
                                            }
                                        } else {
                                            if (f2 < mMViewPager.miL.right) {
                                                mMViewPager.miS = true;
                                            }
                                            if (f > 0.0f || f2 >= ((float) mMViewPager.jYp)) {
                                                sqrt = i2;
                                            } else if (f2 > ((float) mMViewPager.jYp) * 0.7f && f2 < ((float) mMViewPager.jYq)) {
                                                sqrt = 0.3f * i2;
                                            }
                                        }
                                    }
                                    if (j != 0.0f) {
                                        mMViewPager.vno = true;
                                        if (j < 0.0f) {
                                            if (f3 > mMViewPager.miL.top) {
                                                mMViewPager.miP = true;
                                            }
                                            if (f3 <= mMViewPager.miL.top || f4 < ((float) mMViewPager.jYq)) {
                                                i = j;
                                            } else if (f3 > mMViewPager.miL.top && f3 < ((float) mMViewPager.jYq) * 0.3f) {
                                                i = 0.3f * j;
                                            }
                                        } else {
                                            if (f4 < mMViewPager.miL.bottom) {
                                                mMViewPager.miQ = true;
                                            }
                                            if (f3 > 0.0f || f4 >= ((float) mMViewPager.jYq)) {
                                                i = j;
                                            } else if (f4 > ((float) mMViewPager.jYq) * 0.7f && f4 < ((float) mMViewPager.jYq)) {
                                                i = 0.3f * j;
                                            }
                                        }
                                    }
                                    mMViewPager.mjb.G(-sqrt, -i);
                                    z = true;
                                } else if (mMViewPager.a(f, f2, Al, i2)) {
                                    z = true;
                                } else {
                                    if (i2 > 0.0f) {
                                        if (f2 <= ((float) mMViewPager.jYp)) {
                                            z = mMViewPager.bSC();
                                        }
                                    } else if (f >= 0.0f) {
                                        z = mMViewPager.bSC();
                                    }
                                    if (!mMViewPager.vnp || ((((double) mMViewPager.vnx) < 0.06d && i2 > 0.0f && f2 > ((float) mMViewPager.jYp)) || ((((double) mMViewPager.vnx) > 0.94d || mMViewPager.vnx == 0.0f) && i2 < 0.0f && f < 0.0f))) {
                                        i = -i2;
                                        if (i2 < 0.0f) {
                                            if (f < 0.0f && f - i2 > 0.0f) {
                                                sqrt = -f;
                                            }
                                            sqrt = i;
                                        } else {
                                            if (f2 > ((float) mMViewPager.jYp) && f2 - i2 < ((float) mMViewPager.jYp)) {
                                                sqrt = ((float) mMViewPager.jYp) - f2;
                                            }
                                            sqrt = i;
                                        }
                                        i = -j;
                                        if (j < 0.0f) {
                                            if (f3 < 0.0f && f3 + i > 0.0f) {
                                                i = -f3;
                                            }
                                        } else if (f4 > ((float) mMViewPager.jYq) && f4 + i < ((float) mMViewPager.jYq)) {
                                            i = ((float) mMViewPager.jYq) - f4;
                                        }
                                        mMViewPager.mjb.G(sqrt, i);
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                            } else if (mMViewPager.a(f, f2, Al, i2)) {
                                z = true;
                            } else {
                                if (i2 > 0.0f) {
                                    if (f2 <= ((float) mMViewPager.jYp)) {
                                        z = mMViewPager.bSC();
                                    }
                                } else if (f >= 0.0f) {
                                    z = mMViewPager.bSC();
                                }
                                if (!mMViewPager.vnp || ((((double) mMViewPager.vnx) < 0.06d && i2 > 0.0f && f2 > ((float) mMViewPager.jYp)) || ((((double) mMViewPager.vnx) > 0.94d || mMViewPager.vnx == 0.0f) && i2 < 0.0f && f < 0.0f))) {
                                    i = -i2;
                                    if (i2 < 0.0f) {
                                        if (f < 0.0f && f - i2 > 0.0f) {
                                            i = -f;
                                        }
                                    } else if (f2 > ((float) mMViewPager.jYp) && f2 - i2 < ((float) mMViewPager.jYp)) {
                                        i = ((float) mMViewPager.jYp) - f2;
                                    }
                                    mMViewPager.mjb.G(i, 0.0f);
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                        } else if (Math.abs(j) > Math.abs(i2)) {
                            if (mMViewPager.vnp || mMViewPager.vnq || mMViewPager.vnr) {
                                z = true;
                            } else {
                                mMViewPager.vno = true;
                                i = 0.0f;
                                if (j < 0.0f) {
                                    if (f3 > mMViewPager.miL.top) {
                                        mMViewPager.miP = true;
                                    }
                                    if (f3 <= mMViewPager.miL.top || f4 < ((float) mMViewPager.jYq)) {
                                        j = -j;
                                    } else {
                                        if (f3 > mMViewPager.miL.top && f3 < ((float) mMViewPager.jYq) * 0.3f) {
                                            j = -(j * 0.3f);
                                        }
                                        j = 0.0f;
                                    }
                                } else {
                                    if (f4 < mMViewPager.miL.bottom) {
                                        mMViewPager.miQ = true;
                                    }
                                    if (f3 > 0.0f || f4 >= ((float) mMViewPager.jYq)) {
                                        j = -j;
                                    } else {
                                        if (f4 > ((float) mMViewPager.jYq) * 0.7f && f4 < ((float) mMViewPager.jYq)) {
                                            j = -(j * 0.3f);
                                        }
                                        j = 0.0f;
                                    }
                                }
                                if (i2 < 0.0f && f > mMViewPager.miL.left) {
                                    mMViewPager.miR = true;
                                    i = -(0.3f * i2);
                                } else if (i2 > 0.0f && f2 < mMViewPager.miL.right) {
                                    mMViewPager.miS = true;
                                    i = -(0.3f * i2);
                                }
                                mMViewPager.mjb.G(i, j);
                                z = true;
                            }
                        } else if (mMViewPager.a(f, f2, Al, i2)) {
                            z = true;
                        } else {
                            if (i2 > 0.0f) {
                                if (f2 <= ((float) mMViewPager.jYp)) {
                                    z = mMViewPager.bSC();
                                }
                            } else if (f >= 0.0f) {
                                z = mMViewPager.bSC();
                            }
                            if (!mMViewPager.vnp) {
                                i = -i2;
                                if (i2 < 0.0f) {
                                    if (f < 0.0f && f - i2 > 0.0f) {
                                        i = -f;
                                    }
                                } else if (f2 > ((float) mMViewPager.jYp) && f2 - i2 < ((float) mMViewPager.jYp)) {
                                    i = ((float) mMViewPager.jYp) - f2;
                                }
                                mMViewPager.mjb.G(i, 0.0f);
                            }
                            z = true;
                        }
                    } else if (mMViewPager.a(f, f2, Al, i2)) {
                        z = true;
                    } else {
                        if (i2 > 0.0f) {
                            if (f2 <= ((float) mMViewPager.jYp)) {
                                z = mMViewPager.bSC();
                            }
                        } else if (f >= 0.0f) {
                            z = mMViewPager.bSC();
                        }
                        if (!mMViewPager.vnp) {
                            i = -i2;
                            if (i2 < 0.0f) {
                                if (f < 0.0f && f - i2 > 0.0f) {
                                    i = -f;
                                }
                            } else if (f2 > ((float) mMViewPager.jYp) && f2 - i2 < ((float) mMViewPager.jYp)) {
                                i = ((float) mMViewPager.jYp) - f2;
                            }
                            mMViewPager.mjb.G(i, 0.0f);
                        }
                        z = true;
                    }
                }
                if (z) {
                    return z;
                }
                j = f.i(mMViewPager.vny, 0);
                sqrt = f.j(mMViewPager.vny, 0);
                mMViewPager.yN = j;
                mMViewPager.yO = sqrt;
                return z;
            case 5:
                w.d("MicroMsg.MMViewPager", "ACTION_POINTER_DOWN");
                mMViewPager.miO = 0.0f;
                mMViewPager.miN = multiTouchImageView.getScale();
                mMViewPager.miI = true;
                if (mMViewPager.yT) {
                    return true;
                }
                if (!mMViewPager.iC) {
                    mMViewPager.yT = true;
                    super.X(1);
                    mMViewPager.yN = 0.0f;
                    mMViewPager.xC = 0.0f;
                    if (mMViewPager.fk == null) {
                        mMViewPager.fk = VelocityTracker.obtain();
                    } else {
                        mMViewPager.fk.clear();
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
                    mMViewPager.fk.addMovement(obtain);
                    obtain.recycle();
                    mMViewPager.qll = uptimeMillis;
                }
                return true;
            case 6:
                w.d("MicroMsg.MMViewPager", "ACTION_POINTER_UP");
                mMViewPager.miO = 0.0f;
                mMViewPager.miN = multiTouchImageView.getScale();
                mMViewPager.miI = true;
                if (mMViewPager.miN < multiTouchImageView.pbn) {
                    multiTouchImageView.E((f.i(motionEvent, 0) - f.i(motionEvent, 1)) + f.i(motionEvent, 1), (f.j(motionEvent, 0) - f.j(motionEvent, 1)) + f.j(motionEvent, 1));
                }
                if (mMViewPager.miN <= multiTouchImageView.bSO() * 2.0f) {
                    return false;
                }
                j = f.i(motionEvent, 0) - f.i(motionEvent, 1);
                sqrt = f.j(motionEvent, 0) - f.j(motionEvent, 1);
                multiTouchImageView.at(multiTouchImageView.bSO() * 2.0f);
                multiTouchImageView.f(multiTouchImageView.bSO() * 2.0f, j + f.i(motionEvent, 1), sqrt + f.j(motionEvent, 1));
                return false;
            default:
                return false;
        }
    }

    public MMViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
    }

    private void azd() {
        this.vnm.removeMessages(1);
    }

    private void aze() {
        azd();
        k kVar = this.vnm;
        kVar.mjh = 15;
        kVar.sendEmptyMessageDelayed(1, 15);
    }

    public final void b(android.support.v4.view.ViewPager.e eVar) {
        this.vnw = eVar;
    }

    public MMViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
        this.vnm = new k(new WeakReference(this));
        this.iXs = new GestureDetector(context, new d());
        this.miJ = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.vns = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        super.b(new android.support.v4.view.ViewPager.e(this) {
            final /* synthetic */ MMViewPager vnD;

            {
                this.vnD = r1;
            }

            public final void V(int i) {
                if (this.vnD.vnw != null) {
                    this.vnD.vnw.V(i);
                }
            }

            public final void a(int i, float f, int i2) {
                if (this.vnD.vnw != null) {
                    this.vnD.vnw.a(i, f, i2);
                }
                this.vnD.vnx = f;
            }

            public final void W(int i) {
                if (this.vnD.vnw != null) {
                    this.vnD.vnw.W(i);
                }
                if (i == 0) {
                    this.vnD.vnx = 0.0f;
                }
            }
        });
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMViewPager vnD;

            {
                this.vnD = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onTouch;
                if (this.vnD.rlX != null) {
                    onTouch = this.vnD.rlX.onTouch(view, motionEvent);
                } else {
                    onTouch = false;
                }
                MultiTouchImageView g = ((t) this.vnD.yr).nk(this.vnD.ys);
                if (g == null) {
                    MMViewPager.a(this.vnD, motionEvent);
                    this.vnD.vny = null;
                    this.vnD.iXs.onTouchEvent(motionEvent);
                    return (this.vnD.miI || this.vnD.qEw) ? true : onTouch;
                } else {
                    this.vnD.mjb = g;
                    boolean a = MMViewPager.a(this.vnD, this.vnD.mjb, motionEvent);
                    if (this.vnD.vny != null) {
                        this.vnD.vny.recycle();
                    }
                    this.vnD.vny = MotionEvent.obtainNoHistory(motionEvent);
                    this.vnD.iXs.onTouchEvent(motionEvent);
                    this.vnD.computeScroll();
                    return a || onTouch;
                }
            }
        });
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.rlX = onTouchListener;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.jYp = MeasureSpec.getSize(i);
        this.jYq = MeasureSpec.getSize(i2);
        this.miL.set(0.0f, 0.0f, (float) this.jYp, (float) this.jYq);
    }

    private boolean bSC() {
        if (this.vno) {
            return true;
        }
        this.vnp = true;
        return false;
    }

    private boolean a(float f, float f2, View view, float f3) {
        boolean z;
        if (this.yr.j(view) == bSE()) {
            if (this.vnr) {
                if (f3 > 0.0f) {
                    if (f2 >= ((float) this.jYp)) {
                        this.mjb.G(-f3, 0.0f);
                    } else if (f2 > ((float) this.jYp) * 0.7f && f2 < ((float) this.jYq)) {
                        this.mjb.G(-(f3 * 0.3f), 0.0f);
                        z = true;
                    }
                }
                z = false;
            } else if (f3 > 0.0f) {
                if (f2 < ((float) this.jYp)) {
                    this.vnr = true;
                }
                if (f2 >= ((float) this.jYp)) {
                    this.mjb.G(-f3, 0.0f);
                } else if (f2 > ((float) this.jYp) * 0.7f && f2 < ((float) this.jYq)) {
                    this.mjb.G(-(f3 * 0.3f), 0.0f);
                    z = true;
                }
            }
            if (z) {
                return true;
            }
            if (this.yr.j(view) == bSD()) {
                if (this.vnq) {
                    if (f3 < 0.0f) {
                        if (f > this.miL.left) {
                            this.mjb.G(-f3, 0.0f);
                        } else if (f > this.miL.left && f < ((float) this.jYp) * 0.3f) {
                            this.mjb.G(-(f3 * 0.3f), 0.0f);
                            z = true;
                        }
                    }
                    z = false;
                } else if (f3 < 0.0f) {
                    if (f > 0.0f) {
                        this.vnq = true;
                    }
                    if (f > this.miL.left) {
                        this.mjb.G(-f3, 0.0f);
                    } else if (f > this.miL.left && f < ((float) this.jYp) * 0.3f) {
                        this.mjb.G(-(f3 * 0.3f), 0.0f);
                        z = true;
                    }
                }
                if (z) {
                    return false;
                }
                return true;
            }
            if (!this.vnp || this.vno) {
                z = false;
            } else {
                this.vnq = false;
                z = false;
            }
            if (z) {
                return true;
            }
            return false;
        }
        if (this.vnp || this.vno) {
            z = false;
        } else {
            this.vnr = false;
            z = false;
        }
        if (z) {
            return true;
        }
        if (this.yr.j(view) == bSD()) {
            if (this.vnq) {
                if (f3 < 0.0f) {
                    if (f > this.miL.left) {
                        this.mjb.G(-(f3 * 0.3f), 0.0f);
                        z = true;
                    } else {
                        this.mjb.G(-f3, 0.0f);
                    }
                }
                z = false;
            } else if (f3 < 0.0f) {
                if (f > 0.0f) {
                    this.vnq = true;
                }
                if (f > this.miL.left) {
                    this.mjb.G(-(f3 * 0.3f), 0.0f);
                    z = true;
                } else {
                    this.mjb.G(-f3, 0.0f);
                }
            }
            if (z) {
                return false;
            }
            return true;
        }
        if (this.vnp) {
        }
        z = false;
        if (z) {
            return true;
        }
        return false;
    }

    public final void a(u uVar) {
        if (uVar instanceof t) {
            super.a(uVar);
            return;
        }
        throw new IllegalArgumentException("must be MMViewPagerAdapter");
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent.getX() - motionEvent2.getX() < 0.0f;
    }

    public void computeScroll() {
        int i = 0;
        super.computeScroll();
        if (this.mjb != null) {
            float scale = this.mjb.getScale() * ((float) this.mjb.imageWidth);
            float scale2 = this.mjb.getScale() * ((float) this.mjb.imageHeight);
            if (this.miJ.computeScrollOffset()) {
                int currX = this.miJ.getCurrX() - this.abb;
                int currY = this.miJ.getCurrY() - this.abc;
                this.abb = this.miJ.getCurrX();
                this.abc = this.miJ.getCurrY();
                float[] fArr = new float[9];
                this.mjb.getImageMatrix().getValues(fArr);
                float f = fArr[2];
                scale += f;
                float f2 = fArr[5];
                float f3 = f2 + scale2;
                if (currX < 0 && ((float) currX) < this.miL.right - ((float) Math.round(scale))) {
                    currX = (int) (this.miL.right - ((float) Math.round(scale)));
                }
                if (currX > 0 && ((float) currX) > this.miL.left - ((float) Math.round(f))) {
                    currX = (int) (this.miL.left - ((float) Math.round(f)));
                }
                if (currY < 0 && ((float) currY) < this.miL.bottom - ((float) Math.round(f3))) {
                    currY = (int) (this.miL.bottom - ((float) Math.round(f3)));
                }
                if (currY > 0 && ((float) currY) > this.miL.top - ((float) Math.round(f2))) {
                    currY = (int) (this.miL.top - ((float) Math.round(f2)));
                }
                if (((float) Math.round(f)) >= this.miL.left || ((float) Math.round(scale)) <= this.miL.right) {
                    currX = 0;
                } else if (((float) Math.round(f2)) >= this.miL.top || ((float) Math.round(f3)) <= this.miL.bottom) {
                    currY = 0;
                }
                if (scale2 >= ((float) this.jYq)) {
                    i = currY;
                }
                this.mjb.G((float) currX, (float) i);
                postInvalidate();
            }
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    public boolean isFocused() {
        return true;
    }

    public final int bSD() {
        int bSD = ((t) this.yr).bSD();
        return bSD >= 0 ? bSD : super.bSD();
    }

    public final int bSE() {
        int bSE = ((t) this.yr).bSE();
        return bSE >= 0 ? bSE : super.bSE();
    }
}
