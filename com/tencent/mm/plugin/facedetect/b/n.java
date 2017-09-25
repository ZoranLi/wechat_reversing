package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.protocal.c.aun;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j, e {
    private b gUA;
    private e gUD;
    private boolean lva = false;
    private String lve = null;

    public n(long j, String str, String str2) {
        a aVar = new a();
        aVar.hsm = new aum();
        aVar.hsn = new aun();
        aVar.uri = "/cgi-bin/micromsg-bin/registerface";
        aVar.hsl = 918;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aum com_tencent_mm_protocal_c_aum = (aum) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aum.tCF = j;
        com_tencent_mm_protocal_c_aum.tYe = str;
        com_tencent_mm_protocal_c_aum.tYf = str2;
    }

    public final int getType() {
        return 918;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        aun com_tencent_mm_protocal_c_aun = (aun) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            this.lva = com_tencent_mm_protocal_c_aun.tYh == 0;
            this.lve = com_tencent_mm_protocal_c_aun.tYg;
            i3 = com_tencent_mm_protocal_c_aun.tYh;
            w.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[]{Boolean.valueOf(this.lva)});
        } else if (!(com_tencent_mm_protocal_c_aun == null || com_tencent_mm_protocal_c_aun.tYh == 0)) {
            w.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
            i3 = com_tencent_mm_protocal_c_aun.tYh;
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final boolean arm() {
        return true;
    }

    public final String arn() {
        return this.lve;
    }
}
