package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MMLoadScrollView extends ScrollView {
    private a kZy;

    public interface a {
        void aoE();
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (z2 && i2 > 0 && this.kZy != null) {
            this.kZy.aoE();
        }
        super.onOverScrolled(i, i2, z, z2);
    }
}
