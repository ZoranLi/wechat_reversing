package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.s.a.e;

public class BigIconSummaryPreference extends IconSummaryPreference {
    public BigIconSummaryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BigIconSummaryPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(e.hbH));
        return onCreateView;
    }
}
