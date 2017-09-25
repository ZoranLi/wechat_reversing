package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class g extends k implements j {
    private final b gUA;
    private e gUD;
    public String kfG;
    public int kfH;
    public String kfI;

    public g(int i, LinkedList<azt> linkedList, String str, String str2, bab com_tencent_mm_protocal_c_bab, int i2, bde com_tencent_mm_protocal_c_bde) {
        a aVar = new a();
        aVar.hsm = new azr();
        aVar.hsn = new azs();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecarditem";
        aVar.hsl = 902;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        azr com_tencent_mm_protocal_c_azr = (azr) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_azr.uba = i;
        com_tencent_mm_protocal_c_azr.hkm = linkedList;
        com_tencent_mm_protocal_c_azr.ubb = str;
        com_tencent_mm_protocal_c_azr.tDa = str2;
        w.i("MicroMsg.NetSceneShareCardItem", "list length is " + linkedList.size());
        com_tencent_mm_protocal_c_azr.ubc = com_tencent_mm_protocal_c_bab;
        com_tencent_mm_protocal_c_azr.fVn = i2;
        com_tencent_mm_protocal_c_azr.tcS = com_tencent_mm_protocal_c_bde;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(902), Integer.valueOf(i2), Integer.valueOf(i3)});
        azs com_tencent_mm_protocal_c_azs;
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
            com_tencent_mm_protocal_c_azs = (azs) this.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_azs != null) {
                this.kfG = com_tencent_mm_protocal_c_azs.kfG;
                this.kfH = com_tencent_mm_protocal_c_azs.kfH;
                this.kfI = com_tencent_mm_protocal_c_azs.kfI;
            }
        } else {
            com_tencent_mm_protocal_c_azs = (azs) this.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_azs != null) {
                this.kfG = com_tencent_mm_protocal_c_azs.kfG;
                this.kfH = com_tencent_mm_protocal_c_azs.kfH;
                this.kfI = com_tencent_mm_protocal_c_azs.kfI;
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 902;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
