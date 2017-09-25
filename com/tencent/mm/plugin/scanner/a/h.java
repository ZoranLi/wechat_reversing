package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.protocal.c.hk;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private b gUA;
    private e gUD;

    public h(String str, String str2, int i, String str3, int i2, int i3) {
        a aVar = new a();
        aVar.hsm = new hj();
        aVar.hsn = new hk();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
        aVar.hsl = 1064;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        hj hjVar = (hj) this.gUA.hsj.hsr;
        hjVar.tlu = d.sYH;
        hjVar.tlv = d.sYG;
        hjVar.tlw = d.sYJ;
        hjVar.tlx = d.sYK;
        hjVar.tly = v.bIN();
        hjVar.oTM = 11294;
        hjVar.tlz = null;
        hjVar.oVS = str;
        hjVar.oVR = str2;
        hjVar.type = i;
        hjVar.value = str3;
        hjVar.count = i2;
        hjVar.odt = i3;
        w.v("MircoMsg.NetSceneScanProductReport", "statid:" + str2);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MircoMsg.NetSceneScanProductReport", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1064;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
