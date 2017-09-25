package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axc;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private String fDs;
    private e gUD;
    private b jZk;
    private long jZm;
    public axd jZn;
    private int scene;

    public i(String str, long j, int i) {
        this.fDs = str;
        this.jZm = j;
        this.scene = i;
        w.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0 && this.jZk != null) {
            this.jZn = (axd) this.jZk.hsk.hsr;
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1070;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
        this.gUD = eVar2;
        if (bg.mA(this.fDs)) {
            w.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
            return -1;
        }
        a aVar = new a();
        aVar.hsl = 1070;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
        aVar.hsm = new axc();
        aVar.hsn = new axd();
        aVar.hso = 0;
        aVar.hsp = 0;
        this.jZk = aVar.BE();
        axc com_tencent_mm_protocal_c_axc = (axc) this.jZk.hsj.hsr;
        com_tencent_mm_protocal_c_axc.tDX = this.fDs;
        com_tencent_mm_protocal_c_axc.tOl = c.AU();
        com_tencent_mm_protocal_c_axc.tlY = this.jZm;
        com_tencent_mm_protocal_c_axc.tZJ = this.scene;
        w.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[]{Long.valueOf(this.jZm)});
        return a(eVar, this.jZk, this);
    }
}
