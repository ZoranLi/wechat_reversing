package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MMGestureGallery extends Gallery {
    private int abb;
    private int abc;
    private int count = 0;
    private VelocityTracker fk;
    private ae handler = new ae(Looper.getMainLooper());
    private int jYp;
    private int jYq;
    private long miD = 0;
    private long miE = 0;
    private float miF = 0.0f;
    private float miG = 0.0f;
    private long miH = 0;
    private boolean miI = false;
    private OverScroller miJ;
    private GestureDetector miK;
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
    private final int vnB = 60;
    private final int vnC = 500;
    public boolean vnn = false;
    private boolean vno = false;
    private boolean vnp = false;
    private boolean vnq = false;
    private boolean vnr = false;
    private int vns = 0;
    public l wmN;
    public l wmO;
    public l wmP;
    private a wmQ;
    public f wmR;
    public c wmS;
    public e wmT;
    public boolean wmU = true;
    public b wmV;

    private abstract class a {
        protected boolean miY = false;
        final /* synthetic */ MMGestureGallery wmW;

        public abstract void play();

        public a(MMGestureGallery mMGestureGallery) {
            this.wmW = mMGestureGallery;
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
        final /* synthetic */ MMGestureGallery wmW;

        private d(MMGestureGallery mMGestureGallery) {
            this.wmW = mMGestureGallery;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }
    }

    public interface e {
        void bku();
    }

    public interface f {
        void ahA();
    }

    private class g extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMGestureGallery wmW;

        public g(MMGestureGallery mMGestureGallery) {
            this.wmW = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.wmW.handler.post(new Runnable(this) {
                final /* synthetic */ g wmX;

                {
                    this.wmX = r1;
                }

                public final void run() {
                    this.wmX.wmW.mjb.getImageMatrix().getValues(this.wmX.mja);
                    float scale = ((float) this.wmX.wmW.mjb.imageHeight) * this.wmX.wmW.mjb.getScale();
                    float f = this.wmX.mja[5] + scale;
                    float d = (float) this.wmX.wmW.jYq;
                    if (scale < ((float) this.wmX.wmW.jYq)) {
                        d = (((float) this.wmX.wmW.jYq) / 2.0f) + (scale / 2.0f);
                    }
                    d -= f;
                    if (d <= 0.0f) {
                        this.wmX.miY = true;
                    } else if (Math.abs(d) <= 5.0f) {
                        this.wmX.miY = true;
                    } else {
                        d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.wmX.wmW.mjb.G(0.0f, d);
                }
            });
        }
    }

    private class h extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMGestureGallery wmW;

        public h(MMGestureGallery mMGestureGallery) {
            this.wmW = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.wmW.handler.post(new Runnable(this) {
                final /* synthetic */ h wmY;

                {
                    this.wmY = r1;
                }

                public final void run() {
                    float d;
                    float b;
                    this.wmY.wmW.mjb.getImageMatrix().getValues(this.wmY.mja);
                    float scale = this.wmY.wmW.mjb.getScale() * ((float) this.wmY.wmW.mjb.imageWidth);
                    float scale2 = this.wmY.wmW.mjb.getScale() * ((float) this.wmY.wmW.mjb.imageHeight);
                    float f = this.wmY.mja[2];
                    float f2 = this.wmY.mja[5];
                    float f3 = this.wmY.mja[2] + scale;
                    float f4 = this.wmY.mja[5] + scale2;
                    float d2 = (float) this.wmY.wmW.jYq;
                    float b2 = (float) this.wmY.wmW.jYp;
                    if (scale2 < ((float) this.wmY.wmW.jYq)) {
                        d2 = (((float) this.wmY.wmW.jYq) / 2.0f) - (scale2 / 2.0f);
                        d = (((float) this.wmY.wmW.jYq) / 2.0f) + (scale2 / 2.0f);
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
                    if (scale < ((float) this.wmY.wmW.jYp)) {
                        d = (((float) this.wmY.wmW.jYp) / 2.0f) - (scale / 2.0f);
                        b = (((float) this.wmY.wmW.jYp) / 2.0f) + (scale / 2.0f);
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
                        this.wmY.miY = true;
                    }
                    this.wmY.wmW.mjb.G(d, d2);
                }
            });
        }
    }

    private class i extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMGestureGallery wmW;

        public i(MMGestureGallery mMGestureGallery) {
            this.wmW = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.wmW.handler.post(new Runnable(this) {
                final /* synthetic */ i wmZ;

                {
                    this.wmZ = r1;
                }

                public final void run() {
                    this.wmZ.wmW.mjb.getImageMatrix().getValues(this.wmZ.mja);
                    float f = this.wmZ.mja[2];
                    float scale = this.wmZ.wmW.mjb.getScale() * ((float) this.wmZ.wmW.mjb.imageWidth);
                    if (scale < ((float) this.wmZ.wmW.jYp)) {
                        scale = (((float) this.wmZ.wmW.jYp) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.wmZ.miY = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.wmZ.miY = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.wmZ.wmW.mjb.G(scale, 0.0f);
                }
            });
        }
    }

    private class j extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMGestureGallery wmW;

        public j(MMGestureGallery mMGestureGallery) {
            this.wmW = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.wmW.handler.post(new Runnable(this) {
                final /* synthetic */ j wna;

                {
                    this.wna = r1;
                }

                public final void run() {
                    this.wna.wmW.mjb.getImageMatrix().getValues(this.wna.mja);
                    float scale = ((float) this.wna.wmW.mjb.imageWidth) * this.wna.wmW.mjb.getScale();
                    float f = this.wna.mja[2] + scale;
                    float b = (float) this.wna.wmW.jYp;
                    if (scale < ((float) this.wna.wmW.jYp)) {
                        b = (((float) this.wna.wmW.jYp) / 2.0f) + (scale / 2.0f);
                    }
                    b -= f;
                    if (b <= 0.0f) {
                        this.wna.miY = true;
                    } else if (Math.abs(b) <= 5.0f) {
                        this.wna.miY = true;
                    } else {
                        b = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.wna.wmW.mjb.G(b, 0.0f);
                }
            });
        }
    }

    private class k extends a {
        public float[] mja = new float[9];
        final /* synthetic */ MMGestureGallery wmW;

        public k(MMGestureGallery mMGestureGallery) {
            this.wmW = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.wmW.handler.post(new Runnable(this) {
                final /* synthetic */ k wnb;

                {
                    this.wnb = r1;
                }

                public final void run() {
                    this.wnb.wmW.mjb.getImageMatrix().getValues(this.wnb.mja);
                    float f = this.wnb.mja[5];
                    float scale = this.wnb.wmW.mjb.getScale() * ((float) this.wnb.wmW.mjb.imageHeight);
                    if (scale < ((float) this.wnb.wmW.jYq)) {
                        scale = (((float) this.wnb.wmW.jYq) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.wnb.miY = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.wnb.miY = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.wnb.wmW.mjb.G(0.0f, scale);
                }
            });
        }
    }

    public static class l extends ae {
        private long mjh;
        private boolean mji;
        WeakReference<MMGestureGallery> vnJ;

        public l(WeakReference<MMGestureGallery> weakReference) {
            this.vnJ = weakReference;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            removeMessages(message.what);
            if (this.vnJ != null) {
                final MMGestureGallery mMGestureGallery = (MMGestureGallery) this.vnJ.get();
                if (mMGestureGallery == null) {
                    return;
                }
                if (message.what == 0) {
                    if (mMGestureGallery.count == 1 || this.mji) {
                        w.d("MicroMsg.MMGestureGallery", "single click over!");
                        if (mMGestureGallery.wmR != null) {
                            mMGestureGallery.handler.post(new Runnable(this) {
                                final /* synthetic */ l wnd;

                                public final void run() {
                                    mMGestureGallery.wmR.ahA();
                                }
                            });
                        }
                    }
                    mMGestureGallery.count = 0;
                } else if (message.what != 1) {
                    removeMessages(2);
                    if (mMGestureGallery.wmS != null) {
                        mMGestureGallery.handler.post(new Runnable(this) {
                            final /* synthetic */ l wnd;

                            public final void run() {
                                mMGestureGallery.wmS.auf();
                            }
                        });
                    }
                } else if (mMGestureGallery.wmQ == null || mMGestureGallery.wmQ.azf()) {
                    mMGestureGallery.azd();
                } else {
                    mMGestureGallery.wmQ.play();
                    sendEmptyMessageDelayed(message.what, this.mjh);
                }
            }
        }

        public final void d(int i, long j, long j2) {
            this.mjh = j2;
            sendEmptyMessageDelayed(i, j);
        }

        public final void p(long j, boolean z) {
            this.mji = z;
            d(0, j, 0);
        }

        public final void release() {
            removeMessages(0);
            removeMessages(1);
            removeMessages(2);
        }
    }

    static /* synthetic */ void y(MMGestureGallery mMGestureGallery) {
        mMGestureGallery.azd();
        mMGestureGallery.wmN.d(1, 15, 15);
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setStaticTransformationsEnabled(true);
    }

    private void azd() {
        this.wmN.removeMessages(1);
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
        this.miK = new GestureDetector(context, new d());
        this.wmN = new l(new WeakReference(this));
        this.wmO = new l(new WeakReference(this));
        this.wmP = new l(new WeakReference(this));
        this.miJ = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.vns = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMGestureGallery wmW;

            {
                this.wmW = r1;
            }

            private void bZK() {
                this.wmW.wmP.removeMessages(2);
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.wmW.fk == null) {
                    this.wmW.fk = VelocityTracker.obtain();
                }
                this.wmW.fk.addMovement(motionEvent);
                View selectedView = this.wmW.getSelectedView();
                if (selectedView instanceof ViewGroup) {
                    selectedView = selectedView.findViewById(com.tencent.mm.s.a.g.bWO);
                    if (selectedView == null || selectedView.getVisibility() == 8) {
                        if (this.wmW.wmU && this.wmW.wmR != null && motionEvent.getAction() == 1) {
                            lJ(true);
                        }
                        return false;
                    }
                    selectedView = selectedView.findViewById(com.tencent.mm.s.a.g.Kd);
                    if (selectedView == null) {
                        return false;
                    }
                }
                if (selectedView instanceof MultiTouchImageView) {
                    float i;
                    float j;
                    this.wmW.mjb = (MultiTouchImageView) selectedView;
                    w.d("dktest", "MMGestureGallery onTouch event.getAction():" + motionEvent.getAction());
                    if (motionEvent.getAction() == 0) {
                        bZK();
                        this.wmW.wmP.d(2, 500, 0);
                        this.wmW.mjb.bSN();
                        this.wmW.mwV = motionEvent.getX();
                        this.wmW.qEv = motionEvent.getY();
                        this.wmW.miO = 0.0f;
                        this.wmW.miN = this.wmW.mjb.getScale();
                        w.d("dktest", "originalScale :" + this.wmW.miN);
                        this.wmW.miI = false;
                        this.wmW.count = this.wmW.count + 1;
                        if (this.wmW.count == 1) {
                            this.wmW.miD = System.currentTimeMillis();
                            this.wmW.miF = com.tencent.mm.ui.base.f.i(motionEvent, 0);
                            this.wmW.miG = com.tencent.mm.ui.base.f.j(motionEvent, 0);
                        } else if (this.wmW.count == 2) {
                            this.wmW.miH = System.currentTimeMillis();
                            if (this.wmW.miH - this.wmW.miE >= 350) {
                                this.wmW.count = 1;
                            } else if (Math.abs(this.wmW.miF - com.tencent.mm.ui.base.f.i(motionEvent, 0)) >= 35.0f || Math.abs(this.wmW.miG - com.tencent.mm.ui.base.f.j(motionEvent, 0)) >= 35.0f) {
                                this.wmW.count = 1;
                            } else {
                                this.wmW.count = 0;
                                w.d("MicroMsg.MMGestureGallery", "double click!");
                                if (this.wmW.mjb.getScale() <= this.wmW.mjb.pbn) {
                                    this.wmW.mjb.F(com.tencent.mm.ui.base.f.i(motionEvent, 0), com.tencent.mm.ui.base.f.j(motionEvent, 0));
                                } else {
                                    this.wmW.mjb.E(com.tencent.mm.ui.base.f.i(motionEvent, 0), com.tencent.mm.ui.base.f.j(motionEvent, 0));
                                    this.wmW.mjb.bSM();
                                }
                            }
                        }
                    }
                    if (motionEvent.getAction() == 6 || motionEvent.getAction() == 262) {
                        bZK();
                        this.wmW.miO = 0.0f;
                        this.wmW.miN = this.wmW.mjb.getScale();
                        this.wmW.miI = true;
                        if (this.wmW.miN < this.wmW.mjb.pbn) {
                            this.wmW.mjb.E((com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1)) + com.tencent.mm.ui.base.f.i(motionEvent, 1), (com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1)) + com.tencent.mm.ui.base.f.j(motionEvent, 1));
                        }
                        if (this.wmW.miN > this.wmW.mjb.bSO() * 2.0f) {
                            i = com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1);
                            j = com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1);
                            this.wmW.mjb.at(this.wmW.mjb.bSO() * 2.0f);
                            this.wmW.mjb.f(this.wmW.mjb.bSO() * 2.0f, i + com.tencent.mm.ui.base.f.i(motionEvent, 1), j + com.tencent.mm.ui.base.f.j(motionEvent, 1));
                        }
                    }
                    if (motionEvent.getAction() == 1) {
                        bZK();
                        this.wmW.vno = false;
                        this.wmW.vnp = false;
                        this.wmW.qEy = false;
                        if ((this.wmW.miR || this.wmW.miS || this.wmW.vnq || this.wmW.vnr) && (this.wmW.miP || this.wmW.miQ)) {
                            this.wmW.wmQ = new h(this.wmW);
                            MMGestureGallery.y(this.wmW);
                            this.wmW.miR = false;
                            this.wmW.miS = false;
                            this.wmW.vnq = false;
                            this.wmW.vnr = false;
                            this.wmW.miP = false;
                            this.wmW.miQ = false;
                        } else {
                            if (this.wmW.vnq || this.wmW.miR) {
                                this.wmW.vnq = false;
                                this.wmW.miR = false;
                                this.wmW.wmQ = new i(this.wmW);
                                MMGestureGallery.y(this.wmW);
                            }
                            if (this.wmW.vnr || this.wmW.miS) {
                                this.wmW.vnr = false;
                                this.wmW.miS = false;
                                this.wmW.wmQ = new j(this.wmW);
                                MMGestureGallery.y(this.wmW);
                            }
                            if (this.wmW.miP) {
                                this.wmW.miP = false;
                                this.wmW.wmQ = new k(this.wmW);
                                MMGestureGallery.y(this.wmW);
                            }
                            if (this.wmW.miQ) {
                                this.wmW.miQ = false;
                                this.wmW.wmQ = new g(this.wmW);
                                MMGestureGallery.y(this.wmW);
                            }
                            if (this.wmW.qEx) {
                                if (this.wmW.wmV != null) {
                                    this.wmW.wmV.C(0.0f, 0.0f);
                                }
                                this.wmW.qEw = false;
                            }
                            if (this.wmW.qEw && !this.wmW.vnn) {
                                this.wmW.wmO.p(0, true);
                                this.wmW.qEw = false;
                            }
                        }
                        this.wmW.miO = 0.0f;
                        this.wmW.miN = this.wmW.mjb.getScale();
                        if (this.wmW.count == 1) {
                            this.wmW.miE = System.currentTimeMillis();
                            if (this.wmW.miE - this.wmW.miD >= 350) {
                                this.wmW.count = 0;
                                w.d("MicroMsg.MMGestureGallery", "single long click over!");
                            } else if (Math.abs(this.wmW.miF - com.tencent.mm.ui.base.f.i(motionEvent, 0)) < 10.0f && Math.abs(this.wmW.miG - com.tencent.mm.ui.base.f.j(motionEvent, 0)) < 10.0f) {
                                lJ(false);
                            }
                        }
                    }
                    if (motionEvent.getAction() == 5 || motionEvent.getAction() == 261) {
                        this.wmW.miO = 0.0f;
                        this.wmW.miN = this.wmW.mjb.getScale();
                        this.wmW.miI = true;
                    }
                    if (motionEvent.getAction() == 2) {
                        if (com.tencent.mm.ui.base.f.H(motionEvent) == 2) {
                            bZK();
                            if (this.wmW.vnp || this.wmW.vnq || this.wmW.vnr) {
                                return true;
                            }
                            this.wmW.miI = true;
                            this.wmW.count = 0;
                            i = com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1);
                            float j2 = com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1);
                            j = (float) Math.sqrt((double) ((i * i) + (j2 * j2)));
                            if (this.wmW.miO == 0.0f) {
                                this.wmW.miO = j;
                            } else {
                                j /= this.wmW.miO;
                                if (this.wmW.miI) {
                                    this.wmW.mjb.f(j * this.wmW.miN, i + com.tencent.mm.ui.base.f.i(motionEvent, 1), j2 + com.tencent.mm.ui.base.f.j(motionEvent, 1));
                                }
                            }
                        } else {
                            VelocityTracker f = this.wmW.fk;
                            f.computeCurrentVelocity(1000);
                            int xVelocity = (int) f.getXVelocity();
                            int yVelocity = (int) f.getYVelocity();
                            j = motionEvent.getX() - this.wmW.mwV;
                            float y = motionEvent.getY() - this.wmW.qEv;
                            if (!(this.wmW.wmV == null || this.wmW.vnn || this.wmW.miI || this.wmW.miN > this.wmW.mjb.pbn)) {
                                this.wmW.wmV.D(j, y);
                                if ((Math.abs(j) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || this.wmW.qEy) && !this.wmW.qEw) {
                                    this.wmW.qEw = false;
                                } else {
                                    this.wmW.wmV.C(j, y);
                                    this.wmW.qEw = true;
                                }
                                if (y > 200.0f) {
                                    this.wmW.qEx = false;
                                } else {
                                    this.wmW.qEx = true;
                                }
                            }
                            if (this.wmW.fk != null) {
                                this.wmW.fk.recycle();
                                this.wmW.fk = null;
                            }
                            if (Math.abs(this.wmW.miF - com.tencent.mm.ui.base.f.i(motionEvent, 0)) > 35.0f || Math.abs(this.wmW.miG - com.tencent.mm.ui.base.f.j(motionEvent, 0)) > 35.0f) {
                                bZK();
                                this.wmW.count = 0;
                            }
                        }
                    }
                }
                return false;
            }

            private void lJ(boolean z) {
                this.wmW.wmO.p(350, z);
            }
        });
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.jYp = MeasureSpec.getSize(i);
        this.jYq = MeasureSpec.getSize(i2);
        this.miL.set(0.0f, 0.0f, (float) this.jYp, (float) this.jYq);
        w.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.jYp + " height:" + this.jYq);
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.vno) {
            return true;
        }
        this.vnp = true;
        if (this.wmT != null) {
            this.wmT.bku();
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    private boolean a(float f, float f2, View view, float f3) {
        boolean z;
        if (this.vnp || this.vno) {
            z = false;
        } else {
            if (getPositionForView(view) == getAdapter().getCount() - 1) {
                if (this.vnr) {
                    if (f3 > 0.0f) {
                        if (f2 >= ((float) this.jYp)) {
                            this.mjb.G(-f3, 0.0f);
                        } else if (f2 > ((float) this.jYp) * 0.7f && f2 < ((float) this.jYq)) {
                            this.mjb.G(-(f3 * 0.3f), 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 > 0.0f) {
                    if (f2 < ((float) this.jYp)) {
                        this.vnr = true;
                    }
                    if (f2 >= ((float) this.jYp)) {
                        this.mjb.G(-f3, 0.0f);
                    } else if (f2 > ((float) this.jYp) * 0.7f && f2 < ((float) this.jYq)) {
                        this.mjb.G(-(f3 * 0.3f), 0.0f);
                    }
                    z = true;
                }
            }
            this.vnr = false;
            z = false;
        }
        if (z) {
            return true;
        }
        if (this.vnp || this.vno) {
            z = false;
        } else {
            if (getPositionForView(view) == 0) {
                if (this.vnq) {
                    if (f3 < 0.0f) {
                        if (f > 0.0f && f < ((float) this.jYp) * 0.3f) {
                            this.mjb.G(-(f3 * 0.3f), 0.0f);
                        } else if (f <= 0.0f) {
                            this.mjb.G(-f3, 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 < 0.0f) {
                    if (f > 0.0f) {
                        this.vnq = true;
                    }
                    if (f > 0.0f && f < ((float) this.jYp) * 0.3f) {
                        this.mjb.G(-(f3 * 0.3f), 0.0f);
                    } else if (f <= 0.0f) {
                        this.mjb.G(-f3, 0.0f);
                    }
                    z = true;
                }
            }
            this.vnq = false;
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.miI || this.qEw) {
            return true;
        }
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            View findViewById = selectedView.findViewById(com.tencent.mm.s.a.g.bWO);
            if (findViewById == null || findViewById.getVisibility() == 8) {
                return a(motionEvent, motionEvent2, f, f2);
            }
            selectedView = findViewById.findViewById(com.tencent.mm.s.a.g.Kd);
            if (selectedView == null) {
                return a(motionEvent, motionEvent2, f, f2);
            }
        }
        if (!(selectedView instanceof MultiTouchImageView)) {
            return a(motionEvent, motionEvent2, f, f2);
        }
        this.mjb = (MultiTouchImageView) selectedView;
        float[] fArr = new float[9];
        this.mjb.getImageMatrix().getValues(fArr);
        float scale = this.mjb.getScale() * ((float) this.mjb.imageWidth);
        float scale2 = this.mjb.getScale() * ((float) this.mjb.imageHeight);
        float f3 = fArr[2];
        float f4 = f3 + scale;
        float f5 = fArr[5];
        float f6 = f5 + scale2;
        this.mjb.getGlobalVisibleRect(new Rect());
        if (((int) scale) > this.jYp || ((int) scale2) > this.jYq) {
            if (((int) scale) > this.jYp || ((int) scale2) <= this.jYq) {
                if (((int) scale) <= this.jYp || ((int) scale2) > this.jYq) {
                    if (Math.abs(f2) > Math.abs(f)) {
                        if (f != 0.0f) {
                            this.vnp = true;
                            if (f < 0.0f) {
                                if (f3 > this.miL.left) {
                                    this.miR = true;
                                }
                                if (f3 > this.miL.left && f4 >= ((float) this.jYp)) {
                                    if (f3 > this.miL.left && f3 < ((float) this.jYp) * 0.3f) {
                                        f *= 0.3f;
                                    }
                                }
                                if (f2 != 0.0f) {
                                    this.vno = true;
                                    if (f2 < 0.0f) {
                                        if (f5 > this.miL.top) {
                                            this.miP = true;
                                        }
                                        if (f5 > this.miL.top && f6 >= ((float) this.jYq)) {
                                            if (f5 > this.miL.top && f5 < ((float) this.jYq) * 0.3f) {
                                                f2 *= 0.3f;
                                            }
                                        }
                                        this.mjb.G(-f, -f2);
                                        return true;
                                    }
                                    if (f6 < this.miL.bottom) {
                                        this.miQ = true;
                                    }
                                    if (f5 <= 0.0f && f6 < ((float) this.jYq)) {
                                        if (f6 > ((float) this.jYq) * 0.7f && f6 < ((float) this.jYq)) {
                                            f2 *= 0.3f;
                                        }
                                    }
                                    this.mjb.G(-f, -f2);
                                    return true;
                                }
                                f2 = 0.0f;
                                this.mjb.G(-f, -f2);
                                return true;
                            }
                            if (f4 < this.miL.right) {
                                this.miS = true;
                            }
                            if (f3 <= 0.0f && f4 < ((float) this.jYp)) {
                                if (f4 > ((float) this.jYp) * 0.7f && f4 < ((float) this.jYq)) {
                                    f *= 0.3f;
                                }
                            }
                            if (f2 != 0.0f) {
                                this.vno = true;
                                if (f2 < 0.0f) {
                                    if (f6 < this.miL.bottom) {
                                        this.miQ = true;
                                    }
                                    f2 *= 0.3f;
                                    this.mjb.G(-f, -f2);
                                    return true;
                                }
                                if (f5 > this.miL.top) {
                                    this.miP = true;
                                }
                                f2 *= 0.3f;
                                this.mjb.G(-f, -f2);
                                return true;
                            }
                            f2 = 0.0f;
                            this.mjb.G(-f, -f2);
                            return true;
                        }
                        f = 0.0f;
                        if (f2 != 0.0f) {
                            this.vno = true;
                            if (f2 < 0.0f) {
                                if (f5 > this.miL.top) {
                                    this.miP = true;
                                }
                                f2 *= 0.3f;
                                this.mjb.G(-f, -f2);
                                return true;
                            }
                            if (f6 < this.miL.bottom) {
                                this.miQ = true;
                            }
                            f2 *= 0.3f;
                            this.mjb.G(-f, -f2);
                            return true;
                        }
                        f2 = 0.0f;
                        this.mjb.G(-f, -f2);
                        return true;
                    } else if (a(f3, f4, selectedView, f)) {
                        return true;
                    } else {
                        if (f > 0.0f) {
                            if (f4 <= ((float) this.jYp)) {
                                return a(motionEvent, motionEvent2, f, 0.0f);
                            }
                        } else if (f3 >= 0.0f) {
                            return a(motionEvent, motionEvent2, f, 0.0f);
                        }
                        if (!this.vnp) {
                            this.mjb.G(-f, -f2);
                        }
                        return true;
                    }
                } else if (a(f3, f4, selectedView, f)) {
                    return true;
                } else {
                    if (f > 0.0f) {
                        if (f4 <= ((float) this.jYp)) {
                            return a(motionEvent, motionEvent2, f, 0.0f);
                        }
                    } else if (f3 >= 0.0f) {
                        return a(motionEvent, motionEvent2, f, 0.0f);
                    }
                    if (!this.vnp) {
                        this.mjb.G(-f, 0.0f);
                    }
                    return true;
                }
            } else if (Math.abs(f2) > Math.abs(f)) {
                if (this.vnp || this.vnq || this.vnr) {
                    return true;
                }
                this.vno = true;
                float f7 = 0.0f;
                float f8 = 0.0f;
                if (f2 < 0.0f) {
                    if (f5 > this.miL.top) {
                        this.miP = true;
                    }
                    if (f5 <= this.miL.top || f6 < ((float) this.jYq)) {
                        f8 = -f2;
                    } else if (f5 > this.miL.top && f5 < ((float) this.jYq) * 0.3f) {
                        f8 = -(0.3f * f2);
                    }
                } else {
                    if (f6 < this.miL.bottom) {
                        this.miQ = true;
                    }
                    if (f5 > 0.0f || f6 >= ((float) this.jYq)) {
                        f8 = -f2;
                    } else if (f6 > ((float) this.jYq) * 0.7f && f6 < ((float) this.jYq)) {
                        f8 = -(0.3f * f2);
                    }
                }
                if (f < 0.0f && f3 > this.miL.left) {
                    this.miR = true;
                    f7 = -(0.3f * f);
                } else if (f > 0.0f && f4 < this.miL.right) {
                    this.miS = true;
                    f7 = -(0.3f * f);
                }
                this.mjb.G(f7, f8);
                return true;
            } else if (a(f3, f4, selectedView, f)) {
                return true;
            } else {
                if (f > 0.0f) {
                    if (f4 <= ((float) this.jYp)) {
                        if (f4 > ((float) this.jYp) * 0.7f) {
                            return a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                        }
                        return a(motionEvent, motionEvent2, 0.0f, 0.0f);
                    }
                } else if (f3 >= 0.0f) {
                    if (f3 < ((float) this.jYp) * 0.3f) {
                        return a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                    }
                    return a(motionEvent, motionEvent2, 0.0f, 0.0f);
                }
                if (!this.vnp) {
                    this.mjb.G(-f, 0.0f);
                }
                return true;
            }
        } else if (a(f3, f4, selectedView, f)) {
            return true;
        } else {
            if (f > 0.0f) {
                if (f4 <= ((float) this.jYp)) {
                    return a(motionEvent, motionEvent2, f, 0.0f);
                }
            } else if (f3 >= 0.0f) {
                return a(motionEvent, motionEvent2, f, 0.0f);
            }
            if (!this.vnp) {
                this.mjb.G(-f, 0.0f);
            }
            return true;
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.miJ != null) {
            this.miJ.forceFinished(true);
        }
        return super.onDown(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            selectedView = selectedView.findViewById(com.tencent.mm.s.a.g.bWO);
            if (selectedView == null || selectedView.getVisibility() == 8) {
                a(motionEvent, motionEvent2, f);
                return false;
            }
            selectedView = selectedView.findViewById(com.tencent.mm.s.a.g.Kd);
            if (selectedView == null) {
                a(motionEvent, motionEvent2, f);
                return false;
            }
        }
        if (selectedView instanceof MultiTouchImageView) {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) selectedView;
            float scale = multiTouchImageView.getScale() * ((float) multiTouchImageView.imageWidth);
            float scale2 = multiTouchImageView.getScale() * ((float) multiTouchImageView.imageHeight);
            if (multiTouchImageView.vom || multiTouchImageView.von || ((int) scale) > this.jYp || ((int) scale2) > this.jYq) {
                float f3;
                r4 = new float[9];
                multiTouchImageView.getImageMatrix().getValues(r4);
                float f4 = r4[2];
                float f5 = f4 + scale;
                float f6 = r4[5];
                float f7 = f6 + scale2;
                w.d("MicroMsg.MMGestureGallery", "jacks left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(b(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2));
                if (((float) Math.round(f4)) >= this.miL.left || ((float) Math.round(f5)) <= this.miL.right) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (((float) Math.round(f6)) >= this.miL.top || ((float) Math.round(f7)) <= this.miL.bottom) {
                    f2 = 0.0f;
                }
                if (((float) Math.round(f6)) < this.miL.top) {
                    this.vnn = true;
                } else {
                    this.vnn = false;
                }
                int i = (int) (this.miL.right - scale);
                int i2 = (int) (scale + this.miL.right);
                int i3 = (int) (this.miL.bottom - scale2);
                int i4 = (int) (this.miL.bottom + scale2);
                if (f3 >= 0.0f) {
                    if (Math.abs(f3) >= ((float) this.vns)) {
                        f3 = (float) this.vns;
                    }
                    f6 = f3;
                } else {
                    if (Math.abs(f3) >= ((float) this.vns)) {
                        f3 = (float) (-this.vns);
                    }
                    f6 = f3;
                }
                if (f2 >= 0.0f) {
                    if (Math.abs(f2) >= ((float) this.vns)) {
                        f2 = (float) this.vns;
                    }
                } else if (Math.abs(f2) >= ((float) this.vns)) {
                    f2 = (float) (-this.vns);
                }
                this.miJ.forceFinished(true);
                this.miJ.fling(this.miJ.getCurrX(), this.miJ.getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                if ((!b(motionEvent, motionEvent2) || f4 < 0.0f) && (b(motionEvent, motionEvent2) || f5 > ((float) this.jYp))) {
                    return true;
                }
            }
        }
        if (this.miI) {
            return true;
        }
        a(motionEvent, motionEvent2, f);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.qEy = true;
        super.onLongPress(motionEvent);
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent.getX() - motionEvent2.getX() < 0.0f;
    }

    private void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f) {
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean b = b(motionEvent, motionEvent2);
        x = Math.abs(x);
        y = Math.abs(y);
        if (Math.abs(f) <= 500.0f || x < 60.0f || x < y) {
            return;
        }
        if (b) {
            onKeyDown(21, null);
        } else {
            onKeyDown(22, null);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.miK.onTouchEvent(motionEvent);
        w.d("dktest", "onTouchEvent event.getAction()" + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 1:
                View selectedView = getSelectedView();
                if (selectedView instanceof MultiTouchImageView) {
                    this.mjb = (MultiTouchImageView) selectedView;
                    float scale = this.mjb.getScale() * ((float) this.mjb.imageWidth);
                    float scale2 = this.mjb.getScale() * ((float) this.mjb.imageHeight);
                    if (((int) scale) <= this.jYp && ((int) scale2) <= this.jYq) {
                        w.i("dktest", "onTouchEvent width:" + scale + "height:" + scale2);
                        break;
                    }
                    float[] fArr = new float[9];
                    this.mjb.getImageMatrix().getValues(fArr);
                    scale = fArr[5];
                    w.d("dktest", "onTouchEvent top:" + scale + " height:" + scale2 + " bottom:" + (scale + scale2));
                    break;
                }
                break;
        }
        computeScroll();
        return super.onTouchEvent(motionEvent);
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

    public void computeScroll() {
        int i = 0;
        if (this.mjb != null && this.miJ.computeScrollOffset()) {
            int currX = this.miJ.getCurrX() - this.abb;
            int currY = this.miJ.getCurrY() - this.abc;
            this.abb = this.miJ.getCurrX();
            this.abc = this.miJ.getCurrY();
            float scale = this.mjb.getScale() * ((float) this.mjb.imageWidth);
            float scale2 = this.mjb.getScale() * ((float) this.mjb.imageHeight);
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

    public boolean isFocused() {
        return true;
    }
}
