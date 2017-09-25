package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agq;
import com.tencent.mm.protocal.c.agr;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class k extends com.tencent.mm.y.k implements j {
    public final b gUA;
    private e gWW;

    public k(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new agq();
        aVar.hsn = new agr();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
        aVar.hsl = 1566;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        agq com_tencent_mm_protocal_c_agq = (agq) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_agq.jNj = str2;
        com_tencent_mm_protocal_c_agq.mtb = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1566;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
