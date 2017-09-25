package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.e.a.jr;
import com.tencent.mm.e.a.js;
import com.tencent.mm.e.a.jz;
import com.tencent.mm.plugin.favorite.b.b.a;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.w;

public final class l implements a, j.a {
    private int lEm;

    public final void b(a aVar) {
        if (aVar != null) {
            w.d("MircoMsg.FavItemInfoStorageProxy", "notify CdnChanged dataId: %s, status: %d", new Object[]{aVar.field_dataId, Integer.valueOf(aVar.field_status)});
            j bT = h.ata().bT(aVar.field_favLocalId);
            b jrVar;
            if (bT == null || bT.field_type != 18) {
                jrVar = new jr();
                jrVar.fQe.field_favLocalId = aVar.field_favLocalId;
                jrVar.fQe.field_dataId = aVar.field_dataId;
                jrVar.fQe.field_status = aVar.field_status;
                jrVar.fQe.field_offset = aVar.field_offset;
                jrVar.fQe.field_totalLen = aVar.field_totalLen;
                com.tencent.mm.sdk.b.a.urY.m(jrVar);
                return;
            }
            jrVar = new jz();
            jrVar.fQn.field_favLocalId = aVar.field_favLocalId;
            jrVar.fQn.field_dataId = aVar.field_dataId;
            jrVar.fQn.field_status = aVar.field_status;
            jrVar.fQn.field_offset = aVar.field_offset;
            jrVar.fQn.field_totalLen = aVar.field_totalLen;
            jrVar.fQn.field_path = aVar.field_path;
            com.tencent.mm.sdk.b.a.urY.m(jrVar);
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        w.d("MircoMsg.FavItemInfoStorageProxy", "on notify change event %s, favIDStr %s", new Object[]{str, String.valueOf(this.lEm)});
        if (String.valueOf(this.lEm).equals(str)) {
            b jsVar = new js();
            jsVar.fQf.fQg = this.lEm;
            com.tencent.mm.sdk.b.a.urY.m(jsVar);
        }
    }
}
