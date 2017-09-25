package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.s.a.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.tools.r;

public class IconSwitchKeyValuePreference extends IconPreference {
    private TextView ouW;
    private int status;

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.ouW = (TextView) view.findViewById(16908304);
        ar();
    }

    public final void AA(int i) {
        this.status = i;
        ar();
    }

    private void ar() {
        if (this.ouW != null) {
            int a = b.a(this.mContext, 2.0f);
            this.ouW.setTextColor(r.ff(this.mContext));
            if (this.status == 0) {
                this.ouW.setCompoundDrawablesWithIntrinsicBounds(j.hfb, 0, 0, 0);
                this.ouW.setCompoundDrawablePadding(a);
            } else if (this.status == 1) {
                this.ouW.setCompoundDrawablesWithIntrinsicBounds(j.heZ, 0, 0, 0);
                this.ouW.setCompoundDrawablePadding(a);
            } else if (this.status == 2) {
                this.ouW.setCompoundDrawablesWithIntrinsicBounds(j.hfa, 0, 0, 0);
                this.ouW.setCompoundDrawablePadding(a);
            } else {
                this.ouW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
    }
}
