package com.tencent.mm.plugin.appbrand.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bmv;
import com.tencent.mm.protocal.c.bmw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Locale;

public final class a extends k implements j {
    private e gWW;
    private b hpV;
    private bmw jaN;

    public a() {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bmv();
        aVar.hsn = new bmw();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
        aVar.hsl = 1170;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hpV = aVar.BE();
    }

    public final int getType() {
        return 1170;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.hpV, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.jaN = (bmw) this.hpV.hsk.hsr;
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
        if (this.jaN.umr != null) {
            ap.yY();
            t vr = c.vr();
            vr.a(com.tencent.mm.storage.w.a.uFV, Locale.getDefault().getLanguage());
            vr.a(com.tencent.mm.storage.w.a.uFW, this.jaN.umr.mQZ);
            vr.a(com.tencent.mm.storage.w.a.uFX, this.jaN.umr.umq);
            vr.a(com.tencent.mm.storage.w.a.uFY, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
