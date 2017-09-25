package com.tencent.mm.modelappbrand;

import com.tencent.mm.as.b;
import com.tencent.mm.e.a.ho;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bmt;
import com.tencent.mm.protocal.c.bmu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class m extends b implements j {
    private e gWW;
    private com.tencent.mm.y.b hpV;
    private bmu hpX;

    public m(String str, int i, int i2) {
        this.hPj = str;
        this.hPi = i;
        this.hPg = i2;
        if (bg.mA(str)) {
            w.e("MicroMsg.NetSceneWeAppSuggest", "keyword is unavailable");
            return;
        }
        w.i("MicroMsg.NetSceneWeAppSuggest", "Constructors: query = %s", new Object[]{str});
        a aVar = new a();
        aVar.hsl = 1173;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchsuggestion";
        aVar.hsm = new bmt();
        aVar.hsn = new bmu();
        this.hpV = aVar.BE();
        bmt com_tencent_mm_protocal_c_bmt = (bmt) this.hpV.hsj.hsr;
        com_tencent_mm_protocal_c_bmt.fRM = str;
        com.tencent.mm.sdk.b.b hoVar = new ho();
        com.tencent.mm.sdk.b.a.urY.m(hoVar);
        com_tencent_mm_protocal_c_bmt.umf = hoVar.fNc.fNd;
        ap.yY();
        Object obj = c.vr().get(com.tencent.mm.storage.w.a.uFX, null);
        if (obj != null && (obj instanceof String)) {
            com_tencent_mm_protocal_c_bmt.umq = (String) obj;
        }
        com_tencent_mm_protocal_c_bmt.umj = b.hpQ;
        com_tencent_mm_protocal_c_bmt.umk = b.hpR;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneWeAppSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.hpX = (bmu) this.hpV.hsk.hsr;
            if (this.hpX != null) {
                w.v("MicroMsg.NetSceneWeAppSuggest", "return data\n%s", new Object[]{this.hpX.tlt});
            }
            this.gWW.a(i2, i3, str, this);
            return;
        }
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1173;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.hpV, this);
    }

    public final String AS() {
        return this.hpX != null ? this.hpX.tlt : "";
    }
}
