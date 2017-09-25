package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.mm.kernel.h;
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
        return ((l) h.j(l.class)).search(2, f.a(this.fRM, new int[]{131076}, null, 4, hashSet, com.tencent.mm.plugin.fts.a.b.b.maC, this, aeVar));
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List list = gVar.maj;
        if (aF(list)) {
            i.a aVar = new i.a();
            aVar.hPq = -7;
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
            com.tencent.mm.plugin.fts.d.a.a a = a(i, iVar, aVar.iJD);
            a.cc(iVar.type, iVar.hPr);
            aVar2 = a;
        }
        if (aVar2 != null) {
            aVar2.mdg = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 96;
    }

    public final com.tencent.mm.plugin.fts.d.a.a a(int i, com.tencent.mm.plugin.fts.a.a.i iVar, List<String> list) {
        com.tencent.mm.plugin.fts.d.a.a aVar = new a(i);
        aVar.iJC = iVar;
        aVar.iJD = list;
        aVar.cc(iVar.type, iVar.hPr);
        return aVar;
    }
}
