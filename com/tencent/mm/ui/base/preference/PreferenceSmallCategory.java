package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.s.a.h;

public class PreferenceSmallCategory extends PreferenceCategory {
    public PreferenceSmallCategory(Context context) {
        this(context, null);
    }

    public PreferenceSmallCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceSmallCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(h.het);
    }
}
