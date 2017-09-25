package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import java.util.HashSet;
import java.util.List;

public final class l extends c {
    private boolean phz = false;

    public l(Context context, b bVar, int i) {
        boolean z;
        super(context, bVar, i);
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.phz = z;
        this.phz &= bg.Hp();
    }

    protected final a a(ae aeVar, HashSet<String> hashSet) {
        f fVar = new f();
        fVar.maa = this.phz ? new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131073, 131074, 262144, 131076} : new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 262144, 131076};
        fVar.mad = 3;
        fVar.mag = this;
        fVar.handler = aeVar;
        fVar.scene = 0;
        fVar.mae = hashSet;
        if (this.fRM.startsWith("@@")) {
            fVar.fRM = this.fRM.substring(2);
            return ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).search(10000, fVar);
        }
        fVar.fRM = this.fRM;
        return ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).search(1, fVar);
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List<i> list = gVar.maj;
        for (i iVar : list) {
            hashSet.add(iVar.lZO);
        }
        if (com.tencent.mm.plugin.fts.d.b.aF(list)) {
            List list2;
            com.tencent.mm.plugin.fts.d.i.a aVar = new com.tencent.mm.plugin.fts.d.i.a();
            aVar.hPq = -8;
            if (!com.tencent.mm.plugin.fts.d.b.aF(list) || list.size() <= 3) {
                list2 = list;
            } else {
                list2 = list.subList(0, 3);
            }
            aVar.mcR = list2;
            aVar.mcQ = false;
            aVar.iJD = this.iJD;
            this.mcy.add(aVar);
        }
        d.aD(list);
    }

    protected final com.tencent.mm.plugin.fts.d.a.a a(int i, com.tencent.mm.plugin.fts.d.i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.a a;
        int i2 = (i - aVar.mcN) - 1;
        if (i2 < aVar.mcR.size() && i2 >= 0) {
            i iVar = (i) aVar.mcR.get(i2);
            c cVar = iVar.type == 131075 ? (c) com.tencent.mm.plugin.fts.d.h.a(48, this.context, this.mcw, this.mcx) : (iVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || iVar.type == 131073 || iVar.type == 131074) ? (c) com.tencent.mm.plugin.fts.d.h.a(32, this.context, this.mcw, this.mcx) : iVar.type == 262144 ? (c) com.tencent.mm.plugin.fts.d.h.a(64, this.context, this.mcw, this.mcx) : iVar.type == 131076 ? (c) com.tencent.mm.plugin.fts.d.h.a(96, this.context, this.mcw, this.mcx) : null;
            if (cVar != null) {
                a = cVar.a(i, iVar, aVar.iJD);
                if (a != null) {
                    a.mdg = i2 + 1;
                }
                return a;
            }
        }
        a = null;
        if (a != null) {
            a.mdg = i2 + 1;
        }
        return a;
    }

    public final int getType() {
        return 16;
    }
}
