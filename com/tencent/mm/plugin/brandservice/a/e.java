package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.protocal.c.akk;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    public b gUA;
    private com.tencent.mm.y.e gUD;

    public e(String str) {
        a aVar = new a();
        aVar.hsm = new akj();
        aVar.hsn = new akk();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
        aVar.hsl = 1031;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((akj) this.gUA.hsj.hsr).tKK = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1031;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
        return a(eVar, this.gUA, this);
    }
}
