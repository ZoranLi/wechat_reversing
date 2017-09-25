package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class o extends k implements j {
    public b gUA;
    private e gUD;
    boolean hxv = false;

    public o(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new ve();
        aVar.hsn = new vf();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
        aVar.hsl = 1352;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ve veVar = (ve) this.gUA.hsj.hsr;
        veVar.tkF = str;
        veVar.tkL = str2;
        this.hxv = true;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1352;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
        return a(eVar, this.gUA, this);
    }
}
