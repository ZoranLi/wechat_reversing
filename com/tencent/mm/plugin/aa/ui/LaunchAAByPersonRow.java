package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow extends LinearLayout {
    private WalletFormView iqA;
    private TextView iqB;
    private ImageView iqx;
    private TextView iqy;
    private TextView iqz;

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        inflate(getContext(), R.i.dgE, this);
        this.iqx = (ImageView) findViewById(R.h.bmj);
        this.iqy = (TextView) findViewById(R.h.bmu);
        this.iqA = (WalletFormView) findViewById(R.h.caC);
        this.iqz = (TextView) findViewById(R.h.caD);
        this.iqB = (TextView) findViewById(R.h.cmj);
    }
}
