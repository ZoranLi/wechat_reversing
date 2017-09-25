package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.s.a.h;
import com.tencent.mm.ui.tools.r;

public class SwitchKeyValuePreference extends Preference {
    public boolean fFU;
    private TextView ouW;

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFU = true;
        setLayoutResource(h.diC);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.ouW = (TextView) view.findViewById(16908304);
        ar();
    }

    public final void ar() {
        if (this.ouW != null) {
            if (this.fFU) {
                this.ouW.setTextColor(r.fe(this.mContext));
            } else {
                this.ouW.setTextColor(r.ff(this.mContext));
            }
        }
    }
}
