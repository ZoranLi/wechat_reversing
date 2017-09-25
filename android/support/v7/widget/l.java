package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class l {
    private static final int[] Vp = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] Vq = new int[]{a.textAllCaps};
    final TextView Vr;
    private an Vs;
    private an Vt;
    private an Vu;
    private an Vv;

    static l d(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new m(textView);
        }
        return new l(textView);
    }

    l(TextView textView) {
        this.Vr = textView;
    }

    void a(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.Vr.getContext();
        h ey = h.ey();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Vp, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.Vs = a(context, ey, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.Vt = a(context, ey, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.Vu = a(context, ey, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.Vv = a(context, ey, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.Vr.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, k.dk);
                if (obtainStyledAttributes2.hasValue(k.Nu)) {
                    z = obtainStyledAttributes2.getBoolean(k.Nu, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, Vq, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                setAllCaps(z);
            }
        }
    }

    final void g(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, Vq);
        if (obtainStyledAttributes.hasValue(0)) {
            setAllCaps(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    private void setAllCaps(boolean z) {
        this.Vr.setTransformationMethod(z ? new android.support.v7.e.a(this.Vr.getContext()) : null);
    }

    void eB() {
        if (this.Vs != null || this.Vt != null || this.Vu != null || this.Vv != null) {
            Drawable[] compoundDrawables = this.Vr.getCompoundDrawables();
            a(compoundDrawables[0], this.Vs);
            a(compoundDrawables[1], this.Vt);
            a(compoundDrawables[2], this.Vu);
            a(compoundDrawables[3], this.Vv);
        }
    }

    final void a(Drawable drawable, an anVar) {
        if (drawable != null && anVar != null) {
            h.a(drawable, anVar, this.Vr.getDrawableState());
        }
    }

    protected static an a(Context context, h hVar, int i) {
        ColorStateList e = hVar.e(context, i);
        if (e == null) {
            return null;
        }
        an anVar = new an();
        anVar.aeE = true;
        anVar.aeC = e;
        return anVar;
    }
}
