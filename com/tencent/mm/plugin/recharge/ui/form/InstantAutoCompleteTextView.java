package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.sdk.platformtools.w;

public class InstantAutoCompleteTextView extends AutoCompleteTextView {
    public boolean oNl;

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void dismissDropDown() {
        super.dismissDropDown();
        w.d("TestAutoCompleteTextView", "dismiss");
    }

    public boolean enoughToFilter() {
        return this.oNl || super.enoughToFilter();
    }
}
