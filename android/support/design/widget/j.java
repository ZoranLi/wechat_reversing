package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;

class j extends l {
    private int ib;
    private r ic = new r();
    public boolean ie;
    o if;

    private abstract class a extends Animation {
        final /* synthetic */ j ii;
        private float ij;
        private float ik;

        protected abstract float Y();

        private a(j jVar) {
            this.ii = jVar;
        }

        public void reset() {
            super.reset();
            this.ij = this.ii.if.jb;
            this.ik = Y() - this.ij;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            o oVar = this.ii.if;
            oVar.d(this.ij + (this.ik * f), oVar.iZ);
        }
    }

    private class b extends a {
        final /* synthetic */ j ii;

        private b(j jVar) {
            this.ii = jVar;
            super();
        }

        protected final float Y() {
            return this.ii.is + this.ii.it;
        }
    }

    private class c extends a {
        final /* synthetic */ j ii;

        private c(j jVar) {
            this.ii = jVar;
            super();
        }

        protected final float Y() {
            return this.ii.is;
        }
    }

    j(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.ib = visibilityAwareImageButton.getResources().getInteger(17694720);
        r rVar = this.ic;
        View an = rVar.an();
        if (an != visibilityAwareImageButton) {
            if (an != null) {
                View an2 = rVar.an();
                int size = rVar.jA.size();
                for (int i = 0; i < size; i++) {
                    if (an2.getAnimation() == ((a) rVar.jA.get(i)).mAnimation) {
                        an2.clearAnimation();
                    }
                }
                rVar.fh = null;
                rVar.jB = null;
                rVar.jC = null;
            }
            if (visibilityAwareImageButton != null) {
                rVar.fh = new WeakReference(visibilityAwareImageButton);
            }
        }
        this.ic.a(PRESSED_ENABLED_STATE_SET, c(new b()));
        this.ic.a(iu, c(new b()));
        this.ic.a(EMPTY_STATE_SET, c(new c()));
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.in = android.support.v4.b.a.a.g(l.ad());
        android.support.v4.b.a.a.a(this.in, colorStateList);
        if (mode != null) {
            android.support.v4.b.a.a.a(this.in, mode);
        }
        this.io = android.support.v4.b.a.a.g(l.ad());
        Drawable drawable = this.io;
        r1 = new int[3][];
        int[] iArr = new int[]{iu, i, PRESSED_ENABLED_STATE_SET};
        iArr[1] = i;
        r1[2] = new int[0];
        iArr[2] = 0;
        android.support.v4.b.a.a.a(drawable, new ColorStateList(r1, iArr));
        if (i2 > 0) {
            this.iq = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.iq, this.in, this.io};
        } else {
            this.iq = null;
            drawableArr = new Drawable[]{this.in, this.io};
        }
        this.ir = new LayerDrawable(drawableArr);
        this.if = new o(this.iv.getResources(), this.ir, this.iw.V(), this.is, this.is + this.it);
        o oVar = this.if;
        oVar.jg = false;
        oVar.invalidateSelf();
        this.iw.setBackgroundDrawable(this.if);
    }

    final void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.in != null) {
            android.support.v4.b.a.a.a(this.in, colorStateList);
        }
        if (this.iq != null) {
            this.iq.c(colorStateList);
        }
    }

    final void setBackgroundTintMode(Mode mode) {
        if (this.in != null) {
            android.support.v4.b.a.a.a(this.in, mode);
        }
    }

    void i(float f) {
        if (this.if != null) {
            this.if.d(f, this.it + f);
            ab();
        }
    }

    void j(float f) {
        if (this.if != null) {
            o oVar = this.if;
            oVar.d(oVar.jb, this.is + f);
            ab();
        }
    }

    void b(int[] iArr) {
        a aVar;
        r rVar = this.ic;
        int size = rVar.jA.size();
        for (int i = 0; i < size; i++) {
            a aVar2 = (a) rVar.jA.get(i);
            if (StateSet.stateSetMatches(aVar2.jF, iArr)) {
                aVar = aVar2;
                break;
            }
        }
        aVar = null;
        if (aVar != rVar.jB) {
            View an;
            if (!(rVar.jB == null || rVar.jC == null)) {
                an = rVar.an();
                if (an != null && an.getAnimation() == rVar.jC) {
                    an.clearAnimation();
                }
                rVar.jC = null;
            }
            rVar.jB = aVar;
            an = (View) rVar.fh.get();
            if (aVar != null && an != null && an.getVisibility() == 0) {
                rVar.jC = aVar.mAnimation;
                an = rVar.an();
                if (an != null) {
                    an.startAnimation(rVar.jC);
                }
            }
        }
    }

    void X() {
        r rVar = this.ic;
        if (rVar.jC != null) {
            View an = rVar.an();
            if (an != null && an.getAnimation() == rVar.jC) {
                an.clearAnimation();
            }
        }
    }

    void a(final a aVar, boolean z) {
        if (!this.ie && this.iv.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.iv.getContext(), android.support.design.a.a.U);
            loadAnimation.setInterpolator(a.eu);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new b(this, false) {
                final /* synthetic */ j ii;
            });
            this.iv.startAnimation(loadAnimation);
        }
    }

    void b(final a aVar, boolean z) {
        if (this.iv.getVisibility() != 0 || this.ie) {
            this.iv.clearAnimation();
            this.iv.i(0, false);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.iv.getContext(), android.support.design.a.a.T);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(a.ev);
            loadAnimation.setAnimationListener(new b(this) {
                final /* synthetic */ j ii;
            });
            this.iv.startAnimation(loadAnimation);
        }
    }

    void b(Rect rect) {
        this.if.getPadding(rect);
    }

    private Animation c(Animation animation) {
        animation.setInterpolator(a.et);
        animation.setDuration((long) this.ib);
        return animation;
    }
}
