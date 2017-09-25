package com.tencent.mm.modelsimple;

import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.protocal.z.b;
import com.tencent.mm.y.i;

final class e extends i {
    private final a hRH = new a();
    private final b hRI = new b();

    e() {
    }

    protected final d zf() {
        return this.hRH;
    }

    public final com.tencent.mm.protocal.k.e zg() {
        return this.hRI;
    }

    public final int getType() {
        return 26;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/sendcard";
    }
}
