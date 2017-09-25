package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.ard;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.awb;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.j {
    private b gUA;
    private e gUD;
    public String ooX;
    public LinkedList<qe> opi;
    public LinkedList<ar> opj;

    public j(LinkedList<awb> linkedList, int i) {
        int i2 = 0;
        a aVar = new a();
        aVar.hsm = new ard();
        aVar.hsn = new are();
        aVar.uri = "/cgi-bin/micromsg-bin/presubmitorder";
        aVar.hsl = 554;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ard com_tencent_mm_protocal_c_ard = (ard) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ard.tnp = linkedList;
        if (linkedList != null) {
            i2 = linkedList.size();
        }
        com_tencent_mm_protocal_c_ard.ogX = i2;
        com_tencent_mm_protocal_c_ard.tVA = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        are com_tencent_mm_protocal_c_are = (are) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0 && com_tencent_mm_protocal_c_are.tnr == 0) {
            w.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + com_tencent_mm_protocal_c_are.tFi);
            w.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + com_tencent_mm_protocal_c_are.tnq);
            this.opi = com_tencent_mm_protocal_c_are.tVB;
            this.ooX = com_tencent_mm_protocal_c_are.tnq;
            this.opj = com_tencent_mm_protocal_c_are.tVC;
        }
        if (i3 == 0 && com_tencent_mm_protocal_c_are.tnr != 0) {
            i3 = com_tencent_mm_protocal_c_are.tnr;
            str = com_tencent_mm_protocal_c_are.tns;
        }
        w.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + i3 + ", errMsg " + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
