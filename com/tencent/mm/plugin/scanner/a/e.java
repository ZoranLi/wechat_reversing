package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.anx;
import com.tencent.mm.protocal.c.any;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    public b gUA;
    private com.tencent.mm.y.e gUD;
    private byte[] oWf;
    private int oWg = 1;
    private String oWh = "en";
    private String oWi = "zh_CN";
    private int oWj;

    public e(byte[] bArr, String str, String str2, int i) {
        this.oWf = bArr;
        this.oWg = 1;
        this.oWh = str;
        this.oWi = str2;
        this.oWj = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new anx();
        aVar.hsn = new any();
        aVar.uri = "/cgi-bin/micromsg-bin/ocrtranslation";
        aVar.hsl = 392;
        aVar.hso = 199;
        aVar.hsp = 1000000199;
        this.gUA = aVar.BE();
        anx com_tencent_mm_protocal_c_anx = (anx) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_anx.tli = ((int) bg.Nz()) & Integer.MAX_VALUE;
        com_tencent_mm_protocal_c_anx.tlj = new avw().bb(this.oWf);
        com_tencent_mm_protocal_c_anx.tlm = this.oWg;
        com_tencent_mm_protocal_c_anx.tSZ = this.oWh;
        com_tencent_mm_protocal_c_anx.tTa = this.oWi;
        com_tencent_mm_protocal_c_anx.tln = this.oWj;
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        anx com_tencent_mm_protocal_c_anx = (anx) ((b) pVar).hsj.hsr;
        if (com_tencent_mm_protocal_c_anx.tli > 0 && !bg.mA(com_tencent_mm_protocal_c_anx.tTa) && !bg.mA(com_tencent_mm_protocal_c_anx.tSZ) && com_tencent_mm_protocal_c_anx.tlm >= 0 && com_tencent_mm_protocal_c_anx.tlj != null && com_tencent_mm_protocal_c_anx.tlj.tZn > 0) {
            return k.b.hsT;
        }
        w.e("MicroMsg.scanner.NetSceneOCRTranslate", "ERR: Security Check Failed");
        return k.b.hsU;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.scanner.NetSceneOCRTranslate", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 392;
    }
}
