package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ql;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    private e gUD;
    final b hKp;

    public c(String str) {
        a aVar = new a();
        com.tencent.mm.bd.a qlVar = new ql();
        com.tencent.mm.bd.a qmVar = new qm();
        aVar.hsm = qlVar;
        aVar.hsn = qmVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
        aVar.hsl = 971;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hKp = aVar.BE();
        qlVar.tvX = str;
        w.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", new Object[]{str});
    }

    public final int getType() {
        return 971;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        this.gUD.a(i2, i3, str, this);
    }
}
