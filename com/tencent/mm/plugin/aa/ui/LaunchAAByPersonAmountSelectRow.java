package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow extends LinearLayout {
    private ImageView ioV;
    private TextView ipW;
    private WalletFormView ipX;
    private View ipY;
    private TextWatcher ipZ = null;

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        r.eC(context).inflate(R.i.dgB, this, true);
        this.ioV = (ImageView) findViewById(R.h.bqG);
        this.ipW = (TextView) findViewById(R.h.cLl);
        this.ipX = (WalletFormView) findViewById(R.h.ckZ);
        this.ipY = findViewById(R.h.divider);
    }
}
