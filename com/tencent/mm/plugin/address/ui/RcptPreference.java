package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.ui.base.preference.Preference;

public class RcptPreference extends Preference {
    RcptItem iuZ;

    public RcptPreference(Context context) {
        this(context, null);
    }

    public RcptPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RcptPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diS, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.iuZ != null) {
            ((TextView) view.findViewById(R.h.cTr)).setText(this.iuZ.name);
            View findViewById = view.findViewById(16908312);
            if (this.iuZ.ith) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
        }
    }
}
