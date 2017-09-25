package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.s.a.h;
import com.tencent.mm.ui.r;

public class TextButtonPreference extends Preference {
    public TextButtonPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextButtonPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int getLayoutResource() {
        return h.hel;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return r.eC(this.mContext).inflate(h.hel, viewGroup, false);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setText(getTitle());
            textView.setEnabled(isEnabled());
        }
    }
}
