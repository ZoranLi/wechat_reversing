package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class SignaturePreference extends Preference {
    public SignaturePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SignaturePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        viewGroup2.setPadding(0, 0, 0, 0);
        View.inflate(this.mContext, R.i.diW, viewGroup2);
        return onCreateView;
    }
}
