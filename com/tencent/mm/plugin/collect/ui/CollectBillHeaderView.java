package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class CollectBillHeaderView extends LinearLayout {
    TextView kBg;
    WalletTextView kBh;
    TextView kBi;
    private TextView kBj;

    public CollectBillHeaderView(Context context) {
        super(context);
        init(context);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = r.eC(context).inflate(R.i.cYY, this);
        this.kBg = (TextView) inflate.findViewById(R.h.bDl);
        this.kBj = (TextView) inflate.findViewById(R.h.bDk);
        this.kBh = (WalletTextView) inflate.findViewById(R.h.bDn);
        this.kBi = (TextView) inflate.findViewById(R.h.bDm);
    }
}
