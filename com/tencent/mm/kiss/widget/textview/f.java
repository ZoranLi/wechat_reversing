package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public final class f {
    public int gravity;
    public TruncateAt haA;
    public boolean haI = true;
    CharSequence haJ;
    public TextPaint haK;
    public StaticLayout haL;
    public Alignment haz;
    public int maxLength;
    public int maxLines;
    CharSequence text;

    public f(StaticLayout staticLayout) {
        this.haL = staticLayout;
    }
}
