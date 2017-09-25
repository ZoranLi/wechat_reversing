package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.z;

class k extends j {
    public boolean ie;

    k(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
    }

    boolean Z() {
        return true;
    }

    final void aa() {
        float rotation = this.iv.getRotation();
        if (this.if != null) {
            o oVar = this.if;
            float f = -rotation;
            if (oVar.fF != f) {
                oVar.fF = f;
                oVar.invalidateSelf();
            }
        }
        if (this.iq != null) {
            d dVar = this.iq;
            rotation = -rotation;
            if (rotation != dVar.fF) {
                dVar.fF = rotation;
                dVar.invalidateSelf();
            }
        }
    }

    final void a(final a aVar, boolean z) {
        if (!this.ie && this.iv.getVisibility() == 0) {
            if (!z.aj(this.iv) || this.iv.isInEditMode()) {
                this.iv.i(8, false);
                if (aVar == null) {
                    return;
                }
                return;
            }
            this.iv.animate().cancel();
            this.iv.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(a.eu).setListener(new AnimatorListenerAdapter(this, false) {
                private boolean il;
                final /* synthetic */ k im;

                public final void onAnimationStart(Animator animator) {
                    this.im.ie = true;
                    this.il = false;
                    this.im.iv.i(0, false);
                }

                public final void onAnimationCancel(Animator animator) {
                    this.im.ie = false;
                    this.il = true;
                }

                public final void onAnimationEnd(Animator animator) {
                    this.im.ie = false;
                    if (!this.il) {
                        this.im.iv.i(8, false);
                    }
                }
            });
        }
    }

    final void b(final a aVar, boolean z) {
        if (!this.ie && this.iv.getVisibility() == 0) {
            return;
        }
        if (!z.aj(this.iv) || this.iv.isInEditMode()) {
            this.iv.i(0, false);
            this.iv.setAlpha(1.0f);
            this.iv.setScaleY(1.0f);
            this.iv.setScaleX(1.0f);
            return;
        }
        this.iv.animate().cancel();
        if (this.iv.getVisibility() != 0) {
            this.iv.setAlpha(0.0f);
            this.iv.setScaleY(0.0f);
            this.iv.setScaleX(0.0f);
        }
        this.iv.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(a.ev).setListener(new AnimatorListenerAdapter(this, false) {
            final /* synthetic */ k im;

            public final void onAnimationStart(Animator animator) {
                this.im.iv.i(0, false);
            }

            public final void onAnimationEnd(Animator animator) {
            }
        });
    }
}
