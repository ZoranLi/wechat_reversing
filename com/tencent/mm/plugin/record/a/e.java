package com.tencent.mm.plugin.record.a;

import com.tencent.mm.e.a.jz;
import com.tencent.mm.plugin.record.a.i.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;

public final class e implements a {
    public final void a(int i, g gVar) {
        if (gVar != null) {
            w.d("MircoMsg.RecordInfoStorageProxy", "notify CdnChanged dataId: %s, status: %d", gVar.field_dataId, Integer.valueOf(gVar.field_status));
            b jzVar = new jz();
            jzVar.fQn.field_dataId = gVar.field_dataId;
            jzVar.fQn.field_status = gVar.field_status;
            jzVar.fQn.field_offset = gVar.field_offset;
            jzVar.fQn.field_totalLen = gVar.field_totalLen;
            jzVar.fQn.field_localId = gVar.field_localId;
            jzVar.fQn.field_path = gVar.field_path;
            com.tencent.mm.sdk.b.a.urY.m(jzVar);
        }
    }
}
