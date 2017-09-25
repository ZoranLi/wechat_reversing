package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class v extends k implements j {
    Object data;
    public b gUA;
    private e gUD;

    public v(gy gyVar, Object obj) {
        a aVar = new a();
        aVar.hsm = new ays();
        aVar.hsn = new ayt();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
        this.gUA = aVar.BE();
        ays com_tencent_mm_protocal_c_ays = (ays) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ays.tCN = gyVar;
        com_tencent_mm_protocal_c_ays.mask = 1;
        com_tencent_mm_protocal_c_ays.tCM = 1;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1228;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
        return a(eVar, this.gUA, this);
    }
}
