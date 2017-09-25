package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aco;
import com.tencent.mm.protocal.c.acp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private final b gUA;
    private e gUD;
    String rci = "";
    int rcj = 0;
    String rck = "";

    public d(int i, String str) {
        a aVar = new a();
        aVar.hsm = new aco();
        aVar.hsn = new acp();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
        aVar.hsl = 611;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aco com_tencent_mm_protocal_c_aco = (aco) this.gUA.hsj.hsr;
        w.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[]{Integer.valueOf(i), str});
        com_tencent_mm_protocal_c_aco.tIp = i;
        com_tencent_mm_protocal_c_aco.tIq = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 611;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        acp com_tencent_mm_protocal_c_acp = (acp) ((b) pVar).hsk.hsr;
        if (i2 == 0 || i3 == 0) {
            if (com_tencent_mm_protocal_c_acp.tIr != null) {
                this.rci = new String(com_tencent_mm_protocal_c_acp.tIr.tYV.tZp.sYA);
                this.rcj = com_tencent_mm_protocal_c_acp.tIr.tYm;
                w.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[]{Integer.valueOf(this.rcj), this.rci});
            } else {
                w.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
