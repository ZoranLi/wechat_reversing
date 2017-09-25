package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aee;
import com.tencent.mm.protocal.c.aef;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class j extends k implements com.tencent.mm.network.j {
    private final b gUA;
    private e gUD = null;

    public final int getType() {
        return 339;
    }

    public j(String str) {
        a aVar = new a();
        aVar.hsm = new aee();
        aVar.hsn = new aef();
        aVar.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
        aVar.hsl = 339;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((aee) this.gUA.hsj.hsr).mvU = str;
        w.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + i2 + " " + i3 + "  " + str);
        if (i2 == 0 && i3 == 0) {
            ap.yY();
            int intValue = ((Integer) c.vr().get(135176, Integer.valueOf(0))).intValue();
            if (intValue - 1 >= 0) {
                ap.yY();
                c.vr().set(135176, Integer.valueOf(intValue - 1));
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
