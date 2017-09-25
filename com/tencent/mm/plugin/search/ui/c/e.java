package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.List;

public final class e extends c {
    public e(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ae aeVar, HashSet<String> hashSet) {
        f fVar = new f();
        fVar.lZZ = 48;
        fVar.fRM = this.fRM;
        fVar.maa = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        fVar.mad = 3;
        fVar.maf = com.tencent.mm.plugin.fts.a.b.b.maC;
        fVar.mae = hashSet;
        fVar.mag = this;
        fVar.handler = aeVar;
        return ((l) h.j(l.class)).search(2, fVar);
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List list = gVar.maj;
        i.a aVar = new i.a();
        aVar.hPq = -4;
        aVar.mcR = list;
        aVar.mcO = com.tencent.mm.plugin.fts.d.b.aF(list);
        aVar.iJD = this.iJD;
        if (aVar.mcR.size() > 3) {
            aVar.mcQ = true;
            aVar.mcR = aVar.mcR.subList(0, 3);
        }
        if (com.tencent.mm.plugin.fts.d.b.aF(list)) {
            this.mcy.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.a a(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.a aVar2;
        int i2 = 0;
        if (aVar.mcO) {
            int i3 = (i - aVar.mcN) - 1;
            if (i3 >= aVar.mcR.size() || i3 < 0) {
                i2 = i3;
                aVar2 = null;
            } else {
                com.tencent.mm.plugin.fts.a.a.i iVar = (com.tencent.mm.plugin.fts.a.a.i) aVar.mcR.get(i3);
                com.tencent.mm.plugin.fts.d.a.a a = a(i, iVar, aVar.iJD);
                a.cc(iVar.type, iVar.hPr);
                i2 = i3;
                aVar2 = a;
            }
        } else {
            aVar2 = null;
        }
        if (aVar2 != null) {
            aVar2.mdg = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 32;
    }

    public final com.tencent.mm.plugin.fts.d.a.a a(int i, com.tencent.mm.plugin.fts.a.a.i iVar, List<String> list) {
        com.tencent.mm.plugin.fts.d.a.a lVar;
        if (iVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            lVar = new com.tencent.mm.plugin.search.ui.a.l(i);
            lVar.iJC = iVar;
            lVar.iJD = list;
            lVar.cc(iVar.type, iVar.hPr);
            return lVar;
        } else if (iVar.type != 131073 && iVar.type != 131074) {
            return null;
        } else {
            lVar = new com.tencent.mm.plugin.search.ui.a.g(i);
            lVar.iJC = iVar;
            lVar.iJD = list;
            lVar.cc(iVar.type, iVar.hPr);
            return lVar;
        }
    }
}
