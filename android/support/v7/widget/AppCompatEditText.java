package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.x;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.EditText;

public class AppCompatEditText extends EditText implements x {
    private h Um;
    private f Un;
    private l Uo;

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(am.p(context), attributeSet, i);
        this.Um = h.ey();
        this.Un = new f(this, this.Um);
        this.Un.a(attributeSet, i);
        this.Uo = l.d(this);
        this.Uo.a(attributeSet, i);
        this.Uo.eB();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Un != null) {
            this.Un.aK(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Un != null) {
            this.Un.f(null);
        }
    }

    public final void d(ColorStateList colorStateList) {
        if (this.Un != null) {
            this.Un.d(colorStateList);
        }
    }

    public final ColorStateList bL() {
        return this.Un != null ? this.Un.bL() : null;
    }

    public final void a(Mode mode) {
        if (this.Un != null) {
            this.Un.a(mode);
        }
    }

    public final Mode bM() {
        return this.Un != null ? this.Un.bM() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Un != null) {
            this.Un.ev();
        }
        if (this.Uo != null) {
            this.Uo.eB();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Uo != null) {
            this.Uo.g(context, i);
        }
    }
}
