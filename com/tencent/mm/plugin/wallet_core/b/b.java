package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.e.a.nj;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.uu;
import com.tencent.mm.protocal.c.uv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class b extends k implements j {
    private com.tencent.mm.y.b gUA;
    private e gUD;

    public b(LinkedList<String> linkedList) {
        w.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
        a aVar = new a();
        aVar.hsm = new uu();
        aVar.hsn = new uv();
        aVar.uri = "/cgi-bin/mmpay-bin/bankresource";
        aVar.hsl = 1650;
        this.gUA = aVar.BE();
        this.gUA.hsA = true;
        uu uuVar = (uu) this.gUA.hsj.hsr;
        uuVar.tCu = linkedList;
        uuVar.tnu = h.btK();
        com.tencent.mm.wallet_core.ui.e.CM(42);
    }

    public final int getType() {
        return 1650;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            uv uvVar = (uv) ((com.tencent.mm.y.b) pVar).hsk.hsr;
            w.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[]{uvVar.tCw});
            LinkedList linkedList = uvVar.tCv;
            if (linkedList == null || linkedList.size() == 0) {
                w.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
            } else {
                com.tencent.mm.sdk.b.b njVar = new nj();
                njVar.fUw.fUy = linkedList;
                com.tencent.mm.sdk.b.a.urY.m(njVar);
            }
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uDH, bg.ap(uvVar.tCw, ""));
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uDI, Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            com.tencent.mm.wallet_core.ui.e.CM(43);
        }
        this.gUD.a(i2, i3, str, this);
    }
}
