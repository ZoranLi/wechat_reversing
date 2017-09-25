package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.avs;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j {
    private b gUA;
    private e gUD;

    public l(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new avr();
        aVar.hsn = new avs();
        aVar.uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
        aVar.hsl = 700;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        avr com_tencent_mm_protocal_c_avr = (avr) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_avr.tZf = str;
        com_tencent_mm_protocal_c_avr.tZg = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 700;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gUD.a(i2, i3, str, this);
    }
}
