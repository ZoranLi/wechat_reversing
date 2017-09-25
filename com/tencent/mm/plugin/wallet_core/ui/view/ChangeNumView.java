package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ChangeNumView extends TextView {
    private int max = 0;
    private int qVP = -1;
    private int rOT = 0;
    private int rOU = 0;
    private boolean rOV = false;
    private final int rOW = 100;

    public ChangeNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangeNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
