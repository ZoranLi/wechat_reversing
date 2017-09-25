package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.List;

public final class f extends c {
    public f(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ae aeVar, HashSet<String> hashSet) {
        com.tencent.mm.plugin.fts.a.a.f fVar = new com.tencent.mm.plugin.fts.a.a.f();
        fVar.fRM = this.fRM;
        fVar.handler = aeVar;
        fVar.mae = hashSet;
        fVar.mag = this;
        fVar.maf = com.tencent.mm.plugin.fts.a.b.c.maD;
        return ((l) h.j(l.class)).search(4, fVar);
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List list = gVar.maj;
        if (com.tencent.mm.plugin.fts.d.b.aF(list)) {
            i.a aVar = new i.a();
            aVar.hPq = -6;
            aVar.iJD = this.iJD;
            aVar.mcR = list;
            this.mcy.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.a a(int i, i.a aVar) {
        int i2 = (i - aVar.mcN) - 1;
        com.tencent.mm.plugin.fts.d.a.a aVar2 = null;
        if (i2 < aVar.mcR.size() && i2 >= 0) {
            aVar2 = a(i, (com.tencent.mm.plugin.fts.a.a.i) aVar.mcR.get(i2), aVar.iJD);
        }
        if (aVar2 != null) {
            aVar2.mdg = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 64;
    }

    public final com.tencent.mm.plugin.fts.d.a.a a(int i, com.tencent.mm.plugin.fts.a.a.i iVar, List<String> list) {
        com.tencent.mm.plugin.fts.d.a.a dVar = new d(i);
        dVar.iJC = iVar;
        dVar.iJD = list;
        dVar.cc(iVar.type, iVar.hPr);
        return dVar;
    }
}
