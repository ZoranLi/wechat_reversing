package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.protocal.c.qo;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private e gUD;
    public final b hKp;
    public boolean srE;

    public d(String str, String str2, boolean z) {
        this.srE = z;
        a aVar = new a();
        com.tencent.mm.bd.a qnVar = new qn();
        com.tencent.mm.bd.a qoVar = new qo();
        aVar.hsm = qnVar;
        aVar.hsn = qoVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
        aVar.hsl = 972;
        aVar.hso = 0;
        aVar.hsp = 0;
        qnVar.tvX = str;
        qnVar.twi = str2;
        qnVar.twk = z;
        this.hKp = aVar.BE();
    }

    public final int getType() {
        return 972;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
