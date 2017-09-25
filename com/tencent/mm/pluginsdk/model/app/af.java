package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajy;
import com.tencent.mm.protocal.c.ajz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class af extends k implements j {
    public b gUA;
    private e gUD;

    public af(int i, String str) {
        a aVar = new a();
        aVar.hsm = new ajy();
        aVar.hsn = new ajz();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
        this.gUA = aVar.BE();
        ajy com_tencent_mm_protocal_c_ajy = (ajy) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ajy.offset = i;
        com_tencent_mm_protocal_c_ajy.aIo = 20;
        com_tencent_mm_protocal_c_ajy.lang = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1060;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
        return a(eVar, this.gUA, this);
    }
}
