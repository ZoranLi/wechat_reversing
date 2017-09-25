package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.u.au.a;
import com.tencent.mm.y.i;

final class b extends i {
    a rce = new a();
    com.tencent.mm.u.au.b rcf = new com.tencent.mm.u.au.b();

    b() {
    }

    public final int getType() {
        return 618;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintticketrsa";
    }

    public final e zg() {
        return this.rcf;
    }

    protected final d zf() {
        return this.rce;
    }

    public final int BD() {
        return 1;
    }
}
