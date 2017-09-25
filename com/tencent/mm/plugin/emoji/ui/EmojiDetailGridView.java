package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.emoji.ui.smiley.SmileySubGrid;

public class EmojiDetailGridView extends SmileySubGrid {
    String kMS;
    EmojiDetailScrollView kQw;
    private volatile boolean kQx = true;

    public EmojiDetailGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    protected final void du(boolean z) {
        if (this.kQw != null) {
            this.kQw.kQy = z;
        }
    }

    protected final int anr() {
        return m.CTRL_INDEX;
    }
}
