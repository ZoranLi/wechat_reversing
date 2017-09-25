package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abh;
import com.tencent.mm.protocal.c.abi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    private final b gUA;
    private e gUD;
    public String kfG;

    public c(String str) {
        a aVar = new a();
        aVar.hsm = new abh();
        aVar.hsn = new abi();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecard";
        aVar.hsl = 904;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((abh) this.gUA.hsj.hsr).fVl = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(904), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            abi com_tencent_mm_protocal_c_abi = (abi) this.gUA.hsk.hsr;
            w.v("MicroMsg.NetSceneGetShareCard", "json:" + com_tencent_mm_protocal_c_abi.kfG);
            this.kfG = com_tencent_mm_protocal_c_abi.kfG;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 904;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
