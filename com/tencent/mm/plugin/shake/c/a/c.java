package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.c.azh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    private final b gUA;
    private e gUD;
    e poL;

    public c(float f, float f2, int i, String str) {
        a aVar = new a();
        aVar.hsm = new azg();
        aVar.hsn = new azh();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/shakecard";
        aVar.hsl = 1250;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        azg com_tencent_mm_protocal_c_azg = (azg) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_azg.fOb = f2;
        com_tencent_mm_protocal_c_azg.fPF = f;
        com_tencent_mm_protocal_c_azg.scene = i;
        com_tencent_mm_protocal_c_azg.uaE = str;
    }

    public final int getType() {
        return 1250;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = 1250" + " errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            azh com_tencent_mm_protocal_c_azh = (azh) this.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_azh != null) {
                this.poL = new e();
                this.poL.kfr = com_tencent_mm_protocal_c_azh.kfr;
                this.poL.kdE = com_tencent_mm_protocal_c_azh.kdE;
                this.poL.fVm = com_tencent_mm_protocal_c_azh.fVm;
                this.poL.title = com_tencent_mm_protocal_c_azh.title;
                this.poL.kdH = com_tencent_mm_protocal_c_azh.kdH;
                this.poL.kdI = com_tencent_mm_protocal_c_azh.kdI;
                this.poL.keT = com_tencent_mm_protocal_c_azh.keT;
                this.poL.kdG = com_tencent_mm_protocal_c_azh.kdG;
                this.poL.hib = com_tencent_mm_protocal_c_azh.hib;
                this.poL.poM = com_tencent_mm_protocal_c_azh.poM;
                this.poL.poP = com_tencent_mm_protocal_c_azh.poP;
                this.poL.poQ = com_tencent_mm_protocal_c_azh.poQ;
                this.poL.poR = com_tencent_mm_protocal_c_azh.poR;
                this.poL.poS = com_tencent_mm_protocal_c_azh.poS;
                this.poL.poT = com_tencent_mm_protocal_c_azh.poT;
                this.poL.kdL = com_tencent_mm_protocal_c_azh.kdL;
                this.poL.poU = com_tencent_mm_protocal_c_azh.poU;
                this.poL.poV = com_tencent_mm_protocal_c_azh.poV;
                m.baY().poO = this.poL.poT;
            } else {
                this.poL = new e();
                this.poL.kfr = 3;
                this.poL.poT = m.baY().poO;
            }
        } else {
            this.poL = new e();
            this.poL.kfr = 3;
            this.poL.poT = m.baY().poO;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
