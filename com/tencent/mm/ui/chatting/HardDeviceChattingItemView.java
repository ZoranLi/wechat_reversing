package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class HardDeviceChattingItemView extends LinearLayout {
    private boolean mHasInit;

    public HardDeviceChattingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.mHasInit = true;
        }
    }
}
