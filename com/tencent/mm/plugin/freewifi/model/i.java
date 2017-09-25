package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bn;
import com.tencent.mm.protocal.c.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private String fTO;
    private final b gUA;
    private e gUD;

    private i() {
        a aVar = new a();
        aVar.hsm = new bn();
        aVar.hsn = new bo();
        aVar.uri = "/cgi-bin/mmo2o-bin/addcontact";
        aVar.hsl = 1703;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public i(String str, String str2, int i, String str3) {
        this();
        this.fTO = str;
        bn bnVar = (bn) this.gUA.hsj.hsr;
        bnVar.teQ = str;
        bnVar.msN = str2;
        bnVar.tcg = i;
        bnVar.tch = str3;
        w.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", new Object[]{str});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, this.fTO});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1703;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
