package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;

public class PreViewEmojiView extends MMEmojiView {
    public int hP = 0;

    public PreViewEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreViewEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.hP > 0) {
            setMeasuredDimension(this.hP, this.hP);
        }
    }
}
