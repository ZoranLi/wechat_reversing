package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.plugin.facedetect.b.j.a;
import com.tencent.mm.plugin.facedetect.b.j.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.y.i;

final class f extends i {
    a luL = new a();
    b luM = new b();

    f() {
    }

    public final int getType() {
        return 931;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/registerfacersa";
    }

    public final e zg() {
        return this.luM;
    }

    protected final d zf() {
        return this.luL;
    }

    public final int BD() {
        return 1;
    }
}
