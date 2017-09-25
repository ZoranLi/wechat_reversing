package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Array;

public final class b {
    public static int shL;
    public boolean nKt;
    public View shM;
    public View shN;
    public View shP;
    public View shQ;
    public View shR;
    public float[][] shS;
    int shT = com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sic;
    public View sif;
    public a sig;

    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] shZ = new int[com.tencent.mm.plugin.webview.ui.tools.fts.a.b.bzd().length];

        static {
            try {
                shZ[com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sic - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                shZ[com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sid - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public interface a {
        void onAnimationEnd();
    }

    public b(Context context, final View view, View view2, View view3, View view4, View view5, View view6) {
        shL = com.tencent.mm.bg.a.fromDPToPix(context, 48) / 2;
        this.shS = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 2});
        this.shQ = view4;
        this.shN = view;
        this.shM = view2;
        this.shR = view5;
        this.shP = view3;
        this.sif = view6;
        this.shN.post(new Runnable(this) {
            final /* synthetic */ b sih;

            public final void run() {
                this.sih.shS[0][0] = view.getY();
                this.sih.shS[0][1] = 0.0f;
                this.sih.shS[1][0] = view.getX();
                this.sih.shS[1][1] = 0.0f;
                this.sih.shS[2][0] = (float) view.getMeasuredWidth();
                this.sih.shS[2][1] = (float) (view.getMeasuredWidth() + (b.shL * 2));
            }
        });
    }

    public final void wy(int i) {
        if (i != this.shT) {
            ObjectAnimator ofFloat;
            ObjectAnimator ofFloat2;
            ObjectAnimator ofFloat3;
            ObjectAnimator ofFloat4;
            AnimatorSet animatorSet;
            switch (AnonymousClass6.shZ[i - 1]) {
                case 1:
                    ofFloat = ObjectAnimator.ofFloat(this.shN, "y", new float[]{this.shS[0][1], this.shS[0][0]});
                    ofFloat2 = ObjectAnimator.ofFloat(this.shN, "x", new float[]{this.shS[1][1], this.shS[1][0]});
                    ofFloat3 = ObjectAnimator.ofFloat(this.sif, "alpha", new float[]{0.0f, 1.0f});
                    ofFloat4 = ObjectAnimator.ofFloat(this.shM, "alpha", new float[]{0.0f, 1.0f});
                    ValueAnimator.ofInt(new int[]{shL, 0}).addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ b sih;

                        {
                            this.sih = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            w.i("MicroMsg.FTS.SosAnimatorController", "widthSearchBarAnimator value : %d", new Object[]{Integer.valueOf(intValue)});
                            LayoutParams layoutParams = (LayoutParams) this.sih.shN.getLayoutParams();
                            layoutParams.leftMargin = b.shL - intValue;
                            layoutParams.rightMargin = b.shL - intValue;
                            layoutParams.width = (intValue * 2) + ((int) this.sih.shS[2][0]);
                            this.sih.shN.requestLayout();
                        }
                    });
                    animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat, r4, ofFloat3, ofFloat4});
                    animatorSet.setDuration(300);
                    animatorSet.addListener(new AnimatorListener(this) {
                        final /* synthetic */ b sih;

                        {
                            this.sih = r1;
                        }

                        public final void onAnimationStart(Animator animator) {
                            this.sih.nKt = true;
                            this.sih.shP.setVisibility(0);
                            this.sih.shM.setVisibility(0);
                            this.sih.shR.setVisibility(8);
                            this.sih.sif.setVisibility(0);
                            this.sih.shQ.setVisibility(8);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            this.sih.nKt = false;
                            if (this.sih.sig != null) {
                                this.sih.sig.onAnimationEnd();
                            }
                        }

                        public final void onAnimationCancel(Animator animator) {
                            this.sih.nKt = false;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                    animatorSet.start();
                    break;
                case 2:
                    ofFloat = ObjectAnimator.ofFloat(this.shN, "y", new float[]{this.shS[0][0], this.shS[0][1]});
                    ofFloat2 = ObjectAnimator.ofFloat(this.shN, "x", new float[]{this.shS[1][0], this.shS[1][1]});
                    ofFloat3 = ObjectAnimator.ofFloat(this.sif, "alpha", new float[]{1.0f, 0.0f});
                    ofFloat4 = ObjectAnimator.ofFloat(this.shM, "alpha", new float[]{1.0f, 0.0f});
                    ValueAnimator.ofInt(new int[]{0, shL}).addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ b sih;

                        {
                            this.sih = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            LayoutParams layoutParams = (LayoutParams) this.sih.shN.getLayoutParams();
                            layoutParams.leftMargin = b.shL - intValue;
                            layoutParams.rightMargin = b.shL - intValue;
                            layoutParams.width = (intValue * 2) + ((int) this.sih.shS[2][0]);
                            this.sih.shN.setLayoutParams(layoutParams);
                        }
                    });
                    animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat, r4, ofFloat3, ofFloat4});
                    animatorSet.setDuration(300);
                    animatorSet.addListener(new AnimatorListener(this) {
                        final /* synthetic */ b sih;

                        {
                            this.sih = r1;
                        }

                        public final void onAnimationStart(Animator animator) {
                            this.sih.nKt = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            this.sih.nKt = false;
                            if (this.sih.sig != null) {
                                this.sih.sig.onAnimationEnd();
                            }
                            this.sih.shR.setVisibility(0);
                            this.sih.sif.setAlpha(1.0f);
                            this.sih.sif.setVisibility(8);
                            this.sih.shM.setAlpha(1.0f);
                            this.sih.shM.setVisibility(8);
                        }

                        public final void onAnimationCancel(Animator animator) {
                            this.sih.nKt = false;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                    animatorSet.start();
                    break;
            }
            this.shT = i;
        }
    }
}
