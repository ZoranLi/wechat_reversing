package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class g {
    public int RQ = 0;
    public int aar = 0;
    private int abF = 0;
    private final Context context;
    private ae mHandler = new ae();
    public int qoA = 4;
    public int qoB = this.qow;
    private int qoh = 0;
    public int qoi = 0;
    public int qoj = 0;
    private int qok = 0;
    private int qol = 0;
    private float qom = 0.0f;
    private float qon = 0.0f;
    public float qoo = 0.0f;
    float qop = 1.0f;
    public int qoq = 0;
    public int qor = 0;
    public int qos = 0;
    public int qot = 0;
    public int qou = 0;
    private int qov = e.CTRL_INDEX;
    public int qow = 0;
    public int qox = 1;
    public int qoy = 2;
    public int qoz = 3;
    public int wmA = 0;
    private int wmB = 10;
    public float wmw = 0.0f;
    private float wmx = 1.0f;
    public float wmy = 1.0f;
    private int wmz = 0;

    @TargetApi(18)
    public interface a {
        void q(int i, int i2, int i3, int i4);
    }

    public interface b {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public interface c {
    }

    public g(Context context) {
        this.context = context;
    }

    public final void p(int i, int i2, int i3, int i4) {
        this.abF = i;
        this.qoh = i2;
        this.aar = i3;
        this.RQ = i4;
    }

    public final void ek(int i, int i2) {
        this.qoi = i;
        this.qoj = i2;
    }

    public final void el(int i, int i2) {
        this.wmz = i;
        this.wmA = i2;
    }

    private void k(View view, boolean z) {
        int i;
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
        float f = this.wmx;
        if (!(this.qor == 0 && this.qos == 0 && this.qot == 0 && this.qou == 0)) {
            f = 1.1f;
        }
        if (z) {
            if (!(this.qoi == 0 || this.qoj == 0)) {
                this.qom = ((float) this.aar) / ((float) this.qoi);
                this.qon = ((float) this.RQ) / ((float) this.qoj);
            }
            f = 1.0f;
        }
        if (((double) this.wmy) != 1.0d) {
            this.qok += iArr[0];
            this.qol += iArr[1];
            this.qoo = this.qom * this.wmy;
            this.wmw = this.qoo;
            this.qol = (int) (((float) this.qol) - (((float) this.wmA) * this.qoo));
            this.qok = (int) (((float) this.qok) - (((float) this.wmz) * this.qoo));
            return;
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

    @TargetApi(16)
    public final void a(final View view, View view2, final b bVar) {
        if (VERSION.SDK_INT >= 12 && view != null && this.qoB != this.qoy && this.qoB != this.qoA && this.qoB != this.qoz) {
            k(view, false);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(this.qoo);
            view.setScaleY(this.qoo);
            view.setTranslationX((float) this.qok);
            view.setTranslationY((float) this.qol);
            if (view2 != null) {
                view2.setAlpha(0.0f);
                view2.animate().setDuration((long) this.qov).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(1.0f);
            }
            view.animate().setDuration((long) this.qov).setInterpolator(new DecelerateInterpolator(1.2f)).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setListener(new AnimatorListener(this) {
                final /* synthetic */ g wmD;

                public final void onAnimationStart(Animator animator) {
                    if (bVar != null) {
                        bVar.onAnimationStart();
                    }
                    this.wmD.qoB = this.wmD.qoy;
                }

                public final void onAnimationEnd(Animator animator) {
                    if (bVar != null) {
                        bVar.onAnimationEnd();
                    }
                    this.wmD.qoB = this.wmD.qoz;
                }

                public final void onAnimationCancel(Animator animator) {
                    this.wmD.qoB = this.wmD.qoz;
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ g wmD;

                public final void run() {
                    if (this.wmD.qoB == this.wmD.qow) {
                        w.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
                        view.requestLayout();
                    }
                }
            }, (long) this.wmB);
        }
    }

    @TargetApi(16)
    public final void a(View view, View view2, final b bVar, a aVar) {
        if (VERSION.SDK_INT < 12 || view == null || this.qoB == this.qoy || this.qoB == this.qoA || this.qoB == this.qox) {
            w.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", Integer.valueOf(this.qoB), view);
            return;
        }
        k(view, true);
        if (view2 != null) {
            view2.animate().setDuration(200).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
        }
        Animation animationSet = new AnimationSet(true);
        final View view3 = view;
        final a aVar2 = aVar;
        Animation anonymousClass3 = new ScaleAnimation(this, this.qoo, this.qoo) {
            final /* synthetic */ g wmD;

            protected final void applyTransformation(float f, Transformation transformation) {
                if (!(this.wmD.qoi == 0 || this.wmD.qoj == 0 || this.wmD.wmy != 1.0f)) {
                    Rect rect = new Rect();
                    view3.getGlobalVisibleRect(rect);
                    int i = (rect.right - rect.left) / 2;
                    int i2 = ((rect.bottom - rect.top) + this.wmD.qoq) / 2;
                    int i3 = (int) (((((float) (this.wmD.qoi - this.wmD.aar)) * (1.0f - f)) + ((float) this.wmD.aar)) / (1.0f - ((1.0f - this.wmD.qoo) * f)));
                    int i4 = (int) (((((float) (this.wmD.qoj - this.wmD.RQ)) * (1.0f - f)) + ((float) this.wmD.RQ)) / (1.0f - ((1.0f - this.wmD.qoo) * f)));
                    if (this.wmD.wmy != 1.0f) {
                        this.wmD.qoo = this.wmD.wmw / this.wmD.wmy;
                        i4 = rect.right;
                        i4 = rect.left;
                        i = (rect.right + rect.left) / 2;
                        i2 = (this.wmD.wmA - rect.top) + ((int) (((float) this.wmD.qoj) / 2.0f));
                        i3 = (int) (((((float) (this.wmD.qoi - this.wmD.aar)) * (1.0f - f)) + ((float) this.wmD.aar)) / (1.0f - ((1.0f - this.wmD.qoo) * f)));
                        i4 = (int) (((((float) (this.wmD.qoj - this.wmD.RQ)) * (1.0f - f)) + ((float) this.wmD.RQ)) / (1.0f - ((1.0f - this.wmD.qoo) * f)));
                    }
                    int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) this.wmD.qor) * f) / (1.0f - ((1.0f - this.wmD.qoo) * f))));
                    int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) this.wmD.qoq) * (1.0f - f)) / 2.0f)) + ((((float) this.wmD.qot) * f) / (1.0f - ((1.0f - this.wmD.qoo) * f))));
                    i3 = (int) (((float) ((i3 / 2) + i)) - ((((float) this.wmD.qos) * f) / (1.0f - ((1.0f - this.wmD.qoo) * f))));
                    i4 = (int) (((float) ((i4 / 2) + i2)) - ((((float) this.wmD.qou) * f) / (1.0f - ((1.0f - this.wmD.qoo) * f))));
                    if (VERSION.SDK_INT >= 21) {
                        view3.setClipBounds(new Rect(i5, i6, i3, i4));
                    } else if (VERSION.SDK_INT >= 18) {
                        if (aVar2 != null) {
                            aVar2.q(i5, i6, i3, i4);
                        } else {
                            view3.setClipBounds(new Rect(i5 + view3.getScrollX(), i6, i3 + view3.getScrollX(), i4));
                        }
                    }
                }
                super.applyTransformation(f, transformation);
            }
        };
        anonymousClass3.setDuration(200);
        anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(anonymousClass3);
        anonymousClass3 = new TranslateAnimation(0.0f, (float) this.qok, 0.0f, (float) this.qol);
        anonymousClass3.setDuration(200);
        anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(anonymousClass3);
        anonymousClass3 = new AlphaAnimation(1.0f, this.qop);
        anonymousClass3.setDuration(200);
        anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(anonymousClass3);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ g wmD;

            public final void onAnimationStart(Animation animation) {
                w.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
                if (bVar != null) {
                    bVar.onAnimationStart();
                }
                this.wmD.qoB = this.wmD.qoA;
            }

            public final void onAnimationEnd(Animation animation) {
                w.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
                if (bVar != null) {
                    bVar.onAnimationEnd();
                }
                this.wmD.qoB = this.wmD.qox;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(animationSet);
    }
}
