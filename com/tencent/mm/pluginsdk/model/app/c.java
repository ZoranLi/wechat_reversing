package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class c extends i<b> {
    public static final String[] gUx = new String[]{i.a(b.gTP, "appattach")};
    e gUz;

    public c(e eVar) {
        super(eVar, b.gTP, "appattach", null);
        this.gUz = eVar;
    }

    public final b LW(String str) {
        b bVar = new b();
        bVar.field_mediaSvrId = str;
        if (b((com.tencent.mm.sdk.e.c) bVar, "mediaSvrId")) {
            return bVar;
        }
        return !b((com.tencent.mm.sdk.e.c) bVar, "mediaId") ? null : bVar;
    }

    public final b eb(long j) {
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_msgInfoId = j;
        return b(bVar, "msgInfoId") ? bVar : null;
    }
}
