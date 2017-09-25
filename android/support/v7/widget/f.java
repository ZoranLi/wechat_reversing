package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;

final class f {
    private final h Um;
    private an Up;
    private an Uq;
    private an Ur;
    private final View mView;

    f(View view, h hVar) {
        this.mView = view;
        this.Um = hVar;
    }

    final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, k.dF, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(k.NT)) {
                ColorStateList e = this.Um.e(this.mView.getContext(), obtainStyledAttributes.getResourceId(k.NT, -1));
                if (e != null) {
                    f(e);
                }
            }
            if (obtainStyledAttributes.hasValue(k.NU)) {
                z.a(this.mView, obtainStyledAttributes.getColorStateList(k.NU));
            }
            if (obtainStyledAttributes.hasValue(k.NV)) {
                z.a(this.mView, w.aQ(obtainStyledAttributes.getInt(k.NV, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void aK(int i) {
        f(this.Um != null ? this.Um.e(this.mView.getContext(), i) : null);
    }

    final void d(ColorStateList colorStateList) {
        if (this.Uq == null) {
            this.Uq = new an();
        }
        this.Uq.aeC = colorStateList;
        this.Uq.aeE = true;
        ev();
    }

    final ColorStateList bL() {
        return this.Uq != null ? this.Uq.aeC : null;
    }

    final void a(Mode mode) {
        if (this.Uq == null) {
            this.Uq = new an();
        }
        this.Uq.nl = mode;
        this.Uq.aeD = true;
        ev();
    }

    final Mode bM() {
        return this.Uq != null ? this.Uq.nl : null;
    }

    final void ev() {
        boolean z = false;
        Drawable background = this.mView.getBackground();
        if (background != null) {
            if (VERSION.SDK_INT == 21) {
                if (this.Ur == null) {
                    this.Ur = new an();
                }
                an anVar = this.Ur;
                anVar.aeC = null;
                anVar.aeE = false;
                anVar.nl = null;
                anVar.aeD = false;
                ColorStateList af = z.af(this.mView);
                if (af != null) {
                    anVar.aeE = true;
                    anVar.aeC = af;
                }
                Mode ag = z.ag(this.mView);
                if (ag != null) {
                    anVar.aeD = true;
                    anVar.nl = ag;
                }
                if (anVar.aeE || anVar.aeD) {
                    h.a(background, anVar, this.mView.getDrawableState());
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            if (this.Uq != null) {
                h.a(background, this.Uq, this.mView.getDrawableState());
            } else if (this.Up != null) {
                h.a(background, this.Up, this.mView.getDrawableState());
            }
        }
    }

    final void f(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.Up == null) {
                this.Up = new an();
            }
            this.Up.aeC = colorStateList;
            this.Up.aeE = true;
        } else {
            this.Up = null;
        }
        ev();
    }
}
