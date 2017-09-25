package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.k.a.c.c;
import com.tencent.mm.pluginsdk.k.a.d.j;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.l;
import com.tencent.mm.pluginsdk.k.a.d.m.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

final class d extends a<c> {
    public d(c cVar) {
        super(cVar);
    }

    public final String Qo() {
        return "CheckResUpdate";
    }

    public final boolean dW(long j) {
        if (((c) Qv()).fileSize <= 0 || ((c) Qv()).fileSize == com.tencent.mm.pluginsdk.k.a.e.a.BA(getFilePath()) + j) {
            return super.dW(j);
        }
        return false;
    }

    public final boolean Qu() {
        if (super.Qu()) {
            j.u(((c) Qv()).sFf, 12);
            return true;
        }
        j.u(((c) Qv()).sFf, 27);
        return false;
    }

    protected final l a(j jVar) {
        c cVar = (c) Qv();
        String Mp = i.Mp(cVar.sEX);
        String str = cVar.fFW;
        if (cVar.rWc && bg.mz(g.aV(i.Mp(cVar.sEX))).equals(str)) {
            w.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
            return new l(cVar, com.tencent.mm.pluginsdk.k.a.e.a.BA(Mp));
        } else if (!bg.bm(((c) Qv()).sFF) && com.tencent.mm.pluginsdk.k.a.e.a.v(i.Mp(((c) Qv()).sEX), ((c) Qv()).sFF) && bg.mz(g.aV(i.Mp(((c) Qv()).sEX))).equals(((c) Qv()).fFW)) {
            return new l((k) Qv(), com.tencent.mm.pluginsdk.k.a.e.a.BA(i.Mp(((c) Qv()).sEX)));
        } else {
            l a = super.a(jVar);
            w.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = " + a, cVar.sEX);
            if (a.status == 2) {
                if (bg.mA(((c) Qv()).fFW) || !((c) Qv()).fFW.equals(g.aV(getFilePath()))) {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", cVar.sEX);
                    return new l("CheckResUpdate", bDp(), getURL(), getFilePath(), a.gan, a.gam, new c());
                }
                w.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", cVar.sEX);
            }
            return a;
        }
    }
}
