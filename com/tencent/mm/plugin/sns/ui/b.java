package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    public int RQ = 0;
    public int aar = 0;
    private int abF = 0;
    public final Context context;
    ae mHandler = new ae();
    public int qoA = 4;
    public int qoB = this.qow;
    private int qoh = 0;
    public int qoi = 0;
    public int qoj = 0;
    int qok = 0;
    int qol = 0;
    private float qom = 0.0f;
    private float qon = 0.0f;
    public float qoo = 0.0f;
    float qop = 1.0f;
    public int qoq = 0;
    public int qor = 0;
    public int qos = 0;
    public int qot = 0;
    public int qou = 0;
    public int qov = e.CTRL_INDEX;
    public int qow = 0;
    public int qox = 1;
    public int qoy = 2;
    public int qoz = 3;

    class AnonymousClass1 implements AnimatorListener {
        final /* synthetic */ b qoC;
        final /* synthetic */ View qoD;
        final /* synthetic */ LinkedList qoE;
        final /* synthetic */ b qoF;

        AnonymousClass1(b bVar, b bVar2, View view, LinkedList linkedList) {
            this.qoF = bVar;
            this.qoC = bVar2;
            this.qoD = view;
            this.qoE = linkedList;
        }

        public final void onAnimationStart(Animator animator) {
            if (this.qoC != null) {
                this.qoC.onAnimationStart();
            }
            this.qoF.qoB = this.qoF.qoy;
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.qoC != null) {
                this.qoC.onAnimationEnd();
            }
            this.qoF.qoB = this.qoF.qoz;
            ((WindowManager) this.qoF.context.getSystemService("window")).getDefaultDisplay().getHeight();
            this.qoD.setTranslationY(0.0f);
            Iterator it = this.qoE.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                view.setVisibility(0);
                view.setTranslationY(100.0f);
                view.setAlpha(0.0f);
                view.animate().setDuration((long) (this.qoF.qov / 2)).setInterpolator(new DecelerateInterpolator(1.2f)).translationY(0.0f).alpha(1.0f).setListener(new AnimatorListener(this) {
                    final /* synthetic */ AnonymousClass1 qoG;

                    {
                        this.qoG = r1;
                    }

                    public final void onAnimationStart(Animator animator) {
                        if (this.qoG.qoC != null) {
                            this.qoG.qoC.onAnimationStart();
                        }
                        this.qoG.qoF.qoB = this.qoG.qoF.qoy;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        if (this.qoG.qoC != null) {
                            this.qoG.qoC.onAnimationEnd();
                        }
                        this.qoG.qoF.qoB = this.qoG.qoF.qoz;
                    }

                    public final void onAnimationCancel(Animator animator) {
                        this.qoG.qoF.qoB = this.qoG.qoF.qoz;
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.qoF.qoB = this.qoF.qoz;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ View qoD;
        final /* synthetic */ LinkedList qoE;
        final /* synthetic */ b qoF;

        AnonymousClass2(b bVar, View view, LinkedList linkedList) {
            this.qoF = bVar;
            this.qoD = view;
            this.qoE = linkedList;
        }

        public final void run() {
            if (this.qoF.qoB == this.qoF.qow) {
                w.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
                this.qoD.requestLayout();
                Iterator it = this.qoE.iterator();
                while (it.hasNext()) {
                    ((View) it.next()).requestLayout();
                }
            }
        }
    }

    class AnonymousClass3 extends ScaleAnimation {
        final /* synthetic */ View qoD;
        final /* synthetic */ b qoF;
        final /* synthetic */ a qoH = null;

        AnonymousClass3(b bVar, float f, float f2, View view, a aVar) {
            this.qoF = bVar;
            this.qoD = view;
            super(1.0f, f, 1.0f, f2);
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (!(this.qoF.qoi == 0 || this.qoF.qoj == 0)) {
                Rect rect = new Rect();
                this.qoD.getGlobalVisibleRect(rect);
                int i = (rect.right - rect.left) / 2;
                int i2 = ((rect.bottom - rect.top) + this.qoF.qoq) / 2;
                int i3 = (int) (((((float) (this.qoF.qoi - this.qoF.aar)) * (1.0f - f)) + ((float) this.qoF.aar)) / (1.0f - ((1.0f - this.qoF.qoo) * f)));
                int i4 = (int) (((((float) (this.qoF.qoj - this.qoF.RQ)) * (1.0f - f)) + ((float) this.qoF.RQ)) / (1.0f - ((1.0f - this.qoF.qoo) * f)));
                int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) this.qoF.qor) * f) / (1.0f - ((1.0f - this.qoF.qoo) * f))));
                int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) this.qoF.qoq) * (1.0f - f)) / 2.0f)) + ((((float) this.qoF.qot) * f) / (1.0f - ((1.0f - this.qoF.qoo) * f))));
                i = (int) (((float) (i + (i3 / 2))) - ((((float) this.qoF.qos) * f) / (1.0f - ((1.0f - this.qoF.qoo) * f))));
                i2 = (int) (((float) (i2 + (i4 / 2))) - ((((float) this.qoF.qou) * f) / (1.0f - ((1.0f - this.qoF.qoo) * f))));
                if (VERSION.SDK_INT >= 21) {
                    this.qoD.setClipBounds(new Rect(i5, i6, i, i2));
                } else if (VERSION.SDK_INT >= 18 && this.qoH == null) {
                    this.qoD.setClipBounds(new Rect(i5 + this.qoD.getScrollX(), i6, i + this.qoD.getScrollX(), i2));
                }
            }
            super.applyTransformation(f, transformation);
        }
    }

    class AnonymousClass4 implements AnimationListener {
        final /* synthetic */ b qoC;
        final /* synthetic */ b qoF;

        AnonymousClass4(b bVar, b bVar2) {
            this.qoF = bVar;
            this.qoC = bVar2;
        }

        public final void onAnimationStart(Animation animation) {
            if (this.qoC != null) {
                this.qoC.onAnimationStart();
            }
            this.qoF.qoB = this.qoF.qoA;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.qoC != null) {
                this.qoC.onAnimationEnd();
            }
            this.qoF.qoB = this.qoF.qox;
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    @TargetApi(18)
    public interface a {
    }

    public interface b {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public b(Context context) {
        this.context = context;
    }

    public final void p(int i, int i2, int i3, int i4) {
        this.abF = i;
        this.qoh = i2;
        this.aar = i3;
        this.RQ = i4;
    }

    final void k(View view, boolean z) {
        int i;
        float f;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (this.abF == 0 && this.qoh == 0) {
            this.abF = view.getWidth() / 2;
            this.qoh = view.getHeight() / 2;
        }
        this.qok = this.abF - iArr[0];
        this.qol = this.qoh - iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            width = this.qoi;
            i = this.qoj;
            height = width;
        } else {
            i = height;
            height = width;
        }
        if (!(height == 0 || i == 0)) {
            this.qom = ((float) this.aar) / ((float) height);
            this.qon = ((float) this.RQ) / ((float) i);
        }
        if (this.qor == 0 && this.qos == 0 && this.qot == 0 && this.qou == 0) {
            f = 1.0f;
        } else {
            f = 1.1f;
        }
        if (z) {
            if (!(this.qoi == 0 || this.qoj == 0)) {
                this.qom = ((float) this.aar) / ((float) this.qoi);
                this.qon = ((float) this.RQ) / ((float) this.qoj);
            }
            f = 1.0f;
        }
        if (this.qom > this.qon) {
            this.qoo = this.qom * f;
            this.qol = (int) (((float) this.qol) - (((((float) i) * this.qoo) - (((float) this.RQ) * f)) / 2.0f));
        } else {
            this.qoo = this.qon * f;
            this.qok = (int) (((float) this.qok) - (((((float) height) * this.qoo) - (((float) this.aar) * f)) / 2.0f));
            if (this.qoj != 0 && this.qoj < i) {
                this.qol = (int) (((float) this.qol) - (((((float) i) * this.qoo) - (((float) this.RQ) * f)) / 2.0f));
            }
        }
        this.qol = (int) ((((float) this.qol) - ((((float) this.RQ) * (f - 1.0f)) / 2.0f)) - ((((float) this.qoq) * this.qoo) / 2.0f));
        this.qok = (int) (((float) this.qok) - ((((float) this.aar) * (f - 1.0f)) / 2.0f));
        if (this.qoj != 0 && this.qoh < (i - this.qoj) / 2) {
            this.qol = (int) ((((f - 1.0f) * ((float) this.RQ)) / 2.0f) + ((float) this.qol));
        } else if (this.qoj != 0 && this.qoh + this.RQ > (this.qoj + i) / 2) {
            this.qol = (int) (((float) this.qol) - (((f - 1.0f) * ((float) this.RQ)) / 2.0f));
        }
        if (this.aar == 0 && this.RQ == 0) {
            this.qoo = 0.5f;
            this.qop = 0.0f;
            this.qok = (int) (((float) this.qok) - ((((float) height) * this.qoo) / 2.0f));
            this.qol = (int) ((((float) this.qol) - ((((float) i) * this.qoo) / 2.0f)) - ((((float) this.qoq) * this.qoo) / 2.0f));
        }
    }
}
