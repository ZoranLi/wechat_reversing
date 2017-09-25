package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abd;
import com.tencent.mm.protocal.c.abe;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private final b gUA;
    private e gUD;
    public String kfG;
    public int kfH;
    public String kfI;

    public d(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hsm = new abd();
        aVar.hsn = new abe();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
        aVar.hsl = 910;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        abd com_tencent_mm_protocal_c_abd = (abd) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_abd.fVl = str;
        com_tencent_mm_protocal_c_abd.scene = 20;
        com_tencent_mm_protocal_c_abd.kdE = str2;
        com_tencent_mm_protocal_c_abd.code = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(910), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            abe com_tencent_mm_protocal_c_abe = (abe) this.gUA.hsk.hsr;
            w.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + com_tencent_mm_protocal_c_abe.kfG);
            this.kfG = com_tencent_mm_protocal_c_abe.kfG;
            this.kfI = com_tencent_mm_protocal_c_abe.kfI;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 910;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
