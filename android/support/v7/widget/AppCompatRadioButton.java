package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.t;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton implements t {
    private h Um;
    private g Us;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(am.p(context), attributeSet, i);
        this.Um = h.ey();
        this.Us = new g(this, this.Um);
        this.Us.a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.Us != null) {
            this.Us.ew();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.Um != null ? this.Um.a(getContext(), i, false) : android.support.v4.content.a.a(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.Us != null ? this.Us.aL(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public final void e(ColorStateList colorStateList) {
        if (this.Us != null) {
            this.Us.e(colorStateList);
        }
    }

    public final void b(Mode mode) {
        if (this.Us != null) {
            this.Us.b(mode);
        }
    }
}
