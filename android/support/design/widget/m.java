package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.b.a.a;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
final class m extends k {
    private InsetDrawable iz;
    private final Interpolator mInterpolator;

    m(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.mInterpolator = visibilityAwareImageButton.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.iv.getContext(), 17563661);
    }

    final void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.in = a.g(l.ad());
        a.a(this.in, colorStateList);
        if (mode != null) {
            a.a(this.in, mode);
        }
        if (i2 > 0) {
            this.iq = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.iq, this.in});
        } else {
            this.iq = null;
            layerDrawable = this.in;
        }
        this.io = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.ir = this.io;
        this.iw.setBackgroundDrawable(this.io);
    }

    public final void i(float f) {
        this.iv.setElevation(f);
        if (this.iw.W()) {
            ab();
        }
    }

    final void j(float f) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, a(ObjectAnimator.ofFloat(this.iv, "translationZ", new float[]{f})));
        stateListAnimator.addState(iu, a(ObjectAnimator.ofFloat(this.iv, "translationZ", new float[]{f})));
        stateListAnimator.addState(EMPTY_STATE_SET, a(ObjectAnimator.ofFloat(this.iv, "translationZ", new float[]{0.0f})));
        this.iv.setStateListAnimator(stateListAnimator);
        if (this.iw.W()) {
            ab();
        }
    }

    final void c(Rect rect) {
        if (this.iw.W()) {
            this.iz = new InsetDrawable(this.io, rect.left, rect.top, rect.right, rect.bottom);
            this.iw.setBackgroundDrawable(this.iz);
            return;
        }
        this.iw.setBackgroundDrawable(this.io);
    }

    final void b(int[] iArr) {
    }

    final void X() {
    }

    final boolean Z() {
        return false;
    }

    private Animator a(Animator animator) {
        animator.setInterpolator(this.mInterpolator);
        return animator;
    }

    final d ac() {
        return new e();
    }

    final void b(Rect rect) {
        if (this.iw.W()) {
            float V = this.iw.V();
            float elevation = this.iv.getElevation() + this.it;
            int ceil = (int) Math.ceil((double) o.b(elevation, V, false));
            int ceil2 = (int) Math.ceil((double) o.a(elevation, V, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
