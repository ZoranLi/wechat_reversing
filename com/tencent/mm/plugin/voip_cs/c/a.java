package com.tencent.mm.plugin.voip_cs.c;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public aj irQ = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ a rtr;

        {
            this.rtr = r1;
        }

        public final boolean oQ() {
            int i = this.rtr.rlP[this.rtr.rlR % this.rtr.rlP.length];
            if (this.rtr.kH != null) {
                if (-1 == i) {
                    this.rtr.kH.setText(null);
                } else {
                    this.rtr.kH.setText(i);
                }
            }
            a aVar = this.rtr;
            aVar.rlR++;
            return true;
        }
    }, true);
    public TextView kH;
    public int[] rlP;
    public int rlQ;
    public int rlR;

    public final void bqW() {
        if (this.irQ != null) {
            this.irQ.KH();
        }
        w.h("MicroMsg.DynamicTextWrap", "stop textview: " + this.kH, new Object[0]);
        this.kH = null;
    }
}
