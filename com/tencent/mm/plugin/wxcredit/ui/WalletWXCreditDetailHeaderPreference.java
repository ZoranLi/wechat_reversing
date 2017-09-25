package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailHeaderPreference extends Preference {
    private LayoutInflater Du;
    TextView ioZ;
    TextView sAx;

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Du = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        this.Du.inflate(R.i.drE, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.ioZ = (TextView) view.findViewById(R.h.cRX);
        this.sAx = (TextView) view.findViewById(R.h.cSe);
    }
}
