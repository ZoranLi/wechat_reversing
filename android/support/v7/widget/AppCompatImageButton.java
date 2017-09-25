package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.x;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class AppCompatImageButton extends ImageButton implements x {
    private f Un;
    private i hT;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(am.p(context), attributeSet, i);
        h ey = h.ey();
        this.Un = new f(this, ey);
        this.Un.a(attributeSet, i);
        this.hT = new i(this, ey);
        this.hT.a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.hT.setImageResource(i);
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
    }
}
