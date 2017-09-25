package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.b.d;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.List;

public final class c extends com.tencent.mm.plugin.fts.d.c {
    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ae aeVar, HashSet<String> hashSet) {
        f fVar = new f();
        fVar.lZZ = 2;
        fVar.fRM = this.fRM;
        fVar.mae = hashSet;
        fVar.handler = aeVar;
        fVar.mag = this;
        fVar.maf = d.maE;
        return ((l) h.j(l.class)).search(6, fVar);
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List list = gVar.maj;
        if (com.tencent.mm.plugin.fts.d.b.aF(list)) {
            i.a aVar = new i.a();
            aVar.hPq = -1;
            aVar.iJD = this.iJD;
            aVar.mcR = list;
            this.mcy.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.a a(int i, i.a aVar) {
        int i2 = (i - aVar.mcN) - 1;
        com.tencent.mm.plugin.fts.d.a.a aVar2 = null;
        if (i2 < aVar.mcR.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.a.i iVar = (com.tencent.mm.plugin.fts.a.a.i) aVar.mcR.get(i2);
            com.tencent.mm.plugin.fts.d.a.a aVar3 = new a(i);
            aVar3.iJC = iVar;
            aVar3.iJD = aVar.iJD;
            aVar3.cc(iVar.type, iVar.hPr);
            aVar2 = aVar3;
        }
        if (aVar2 != null) {
            aVar2.mdg = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4176;
    }
}
