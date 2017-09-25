package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayw;
import com.tencent.mm.protocal.c.ayx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.utils.TbsLog;

public final class m extends k implements j {
    private final b gUA;
    private e gUD;

    public m(String str, String str2) {
        a aVar = new a();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ayw = new ayw();
        com_tencent_mm_protocal_c_ayw.ttq = str;
        com_tencent_mm_protocal_c_ayw.tDl = str2;
        aVar.hsm = com_tencent_mm_protocal_c_ayw;
        aVar.hsn = new ayx();
        aVar.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
        aVar.hsl = TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
