package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.c;

final class AppBrandSmileyPanel extends WebViewSmileyPanel {
    private int jus = 0;
    int jut = -1;
    private boolean pd = false;

    public AppBrandSmileyPanel(Context context) {
        super(context);
    }

    public AppBrandSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final c YV() {
        return new u();
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int min;
            int[] Xf;
            if (!j.aF(getContext())) {
                Xf = c.Xf();
                min = (Math.min(Xf[0], Xf[1]) / 2) - getContext().getResources().getDimensionPixelSize(R.f.aWK);
            } else if (this.jut > 0) {
                min = this.jut;
            } else if (this.jus > 0) {
                min = this.jus;
            } else {
                Xf = c.Xf();
                min = (Math.max(Xf[0], Xf[1]) / 2) - getContext().getResources().getDimensionPixelSize(R.f.aWK);
                this.jus = min;
            }
            bB(i, MeasureSpec.makeMeasureSpec(min, 1073741824));
            return;
        }
        bB(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
    }

    public final void setVisibility(int i) {
        iU(i);
        if (i == 0) {
            KC();
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.pd = true;
        super.onLayout(z, i, i2, i3, i4);
        this.pd = false;
    }

    final boolean YW() {
        if (d.eo(18)) {
            return super.isInLayout();
        }
        return this.pd;
    }
}
