package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailFooterPreference extends Preference implements OnClickListener {
    private LayoutInflater Du;
    private TextView sAu;
    private TextView sAv;
    OnClickListener sAw;

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Du = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        this.Du.inflate(R.i.drD, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.sAu = (TextView) view.findViewById(R.h.cRY);
        this.sAv = (TextView) view.findViewById(R.h.cRW);
        this.sAu.setOnClickListener(this);
        this.sAv.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.sAw != null) {
            this.sAw.onClick(view);
        }
    }
}
