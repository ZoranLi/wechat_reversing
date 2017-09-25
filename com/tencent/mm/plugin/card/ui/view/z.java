package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.lz;

public final class z extends i {
    private View kqO;

    public final void KC() {
    }

    public final void update() {
        if (this.kqO == null) {
            this.kqO = ((ViewStub) findViewById(R.h.byA)).inflate();
        }
        lz lzVar = this.kqe.ahj().afj().tnL;
        if (this.kqO != null) {
            ((TextView) this.kqO.findViewById(R.h.cHX)).setText(lzVar.title);
            ((TextView) this.kqO.findViewById(R.h.cHW)).setText(lzVar.kdH);
            int i = (this.kqe.aho().ahS() && this.kqe.aho().ahT()) ? 0 : 1;
            if (i != 0) {
                ((LayoutParams) ((LinearLayout) this.kqO).getLayoutParams()).bottomMargin = 0;
            } else {
                ((LayoutParams) ((LinearLayout) this.kqO).getLayoutParams()).bottomMargin = this.kqe.ahm().getResources().getDimensionPixelSize(R.f.aXO);
            }
        }
    }

    public final void aiz() {
        if (this.kqO != null) {
            this.kqO.setVisibility(8);
        }
    }
}
