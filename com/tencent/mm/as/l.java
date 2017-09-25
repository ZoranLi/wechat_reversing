package com.tencent.mm.as;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j {
    public int fRO;
    private e gUD;
    private b hKp;
    private int hPW;
    public int hPq;
    public akq hQk;
    public int scene;

    public l(int i, int i2, int i3, int i4, String str, long j) {
        this.scene = i;
        this.hPW = i3;
        this.fRO = i4;
        this.hPq = i2;
        w.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.hsl = 1048;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchguide";
        aVar.hsm = new akp();
        aVar.hsn = new akq();
        this.hKp = aVar.BE();
        akp com_tencent_mm_protocal_c_akp = (akp) this.hKp.hsj.hsr;
        com_tencent_mm_protocal_c_akp.tdM = i;
        com_tencent_mm_protocal_c_akp.tOk = i3;
        com_tencent_mm_protocal_c_akp.tOl = d.AU();
        com_tencent_mm_protocal_c_akp.tOm = i2;
        com_tencent_mm_protocal_c_akp.leO = str;
        com_tencent_mm_protocal_c_akp.tOn = j;
    }

    public final int getType() {
        return 1048;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.hQk = (akq) this.hKp.hsk.hsr;
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
