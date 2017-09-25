package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public final class y extends i {
    private b kcX;
    private MMActivity kdb;
    private View kqN;

    public final void KC() {
        this.kdb = this.kqe.ahm();
    }

    public final void update() {
        this.kcX = this.kqe.ahj();
        if (this.kqN == null) {
            this.kqN = ((ViewStub) findViewById(R.h.byv)).inflate();
        }
        if (this.kcX.aeR()) {
            this.kqN.setBackgroundDrawable(l.u(this.kdb, this.kdb.getResources().getColor(R.e.aTi)));
        }
        TextView textView = (TextView) this.kqN.findViewById(R.h.byw);
        if (this.kcX.afj() == null) {
            w.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setTextColor(this.kdb.getResources().getColor(R.e.aUf));
        if (TextUtils.isEmpty(this.kcX.afi().toI)) {
            m.b(textView, this.kcX.afj().status);
        } else {
            textView.setText(this.kcX.afi().toI);
        }
    }

    public final void aiz() {
        if (this.kqN != null) {
            this.kqN.setVisibility(8);
        }
    }
}
