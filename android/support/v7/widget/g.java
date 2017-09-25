package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.b.a.a;
import android.support.v4.widget.c;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class g {
    private final h Um;
    private final CompoundButton Ut;
    private ColorStateList Uu = null;
    private Mode Uv = null;
    private boolean Uw = false;
    private boolean Ux = false;
    private boolean Uy;

    g(CompoundButton compoundButton, h hVar) {
        this.Ut = compoundButton;
        this.Um = hVar;
    }

    final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.Ut.getContext().obtainStyledAttributes(attributeSet, k.bJ, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(k.LU)) {
                int resourceId = obtainStyledAttributes.getResourceId(k.LU, 0);
                if (resourceId != 0) {
                    this.Ut.setButtonDrawable(this.Um.a(this.Ut.getContext(), resourceId, false));
                }
            }
            if (obtainStyledAttributes.hasValue(k.LV)) {
                c.a(this.Ut, obtainStyledAttributes.getColorStateList(k.LV));
            }
            if (obtainStyledAttributes.hasValue(k.LW)) {
                c.a(this.Ut, w.aQ(obtainStyledAttributes.getInt(k.LW, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void e(ColorStateList colorStateList) {
        this.Uu = colorStateList;
        this.Uw = true;
        ex();
    }

    final void b(Mode mode) {
        this.Uv = mode;
        this.Ux = true;
        ex();
    }

    final void ew() {
        if (this.Uy) {
            this.Uy = false;
            return;
        }
        this.Uy = true;
        ex();
    }

    private void ex() {
        Drawable a = c.a(this.Ut);
        if (a == null) {
            return;
        }
        if (this.Uw || this.Ux) {
            a = a.g(a).mutate();
            if (this.Uw) {
                a.a(a, this.Uu);
            }
            if (this.Ux) {
                a.a(a, this.Uv);
            }
            if (a.isStateful()) {
                a.setState(this.Ut.getDrawableState());
            }
            this.Ut.setButtonDrawable(a);
        }
    }

    final int aL(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = c.a(this.Ut);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
