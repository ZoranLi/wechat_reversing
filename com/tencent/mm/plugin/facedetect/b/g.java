package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.plugin.facedetect.b.k.a;
import com.tencent.mm.plugin.facedetect.b.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.y.i;

final class g extends i {
    a luN = new a();
    b luO = new b();

    g() {
    }

    public final int getType() {
        return 930;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyfacersa";
    }

    public final e zg() {
        return this.luO;
    }

    protected final d zf() {
        return this.luN;
    }

    public final int BD() {
        return 1;
    }
}
