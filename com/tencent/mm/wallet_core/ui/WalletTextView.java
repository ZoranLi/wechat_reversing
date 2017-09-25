package com.tencent.mm.wallet_core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint({"AppCompatCustomView"})
public class WalletTextView extends TextView {
    public WalletTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTypeface(Typeface typeface, int i) {
        super.setTypeface(e.fm(getContext()), i);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(e.fm(getContext()));
    }
}
