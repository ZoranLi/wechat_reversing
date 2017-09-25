package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.List;

public final class j extends c {
    public j(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ae aeVar, HashSet<String> hashSet) {
        f fVar = new f();
        fVar.fRM = this.fRM;
        fVar.mae = hashSet;
        fVar.mag = this;
        fVar.handler = aeVar;
        fVar.lZZ = 1;
        fVar.mad = 3;
        return ((l) h.j(l.class)).search(3, fVar);
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List list = gVar.maj;
        if (com.tencent.mm.plugin.fts.d.b.aF(list)) {
            i.a aVar = new i.a();
            aVar.hPq = -2;
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
            com.tencent.mm.plugin.fts.d.a.a fVar = new com.tencent.mm.plugin.search.ui.a.f(i);
            fVar.iJC = iVar;
            fVar.iJD = aVar.iJD;
            fVar.cc(iVar.type, iVar.hPr);
            aVar2 = fVar;
        }
        if (aVar2 != null) {
            aVar2.mdg = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    }
}
