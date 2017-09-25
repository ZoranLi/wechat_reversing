package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;

public class RTChattingEmojiViewFrom extends RTChattingEmojiView {
    public RTChattingEmojiViewFrom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public RTChattingEmojiViewFrom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    public final void KC() {
        super.KC();
        this.sRL.gravity = 3;
        addView(this.sRI, this.sRL);
    }
}
