package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.bg.a;
import com.tencent.smtt.sdk.WebView;

public class f extends YANumberPicker implements i<String> {
    private int jyB;
    private String[] jyz;

    public final /* synthetic */ Object ZF() {
        return (this.jyz == null || this.jyz.length <= 0) ? "" : this.jyz[getValue()];
    }

    public f(Context context) {
        super(context);
        setDividerHeight(a.fromDPToPix(context, 2));
        int parseColor = Color.parseColor("#1AAD19");
        if (this.jza != parseColor) {
            this.jza = parseColor;
            this.jzG.setColor(this.jza);
            postInvalidate();
        }
        parseColor = a.fromDPToPix(context, 8);
        if (this.jyY != parseColor) {
            this.jyY = parseColor;
            postInvalidate();
        }
        parseColor = Color.parseColor("#A5A5A5");
        if (this.jyO != parseColor) {
            this.jyO = parseColor;
            postInvalidate();
        }
        if (this.jyP != WebView.NIGHT_MODE_COLOR) {
            this.jyP = WebView.NIGHT_MODE_COLOR;
            postInvalidate();
        }
    }

    public final void h(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            setEnabled(false);
            setVisibility(4);
            return;
        }
        setEnabled(true);
        setVisibility(0);
        this.jyz = strArr;
        int i = this.jzi;
        int length = strArr.length - 1;
        if ((length - i) + 1 > (this.jzj - i) + 1) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
    }

    protected final void onMeasure(int i, int i2) {
        if (this.jyB > 0) {
            i = MeasureSpec.makeMeasureSpec(this.jyB, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final View getView() {
        return this;
    }

    public final void a(g gVar) {
    }

    public final void ZD() {
        ZQ();
    }

    public final void b(g gVar) {
    }

    public final void ZE() {
    }
}
