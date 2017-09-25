package com.tencent.mm.modelmulti;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    public String content = "";
    private b gUA;
    private e gUD;
    public int hKq = 0;
    public String title = "";

    public f(int i) {
        a aVar = new a();
        aVar.hsm = new yx();
        aVar.hsn = new yy();
        aVar.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
        aVar.hsl = 1803;
        this.gUA = aVar.BE();
        ((yx) this.gUA.hsj.hsr).tFd = i;
        this.hKq = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            yy yyVar = (yy) this.gUA.hsk.hsr;
            this.title = yyVar.tFe;
            this.content = yyVar.tFf;
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
