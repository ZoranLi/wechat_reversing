package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

final class m extends l {
    private static final int[] Vw = new int[]{16843666, 16843667};
    private an Vx;
    private an Vy;

    m(TextView textView) {
        super(textView);
    }

    final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.Vr.getContext();
        h ey = h.ey();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Vw, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.Vx = l.a(context, ey, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.Vy = l.a(context, ey, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }

    final void eB() {
        super.eB();
        if (this.Vx != null || this.Vy != null) {
            Drawable[] compoundDrawablesRelative = this.Vr.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.Vx);
            a(compoundDrawablesRelative[2], this.Vy);
        }
    }
}
