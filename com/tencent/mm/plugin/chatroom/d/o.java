package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgz;
import com.tencent.mm.protocal.c.bha;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class o extends k implements j {
    public String chatroomName = null;
    public int gMU = 0;
    private final b gUA;
    private e gUD = null;
    public String ksO = null;
    public String ksX = null;
    public int ksY = 0;

    public o(String str) {
        a aVar = new a();
        aVar.hsm = new bgz();
        aVar.hsn = new bha();
        aVar.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
        aVar.hsl = 482;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.chatroomName = str;
        ((bgz) this.gUA.hsj.hsr).ttq = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 482;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bha com_tencent_mm_protocal_c_bha = (bha) this.gUA.hsk.hsr;
        w.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.ksX = com_tencent_mm_protocal_c_bha.tQJ;
        if (!bg.mA(this.ksX)) {
            ap.yY();
            q fV = c.xa().fV(this.chatroomName);
            if (fV == null) {
                fV = new q();
            }
            fV.eJ(m.xL(), this.ksX);
            com.tencent.mm.u.j.a(fV);
        }
        this.ksO = com_tencent_mm_protocal_c_bha.tDz;
        this.gMU = com_tencent_mm_protocal_c_bha.tDy;
        this.ksY = com_tencent_mm_protocal_c_bha.tDA;
        this.gUD.a(i2, i3, str, this);
    }
}
