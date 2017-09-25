package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.b.a.a;
import android.support.v7.b.a.c;
import android.support.v7.b.a.d;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout implements o {
    private static final int[] VB = new int[]{16842801};
    private static final q VC;
    private boolean VD;
    private int VE;
    private int VF;
    private final Rect VG = new Rect();
    private final Rect VH = new Rect();
    private boolean hR;

    static {
        if (VERSION.SDK_INT >= 21) {
            VC = new n();
        } else if (VERSION.SDK_INT >= 17) {
            VC = new r();
        } else {
            VC = new p();
        }
        VC.eF();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public final boolean eD() {
        return this.hR;
    }

    protected void onMeasure(int i, int i2) {
        if (VC instanceof n) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) VC.a(this)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) VC.b(this)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        int color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.Oh, i, c.Og);
        if (obtainStyledAttributes.hasValue(d.Ok)) {
            color = obtainStyledAttributes.getColor(d.Ok, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(VB);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            color = fArr[2] > 0.5f ? getResources().getColor(a.Oc) : getResources().getColor(a.Ob);
        }
        float dimension = obtainStyledAttributes.getDimension(d.Ol, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.Om, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.On, 0.0f);
        this.hR = obtainStyledAttributes.getBoolean(d.Op, false);
        this.VD = obtainStyledAttributes.getBoolean(d.Oo, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.Oq, 0);
        this.VG.left = obtainStyledAttributes.getDimensionPixelSize(d.Os, dimensionPixelSize);
        this.VG.top = obtainStyledAttributes.getDimensionPixelSize(d.Ou, dimensionPixelSize);
        this.VG.right = obtainStyledAttributes.getDimensionPixelSize(d.Ot, dimensionPixelSize);
        this.VG.bottom = obtainStyledAttributes.getDimensionPixelSize(d.Or, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.VE = obtainStyledAttributes.getDimensionPixelSize(d.Oj, 0);
        this.VF = obtainStyledAttributes.getDimensionPixelSize(d.Oi, 0);
        obtainStyledAttributes.recycle();
        VC.a(this, context, color, dimension, dimension2, dimension3);
    }

    public void setMinimumWidth(int i) {
        this.VE = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.VF = i;
        super.setMinimumHeight(i);
    }

    public final void y(int i, int i2) {
        if (i > this.VE) {
            super.setMinimumWidth(i);
        }
        if (i2 > this.VF) {
            super.setMinimumHeight(i2);
        }
    }

    public final void c(int i, int i2, int i3, int i4) {
        this.VH.set(i, i2, i3, i4);
        super.setPadding(this.VG.left + i, this.VG.top + i2, this.VG.right + i3, this.VG.bottom + i4);
    }

    public final boolean eE() {
        return this.VD;
    }
}
