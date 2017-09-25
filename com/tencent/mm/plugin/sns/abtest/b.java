package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;

public final class b {
    int Sa = 0;
    int jkQ = 0;
    int mScreenHeight = 0;
    c pNN;
    public NotInterestMenu pNS;
    ViewGroup pNT;
    com.tencent.mm.plugin.sns.abtest.NotInterestMenu.b pNU = new com.tencent.mm.plugin.sns.abtest.NotInterestMenu.b(this) {
        final /* synthetic */ b pOi;

        {
            this.pOi = r1;
        }

        public final void bdi() {
            this.pOi.bdj();
        }
    };
    Animation pNV = null;
    Animation pNW = null;
    private Animation pNX = null;
    private Animation pNY = null;
    int pNZ = 0;
    int pOa = 0;
    int pOb = 0;
    int pOc = 0;
    int pOd = 0;
    public boolean pOe = false;
    AbsoluteLayout pOf = null;
    public boolean pOg = false;
    boolean pOh = false;

    public b(ViewGroup viewGroup) {
        this.pNT = viewGroup;
        this.pNV = AnimationUtils.loadAnimation(ab.getContext(), a.pyR);
        this.pNV.setFillAfter(true);
        this.pNV.setDuration(100);
        this.pNV.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b pOi;

            {
                this.pOi = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.pOi.pOg = true;
            }

            public final void onAnimationEnd(Animation animation) {
                if (this.pOi.pNS != null) {
                    this.pOi.pNS.setVisibility(0);
                }
                this.pOi.pOg = false;
                this.pOi.pOe = true;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.pNW = AnimationUtils.loadAnimation(ab.getContext(), a.pyU);
        this.pNW.setFillAfter(true);
        this.pNW.setDuration(100);
        this.pNW.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b pOi;

            {
                this.pOi = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.pOi.pOg = true;
            }

            public final void onAnimationEnd(Animation animation) {
                if (this.pOi.pNS != null) {
                    this.pOi.pNS.setVisibility(0);
                }
                this.pOi.pOg = false;
                this.pOi.pOe = true;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.pNX = AnimationUtils.loadAnimation(ab.getContext(), a.pyS);
        this.pNX.setFillAfter(true);
        this.pNX.setDuration(100);
        this.pNX.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b pOi;

            {
                this.pOi = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.pOi.pOg = true;
            }

            public final void onAnimationEnd(Animation animation) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 pOj;

                    {
                        this.pOj = r1;
                    }

                    public final void run() {
                        this.pOj.pOi.bdj();
                    }
                });
                this.pOi.pOg = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.pNY = AnimationUtils.loadAnimation(ab.getContext(), a.pyT);
        this.pNY.setFillAfter(true);
        this.pNY.setDuration(100);
        this.pNY.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b pOi;

            {
                this.pOi = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.pOi.pOg = true;
            }

            public final void onAnimationEnd(Animation animation) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 pOk;

                    {
                        this.pOk = r1;
                    }

                    public final void run() {
                        this.pOk.pOi.bdj();
                    }
                });
                this.pOi.pOg = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public final void bdj() {
        if (this.pOf != null && this.pNT != null && this.pNS != null) {
            this.pOf.removeView(this.pNS);
            this.pNT.removeView(this.pOf);
            this.pOf = null;
            this.pNS = null;
            this.pOe = false;
        }
    }
}
