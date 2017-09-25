package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.protocal.c.bgj;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class w extends k implements j {
    Object data;
    public b gUA;
    private e gUD;

    public w(String str, gq gqVar, Object obj) {
        a aVar = new a();
        aVar.hsm = new bgi();
        aVar.hsn = new bgj();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
        this.gUA = aVar.BE();
        bgi com_tencent_mm_protocal_c_bgi = (bgi) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bgi.tkL = str;
        com_tencent_mm_protocal_c_bgi.tAE = gqVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1356;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
        return a(eVar, this.gUA, this);
    }
}
