package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.ak;
import java.util.ArrayList;
import java.util.List;

public final class d extends c {
    private final String TAG = "MicroMsg.emoji.EmojiListMineData";

    public d(e eVar) {
        super(eVar);
    }

    public final synchronized void notifyDataSetChanged() {
        List<a> bNp = h.amc().kLb.bNp();
        boolean anw = com.tencent.mm.plugin.emoji.h.a.anw();
        this.mItemList = new ArrayList();
        w.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
        for (a bMX : bNp) {
            pn bMX2 = bMX.bMX();
            f fVar = new f(bMX2);
            if (com.tencent.mm.plugin.emoji.h.a.d(bMX2) && anw) {
                this.kIX.put(bMX2.tgW, new ak(bMX2.tgW));
            }
            fVar.dv(9);
            this.mItemList.add(fVar);
        }
    }

    public final void clear() {
        super.clear();
    }

    public final void als() {
    }
}
