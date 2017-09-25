package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;

public class RTChattingEmojiViewTo extends RTChattingEmojiView {
    public RTChattingEmojiViewTo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public RTChattingEmojiViewTo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    public final void KC() {
        super.KC();
        this.sRL.gravity = 5;
        addView(this.sRI, this.sRL);
    }
}
