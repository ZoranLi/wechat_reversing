package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class StrokeScrollBar extends VerticalScrollBar {
    protected final void aez() {
        this.mTx = new String[18];
        for (int i = 0; i < this.mTx.length; i++) {
            this.mTx[i] = Integer.toString(i + 3) + "劃";
        }
        this.mTv = 2.0f;
        this.mTw = 79;
    }

    public StrokeScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int aEZ() {
        return R.i.doy;
    }
}
