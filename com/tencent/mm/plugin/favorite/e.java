package com.tencent.mm.plugin.favorite;

import com.tencent.mm.a.n;
import com.tencent.mm.e.a.fo;
import com.tencent.mm.plugin.favorite.b.ad;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class e extends c<fo> {
    public e() {
        this.usg = fo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fo foVar = (fo) bVar;
        w.v("MicroMsg.FavNotifyListener", "deal with fav notify");
        if (h.asQ().fBm) {
            w.w("MicroMsg.FavNotifyListener", "sending item, do not do sync");
        } else {
            byte[] bArr = foVar.fKn.fKo;
            ap.vd().a(new ad(bArr == null ? 1 : n.c(bArr, 0)), 0);
        }
        return false;
    }
}
