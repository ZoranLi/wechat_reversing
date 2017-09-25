package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.u.at.b;
import com.tencent.mm.y.i;

final class a extends i {
    com.tencent.mm.u.at.a rcc = new com.tencent.mm.u.at.a();
    b rcd = new b();

    a() {
    }

    public final int getType() {
        return 616;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
    }

    public final e zg() {
        return this.rcd;
    }

    protected final d zf() {
        return this.rcc;
    }

    public final int BD() {
        return 1;
    }
}
