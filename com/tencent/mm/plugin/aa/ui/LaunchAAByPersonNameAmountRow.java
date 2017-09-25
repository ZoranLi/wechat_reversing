package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.r;

public class LaunchAAByPersonNameAmountRow extends LinearLayout {
    TextView ioZ;
    TextView ipW;
    View ipY;

    public LaunchAAByPersonNameAmountRow(Context context) {
        super(context);
        init(context);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        r.eC(context).inflate(R.i.dgD, this, true);
        this.ipW = (TextView) findViewById(R.h.cLl);
        this.ioZ = (TextView) findViewById(R.h.boy);
        this.ipY = findViewById(R.h.divider);
    }
}
