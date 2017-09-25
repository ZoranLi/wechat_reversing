package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gv;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j {
    private Object data;
    public b gUA;
    private e gUD;

    public l(String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new gv();
        aVar.hsn = new gw();
        aVar.uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
        this.gUA = aVar.BE();
        gv gvVar = (gv) this.gUA.hsj.hsr;
        gvVar.tkL = str;
        gvVar.fDs = str2;
        gvVar.offset = i;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1364;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
        return a(eVar, this.gUA, this);
    }
}
