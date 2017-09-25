package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.mt;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j {
    Object data;
    public b gUA;
    private e gUD;

    public n(String str, ss ssVar, Object obj) {
        a aVar = new a();
        aVar.hsm = new ms();
        aVar.hsn = new mt();
        aVar.uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
        this.gUA = aVar.BE();
        ms msVar = (ms) this.gUA.hsj.hsr;
        msVar.tkL = str;
        msVar.ttc = ssVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1355;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
        return a(eVar, this.gUA, this);
    }

    public final mt Eb() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (mt) this.gUA.hsk.hsr;
    }

    public final ms Ec() {
        if (this.gUA == null || this.gUA.hsj.hsr == null) {
            return null;
        }
        return (ms) this.gUA.hsj.hsr;
    }
}
