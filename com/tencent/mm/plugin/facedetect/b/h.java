package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.plugin.facedetect.b.i.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.y.i;

final class h extends i {
    a luP = new a();
    b luQ = new b();

    h() {
    }

    public final int getType() {
        return 733;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getbioconfigrsa";
    }

    public final e zg() {
        return this.luQ;
    }

    protected final d zf() {
        return this.luP;
    }

    public final int BD() {
        return 1;
    }
}
