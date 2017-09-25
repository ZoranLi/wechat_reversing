package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class aa extends k implements j {
    private final b gUA;
    private e gUD;
    public String kfG;

    public aa(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, bde com_tencent_mm_protocal_c_bde) {
        a aVar = new a();
        aVar.hsm = new wc();
        aVar.hsn = new wd();
        aVar.uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
        aVar.hsl = 645;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        wc wcVar = (wc) this.gUA.hsj.hsr;
        wcVar.fVl = str;
        wcVar.fVn = i;
        wcVar.keR = str2;
        wcVar.fVm = str3;
        wcVar.tcP = str4;
        wcVar.tcO = str5;
        wcVar.tcQ = i2;
        wcVar.tDa = str6;
        wcVar.tcS = com_tencent_mm_protocal_c_bde;
    }

    public final int getType() {
        return 645;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.kfG = ((wd) this.gUA.hsk.hsr).kfG;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
