package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajf;
import com.tencent.mm.protocal.c.ajg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private final b gUA;
    private e gUD;
    public String nVD;
    public String nVE;

    public d(float f, float f2, int i, String str, String str2) {
        a aVar = new a();
        aVar.hsm = new ajf();
        aVar.hsn = new ajg();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.hsl = 376;
        aVar.hso = 183;
        aVar.hsp = 1000000183;
        this.gUA = aVar.BE();
        ajf com_tencent_mm_protocal_c_ajf = (ajf) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ajf.tce = 1;
        com_tencent_mm_protocal_c_ajf.tmZ = f;
        com_tencent_mm_protocal_c_ajf.tna = f2;
        com_tencent_mm_protocal_c_ajf.twQ = i;
        com_tencent_mm_protocal_c_ajf.twR = str;
        com_tencent_mm_protocal_c_ajf.twS = str2;
        com_tencent_mm_protocal_c_ajf.twT = 0;
        w.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1" + " lon:" + f + " lat:" + f2 + " pre:" + i + " gpsSource:0 mac" + str + " cell:" + str2);
    }

    public d(String str, int i, int i2) {
        a aVar = new a();
        aVar.hsm = new ajf();
        aVar.hsn = new ajg();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.hsl = 376;
        aVar.hso = 183;
        aVar.hsp = 1000000183;
        this.gUA = aVar.BE();
        ajf com_tencent_mm_protocal_c_ajf = (ajf) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ajf.tmZ = 0.0f;
        com_tencent_mm_protocal_c_ajf.tna = 0.0f;
        com_tencent_mm_protocal_c_ajf.twQ = 0;
        com_tencent_mm_protocal_c_ajf.twT = 0;
        com_tencent_mm_protocal_c_ajf.twR = "";
        com_tencent_mm_protocal_c_ajf.twS = "";
        com_tencent_mm_protocal_c_ajf.tce = 2;
        com_tencent_mm_protocal_c_ajf.hNe = str;
        com_tencent_mm_protocal_c_ajf.tNh = i;
        com_tencent_mm_protocal_c_ajf.tNg = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 376;
    }

    public final int AJ() {
        return ((ajf) this.gUA.hsj.hsr).tce;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " opCode:" + AJ());
        ajg com_tencent_mm_protocal_c_ajg = (ajg) ((b) pVar).hsk.hsr;
        if (i2 != 0) {
            this.gUD.a(i2, i3, str, this);
        } else if (AJ() == 1) {
            this.nVD = com_tencent_mm_protocal_c_ajg.hNe;
            this.nVE = com_tencent_mm_protocal_c_ajg.tNi;
            this.gUD.a(i2, i3, str, this);
        } else if (AJ() == 2) {
            b.BG(((ajf) ((b) pVar).hsj.hsr).hNe);
            this.gUD.a(i2, i3, str, this);
        }
    }
}
