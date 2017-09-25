package com.tencent.mm.plugin.sns.ui.widget;

import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    private static a qPy = new a();
    private com.tencent.mm.kiss.widget.textview.a.a qPw = null;
    public int qPx = 0;

    public static a blI() {
        return qPy;
    }

    public final com.tencent.mm.kiss.widget.textview.a.a blJ() {
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), (int) (14.0f * com.tencent.mm.bg.a.dI(ab.getContext())));
        if (this.qPw == null || ((int) this.qPw.hbf) != fromDPToPix) {
            this.qPw = b.we().I((float) fromDPToPix).eR(ab.getContext().getResources().getColor(c.pyZ)).eQ(16).haO;
        }
        return this.qPw;
    }
}
