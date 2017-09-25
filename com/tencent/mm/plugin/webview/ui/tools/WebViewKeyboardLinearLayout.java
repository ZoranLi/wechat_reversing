package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout extends KeyboardLinearLayout {
    private int RQ;
    private boolean mHasInit = false;
    private boolean scb;
    private int scc;
    public int scd;
    private int sce;

    public WebViewKeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebViewKeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected final void wl(int i) {
        w.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + i + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.scb);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int height = getRootView().getHeight();
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.RQ = i;
            w.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", new Object[]{Integer.valueOf(this.RQ)});
            nx(-1);
            this.sce = height - rect.bottom;
        }
        w.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", new Object[]{rect.toString()});
        height = rect.height();
        this.RQ = height;
        w.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", new Object[]{Integer.valueOf(height), Integer.valueOf(this.scc)});
        if (this.scc != height) {
            int height2 = (getRootView().getHeight() - this.sce) - rect.top;
            int i2 = height2 - height;
            if (i2 > height2 / 4) {
                this.scb = true;
                this.scd = i2;
                nx(-3);
                w.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.RQ + " b: " + i + " mKBHeight: " + this.scd);
            } else {
                this.scb = false;
                nx(-2);
                w.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.RQ + " b: " + i);
            }
            this.scc = height;
        }
    }
}
