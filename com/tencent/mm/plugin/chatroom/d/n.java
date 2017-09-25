package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bfn;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j {
    private final b gUA;
    private e gUD;
    public String username;

    public n(String str, String str2) {
        a aVar = new a();
        this.username = str2;
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_bfn = new bfn();
        com_tencent_mm_protocal_c_bfn.ttq = str;
        com_tencent_mm_protocal_c_bfn.ufY = str2;
        aVar.hsm = com_tencent_mm_protocal_c_bfn;
        aVar.hsn = new bfo();
        aVar.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
        aVar.hsl = 990;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.w("MicroMsg.NetSceneTransferChatRoomOwner", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 990;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
