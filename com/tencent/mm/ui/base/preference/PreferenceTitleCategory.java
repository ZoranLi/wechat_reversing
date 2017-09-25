package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.s.a.h;

public class PreferenceTitleCategory extends PreferenceCategory {
    public PreferenceTitleCategory(Context context) {
        this(context, null);
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getLayoutResource() != h.hey) {
            setLayoutResource(h.hew);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            if (getTitle() == null || getTitle().length() <= 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(getTitle());
        }
    }
}
