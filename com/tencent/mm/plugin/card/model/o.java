package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ah;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class o extends k implements j {
    private final b gUA;
    private e gUD;
    public String kfG;
    public int kfH;
    public String kfI;

    public o(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, bde com_tencent_mm_protocal_c_bde) {
        a aVar = new a();
        aVar.hsm = new ah();
        aVar.hsn = new ai();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcarditem";
        aVar.hsl = 651;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ah ahVar = (ah) this.gUA.hsj.hsr;
        ahVar.fVl = str;
        ahVar.keR = str2;
        ahVar.fVn = i;
        ahVar.fVm = str3;
        ahVar.tcP = str4;
        ahVar.tcO = str5;
        ahVar.tcQ = i2;
        ahVar.tcR = i3;
        ahVar.tcS = com_tencent_mm_protocal_c_bde;
    }

    public final int getType() {
        return 651;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        ai aiVar;
        if (i2 == 0 && i3 == 0) {
            aiVar = (ai) this.gUA.hsk.hsr;
            if (aiVar != null) {
                this.kfG = aiVar.kfG;
                this.kfH = aiVar.kfH;
                this.kfI = aiVar.kfI;
            }
        } else {
            aiVar = (ai) this.gUA.hsk.hsr;
            if (aiVar != null) {
                this.kfG = aiVar.kfG;
                this.kfH = aiVar.kfH;
                this.kfI = aiVar.kfI;
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
