package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.RectF;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MultiGestureImageView extends LinearLayout {
    private int abb;
    private int abc;
    private int count = 0;
    private int jYp;
    private int jYq;
    private MultiTouchImageView miC;
    private long miD = 0;
    private long miE = 0;
    private float miF = 0.0f;
    private float miG = 0.0f;
    private long miH = 0;
    private boolean miI = false;
    private OverScroller miJ;
    private GestureDetector miK;
    private RectF miL = new RectF();
    private a miM;
    private float miN;
    private float miO;
    private boolean miP = false;
    private boolean miQ = false;
    private boolean miR = false;
    private boolean miS = false;
    private j miT;
    private j miU;
    private j miV;
    private d miW;
    private b miX;

    private abstract class a {
        protected boolean miY = false;
        final /* synthetic */ MultiGestureImageView miZ;

        public abstract void play();

        public a(MultiGestureImageView multiGestureImageView) {
            this.miZ = multiGestureImageView;
        }

        public final boolean azf() {
            return this.miY;
        }
    }

    public interface b {
    }

    private class c extends SimpleOnGestureListener {
        final /* synthetic */ MultiGestureImageView miZ;

        private c(MultiGestureImageView multiGestureImageView) {
            this.miZ = multiGestureImageView;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }
    }

    public interface d {
    }

    public class j extends ae {
        WeakReference<MultiGestureImageView> hqr;
        final /* synthetic */ MultiGestureImageView miZ;
        private long mjh;
        boolean mji;

        public j(MultiGestureImageView multiGestureImageView, WeakReference<MultiGestureImageView> weakReference) {
            this.miZ = multiGestureImageView;
            this.hqr = weakReference;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            removeMessages(message.what);
            if (this.hqr != null) {
                final MultiGestureImageView multiGestureImageView = (MultiGestureImageView) this.hqr.get();
                if (multiGestureImageView == null) {
                    return;
                }
                if (message.what == 0) {
                    if (multiGestureImageView.count == 1 || this.mji) {
                        w.d("MicroMsg.MuitlGestureImageView", "single click over!");
                        if (multiGestureImageView.miW != null) {
                            multiGestureImageView.getHandler().post(new Runnable(this) {
                                final /* synthetic */ j mjk;

                                public final void run() {
                                }
                            });
                        }
                    }
                    this.miZ.count = 0;
                } else if (message.what != 1) {
                    removeMessages(2);
                    if (multiGestureImageView.miX != null) {
                        multiGestureImageView.getHandler().post(new Runnable(this) {
                            final /* synthetic */ j mjk;

                            public final void run() {
                            }
                        });
                    }
                } else if (this.miZ.miM == null || this.miZ.miM.azf()) {
                    multiGestureImageView.azd();
                } else {
                    this.miZ.miM.play();
                    sendEmptyMessageDelayed(message.what, this.mjh);
                }
            }
        }

        public final void d(int i, long j, long j2) {
            this.mjh = j2;
            sendEmptyMessageDelayed(i, j);
        }
    }

    private class e extends a {
        final /* synthetic */ MultiGestureImageView miZ;
        public float[] mja = new float[9];
        MultiTouchImageView mjb;

        public e(MultiGestureImageView multiGestureImageView, MultiTouchImageView multiTouchImageView) {
            this.miZ = multiGestureImageView;
            super(multiGestureImageView);
            this.mjb = multiTouchImageView;
        }

        public final void play() {
            this.miZ.miC.getHandler().post(new Runnable(this) {
                final /* synthetic */ e mjc;

                {
                    this.mjc = r1;
                }

                public final void run() {
                    this.mjc.mjb.getImageMatrix().getValues(this.mjc.mja);
                    float scale = ((float) this.mjc.mjb.imageHeight) * this.mjc.mjb.getScale();
                    float f = this.mjc.mja[5] + scale;
                    float i = (float) this.mjc.miZ.jYq;
                    if (scale < ((float) this.mjc.miZ.jYq)) {
                        i = (((float) this.mjc.miZ.jYq) / 2.0f) + (scale / 2.0f);
                    }
                    i -= f;
                    if (i <= 0.0f) {
                        this.mjc.miY = true;
                    } else if (Math.abs(i) <= 5.0f) {
                        this.mjc.miY = true;
                    } else {
                        i = ((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.mjc.mjb.G(0.0f, i);
                }
            });
        }
    }

    private class f extends a {
        final /* synthetic */ MultiGestureImageView miZ;
        public float[] mja = new float[9];
        MultiTouchImageView mjb;

        public f(MultiGestureImageView multiGestureImageView, MultiTouchImageView multiTouchImageView) {
            this.miZ = multiGestureImageView;
            super(multiGestureImageView);
            this.mjb = multiTouchImageView;
        }

        public final void play() {
            this.miZ.miC.getHandler().post(new Runnable(this) {
                final /* synthetic */ f mjd;

                {
                    this.mjd = r1;
                }

                public final void run() {
                    float i;
                    float g;
                    this.mjd.mjb.getImageMatrix().getValues(this.mjd.mja);
                    float scale = this.mjd.mjb.getScale() * ((float) this.mjd.mjb.imageWidth);
                    float scale2 = this.mjd.mjb.getScale() * ((float) this.mjd.mjb.imageHeight);
                    float f = this.mjd.mja[2];
                    float f2 = this.mjd.mja[5];
                    float f3 = this.mjd.mja[2] + scale;
                    float f4 = this.mjd.mja[5] + scale2;
                    float i2 = (float) this.mjd.miZ.jYq;
                    float g2 = (float) this.mjd.miZ.jYp;
                    if (scale2 < ((float) this.mjd.miZ.jYq)) {
                        i2 = (((float) this.mjd.miZ.jYq) / 2.0f) - (scale2 / 2.0f);
                        i = (((float) this.mjd.miZ.jYq) / 2.0f) + (scale2 / 2.0f);
                    } else {
                        float f5 = i2;
                        i2 = 0.0f;
                        i = f5;
                    }
                    i2 -= f2;
                    i -= f4;
                    if (i2 >= 0.0f) {
                        if (i > 0.0f) {
                            i2 = i;
                        } else {
                            i2 = 0.0f;
                        }
                    }
                    if (scale < ((float) this.mjd.miZ.jYp)) {
                        i = (((float) this.mjd.miZ.jYp) / 2.0f) - (scale / 2.0f);
                        g = (((float) this.mjd.miZ.jYp) / 2.0f) + (scale / 2.0f);
                    } else {
                        g = g2;
                        i = 0.0f;
                    }
                    i -= f;
                    g -= f3;
                    if (i >= 0.0f) {
                        if (g > 0.0f) {
                            i = g;
                        } else {
                            i = 0.0f;
                        }
                    }
                    if (Math.abs(i) > 5.0f || Math.abs(i2) > 5.0f) {
                        if (i >= 0.0f) {
                            i = ((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            i = (-((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                        if (i2 >= 0.0f) {
                            i2 = ((float) (((double) Math.abs(i2)) - Math.pow(Math.sqrt((double) Math.abs(i2)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            i2 = (-((float) (((double) Math.abs(i2)) - Math.pow(Math.sqrt((double) Math.abs(i2)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                    } else {
                        this.mjd.miY = true;
                    }
                    this.mjd.mjb.G(i, i2);
                }
            });
        }
    }

    private class g extends a {
        final /* synthetic */ MultiGestureImageView miZ;
        public float[] mja = new float[9];
        MultiTouchImageView mjb;

        public g(MultiGestureImageView multiGestureImageView, MultiTouchImageView multiTouchImageView) {
            this.miZ = multiGestureImageView;
            super(multiGestureImageView);
            this.mjb = multiTouchImageView;
        }

        public final void play() {
            this.miZ.miC.getHandler().post(new Runnable(this) {
                final /* synthetic */ g mje;

                {
                    this.mje = r1;
                }

                public final void run() {
                    this.mje.mjb.getImageMatrix().getValues(this.mje.mja);
                    float f = this.mje.mja[2];
                    float scale = this.mje.mjb.getScale() * ((float) this.mje.mjb.imageWidth);
                    if (scale < ((float) this.mje.miZ.jYp)) {
                        scale = (((float) this.mje.miZ.jYp) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.mje.miY = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.mje.miY = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.mje.mjb.G(scale, 0.0f);
                }
            });
        }
    }

    private class h extends a {
        final /* synthetic */ MultiGestureImageView miZ;
        public float[] mja = new float[9];
        MultiTouchImageView mjb;

        public h(MultiGestureImageView multiGestureImageView, MultiTouchImageView multiTouchImageView) {
            this.miZ = multiGestureImageView;
            super(multiGestureImageView);
            this.mjb = multiTouchImageView;
        }

        public final void play() {
            this.miZ.miC.getHandler().post(new Runnable(this) {
                final /* synthetic */ h mjf;

                {
                    this.mjf = r1;
                }

                public final void run() {
                    this.mjf.mjb.getImageMatrix().getValues(this.mjf.mja);
                    float scale = ((float) this.mjf.mjb.imageWidth) * this.mjf.mjb.getScale();
                    float f = this.mjf.mja[2] + scale;
                    float g = (float) this.mjf.miZ.jYp;
                    if (scale < ((float) this.mjf.miZ.jYp)) {
                        g = (((float) this.mjf.miZ.jYp) / 2.0f) + (scale / 2.0f);
                    }
                    g -= f;
                    if (g <= 0.0f) {
                        this.mjf.miY = true;
                    } else if (Math.abs(g) <= 5.0f) {
                        this.mjf.miY = true;
                    } else {
                        g = ((float) (((double) Math.abs(g)) - Math.pow(Math.sqrt((double) Math.abs(g)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.mjf.mjb.G(g, 0.0f);
                }
            });
        }
    }

    private class i extends a {
        final /* synthetic */ MultiGestureImageView miZ;
        public float[] mja = new float[9];
        MultiTouchImageView mjb;

        public i(MultiGestureImageView multiGestureImageView, MultiTouchImageView multiTouchImageView) {
            this.miZ = multiGestureImageView;
            super(multiGestureImageView);
            this.mjb = multiTouchImageView;
        }

        public final void play() {
            this.miZ.miC.getHandler().post(new Runnable(this) {
                final /* synthetic */ i mjg;

                {
                    this.mjg = r1;
                }

                public final void run() {
                    this.mjg.mjb.getImageMatrix().getValues(this.mjg.mja);
                    float f = this.mjg.mja[5];
                    float scale = this.mjg.mjb.getScale() * ((float) this.mjg.mjb.imageHeight);
                    if (scale < ((float) this.mjg.miZ.jYq)) {
                        scale = (((float) this.mjg.miZ.jYq) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.mjg.miY = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.mjg.miY = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.mjg.mjb.G(0.0f, scale);
                }
            });
        }
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.miC = new MultiTouchImageView(context, attributeSet);
        this.miK = new GestureDetector(context, new c());
        this.miJ = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.miC.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.miC);
        this.miT = new j(this, new WeakReference(this));
        this.miU = new j(this, new WeakReference(this));
        this.miV = new j(this, new WeakReference(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.jYp = MeasureSpec.getSize(i);
        this.jYq = MeasureSpec.getSize(i2);
        this.miL.set(0.0f, 0.0f, (float) this.jYp, (float) this.jYq);
        w.v("MicroMsg.MuitlGestureImageView", "MMGestureGallery width:" + this.jYp + " height:" + this.jYq);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.miK.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.miJ.forceFinished(true);
            this.miV.removeMessages(2);
            this.miV.d(2, 500, 0);
            this.miC.bSN();
            this.count++;
            if (this.count == 1) {
                this.miD = System.currentTimeMillis();
                this.miF = com.tencent.mm.ui.base.f.i(motionEvent, 0);
                this.miG = com.tencent.mm.ui.base.f.j(motionEvent, 0);
            } else if (this.count == 2) {
                this.miH = System.currentTimeMillis();
                if (this.miH - this.miE >= 350) {
                    this.count = 1;
                } else if (Math.abs(this.miF - com.tencent.mm.ui.base.f.i(motionEvent, 0)) >= 35.0f || Math.abs(this.miG - com.tencent.mm.ui.base.f.j(motionEvent, 0)) >= 35.0f) {
                    this.count = 1;
                } else {
                    this.count = 0;
                    w.d("MicroMsg.MuitlGestureImageView", "double click!");
                    if (this.miC.getScale() <= this.miC.pbn) {
                        this.miC.F(com.tencent.mm.ui.base.f.i(motionEvent, 0), com.tencent.mm.ui.base.f.j(motionEvent, 0));
                    } else {
                        this.miC.E(com.tencent.mm.ui.base.f.i(motionEvent, 0), com.tencent.mm.ui.base.f.j(motionEvent, 0));
                        this.miC.bSM();
                    }
                }
            }
        }
        if (motionEvent.getAction() == 6 || motionEvent.getAction() == 262) {
            this.miV.removeMessages(2);
            this.miO = 0.0f;
            this.miN = this.miC.getScale();
            this.miI = true;
            if (this.miN < this.miC.pbn) {
                this.miC.E((com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1)) + com.tencent.mm.ui.base.f.i(motionEvent, 1), (com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1)) + com.tencent.mm.ui.base.f.j(motionEvent, 1));
            }
            if (this.miN > this.miC.bSO()) {
                this.miC.F((com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1)) + com.tencent.mm.ui.base.f.i(motionEvent, 1), (com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1)) + com.tencent.mm.ui.base.f.j(motionEvent, 1));
            }
        }
        if (motionEvent.getAction() == 1) {
            this.miV.removeMessages(2);
            if ((this.miR || this.miS) && (this.miP || this.miQ)) {
                this.miM = new f(this, this.miC);
                aze();
                this.miR = false;
                this.miS = false;
                this.miP = false;
                this.miQ = false;
            } else {
                if (this.miR) {
                    this.miR = false;
                    this.miM = new g(this, this.miC);
                    aze();
                }
                if (this.miS) {
                    this.miS = false;
                    this.miM = new h(this, this.miC);
                    aze();
                }
                if (this.miP) {
                    this.miP = false;
                    this.miM = new i(this, this.miC);
                    aze();
                }
                if (this.miQ) {
                    this.miQ = false;
                    this.miM = new e(this, this.miC);
                    aze();
                }
            }
            this.miO = 0.0f;
            this.miN = this.miC.getScale();
            if (this.count == 1) {
                this.miE = System.currentTimeMillis();
                if (this.miE - this.miD >= 350) {
                    this.count = 0;
                    w.d("MicroMsg.MuitlGestureImageView", "single long click over!");
                } else if (Math.abs(this.miF - com.tencent.mm.ui.base.f.i(motionEvent, 0)) < 10.0f && Math.abs(this.miG - com.tencent.mm.ui.base.f.j(motionEvent, 0)) < 10.0f) {
                    j jVar = this.miU;
                    jVar.mji = false;
                    jVar.d(0, 350, 0);
                }
            }
        }
        if (motionEvent.getAction() == 5 || motionEvent.getAction() == 261) {
            this.miO = 0.0f;
            this.miN = this.miC.getScale();
            this.miI = true;
        }
        if (motionEvent.getAction() == 2) {
            if (com.tencent.mm.ui.base.f.H(motionEvent) == 2) {
                this.miV.removeMessages(2);
                this.miI = true;
                this.count = 0;
                float i = com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1);
                float j = com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1);
                float sqrt = (float) Math.sqrt((double) ((i * i) + (j * j)));
                if (this.miO == 0.0f) {
                    this.miO = sqrt;
                } else {
                    sqrt /= this.miO;
                    if (this.miI) {
                        this.miC.f(sqrt * this.miN, i + com.tencent.mm.ui.base.f.i(motionEvent, 1), j + com.tencent.mm.ui.base.f.j(motionEvent, 1));
                    }
                }
            } else if (Math.abs(this.miF - com.tencent.mm.ui.base.f.i(motionEvent, 0)) > 10.0f || Math.abs(this.miG - com.tencent.mm.ui.base.f.j(motionEvent, 0)) > 10.0f) {
                this.miV.removeMessages(2);
                this.count = 0;
                computeScroll();
            }
        }
        return true;
    }

    public void computeScroll() {
        int i = 0;
        if (this.miC != null && this.miJ.computeScrollOffset()) {
            int currX = this.miJ.getCurrX() - this.abb;
            int currY = this.miJ.getCurrY() - this.abc;
            this.abb = this.miJ.getCurrX();
            this.abc = this.miJ.getCurrY();
            float scale = this.miC.getScale();
            float f = ((float) this.miC.imageWidth) * scale;
            scale *= (float) this.miC.imageHeight;
            float[] fArr = new float[9];
            this.miC.getImageMatrix().getValues(fArr);
            float f2 = fArr[2];
            f += f2;
            float f3 = fArr[5];
            float f4 = f3 + scale;
            if (currX < 0 && ((float) currX) < this.miL.right - ((float) Math.round(f))) {
                currX = (int) (this.miL.right - ((float) Math.round(f)));
            }
            if (currX > 0 && ((float) currX) > this.miL.left - ((float) Math.round(f2))) {
                currX = (int) (this.miL.left - ((float) Math.round(f2)));
            }
            if (currY < 0 && ((float) currY) < this.miL.bottom - ((float) Math.round(f4))) {
                currY = (int) (this.miL.bottom - ((float) Math.round(f4)));
            }
            if (currY > 0 && ((float) currY) > this.miL.top - ((float) Math.round(f3))) {
                currY = (int) (this.miL.top - ((float) Math.round(f3)));
            }
            if (((float) Math.round(f2)) >= this.miL.left || ((float) Math.round(f)) <= this.miL.right) {
                currX = 0;
            } else if (((float) Math.round(f3)) >= this.miL.top || ((float) Math.round(f4)) <= this.miL.bottom) {
                currY = 0;
            }
            if (scale >= ((float) this.jYq)) {
                i = currY;
            }
            this.miC.G((float) currX, (float) i);
            postInvalidate();
        }
    }

    private void azd() {
        this.miT.removeMessages(1);
    }

    private void aze() {
        azd();
        this.miT.d(1, 15, 15);
    }
}
