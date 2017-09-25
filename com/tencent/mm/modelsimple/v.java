package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ass;
import com.tencent.mm.protocal.c.ast;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class v extends k implements j {
    private b gUA;
    private e gUD;
    public int hSF = 1;

    public v(int i) {
        a aVar = new a();
        aVar.hsm = new ass();
        aVar.hsn = new ast();
        aVar.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
        aVar.hsl = 255;
        aVar.hso = 132;
        aVar.hsp = 1000000132;
        this.gUA = aVar.BE();
        ((ass) this.gUA.hsj.hsr).tdM = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 255;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
