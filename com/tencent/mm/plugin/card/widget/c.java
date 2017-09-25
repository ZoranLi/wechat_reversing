package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.lz;

public final class c extends a {
    protected TextView krG;
    protected TextView krH;

    public c(Context context) {
        super(context);
    }

    protected final void aiS() {
        this.krH = (TextView) aiR().findViewById(R.h.bwc);
        this.krG = (TextView) aiR().findViewById(R.h.byx);
    }

    protected final void aiT() {
        if (this.kcX.afi().toj != null && this.kcX.afi().toj.size() > 0) {
            lz lzVar = (lz) this.kcX.afi().toj.get(0);
            if (this.krx != null) {
                this.krx.setText(lzVar.title);
            }
            if (this.krG != null) {
                if (TextUtils.isEmpty(lzVar.kdH)) {
                    this.krG.setVisibility(8);
                } else {
                    this.krG.setText(lzVar.kdH);
                }
            }
            if (this.krH == null) {
                return;
            }
            if (TextUtils.isEmpty(lzVar.kdI)) {
                this.krH.setVisibility(8);
            } else {
                this.krH.setText(lzVar.kdI);
            }
        }
    }

    public final void i(boolean z, boolean z2) {
    }
}
