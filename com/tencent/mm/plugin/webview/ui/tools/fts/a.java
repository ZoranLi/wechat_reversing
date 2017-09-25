package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Array;

public final class a {
    public static int nRa;
    public static int shL;
    private View jXN;
    public boolean nKt;
    public View shM;
    public View shN;
    public View shO;
    public View shP;
    public View shQ;
    public View shR;
    public float[][] shS;
    int shT = b.sic;
    public int shU;
    public int shV;
    public a shW;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] shZ = new int[b.bzd().length];

        static {
            try {
                shZ[b.sic - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                shZ[b.sid - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public interface a {
        void onAnimationEnd();
    }

    public enum b {
        ;

        public static int[] bzd() {
            return (int[]) sie.clone();
        }

        static {
            sic = 1;
            sid = 2;
            sie = new int[]{sic, sid};
        }
    }

    public a(Context context, final View view, final View view2, View view3, View view4, View view5, final View view6, View view7) {
        shL = com.tencent.mm.bg.a.fromDPToPix(context, 48) / 2;
        nRa = (int) context.getResources().getDimension(R.f.bbf);
        this.shS = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 2});
        this.shN = view;
        this.shM = view2;
        this.shO = view3;
        this.shR = view7;
        this.shP = view4;
        this.shQ = view5;
        this.jXN = view6;
        this.shN.post(new Runnable(this) {
            final /* synthetic */ a shY;

            public final void run() {
                this.shY.shS[0][0] = view.getY();
                this.shY.shS[0][1] = 0.0f;
                this.shY.shS[1][0] = view.getX();
                this.shY.shS[1][1] = 0.0f;
                this.shY.shS[2][0] = (float) view.getMeasuredWidth();
                this.shY.shS[2][1] = (float) (view.getMeasuredWidth() + (a.shL * 2));
            }
        });
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ a shY;

            public final boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                this.shY.shV = layoutParams.leftMargin - a.nRa;
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ a shY;

            public final boolean onPreDraw() {
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                this.shY.shU = (int) view6.getX();
                return true;
            }
        });
    }

    public final void wy(int i) {
        if (i != this.shT) {
            ObjectAnimator ofFloat;
            ObjectAnimator ofFloat2;
            ObjectAnimator ofFloat3;
            ObjectAnimator ofFloat4;
            switch (AnonymousClass2.shZ[i - 1]) {
                case 1:
                    ofFloat = ObjectAnimator.ofFloat(this.shN, "y", new float[]{this.shS[0][1], this.shS[0][0]});
                    ofFloat2 = ObjectAnimator.ofFloat(this.shN, "x", new float[]{this.shS[1][1], this.shS[1][0]});
                    ofFloat3 = ObjectAnimator.ofFloat(this.shM, "alpha", new float[]{0.0f, 1.0f});
                    ofFloat4 = ObjectAnimator.ofFloat(this.shP, "alpha", new float[]{0.0f, 1.0f});
                    ValueAnimator.ofInt(new int[]{this.shV, this.shU}).addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ a shY;

                        {
                            this.shY = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.shY.shN.setPadding(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0, 0, 0);
                        }
                    });
                    ValueAnimator.ofInt(new int[]{shL, 0}).addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ a shY;

                        {
                            this.shY = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            w.i("MicroMsg.FTS.SosAnimatorController", "widthSearchBarAnimator value : %d", new Object[]{Integer.valueOf(intValue)});
                            LayoutParams layoutParams = (LayoutParams) this.shY.shN.getLayoutParams();
                            layoutParams.leftMargin = a.shL - intValue;
                            layoutParams.rightMargin = a.shL - intValue;
                            layoutParams.width = (intValue * 2) + ((int) this.shY.shS[2][0]);
                            this.shY.shN.requestLayout();
                        }
                    });
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat, r5, ofFloat3, ofFloat4, r4});
                    animatorSet.setDuration(300);
                    animatorSet.addListener(new AnimatorListener(this) {
                        final /* synthetic */ a shY;

                        {
                            this.shY = r1;
                        }

                        public final void onAnimationStart(Animator animator) {
                            this.shY.nKt = true;
                            this.shY.shP.setVisibility(0);
                            this.shY.shM.setVisibility(0);
                            this.shY.shR.setVisibility(8);
                            this.shY.shQ.setVisibility(8);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            this.shY.nKt = false;
                            if (this.shY.shW != null) {
                                this.shY.shW.onAnimationEnd();
                            }
                            this.shY.shO.setVisibility(0);
                            this.shY.shN.setPadding(0, 0, 0, 0);
                            this.shY.shQ.setAlpha(1.0f);
                        }

                        public final void onAnimationCancel(Animator animator) {
                            this.shY.nKt = false;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                    animatorSet.start();
                    break;
                case 2:
                    ofFloat = ObjectAnimator.ofFloat(this.shN, "y", new float[]{this.shS[0][0], this.shS[0][1]});
                    ofFloat2 = ObjectAnimator.ofFloat(this.shN, "x", new float[]{this.shS[1][0], this.shS[1][1]});
                    ofFloat3 = ObjectAnimator.ofFloat(this.shM, "alpha", new float[]{1.0f, 0.0f});
                    ofFloat4 = ObjectAnimator.ofFloat(this.shP, "alpha", new float[]{1.0f, 0.0f});
                    ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.shQ, "alpha", new float[]{0.0f, 1.0f});
                    ValueAnimator.ofInt(new int[]{this.shU, this.shV}).addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ a shY;

                        {
                            this.shY = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.shY.shN.setPadding(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0, 0, 0);
                        }
                    });
                    ValueAnimator.ofInt(new int[]{0, shL}).addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ a shY;

                        {
                            this.shY = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            LayoutParams layoutParams = (LayoutParams) this.shY.shN.getLayoutParams();
                            layoutParams.leftMargin = a.shL - intValue;
                            layoutParams.rightMargin = a.shL - intValue;
                            layoutParams.width = (intValue * 2) + ((int) this.shY.shS[2][0]);
                            this.shY.shN.setLayoutParams(layoutParams);
                        }
                    });
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(new Animator[]{ofFloat2, ofFloat, r6, ofFloat3, ofFloat4, ofFloat5, r5});
                    animatorSet2.setDuration(300);
                    animatorSet2.addListener(new AnimatorListener(this) {
                        final /* synthetic */ a shY;

                        {
                            this.shY = r1;
                        }

                        public final void onAnimationStart(Animator animator) {
                            this.shY.nKt = true;
                            this.shY.shO.setVisibility(8);
                            this.shY.shQ.setVisibility(0);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            this.shY.nKt = false;
                            if (this.shY.shW != null) {
                                this.shY.shW.onAnimationEnd();
                            }
                            this.shY.shR.setVisibility(0);
                            this.shY.shP.setAlpha(1.0f);
                            this.shY.shP.setVisibility(8);
                        }

                        public final void onAnimationCancel(Animator animator) {
                            this.shY.nKt = false;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                    animatorSet2.start();
                    break;
            }
            this.shT = i;
        }
    }
}
