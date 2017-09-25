package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.u.av.a;
import com.tencent.mm.u.av.b;
import com.tencent.mm.y.i;

final class c extends i {
    a rcg = new a();
    b rch = new b();

    c() {
    }

    public final int getType() {
        return 617;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyvoiceprintrsa";
    }

    public final e zg() {
        return this.rch;
    }

    protected final d zf() {
        return this.rcg;
    }

    public final int BD() {
        return 1;
    }
}
