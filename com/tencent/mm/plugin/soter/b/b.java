package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.plugin.soter.b.c.a;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.y.i;

final class b extends i {
    a qPO = new a();
    com.tencent.mm.plugin.soter.b.c.b qPP = new com.tencent.mm.plugin.soter.b.c.b();

    b() {
    }

    public final int getType() {
        return 627;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/updatesoteraskrsa";
    }

    public final e zg() {
        return this.qPP;
    }

    protected final d zf() {
        return this.qPO;
    }

    public final int BD() {
        return 1;
    }
}
