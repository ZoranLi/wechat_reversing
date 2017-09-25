package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.a.k;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.List;

public final class c extends com.tencent.mm.plugin.fts.d.c {
    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ae aeVar, HashSet<String> hashSet) {
        f fVar = new f();
        fVar.lZZ = 80;
        fVar.mad = 3;
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
            aVar.mcR = list;
            aVar.hPq = -3;
            aVar.iJD = this.iJD;
            if (aVar.mcR.size() > 3) {
                if (((com.tencent.mm.plugin.fts.a.a.i) aVar.mcR.get(3)).lZO.equals("create_chatroom​")) {
                    boolean z;
                    if (aVar.mcR.size() > 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar.mcQ = z;
                    aVar.mcR = aVar.mcR.subList(0, 4);
                } else {
                    aVar.mcQ = true;
                    aVar.mcR = aVar.mcR.subList(0, 3);
                }
            }
            this.mcy.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.a a(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.a cVar;
        int i2 = (i - aVar.mcN) - 1;
        if (i2 < aVar.mcR.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.a.i iVar = (com.tencent.mm.plugin.fts.a.a.i) aVar.mcR.get(i2);
            if (iVar.lZO.equals("create_chatroom​")) {
                cVar = new com.tencent.mm.plugin.search.ui.a.c(i);
                cVar.iJD = aVar.iJD;
            } else if (iVar.type == 131075) {
                com.tencent.mm.plugin.fts.d.a.a a = a(i, iVar, aVar.iJD);
                a.cc(iVar.type, iVar.hPr);
                cVar = a;
            }
            if (cVar != null) {
                cVar.mdg = i2 + 1;
            }
            return cVar;
        }
        cVar = null;
        if (cVar != null) {
            cVar.mdg = i2 + 1;
        }
        return cVar;
    }

    public final int getType() {
        return 48;
    }

    public final com.tencent.mm.plugin.fts.d.a.a a(int i, com.tencent.mm.plugin.fts.a.a.i iVar, List<String> list) {
        com.tencent.mm.plugin.fts.d.a.a kVar = new k(i);
        kVar.iJC = iVar;
        kVar.iJD = list;
        kVar.cc(iVar.type, iVar.hPr);
        return kVar;
    }
}
