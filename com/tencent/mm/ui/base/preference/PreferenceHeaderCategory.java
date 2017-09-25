package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.h;

public class PreferenceHeaderCategory extends Preference {
    public PreferenceHeaderCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceHeaderCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(h.het);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.findViewById(16908310).setBackgroundResource(f.bgi);
        return onCreateView;
    }
}
