package com.tencent.mm.plugin.sns.a.a;

import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aif;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.bg;
import com.tencent.mm.protocal.c.bh;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import java.util.List;

public final class e extends k implements j {
    private b gUA;
    public com.tencent.mm.y.e gUD;
    public List<aig> pOW;

    public e(List<aig> list) {
        int i = 0;
        a aVar = new a();
        this.pOW = list;
        aVar.hsm = new bg();
        aVar.hsn = new bh();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.hsl = 1802;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bg bgVar = (bg) this.gUA.hsj.hsr;
        aif com_tencent_mm_protocal_c_aif = new aif();
        com_tencent_mm_protocal_c_aif.tlu = d.sYH;
        com_tencent_mm_protocal_c_aif.tlv = d.sYG;
        com_tencent_mm_protocal_c_aif.tlw = d.sYJ;
        com_tencent_mm_protocal_c_aif.tlx = d.sYK;
        com_tencent_mm_protocal_c_aif.tly = v.bIN();
        com_tencent_mm_protocal_c_aif.tMo = (int) (System.currentTimeMillis() / 1000);
        bgVar.teG = com_tencent_mm_protocal_c_aif;
        while (i < list.size()) {
            bgVar.teH.add(list.get(i));
            i++;
        }
        w.i("MicroMsg.NetSceneAdLog", "report count: " + bgVar.teH.size());
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 1802;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneAdLog", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            int i4 = ((bh) ((b) pVar).hsk.hsr).teI;
            h.vJ();
            h.vI().vr().a(com.tencent.mm.storage.w.a.uBu, Integer.valueOf(i4));
        }
        this.gUD.a(i2, i3, str, this);
    }
}
