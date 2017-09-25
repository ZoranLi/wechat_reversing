package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.qh;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private e gUD;
    private final com.tencent.mm.y.b hKp;

    public b(String str) {
        a aVar = new a();
        com.tencent.mm.bd.a qhVar = new qh();
        com.tencent.mm.bd.a qiVar = new qi();
        aVar.hsm = qhVar;
        aVar.hsn = qiVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
        aVar.hsl = 973;
        aVar.hso = 0;
        aVar.hsp = 0;
        qhVar.tvX = str;
        this.hKp = aVar.BE();
    }

    public final int getType() {
        return 973;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
