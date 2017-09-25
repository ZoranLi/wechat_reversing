package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wt;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    public String chatroomName;
    private final b gUA;
    private e gUD = null;
    public String ksO;
    public int ksP;
    public int ksQ;
    public int status;

    public h(String str) {
        a aVar = new a();
        aVar.hsm = new wt();
        aVar.hsn = new wu();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
        aVar.hsl = 519;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.chatroomName = str;
        ((wt) this.gUA.hsj.hsr).ttq = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 519;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        wu wuVar = (wu) this.gUA.hsk.hsr;
        w.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.status = wuVar.jNB;
        this.ksO = wuVar.tDz;
        this.ksQ = wuVar.tDA;
        this.ksO = wuVar.tDz;
        this.ksP = wuVar.tDy;
        this.gUD.a(i2, i3, str, this);
    }
}
