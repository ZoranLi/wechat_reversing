package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.search.ui.a.k;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.List;

public final class b extends c {
    public b(Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ae aeVar, HashSet<String> hashSet) {
        f fVar = new f();
        fVar.lZZ = 32;
        fVar.fRM = this.fRM;
        fVar.mae = hashSet;
        fVar.maf = com.tencent.mm.plugin.fts.a.b.a.maB;
        fVar.mag = this;
        fVar.handler = aeVar;
        return ((l) h.j(l.class)).search(2, fVar);
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List list = gVar.maj;
        if (com.tencent.mm.plugin.fts.d.b.aF(list)) {
            i.a aVar = new i.a();
            aVar.hPq = -3;
            aVar.mcR = list;
            aVar.iJD = this.iJD;
            aVar.mcQ = false;
            this.mcy.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.a a(int i, i.a aVar) {
        int i2 = (i - aVar.mcN) - 1;
        com.tencent.mm.plugin.fts.d.a.a aVar2 = null;
        if (i2 < aVar.mcR.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.a.i iVar = (com.tencent.mm.plugin.fts.a.a.i) aVar.mcR.get(i2);
            if (iVar.lZO.equals("create_chatroom​")) {
                aVar2 = new com.tencent.mm.plugin.search.ui.a.c(i);
                aVar2.iJD = aVar.iJD;
            } else {
                com.tencent.mm.plugin.fts.d.a.a kVar = new k(i);
                kVar.iJC = iVar;
                kVar.iJD = aVar.iJD;
                kVar.cc(iVar.type, iVar.hPr);
                aVar2 = kVar;
            }
        }
        if (aVar2 != null) {
            aVar2.mdg = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4128;
    }
}
