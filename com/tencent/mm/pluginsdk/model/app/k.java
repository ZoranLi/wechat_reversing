package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.t.f;

public final class k extends i<f> {
    public static final String[] gUx = new String[]{i.a(f.gTP, "AppMessage")};

    public k(e eVar) {
        super(eVar, f.gTP, "AppMessage", null);
    }

    public final f ec(long j) {
        c fVar = new f();
        fVar.field_msgId = j;
        return super.b(fVar, new String[0]) ? fVar : null;
    }
}
