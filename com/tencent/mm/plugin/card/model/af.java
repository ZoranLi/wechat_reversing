package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.adu;
import com.tencent.mm.protocal.c.adv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class af extends k implements j {
    public String fVm;
    private final b gUA;
    private e gUD;
    public int kfH;
    public String kfI;

    public af(String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new adu();
        aVar.hsn = new adv();
        aVar.uri = "/cgi-bin/micromsg-bin/giftcarditem";
        aVar.hsl = 652;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        adu com_tencent_mm_protocal_c_adu = (adu) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_adu.fVl = str;
        com_tencent_mm_protocal_c_adu.tJo = str2;
        com_tencent_mm_protocal_c_adu.tJp = i;
    }

    public final int getType() {
        return 652;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        adv com_tencent_mm_protocal_c_adv;
        if (i2 == 0 && i3 == 0) {
            com_tencent_mm_protocal_c_adv = (adv) this.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_adv != null) {
                this.fVm = com_tencent_mm_protocal_c_adv.fVm;
                this.kfI = com_tencent_mm_protocal_c_adv.kfI;
                this.kfH = com_tencent_mm_protocal_c_adv.kfH;
            }
        } else {
            com_tencent_mm_protocal_c_adv = (adv) this.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_adv != null) {
                this.fVm = com_tencent_mm_protocal_c_adv.fVm;
                this.kfI = com_tencent_mm_protocal_c_adv.kfI;
                this.kfH = com_tencent_mm_protocal_c_adv.kfH;
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
