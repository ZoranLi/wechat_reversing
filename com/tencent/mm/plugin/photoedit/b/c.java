package com.tencent.mm.plugin.photoedit.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.R;
import com.tencent.mm.plugin.photoedit.c.b;
import com.tencent.mm.plugin.photoedit.cache.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends b<a> {
    public Rect oiW = new Rect();
    private int ojC = ((int) ab.getResources().getDimension(R.f.aYt));
    private int ojD = ((int) ab.getResources().getDimension(R.f.aZR));
    private int ojE = ((int) ab.getResources().getDimension(R.f.aZr));
    public Matrix ojF = new Matrix();
    private RectF ojG = new RectF();
    private RectF ojH = new RectF();
    private RectF ojI = new RectF();
    private RectF ojJ = new RectF();
    public com.tencent.mm.plugin.photoedit.a.a ojK = new com.tencent.mm.plugin.photoedit.a.a(this);
    public final Rect ojL = new Rect();
    public com.tencent.mm.plugin.photoedit.f.a ojM = new com.tencent.mm.plugin.photoedit.f.a(this.oiW);
    public boolean ojN = false;
    public boolean ojO = false;
    boolean ojP = false;
    boolean ojQ = false;
    boolean ojR = false;
    boolean ojS = false;
    boolean ojT = false;
    public boolean ojU = true;
    boolean ojV = false;
    float ojW;
    float ojX;
    float ojY;
    float ojZ;
    float oka;
    float okb;
    public Rect okc = new Rect();
    public int okd = 0;
    public boolean oke = false;
    public ValueAnimator okf;

    class AnonymousClass7 implements AnimatorUpdateListener {
        final /* synthetic */ float hFU;
        float miO = ((float) Math.pow((double) this.hFU, 0.0833333358168602d));
        int oja = 0;
        final /* synthetic */ c okg;
        int oki = 0;
        float okj;
        float okk = 0.0f;
        float okl;
        float okm = 0.0f;
        float okn = this.okp;
        float oko = this.okq;
        final /* synthetic */ float okp;
        final /* synthetic */ float okq;

        public AnonymousClass7(c cVar, float f, float f2, float f3) {
            this.okg = cVar;
            this.okp = f;
            this.okq = f2;
            this.hFU = f3;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.oja < 12) {
                this.okg.ojv.postScale(this.miO, this.miO, ((float) this.okg.oiW.centerX()) + this.okk, ((float) this.okg.oiW.centerY()) + this.okm);
                this.okg.ojF.postScale(this.miO, this.miO, ((float) this.okg.oiW.centerX()) + this.okk, ((float) this.okg.oiW.centerY()) + this.okm);
                this.oja++;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue("rotation")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("deltaX")).intValue();
            int intValue3 = ((Integer) valueAnimator.getAnimatedValue("deltaY")).intValue();
            this.okg.ojv.postRotate((float) (intValue - this.oki), this.okp + this.okk, this.okq + this.okm);
            this.okg.ojF.postRotate((float) (intValue - this.oki), this.okp + this.okk, this.okq + this.okm);
            RectF rectF = new RectF();
            rectF.set(this.okg.oiW);
            this.okg.ojF.mapRect(rectF);
            this.okn += ((float) intValue2) - this.okj;
            this.oko += ((float) intValue3) - this.okl;
            this.okk = this.okn - rectF.centerX();
            this.okm = this.oko - rectF.centerY();
            this.okg.ojv.postTranslate(this.okk, this.okm);
            this.okg.ojF.postTranslate(this.okk, this.okm);
            this.okg.aRR();
            this.oki = intValue;
            this.okj = (float) intValue2;
            this.okl = (float) intValue3;
        }
    }

    public c(b bVar) {
        super(bVar);
    }

    public final void a(com.tencent.mm.plugin.photoedit.d.b bVar) {
        super.a(bVar);
        if (this.ojL.isEmpty()) {
            this.ojL.set(this.ojC, this.ojC * 2, this.ojz.getWidth() - this.ojC, ((this.ojz.getHeight() - this.ojD) - this.ojE) - (this.ojC * 2));
        }
        w.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[]{this.ojL});
        com.tencent.mm.plugin.photoedit.f.a aSm = ((a) aRW()).aSm();
        if (aSm != null && !aSm.olg.isEmpty()) {
            this.ojz.h(aSm.olg);
            w.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[]{Float.valueOf(a(aSm.mMatrix))});
            this.ojv.postRotate(-r1, (float) aSm.olg.centerX(), (float) aSm.olg.centerY());
        }
    }

    public final void a(a aVar, a aVar2) {
        super.a(aVar, aVar2);
        if (aVar2 == a.ojr) {
            this.okc.setEmpty();
            com.tencent.mm.plugin.photoedit.f.a aVar3;
            if (((a) aRW()).gg(true) <= 0) {
                aVar3 = new com.tencent.mm.plugin.photoedit.f.a();
                aVar3.mMatrix.set(this.ojv);
                ((a) aRW()).a(aVar3);
                aSa();
                this.ojz.old = this.oiW;
                this.ojz.a(new com.tencent.mm.plugin.photoedit.d.a.b(this) {
                    final /* synthetic */ c okg;

                    {
                        this.okg = r1;
                    }

                    public final void LT() {
                        if (((a) this.okg.aRW()).okT.isIdentity()) {
                            a aVar = (a) this.okg.aRW();
                            aVar.okT.set(this.okg.ojv);
                        }
                        this.okg.ojz.h(new Rect(0, 0, this.okg.aRX().getWidth(), this.okg.aRX().getHeight()));
                        this.okg.a(200, true, false);
                    }

                    public final void onStart() {
                        this.okg.ojN = false;
                        this.okg.ojU = false;
                    }
                }, 0.0f, false);
            } else {
                aVar3 = ((a) aRW()).aSm();
                this.oiW.set(aVar3.oiW);
                this.ojz.old = aVar3.oiW;
                try {
                    ((a) aRW()).a((com.tencent.mm.plugin.photoedit.f.a) aVar3.clone());
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.CropArtist", e, "", new Object[0]);
                }
                this.ojz.a(new com.tencent.mm.plugin.photoedit.d.a.b(this) {
                    final /* synthetic */ c okg;

                    {
                        this.okg = r1;
                    }

                    public final void LT() {
                        this.okg.ojU = true;
                        this.okg.ojz.h(new Rect(0, 0, this.okg.aRX().getWidth(), this.okg.aRX().getHeight()));
                        this.okg.a(200, true, false);
                    }

                    public final void onStart() {
                        this.okg.ojN = false;
                        this.okg.ojU = false;
                        com.tencent.mm.plugin.photoedit.f.a.rb(282);
                    }
                }, 0.0f, false);
            }
            this.ojz.oly = true;
        }
    }

    public final boolean aRT() {
        return !((a) aRW()).okT.equals(this.ojv);
    }

    public final a aRO() {
        return a.ojr;
    }

    protected final boolean y(MotionEvent motionEvent) {
        RectF aSA = this.ojz.aSA();
        this.ojY = aSA.top - (aSA.bottom - ((float) this.oiW.bottom));
        this.ojZ = aSA.bottom + (((float) this.oiW.top) - aSA.top);
        this.oka = aSA.left - (aSA.right - ((float) this.oiW.right));
        this.okb = aSA.right + (((float) this.oiW.left) - aSA.left);
        if (this.okb > ((float) this.ojL.right)) {
            this.okb = (float) this.ojL.right;
        }
        if (this.oka < ((float) this.ojC)) {
            this.oka = (float) this.ojC;
        }
        if (this.ojZ > ((float) this.ojL.bottom)) {
            this.ojZ = (float) this.ojL.bottom;
        }
        if (this.ojY < ((float) this.ojC)) {
            this.ojY = (float) this.ojC;
        }
        float width;
        float height;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.ojV = false;
                if (this.ojK != null) {
                    this.ojK.cancel();
                }
                if (this.ojH.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.ojS = true;
                }
                if (this.ojG.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.ojR = true;
                }
                if (this.ojI.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.ojQ = true;
                }
                if (this.ojJ.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.ojT = true;
                }
                this.ojU = false;
                if (aRY()) {
                    if (this.ojS && this.ojQ) {
                        this.ojS = true;
                        this.ojQ = true;
                        this.ojR = false;
                        this.ojT = false;
                    } else if (this.ojS && this.ojT) {
                        this.ojS = true;
                        this.ojQ = false;
                        this.ojR = false;
                        this.ojT = true;
                    } else if (this.ojR && this.ojT) {
                        this.ojS = false;
                        this.ojQ = false;
                        this.ojR = true;
                        this.ojT = true;
                    } else if (this.ojR && this.ojT) {
                        this.ojS = false;
                        this.ojQ = false;
                        this.ojR = true;
                        this.ojT = true;
                    }
                    this.ojW = motionEvent.getX();
                    this.ojX = motionEvent.getY();
                    break;
                }
                break;
            case 1:
                width = (((float) this.ojL.width()) * 1.0f) / ((float) this.oiW.width());
                height = (((float) this.ojL.height()) * 1.0f) / ((float) this.oiW.height());
                if (width >= height) {
                    width = height;
                }
                height = ((float) this.ojL.centerX()) - ((float) this.oiW.centerX());
                float centerY = ((float) this.ojL.centerY()) - ((float) this.oiW.centerY());
                if (this.ojV) {
                    this.ojK.oiZ = 1200;
                    com.tencent.mm.plugin.photoedit.a.a aVar = this.ojK;
                    Rect rect = this.oiW;
                    aVar.oiS = height;
                    aVar.oiT = centerY;
                    aVar.oiW = rect;
                    aVar.oiX.set(aVar.oiW);
                    aVar.oiR = width;
                    com.tencent.mm.plugin.photoedit.a.b bVar = this.ojK;
                    w.i("MicroMsg.CropActionUpAnim", "[play]");
                    if (bVar.miY) {
                        bVar.miY = false;
                        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 200.0f});
                        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, bVar.oiS});
                        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, bVar.oiT});
                        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("background_alpha", new float[]{0.0f, 255.0f});
                        bVar.oiP = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
                        bVar.oiP.addUpdateListener(new AnimatorUpdateListener(bVar) {
                            float miO = ((float) Math.pow((double) this.ojb.oiR, 0.0833333358168602d));
                            int oja = 0;
                            final /* synthetic */ a ojb;

                            {
                                this.ojb = r5;
                            }

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                                float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                                float floatValue3 = ((Float) valueAnimator.getAnimatedValue("background_alpha")).floatValue();
                                if (this.oja < 12) {
                                    this.ojb.oiQ.ojv.postScale(this.miO, this.miO, (float) this.ojb.oiW.centerX(), (float) this.ojb.oiW.centerY());
                                    this.ojb.oiY.postScale(this.miO, this.miO, (float) this.ojb.oiW.centerX(), (float) this.ojb.oiW.centerY());
                                    this.oja++;
                                }
                                com.tencent.mm.plugin.photoedit.f.a.rb((int) floatValue3);
                                this.ojb.oiQ.ojv.postTranslate(floatValue2 - this.ojb.oiV, floatValue - this.ojb.oiU);
                                this.ojb.oiY.postTranslate(floatValue2 - this.ojb.oiV, floatValue - this.ojb.oiU);
                                RectF rectF = new RectF(this.ojb.oiW);
                                this.ojb.oiY.mapRect(rectF);
                                rectF.round(this.ojb.oiW);
                                this.ojb.oiY.reset();
                                this.ojb.oiQ.aRR();
                                this.ojb.oiU = floatValue;
                                this.ojb.oiV = floatValue2;
                            }
                        });
                        bVar.oiP.addListener(new AnimatorListener(bVar) {
                            final /* synthetic */ a ojb;

                            {
                                this.ojb = r1;
                            }

                            public final void onAnimationStart(Animator animator) {
                                this.ojb.oiQ.ojU = true;
                                this.ojb.miY = false;
                                this.ojb.oiU = 0.0f;
                                this.ojb.oiV = 0.0f;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                this.ojb.miY = true;
                                this.ojb.oiZ = 0;
                                this.ojb.oiU = 0.0f;
                                this.ojb.oiV = 0.0f;
                                this.ojb.oiQ.aSb();
                                this.ojb.oiQ.aRU();
                            }

                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }
                        });
                        bVar.oiP.setInterpolator(new LinearInterpolator());
                        bVar.oiP.setDuration(200);
                        bVar.oiP.setStartDelay(bVar.oiZ);
                        bVar.oiP.start();
                    }
                }
                if (aRY()) {
                    this.ojP = true;
                } else {
                    this.ojP = false;
                }
                this.ojS = false;
                this.ojQ = false;
                this.ojR = false;
                this.ojT = false;
                aRU();
                break;
            case 2:
                this.ojV = true;
                this.oke = false;
                if (motionEvent.getPointerCount() == 1 && aRY()) {
                    Rect rect2;
                    if (this.ojT && this.oiW.right >= this.oiW.left) {
                        if (this.oiW.right <= this.ojL.right) {
                            if (motionEvent.getX() - this.ojW > ((float) (this.ojL.right - this.oiW.right))) {
                                this.oiW.right = this.ojL.right;
                            } else {
                                rect2 = this.oiW;
                                rect2.right = (int) (((float) rect2.right) + (motionEvent.getX() - this.ojW));
                            }
                        }
                        if (this.oiW.right < this.oiW.left + (this.ojC * 2)) {
                            this.oiW.right = this.oiW.left + (this.ojC * 2);
                        }
                        if (this.oiW.right > this.ojL.right) {
                            this.oiW.right = this.ojL.right;
                        }
                        if (((int) aSA.right) <= ((int) this.okb) && ((int) aSA.right) <= this.oiW.right) {
                            if (motionEvent.getX() - this.ojW > this.okb - aSA.right) {
                                this.ojv.postTranslate(this.okb - aSA.right, 0.0f);
                            } else {
                                this.ojv.postTranslate(motionEvent.getX() - this.ojW, 0.0f);
                            }
                        }
                        if (((float) this.oiW.width()) > aSA.width() && this.oiW.right < this.ojL.right) {
                            height = ((float) this.oiW.width()) / aSA.width();
                            this.ojv.postScale(height, height, (float) this.oiW.left, (float) this.oiW.centerY());
                        }
                    }
                    if (this.ojQ && this.oiW.right >= this.oiW.left) {
                        if (this.oiW.left >= this.ojL.left) {
                            if (this.ojW - motionEvent.getX() > ((float) (this.oiW.left - this.ojL.left))) {
                                this.oiW.left = this.ojL.left;
                            } else {
                                rect2 = this.oiW;
                                rect2.left = (int) (((float) rect2.left) - (this.ojW - motionEvent.getX()));
                            }
                        }
                        if (this.oiW.left > this.oiW.right - (this.ojC * 2)) {
                            this.oiW.left = this.oiW.right - (this.ojC * 2);
                        }
                        if (this.oiW.left < this.ojL.left) {
                            this.oiW.left = this.ojL.left;
                        }
                        if (((int) aSA.left) >= ((int) this.oka) && ((int) aSA.left) >= this.oiW.left) {
                            if (this.ojW - motionEvent.getX() > aSA.left - this.oka) {
                                this.ojv.postTranslate(this.oka - aSA.left, 0.0f);
                            } else {
                                this.ojv.postTranslate(motionEvent.getX() - this.ojW, 0.0f);
                            }
                        }
                        if (((float) this.oiW.width()) > aSA.width() && this.oiW.left > this.ojL.left) {
                            height = ((float) this.oiW.width()) / aSA.width();
                            this.ojv.postScale(height, height, (float) this.oiW.right, (float) this.oiW.centerY());
                        }
                    }
                    if (this.ojR && this.oiW.bottom >= this.oiW.top) {
                        if (this.oiW.top >= this.ojL.top) {
                            if (this.ojX - motionEvent.getY() > ((float) (this.oiW.top - this.ojL.top))) {
                                this.oiW.top = this.ojL.top;
                            } else {
                                rect2 = this.oiW;
                                rect2.top = (int) (((float) rect2.top) - (this.ojX - motionEvent.getY()));
                            }
                        }
                        if (this.oiW.top > this.oiW.bottom - (this.ojC * 2)) {
                            this.oiW.top = this.oiW.bottom - (this.ojC * 2);
                        }
                        if (this.oiW.top < this.ojL.top) {
                            this.oiW.top = this.ojL.top;
                        }
                        if (((int) aSA.top) >= ((int) this.ojY) && ((int) aSA.top) >= this.oiW.top) {
                            if (this.ojX - motionEvent.getY() > aSA.top - this.ojY) {
                                this.ojv.postTranslate(0.0f, this.ojY - aSA.top);
                            } else {
                                this.ojv.postTranslate(0.0f, motionEvent.getY() - this.ojX);
                            }
                        }
                        if (((float) this.oiW.height()) > aSA.height() && this.oiW.top > this.ojL.top) {
                            height = ((float) this.oiW.height()) / aSA.height();
                            this.ojv.postScale(height, height, (float) this.oiW.centerX(), (float) this.oiW.bottom);
                        }
                    }
                    if (this.ojS && this.oiW.bottom >= this.oiW.top) {
                        if (this.oiW.bottom <= this.ojL.bottom) {
                            if (motionEvent.getY() - this.ojX > ((float) (this.ojL.bottom - this.oiW.bottom))) {
                                this.oiW.bottom = this.ojL.bottom;
                            } else {
                                rect2 = this.oiW;
                                rect2.bottom = (int) (((float) rect2.bottom) + (motionEvent.getY() - this.ojX));
                            }
                        }
                        if (this.oiW.bottom < this.oiW.top + (this.ojC * 2)) {
                            this.oiW.bottom = this.oiW.top + (this.ojC * 2);
                        }
                        if (this.oiW.bottom > this.ojL.bottom) {
                            this.oiW.bottom = this.ojL.bottom;
                        }
                        if (((int) aSA.bottom) <= ((int) this.ojZ) && ((int) aSA.bottom) <= this.oiW.bottom) {
                            if (motionEvent.getY() - this.ojX > this.ojZ - aSA.bottom) {
                                this.ojv.postTranslate(0.0f, this.ojZ - aSA.bottom);
                            } else {
                                this.ojv.postTranslate(0.0f, motionEvent.getY() - this.ojX);
                            }
                        }
                        if (((float) this.oiW.height()) > aSA.height() && this.oiW.bottom < this.ojL.bottom) {
                            width = ((float) this.oiW.height()) / aSA.height();
                            this.ojv.postScale(width, width, (float) this.oiW.centerX(), (float) this.oiW.top);
                        }
                    }
                    aSb();
                    this.ojP = true;
                    aRR();
                    this.ojW = motionEvent.getX();
                    this.ojX = motionEvent.getY();
                } else {
                    this.ojP = false;
                }
                z(motionEvent);
                break;
            case 5:
                this.ojS = false;
                this.ojQ = false;
                this.ojR = false;
                this.ojT = false;
                this.ojP = false;
                break;
        }
        return this.ojP;
    }

    private boolean aRY() {
        return this.ojS || this.ojQ || this.ojR || this.ojT;
    }

    public final void g(Canvas canvas) {
        if (this.ojO) {
            canvas.setMatrix(this.ojF);
        } else {
            canvas.setMatrix(null);
        }
        com.tencent.mm.plugin.photoedit.f.a aVar = this.ojM;
        boolean z = this.ojU;
        boolean z2 = this.ojN;
        if (aVar.oiW == null) {
            w.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
            return;
        }
        if (z) {
            canvas.save();
            canvas.clipRect(aVar.oiW, Op.DIFFERENCE);
            canvas.drawPaint(com.tencent.mm.plugin.photoedit.f.a.omd);
            canvas.restore();
        }
        if (z2) {
            if (!com.tencent.mm.plugin.photoedit.f.a.gG.equals(aVar.oiW)) {
                com.tencent.mm.plugin.photoedit.f.a.oma.reset();
                com.tencent.mm.plugin.photoedit.f.a.oma.moveTo((float) aVar.oiW.left, (float) aVar.oiW.top);
                com.tencent.mm.plugin.photoedit.f.a.oma.lineTo((float) aVar.oiW.right, (float) aVar.oiW.top);
                com.tencent.mm.plugin.photoedit.f.a.oma.lineTo((float) aVar.oiW.right, (float) aVar.oiW.bottom);
                com.tencent.mm.plugin.photoedit.f.a.oma.lineTo((float) aVar.oiW.left, (float) aVar.oiW.bottom);
                com.tencent.mm.plugin.photoedit.f.a.oma.close();
                com.tencent.mm.plugin.photoedit.f.a.olZ.reset();
                for (int i = 1; i < 3; i++) {
                    com.tencent.mm.plugin.photoedit.f.a.olZ.moveTo((float) (aVar.oiW.left + ((aVar.oiW.width() / 3) * i)), (float) aVar.oiW.top);
                    com.tencent.mm.plugin.photoedit.f.a.olZ.lineTo((float) (aVar.oiW.left + ((aVar.oiW.width() / 3) * i)), (float) aVar.oiW.bottom);
                    com.tencent.mm.plugin.photoedit.f.a.olZ.moveTo((float) aVar.oiW.left, (float) (aVar.oiW.top + ((aVar.oiW.height() / 3) * i)));
                    com.tencent.mm.plugin.photoedit.f.a.olZ.lineTo((float) aVar.oiW.right, (float) (aVar.oiW.top + ((aVar.oiW.height() / 3) * i)));
                }
            }
            canvas.drawRect((float) aVar.oiW.left, (float) aVar.oiW.top, (float) aVar.oiW.right, (float) aVar.oiW.bottom, com.tencent.mm.plugin.photoedit.f.a.omc);
            canvas.drawPath(com.tencent.mm.plugin.photoedit.f.a.olZ, com.tencent.mm.plugin.photoedit.f.a.ome);
            canvas.drawPath(com.tencent.mm.plugin.photoedit.f.a.oma, com.tencent.mm.plugin.photoedit.f.a.omb);
            Canvas canvas2 = canvas;
            canvas2.drawLine(((float) aVar.oiW.left) - com.tencent.mm.plugin.photoedit.f.a.olX, ((float) aVar.oiW.top) - (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f), com.tencent.mm.plugin.photoedit.f.a.olY + ((float) aVar.oiW.left), ((float) aVar.oiW.top) - (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f), com.tencent.mm.plugin.photoedit.f.a.omf);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + (((float) aVar.oiW.right) - com.tencent.mm.plugin.photoedit.f.a.olY), ((float) aVar.oiW.top) - (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f), com.tencent.mm.plugin.photoedit.f.a.olX + ((float) aVar.oiW.right), ((float) aVar.oiW.top) - (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f), com.tencent.mm.plugin.photoedit.f.a.omf);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.oiW.left) - (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f), ((float) aVar.oiW.top) - (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f), ((float) aVar.oiW.left) - (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f), com.tencent.mm.plugin.photoedit.f.a.olY + ((float) aVar.oiW.top), com.tencent.mm.plugin.photoedit.f.a.omf);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.oiW.left) - (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f), (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + (((float) aVar.oiW.bottom) - com.tencent.mm.plugin.photoedit.f.a.olY), ((float) aVar.oiW.left) - (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f), (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.bottom), com.tencent.mm.plugin.photoedit.f.a.omf);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.right), (float) aVar.oiW.top, (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.right), com.tencent.mm.plugin.photoedit.f.a.olY + ((float) aVar.oiW.top), com.tencent.mm.plugin.photoedit.f.a.omf);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.right), (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + (((float) aVar.oiW.bottom) - com.tencent.mm.plugin.photoedit.f.a.olY), (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.right), (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.bottom), com.tencent.mm.plugin.photoedit.f.a.omf);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.oiW.left) - com.tencent.mm.plugin.photoedit.f.a.olX, (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.bottom), com.tencent.mm.plugin.photoedit.f.a.olY + ((float) aVar.oiW.left), (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.bottom), com.tencent.mm.plugin.photoedit.f.a.omf);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.oiW.right) - com.tencent.mm.plugin.photoedit.f.a.olY, (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.bottom), com.tencent.mm.plugin.photoedit.f.a.olX + ((float) aVar.oiW.right), (com.tencent.mm.plugin.photoedit.f.a.olX / 2.0f) + ((float) aVar.oiW.bottom), com.tencent.mm.plugin.photoedit.f.a.omf);
            if (!com.tencent.mm.plugin.photoedit.f.a.gG.equals(aVar.oiW)) {
                com.tencent.mm.plugin.photoedit.f.a.gG.set(aVar.oiW);
            }
        }
    }

    public final void f(Canvas canvas) {
    }

    public final void aRZ() {
        w.i("MicroMsg.CropArtist", "[doCrop]");
        this.ojK.cancel();
        if (this.okf != null) {
            this.okf.cancel();
        }
        this.ojz.old = this.ojz.ole;
        RectF rectF = new RectF(this.oiW);
        Matrix matrix = new Matrix();
        this.ojv.invert(matrix);
        matrix.mapRect(rectF);
        Rect rect = new Rect();
        rectF.round(rect);
        this.ojz.h(rect);
        final com.tencent.mm.plugin.photoedit.f.a aVar = new com.tencent.mm.plugin.photoedit.f.a();
        aVar.oiW = new Rect(this.oiW);
        aVar.olg.set(rect);
        this.ojz.a(new com.tencent.mm.plugin.photoedit.d.a.b(this) {
            final /* synthetic */ c okg;

            public final void LT() {
                com.tencent.mm.plugin.photoedit.f.a aVar = aVar;
                aVar.mMatrix.set(this.okg.ojv);
                a aVar2 = (a) this.okg.aRW();
                if (aVar2.okR != null) {
                    aVar2.okR.clear();
                }
                ((a) this.okg.aRW()).a(aVar);
            }

            public final void onStart() {
            }
        }, 0.0f, true);
        aRV();
    }

    public final void cancel() {
        w.i("MicroMsg.CropArtist", "[cancel]");
        this.ojK.cancel();
        if (this.okf != null) {
            this.okf.cancel();
        }
        this.ojz.old = this.ojz.ole;
        com.tencent.mm.plugin.photoedit.f.a aSj = ((a) aRW()).aSj();
        float f = 0.0f;
        if (aSj != null) {
            f = getRotation() - a(aSj.mMatrix);
        }
        if (!(aSj == null || aSj.olg.isEmpty())) {
            this.ojz.h(aSj.olg);
        }
        this.ojz.a(null, f, true);
        aRV();
    }

    public final void aSa() {
        float width = (((float) aRX().getWidth()) * 1.0f) / ((float) aRX().getHeight());
        int width2;
        if (width < (((float) this.ojL.width()) * 1.0f) / ((float) this.ojL.height())) {
            width2 = (int) ((((float) this.ojL.width()) - (width * ((float) this.ojL.height()))) / 2.0f);
            this.oiW.set(this.ojL.left + width2, this.ojL.top, this.ojL.right - width2, this.ojL.bottom);
        } else {
            width2 = (int) ((((float) this.ojL.height()) - (((float) this.ojL.width()) / width)) / 2.0f);
            this.oiW.set(this.ojL.left, this.ojL.top + width2, this.ojL.right, this.ojL.bottom - width2);
        }
        aSb();
    }

    public final void aSb() {
        this.ojH.set((float) (this.oiW.left - this.ojC), (float) (this.oiW.bottom - this.ojC), (float) (this.oiW.right + this.ojC), (float) (this.oiW.bottom + this.ojC));
        this.ojG.set((float) (this.oiW.left - this.ojC), (float) (this.oiW.top - this.ojC), (float) (this.oiW.right + this.ojC), (float) (this.oiW.top + this.ojC));
        this.ojI.set((float) (this.oiW.left - this.ojC), (float) (this.oiW.top - this.ojC), (float) (this.oiW.left + this.ojC), (float) (this.oiW.bottom + this.ojC));
        this.ojJ.set((float) (this.oiW.right - this.ojC), (float) (this.oiW.top - this.ojC), (float) (this.oiW.right + this.ojC), (float) (this.oiW.bottom + this.ojC));
    }

    public final void a(long j, boolean z, boolean z2) {
        PropertyValuesHolder ofInt;
        if (this.okf != null) {
            this.okf.cancel();
        }
        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("alpha", new int[]{0, 255});
        if (z) {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", new int[]{282, 255});
        } else if (z2) {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", new int[]{255, 255});
        } else {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", new int[]{0, 255});
        }
        this.okf = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt2, ofInt});
        this.okf.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ c okg;

            {
                this.okg = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue("bg_alpha")).intValue();
                com.tencent.mm.plugin.photoedit.f.a.ra(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
                com.tencent.mm.plugin.photoedit.f.a.rb(intValue);
                this.okg.aRR();
            }
        });
        this.okf.addListener(new AnimatorListener(this) {
            final /* synthetic */ c okg;

            {
                this.okg = r1;
            }

            public final void onAnimationStart(Animator animator) {
                this.okg.ojU = true;
                this.okg.ojN = true;
            }

            public final void onAnimationEnd(Animator animator) {
                this.okg.ojN = true;
            }

            public final void onAnimationCancel(Animator animator) {
                this.okg.ojN = false;
                animator.removeAllListeners();
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        this.okf.setStartDelay(j);
        this.okf.setDuration(300);
        this.okf.start();
    }
}
