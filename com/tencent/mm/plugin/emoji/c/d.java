package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.e.a.nd;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends c<nd> {
    public d() {
        this.usg = nd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nd ndVar = (nd) bVar;
        if (ndVar instanceof nd) {
            if (ndVar.fUm.fGM == 0) {
                com.tencent.mm.plugin.emoji.model.c alW = h.alW();
                long j = ndVar.fUm.fUp;
                alW.kLC.put(Long.valueOf(j), ndVar.fUm.fUn);
            } else {
                w.i("MicroMsg.emoji.EmojiRevokeMsgListener", "has handle in sys cmd msg extension.");
            }
        }
        return false;
    }
}
