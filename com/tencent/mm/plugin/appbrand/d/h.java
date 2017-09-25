package com.tencent.mm.plugin.appbrand.d;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.b.d;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.List;

public final class h extends c {
    public h(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ae aeVar, HashSet<String> hashSet) {
        f fVar = new f();
        fVar.fRM = this.fRM;
        fVar.maf = d.maE;
        fVar.mag = this;
        fVar.handler = aeVar;
        fVar.mae = hashSet;
        return ((l) com.tencent.mm.kernel.h.j(l.class)).search(7, fVar);
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List list = gVar.maj;
        if (!(list == null || list.isEmpty())) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            String str = this.fRM;
            if (str != null) {
                str = str.replaceAll(",", " ");
            }
            dVar.n("20KeyWordId", str + ",");
            dVar.n("21ViewType", "1,");
            dVar.n("22OpType", "1,");
            dVar.n("23ResultCount", list.size() + ",");
            dVar.n("24ClickPos", ",");
            dVar.n("25ClickAppUserName", ",");
            w.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[]{dVar.JG()});
            com.tencent.mm.plugin.report.service.g.oUh.i(13963, new Object[]{dVar});
        }
        if (com.tencent.mm.plugin.fts.d.b.aF(list)) {
            i.a aVar = new i.a();
            aVar.hPq = -13;
            aVar.iJD = this.iJD;
            aVar.mcR = list;
            if (aVar.mcR.size() > 3) {
                aVar.mcQ = true;
                aVar.mcR = aVar.mcR.subList(0, 3);
            }
            this.mcy.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.a a(int i, i.a aVar) {
        int i2 = (i - aVar.mcN) - 1;
        com.tencent.mm.plugin.fts.d.a.a aVar2 = null;
        if (i2 < aVar.mcR.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.a.i iVar = (com.tencent.mm.plugin.fts.a.a.i) aVar.mcR.get(i2);
            com.tencent.mm.plugin.fts.d.a.a dVar = new d(i);
            dVar.iJC = iVar;
            dVar.iJD = aVar.iJD;
            aVar2 = dVar;
        }
        if (aVar2 != null) {
            aVar2.mdg = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.f.CTRL_INDEX;
    }
}
