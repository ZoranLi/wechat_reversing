package com.tencent.mm.w;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.protocal.c.fw;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    public static int hpO = 1;
    public static int hpP = 2;
    private b gUA;
    private e gUD;

    public a(int i, String str) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new fv();
        aVar.hsn = new fw();
        aVar.uri = "/cgi-bin/micromsg-bin/bindemail";
        aVar.hsl = 256;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        fv fvVar = (fv) this.gUA.hsj.hsr;
        fvVar.tce = i;
        fvVar.tjk = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 256;
    }

    public final int AJ() {
        return ((fv) this.gUA.hsj.hsr).tce;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
