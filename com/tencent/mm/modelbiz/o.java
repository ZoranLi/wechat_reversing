package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gn;
import com.tencent.mm.protocal.c.go;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class o extends k implements j {
    private String gLD;
    b gUA;
    private e gUD;
    private a<o> hwf;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public o(String str, String str2, a<o> aVar) {
        this(str, str2);
        this.hwf = aVar;
    }

    private o(String str, String str2) {
        this.gLD = str;
        w.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", str);
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsl = 1075;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
        aVar.hsm = new gn();
        aVar.hsn = new go();
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        gn gnVar = (gn) this.gUA.hsj.hsr;
        gnVar.tkB = this.gLD;
        gnVar.tkC = new com.tencent.mm.bd.b(bg.PT(bg.mz(str2)));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
        if (this.hwf != null) {
            this.hwf.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1075;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
