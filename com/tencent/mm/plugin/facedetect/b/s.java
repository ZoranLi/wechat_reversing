package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.protocal.c.bix;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class s extends k implements j, e {
    private b gUA;
    private e gUD;
    private boolean lva = false;

    public s(long j, String str, String str2) {
        a aVar = new a();
        aVar.hsm = new biw();
        aVar.hsn = new bix();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyface";
        aVar.hsl = 797;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        biw com_tencent_mm_protocal_c_biw = (biw) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_biw.tCF = j;
        com_tencent_mm_protocal_c_biw.tYe = str;
        com_tencent_mm_protocal_c_biw.tYf = str2;
    }

    public final int getType() {
        return 797;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bix com_tencent_mm_protocal_c_bix = (bix) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            this.lva = com_tencent_mm_protocal_c_bix.tYh == 0;
            i3 = com_tencent_mm_protocal_c_bix.tYh;
            w.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[]{Boolean.valueOf(this.lva)});
        } else if (!(com_tencent_mm_protocal_c_bix == null || com_tencent_mm_protocal_c_bix.tYh == 0)) {
            w.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
            i3 = com_tencent_mm_protocal_c_bix.tYh;
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final boolean arm() {
        return true;
    }

    public final String arn() {
        return null;
    }
}
