package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends i {
    private View kpW;

    public final void KC() {
    }

    public final void update() {
        b ahj = this.kqe.ahj();
        iv ivVar = ahj.afi().toy;
        if (ivVar != null) {
            w.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + ivVar.poY);
            w.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + ivVar.text);
            w.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + ivVar.tnW);
        }
        if (ivVar != null && !TextUtils.isEmpty(ivVar.text) && ahj.afg()) {
            if (this.kpW == null) {
                this.kpW = ((ViewStub) findViewById(R.h.bwa)).inflate();
            }
            ((TextView) this.kpW.findViewById(R.h.ctv)).setText(ivVar.text);
            this.kpW.setOnClickListener(this.kqe.ahn());
        } else if (this.kpW != null) {
            this.kpW.setVisibility(8);
        }
    }

    public final void aiz() {
        if (this.kpW != null) {
            this.kpW.setVisibility(8);
        }
    }
}
