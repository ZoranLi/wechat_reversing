package com.tencent.mm.plugin.photoedit.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.R;
import com.tencent.mm.plugin.photoedit.b.e;
import com.tencent.mm.plugin.photoedit.c.d;
import com.tencent.mm.plugin.photoedit.cache.c;
import com.tencent.mm.plugin.photoedit.ui.MMPhotoEditUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

public final class e extends b<c> {
    private static final int okt = ((int) ab.getResources().getDimension(R.f.baR));
    Matrix ms = new Matrix();
    private boolean ojV = false;
    private Timer okA = new Timer();
    private TimerTask okB;
    private Rect okC = new Rect();
    private com.tencent.mm.plugin.photoedit.a.c okD = new com.tencent.mm.plugin.photoedit.a.c(this);
    boolean okE = false;
    private b okF;
    private boolean okr = false;
    private d oku;
    private float okv = 0.0f;
    private float okw = 0.0f;
    private int okx = 0;
    private int oky = 0;
    private boolean okz = false;

    class a extends TimerTask {
        private b okG;
        final /* synthetic */ e okH;

        public a(e eVar, b bVar) {
            this.okH = eVar;
            this.okG = bVar;
        }

        public final void run() {
            w.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
            com.tencent.mm.plugin.photoedit.f.c aSo = ((c) this.okH.aRW()).aSo();
            if (aSo != null && aSo.kuw) {
                aSo.setSelected(false);
                this.okG.b(false, aSo);
                this.okG.aRR();
            }
        }
    }

    public interface b {
        void a(com.tencent.mm.plugin.photoedit.f.e eVar);
    }

    public e(MMPhotoEditUI mMPhotoEditUI, com.tencent.mm.plugin.photoedit.c.b bVar) {
        super(bVar);
        this.okF = mMPhotoEditUI;
        this.oku = mMPhotoEditUI;
    }

    public final void a(com.tencent.mm.plugin.photoedit.d.b bVar) {
        super.a(bVar);
        this.okC.set(0, this.ojz.getHeight() - okt, this.ojz.getWidth(), this.ojz.getHeight());
        w.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s", new Object[]{this.okC});
        b(true, new Object[0]);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.okF = null;
        this.oku = null;
        aSe();
    }

    public final boolean y(MotionEvent motionEvent) {
        com.tencent.mm.plugin.photoedit.f.c B;
        boolean z;
        com.tencent.mm.plugin.photoedit.f.c aSo;
        switch (motionEvent.getActionMasked()) {
            case 0:
                aSe();
                B = B(motionEvent.getX(), motionEvent.getY());
                if (B != null) {
                    z = B.omp;
                    aSc();
                    this.okr = true;
                    B.setSelected(true);
                    B.omp = z;
                    B.omm.set(B.omj);
                    ((c) aRW()).a(B);
                    b(true, new Object[0]);
                    aRR();
                    break;
                }
                this.okr = false;
                aSo = ((c) aRW()).aSo();
                if (aSo != null) {
                    z = aSo.kuw;
                } else {
                    z = false;
                }
                if (z) {
                    b(false, aSc());
                    aRR();
                    break;
                }
                break;
            case 1:
                B = ((c) aRW()).aSo();
                if (B != null) {
                    if (!this.ojw.contains((int) B.omj.x, (int) B.omj.y)) {
                        this.okD.miY = true;
                        com.tencent.mm.plugin.photoedit.a.c cVar = this.okD;
                        cVar.ojd = B;
                        cVar.oiS = B.omm.x - B.omj.x;
                        cVar.oiT = B.omm.y - B.omj.y;
                        cVar.oje = B.omh;
                        com.tencent.mm.plugin.photoedit.a.b bVar = this.okD;
                        if (bVar.miY) {
                            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, bVar.oiT});
                            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, bVar.oiS});
                            bVar.oiP = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                            bVar.oiP.addUpdateListener(new AnimatorUpdateListener(bVar) {
                                final /* synthetic */ c ojf;

                                {
                                    this.ojf = r1;
                                }

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                                    w.d("MicroMsg.StickBackAnim", "animatorValueY:%s  %s", new Object[]{Float.valueOf(floatValue), Float.valueOf(floatValue - this.ojf.oiU)});
                                    e eVar = this.ojf.ojc;
                                    float f = floatValue2 - this.ojf.oiV;
                                    float f2 = floatValue - this.ojf.oiU;
                                    String str = this.ojf.oje;
                                    ListIterator aSq = ((com.tencent.mm.plugin.photoedit.cache.c) eVar.aRW()).aSq();
                                    while (aSq.hasPrevious()) {
                                        com.tencent.mm.plugin.photoedit.f.c cVar = (com.tencent.mm.plugin.photoedit.f.c) aSq.previous();
                                        if (cVar.omh.equals(str)) {
                                            cVar.omj.offset(f, f2);
                                            eVar.aRR();
                                            break;
                                        }
                                    }
                                    this.ojf.oiU = floatValue;
                                    this.ojf.oiV = floatValue2;
                                }
                            });
                            bVar.oiP.addListener(new AnimatorListener(bVar) {
                                final /* synthetic */ c ojf;

                                {
                                    this.ojf = r1;
                                }

                                public final void onAnimationStart(Animator animator) {
                                    this.ojf.miY = false;
                                    this.ojf.oiU = 0.0f;
                                    this.ojf.oiV = 0.0f;
                                    w.d("MicroMsg.StickBackAnim", "onAnimationStart");
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.ojf.miY = true;
                                    this.ojf.oiU = 0.0f;
                                    this.ojf.oiV = 0.0f;
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    this.ojf.miY = true;
                                    this.ojf.oiU = 0.0f;
                                    this.ojf.oiV = 0.0f;
                                }

                                public final void onAnimationRepeat(Animator animator) {
                                }
                            });
                            bVar.oiP.setInterpolator(new LinearInterpolator());
                            bVar.oiP.setDuration(100);
                            bVar.oiP.start();
                        }
                    }
                    if (B instanceof com.tencent.mm.plugin.photoedit.f.e) {
                        com.tencent.mm.plugin.photoedit.f.e eVar = (com.tencent.mm.plugin.photoedit.f.e) B;
                        if (eVar.kuw && eVar.omp) {
                            if (this.okF != null) {
                                this.okF.a(eVar);
                            }
                        } else if (eVar.kuw) {
                            eVar.omp = true;
                        }
                    }
                    PointF pointF = B.omj;
                    w.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[]{this.okC, Float.valueOf(A(pointF.x, pointF.y)[1])});
                    if (B.kuw && ((float) this.okC.top) <= r0[1] && this.okr && this.oku != null) {
                        this.oku.onRelease();
                        ((c) aRW()).aSn();
                        aRR();
                    }
                }
                aSd();
                if (this.ojV && this.oku != null) {
                    this.oku.onHide();
                }
                this.ojV = false;
                break;
            case 2:
                if (!this.okz) {
                    if (this.okr && C(motionEvent)) {
                        int toDegrees;
                        float f;
                        if (!(this.ojV || this.oku == null)) {
                            this.oku.azn();
                        }
                        int[] iArr = new int[]{(int) (motionEvent.getX(0) - this.ojx.x), (int) (motionEvent.getY(0) - this.ojx.y)};
                        float f2 = 1.0f;
                        if (motionEvent.getPointerCount() > 1) {
                            if (0.0f != this.okv) {
                                f2 = ((float) b.B(motionEvent)) / this.okv;
                            }
                            toDegrees = this.okx - ((int) Math.toDegrees(Math.atan2((double) b.A(motionEvent)[0], (double) b.A(motionEvent)[1])));
                            f = f2;
                        } else {
                            toDegrees = 0;
                            f = 1.0f;
                        }
                        float f3 = (float) iArr[0];
                        float f4 = (float) iArr[1];
                        float f5 = this.okw;
                        int i = this.oky;
                        int pointerCount = motionEvent.getPointerCount();
                        aSo = ((c) aRW()).aSo();
                        if (aSo != null) {
                            this.ms.reset();
                            this.ms.postRotate(-getRotation());
                            Matrix matrix = this.ms;
                            Matrix matrix2 = new Matrix();
                            matrix.invert(matrix2);
                            float[] fArr = new float[]{f3, f4};
                            matrix2.mapPoints(fArr);
                            if (pointerCount > 1) {
                                f *= f5;
                                aSo.b(fArr[0] / getScale(), fArr[1] / getScale(), f, (toDegrees + i) % 360);
                            } else {
                                aSo.b(fArr[0] / getScale(), fArr[1] / getScale(), 0.0f, aSo.omk);
                            }
                            aSo.aSJ();
                            PointF pointF2 = aSo.omj;
                            float[] A = A(pointF2.x, pointF2.y);
                            w.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[]{this.okC, Float.valueOf(A[1])});
                            if (((float) this.okC.top) <= A[1]) {
                                if (this.oku != null) {
                                    this.oku.ab((A[1] - ((float) this.okC.top)) / ((float) this.okC.height()));
                                }
                                this.okE = true;
                            } else {
                                if (this.oku != null && this.okE) {
                                    this.oku.aSu();
                                }
                                this.okE = false;
                            }
                            if (aSo instanceof com.tencent.mm.plugin.photoedit.f.e) {
                                aSo.omp = false;
                            }
                        }
                        this.ojV = true;
                        aRR();
                        break;
                    }
                }
                this.okz = false;
                return true;
            case 5:
                if (!this.okr) {
                    int[] iArr2 = new int[2];
                    if (motionEvent.getPointerCount() > 1) {
                        iArr2[0] = ((int) (motionEvent.getX(0) + motionEvent.getX(1))) / 2;
                        iArr2[1] = ((int) (motionEvent.getY(0) + motionEvent.getY(1))) / 2;
                    }
                    B = B((float) iArr2[0], (float) iArr2[1]);
                    if (B != null) {
                        z = B.omp;
                        aSc();
                        B.omp = z;
                        this.okr = true;
                        B.setSelected(true);
                        ((c) aRW()).a(B);
                        this.okv = (float) b.B(motionEvent);
                        this.okx = (int) Math.toDegrees(Math.atan2((double) b.A(motionEvent)[0], (double) b.A(motionEvent)[1]));
                        if (B != null && B.kuw) {
                            this.oky = B.omk;
                            this.okw = B.gj;
                        }
                        b(true, new Object[0]);
                        aRR();
                        break;
                    }
                }
                this.okv = (float) b.B(motionEvent);
                this.okx = (int) Math.toDegrees(Math.atan2((double) b.A(motionEvent)[0], (double) b.A(motionEvent)[1]));
                aSo = ((c) aRW()).aSo();
                if (aSo != null && aSo.kuw) {
                    this.oky = aSo.omk;
                    this.okw = aSo.gj;
                    break;
                }
                break;
            case 6:
                this.okz = true;
                break;
        }
        return this.okr;
    }

    public final a aRO() {
        return a.ojq;
    }

    public final void aRS() {
    }

    public final void a(a aVar, a aVar2) {
        if (aVar2 != a.ojq) {
            com.tencent.mm.plugin.photoedit.f.c aSo = ((c) aRW()).aSo();
            if (aSo != null && aSo.kuw) {
                aSo.setSelected(false);
                b(false, aSo);
                aRR();
            }
        }
    }

    public final void p(com.tencent.mm.storage.a.c cVar) {
        w.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[]{cVar});
        aSe();
        b(false, aSc());
        Rect rect = this.ojz.old;
        com.tencent.mm.plugin.photoedit.f.c cVar2 = new com.tencent.mm.plugin.photoedit.f.c(ab.getContext(), this.ojv, ((c) aRW()).okR.size(), cVar, rect);
        cVar2.setSelected(true);
        float[] z = z((float) rect.centerX(), (float) rect.centerY());
        cVar2.a(z[0], z[1], getScale(), (int) getRotation());
        ((c) aRW()).b(cVar2);
        aRR();
        aSd();
    }

    public final void a(SpannableString spannableString, int i) {
        w.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[]{spannableString});
        aSe();
        b(false, aSc());
        Rect rect = this.ojz.old;
        com.tencent.mm.plugin.photoedit.f.c eVar = new com.tencent.mm.plugin.photoedit.f.e(ab.getContext(), this.ojv, ((c) aRW()).okR.size(), rect, spannableString, i);
        eVar.setSelected(true);
        float[] z = z((float) rect.centerX(), (float) rect.centerY());
        eVar.a(z[0], z[1], this.ojz.aSw(), (int) getRotation());
        ((c) aRW()).b(eVar);
        aRR();
        aSd();
    }

    public final void g(Canvas canvas) {
        com.tencent.mm.plugin.photoedit.f.c aSo = ((c) aRW()).aSo();
        if (aSo != null && aSo.kuw) {
            aSo.draw(canvas);
        }
    }

    private com.tencent.mm.plugin.photoedit.f.c B(float f, float f2) {
        ListIterator aSq = ((c) aRW()).aSq();
        com.tencent.mm.plugin.photoedit.f.c cVar = null;
        while (aSq.hasPrevious()) {
            cVar = (com.tencent.mm.plugin.photoedit.f.c) aSq.previous();
            float[] z = z(f, f2);
            float f3 = z[0];
            float f4 = z[1];
            cVar.omq.clear();
            cVar.omq.add(cVar.ac(cVar.omr - 180.0f));
            cVar.omq.add(cVar.ac(-cVar.omr));
            cVar.omq.add(cVar.ac(cVar.omr));
            cVar.omq.add(cVar.ac((-cVar.omr) + 180.0f));
            com.tencent.mm.plugin.photoedit.f.c.a aVar = new com.tencent.mm.plugin.photoedit.f.c.a(cVar, cVar.omq);
            Object obj = null;
            int i = 0;
            int i2 = aVar.omv - 1;
            while (i < aVar.omv) {
                if ((aVar.omu[i] < f4 && aVar.omu[i2] >= f4) || (aVar.omu[i2] < f4 && aVar.omu[i] >= f4)) {
                    if (((aVar.omt[i2] - aVar.omt[i]) * ((f4 - aVar.omu[i]) / (aVar.omu[i2] - aVar.omu[i]))) + aVar.omt[i] < f3) {
                        obj = obj == null ? 1 : null;
                    }
                }
                int i3 = i;
                i++;
                i2 = i3;
            }
            if (obj != null) {
                break;
            }
            cVar = null;
        }
        return cVar;
    }

    public final com.tencent.mm.plugin.photoedit.f.c aSc() {
        com.tencent.mm.plugin.photoedit.f.c cVar = null;
        ListIterator aSq = ((c) aRW()).aSq();
        while (aSq.hasPrevious()) {
            com.tencent.mm.plugin.photoedit.f.c cVar2 = (com.tencent.mm.plugin.photoedit.f.c) aSq.previous();
            if (cVar2.kuw) {
                cVar = cVar2;
            }
            cVar2.setSelected(false);
        }
        return cVar;
    }

    public final void aSd() {
        w.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
        if (this.okB != null) {
            this.okB.cancel();
        }
        this.okB = new a(this, this);
        this.okA.schedule(this.okB, 1500);
    }

    public final void aSe() {
        w.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
        if (this.okB != null) {
            this.okB.cancel();
        }
    }
}
