package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hb;
import com.tencent.mm.protocal.c.hc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private String fGa;
    public b gUA;
    private e gUD;
    private String oWe;
    private int scene;

    public d(String str, int i, String str2) {
        this.fGa = str;
        this.scene = i;
        this.oWe = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new hb();
        aVar.hsn = new hc();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
        aVar.hsl = 1063;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        hb hbVar = (hb) this.gUA.hsj.hsr;
        hbVar.tgW = this.fGa;
        hbVar.tdM = this.scene;
        hbVar.tlc = this.oWe;
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        hb hbVar = (hb) ((b) pVar).hsj.hsr;
        if (hbVar.tdM >= 0 && hbVar.tgW != null && hbVar.tgW.length() > 0) {
            return k.b.hsT;
        }
        w.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[]{Integer.valueOf(hbVar.tdM)});
        return k.b.hsU;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1063;
    }
}
