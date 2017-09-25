package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.a.c;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class l {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
    static final int[] iu = new int[]{16842908, 16842910};
    private final Rect gG = new Rect();
    Drawable in;
    Drawable io;
    d iq;
    Drawable ir;
    float is;
    float it;
    final VisibilityAwareImageButton iv;
    final p iw;
    OnPreDrawListener ix;

    interface a {
    }

    abstract void X();

    abstract void a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void a(a aVar, boolean z);

    abstract void b(Rect rect);

    abstract void b(a aVar, boolean z);

    abstract void b(int[] iArr);

    abstract void i(float f);

    abstract void j(float f);

    abstract void setBackgroundTintList(ColorStateList colorStateList);

    abstract void setBackgroundTintMode(Mode mode);

    l(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        this.iv = visibilityAwareImageButton;
        this.iw = pVar;
    }

    final void ab() {
        Rect rect = this.gG;
        b(rect);
        c(rect);
        this.iw.c(rect.left, rect.top, rect.right, rect.bottom);
    }

    void c(Rect rect) {
    }

    boolean Z() {
        return false;
    }

    final d a(int i, ColorStateList colorStateList) {
        Resources resources = this.iv.getResources();
        d ac = ac();
        int color = resources.getColor(c.ae);
        int color2 = resources.getColor(c.ad);
        int color3 = resources.getColor(c.ab);
        int color4 = resources.getColor(c.ac);
        ac.fy = color;
        ac.fz = color2;
        ac.fA = color3;
        ac.fB = color4;
        float f = (float) i;
        if (ac.fx != f) {
            ac.fx = f;
            ac.fu.setStrokeWidth(f * 1.3333f);
            ac.fE = true;
            ac.invalidateSelf();
        }
        ac.c(colorStateList);
        return ac;
    }

    d ac() {
        return new d();
    }

    void aa() {
    }

    static GradientDrawable ad() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
