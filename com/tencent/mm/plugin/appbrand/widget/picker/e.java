package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.a.a;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.picker.b;

public class e extends NumberPicker implements i<String> {
    private int PN;
    private int iO;
    private int jyA;
    private String[] jyz;

    public final /* synthetic */ Object ZF() {
        return ZH();
    }

    @a
    public e(Context context) {
        super(new ContextThemeWrapper(context, R.m.foJ));
        b.a(this, getResources().getDrawable(R.g.blX));
        b.b(this);
        this.PN = com.tencent.mm.bg.a.fromDPToPix(context, 100);
        this.jyA = com.tencent.mm.bg.a.fromDPToPix(context, 20);
    }

    public final void h(String[] strArr) {
        if (strArr != null) {
            this.jyz = strArr;
            setDisplayedValues(null);
            setMinValue(0);
            setMaxValue(Math.max(strArr.length - 1, 0));
            if (strArr.length <= 0) {
                strArr = null;
            }
            super.setDisplayedValues(strArr);
        }
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        super.setDisplayedValues(strArr);
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) == Integer.MIN_VALUE || MeasureSpec.getMode(i) == 1073741824) {
            this.iO = MeasureSpec.getSize(i);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), i2);
        if (getMeasuredWidth() > this.PN || (this.iO > 0 && this.PN > this.iO)) {
            int measuredWidth = getMeasuredWidth() + (this.jyA * 2);
            if (this.iO > 0 && this.iO <= measuredWidth) {
                measuredWidth = this.iO;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            return;
        }
        setMeasuredDimension(this.PN, getMeasuredHeight());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.c(this);
    }

    public final String ZH() {
        return (this.jyz == null || this.jyz.length <= 0) ? "" : this.jyz[getValue()];
    }

    public final View getView() {
        return this;
    }

    public final void a(g gVar) {
    }

    public final void ZD() {
    }

    public final void b(g gVar) {
    }

    public final void ZE() {
    }
}
