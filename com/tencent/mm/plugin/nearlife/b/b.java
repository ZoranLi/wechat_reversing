package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aiy;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.mw;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class b extends k implements j {
    private com.tencent.mm.y.b hse;
    private e nXi;
    public String nXj;

    public b(String str, String str2, String str3, aiy com_tencent_mm_protocal_c_aiy, int i, LinkedList<avx> linkedList, String str4) {
        a aVar = new a();
        aVar.hsm = new mw();
        aVar.hsn = new mx();
        aVar.uri = "/cgi-bin/micromsg-bin/createpoi";
        aVar.hsl = 650;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hse = aVar.BE();
        String ap = bg.ap(str4, "");
        String ap2 = bg.ap(null, "");
        mw mwVar = (mw) this.hse.hsj.hsr;
        mwVar.msj = str;
        mwVar.tth = str2;
        mwVar.ttj = com_tencent_mm_protocal_c_aiy;
        mwVar.jNd = i;
        if (linkedList != null) {
            mwVar.ttk = linkedList;
        }
        mwVar.ttl = ap;
        mwVar.ttm = ap2;
        mwVar.tti = str3;
        w.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[]{str, str2, str3, Float.valueOf(com_tencent_mm_protocal_c_aiy.tna), Float.valueOf(com_tencent_mm_protocal_c_aiy.tmZ), Integer.valueOf(i), ap, ap2});
    }

    public final int getType() {
        return 650;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.nXi = eVar2;
        return a(eVar, this.hse, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        mx mxVar = (mx) this.hse.hsk.hsr;
        if (this.hse.hsk.sZC != 0) {
            this.nXi.a(i2, i3, str, this);
            return;
        }
        this.nXj = mxVar.ttn;
        w.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.nXj);
        this.nXi.a(i2, i3, str, this);
    }
}
