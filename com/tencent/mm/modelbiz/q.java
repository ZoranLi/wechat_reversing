package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class q extends k implements j {
    Object data;
    public b gUA;
    private e gUD;

    public q(String str, int i, Object obj) {
        a aVar = new a();
        aVar.hsm = new vk();
        aVar.hsn = new vl();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
        this.gUA = aVar.BE();
        vk vkVar = (vk) this.gUA.hsj.hsr;
        vkVar.tkL = str;
        vkVar.tCM = i;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1343;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
        return a(eVar, this.gUA, this);
    }
}
