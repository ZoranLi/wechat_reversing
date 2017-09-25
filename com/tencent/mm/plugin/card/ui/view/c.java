package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;

public final class c extends i {
    private View kpR;
    private TextView kpS;

    public final void KC() {
    }

    public final void update() {
        if (this.kpR == null) {
            this.kpR = ((ViewStub) findViewById(R.h.bvX)).inflate();
            this.kpS = (TextView) this.kpR.findViewById(R.h.bvY);
        }
        this.kpR.setVisibility(0);
        this.kpR.setOnClickListener(this.kqe.ahn());
        b ahj = this.kqe.ahj();
        if (TextUtils.isEmpty(ahj.afi().toC.ttH)) {
            this.kpS.setText(getString(R.l.dRo));
        } else {
            this.kpS.setText(ahj.afi().toC.ttH);
        }
    }

    public final void aiz() {
        if (this.kpR != null) {
            this.kpR.setVisibility(8);
        }
    }
}
