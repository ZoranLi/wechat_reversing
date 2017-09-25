package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class q extends k implements j {
    Object data;
    public b gUA;
    private e gUD;

    public q(String str, Object obj) {
        a aVar = new a();
        aVar.hsm = new vg();
        aVar.hsn = new vh();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
        this.gUA = aVar.BE();
        ((vg) this.gUA.hsj.hsr).tkL = str;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1354;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
        return a(eVar, this.gUA, this);
    }
}
