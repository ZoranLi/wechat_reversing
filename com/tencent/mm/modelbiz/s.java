package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahx;
import com.tencent.mm.protocal.c.ahy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class s extends k implements j {
    public b gUA;
    private e gUD;
    public String hwg;

    public s(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new ahx();
        aVar.hsn = new ahy();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
        this.gUA = aVar.BE();
        ahx com_tencent_mm_protocal_c_ahx = (ahx) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ahx.tMd = str;
        com_tencent_mm_protocal_c_ahx.tMe = str2;
        this.hwg = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 674;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneKFGetBindList", "do scene");
        return a(eVar, this.gUA, this);
    }

    public final ahy DC() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (ahy) this.gUA.hsk.hsr;
    }
}
