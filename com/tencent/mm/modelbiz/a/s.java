package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.ye;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class s extends k implements j {
    public b gUA;
    private e gUD;

    public s(String str) {
        a aVar = new a();
        aVar.hsm = new yd();
        aVar.hsn = new ye();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
        this.gUA = aVar.BE();
        ((yd) this.gUA.hsj.hsr).tkL = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1367;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
        return a(eVar, this.gUA, this);
    }
}
