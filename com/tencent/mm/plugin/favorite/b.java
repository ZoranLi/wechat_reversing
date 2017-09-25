package com.tencent.mm.plugin.favorite;

import com.tencent.mm.e.a.by;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends c<by> {
    public b() {
        this.usg = by.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        by byVar = (by) bVar;
        w.i("MicroMsg.DelFavoriteItemListener", "do delete favitem, localId %d", new Object[]{Long.valueOf(byVar.fFv.fFx)});
        byVar.fFw.fFj = x.a(byVar.fFv.fFx, null);
        return false;
    }
}
