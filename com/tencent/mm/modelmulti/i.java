package com.tencent.mm.modelmulti;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.bfw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private b gUA;
    private e gUD;
    private int hKq = 0;

    public i(int i, String str) {
        a aVar = new a();
        aVar.hsm = new aqw();
        aVar.hsn = new aqx();
        aVar.uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
        aVar.hsl = 1804;
        this.gUA = aVar.BE();
        aqw com_tencent_mm_protocal_c_aqw = (aqw) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aqw.tFd = i;
        com_tencent_mm_protocal_c_aqw.tFf = str;
        if ((i & 16) > 0) {
            com.tencent.mm.ui.j.a aVar2 = new com.tencent.mm.ui.j.a();
            bfw com_tencent_mm_protocal_c_bfw = new bfw();
            if (aVar2.wrt == null) {
                com_tencent_mm_protocal_c_bfw = null;
            } else if (!bg.mA(aVar2.wrt.token)) {
                com_tencent_mm_protocal_c_bfw.ugm = aVar2.wrt.token;
                com_tencent_mm_protocal_c_bfw.ugn = aVar2.wrt.tPO;
            }
            com_tencent_mm_protocal_c_aqw.tVq = com_tencent_mm_protocal_c_bfw;
        }
        this.hKq = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1804;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
