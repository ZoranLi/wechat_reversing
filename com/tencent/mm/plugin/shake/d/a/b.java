package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abr;
import com.tencent.mm.protocal.c.abs;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    public com.tencent.mm.y.b gUA;
    private e gUD;
    private String pqg;
    private int scene;

    public b(String str, int i) {
        this.pqg = str;
        this.scene = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new abr();
        aVar.hsn = new abs();
        aVar.uri = "/cgi-bin/micromsg-bin/gettvinfo";
        aVar.hsl = 552;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        abr com_tencent_mm_protocal_c_abr = (abr) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_abr.tHu = this.pqg;
        com_tencent_mm_protocal_c_abr.tdM = this.scene;
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        abr com_tencent_mm_protocal_c_abr = (abr) ((com.tencent.mm.y.b) pVar).hsj.hsr;
        if (com_tencent_mm_protocal_c_abr.tdM >= 0 && com_tencent_mm_protocal_c_abr.tHu != null && com_tencent_mm_protocal_c_abr.tHu.length() > 0) {
            return com.tencent.mm.y.k.b.hsT;
        }
        w.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_abr.tdM)});
        return com.tencent.mm.y.k.b.hsU;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 552;
    }
}
