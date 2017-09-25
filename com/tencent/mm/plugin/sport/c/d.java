package com.tencent.mm.plugin.sport.c;

import android.os.Build;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ba;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private e gUD;
    private b hKp;
    bna qRv;

    public d() {
        a aVar = new a();
        aVar.hsl = 1947;
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
        aVar.hsm = new bmz();
        aVar.hsn = new bna();
        this.hKp = aVar.BE();
        bmz com_tencent_mm_protocal_c_bmz = (bmz) this.hKp.hsj.hsr;
        com_tencent_mm_protocal_c_bmz.jNn = com.tencent.mm.protocal.d.sYL;
        com_tencent_mm_protocal_c_bmz.thD = ba.bMW();
        com_tencent_mm_protocal_c_bmz.tlv = Build.BRAND;
        com_tencent_mm_protocal_c_bmz.tlu = Build.MODEL;
        com_tencent_mm_protocal_c_bmz.umu = com.tencent.mm.protocal.d.sYI;
        com_tencent_mm_protocal_c_bmz.tlw = com.tencent.mm.protocal.d.sYJ;
        com_tencent_mm_protocal_c_bmz.tlx = com.tencent.mm.protocal.d.sYK;
        com_tencent_mm_protocal_c_bmz.umv = "0x26050D40";
        com_tencent_mm_protocal_c_bmz.umw = Build.MANUFACTURER;
        w.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[]{com_tencent_mm_protocal_c_bmz.thD, com_tencent_mm_protocal_c_bmz.tlv, com_tencent_mm_protocal_c_bmz.tlu, com_tencent_mm_protocal_c_bmz.jNn, com_tencent_mm_protocal_c_bmz.tlx, com_tencent_mm_protocal_c_bmz.tlw, com_tencent_mm_protocal_c_bmz.tlx, com_tencent_mm_protocal_c_bmz.umv, com_tencent_mm_protocal_c_bmz.umw});
    }

    public final int getType() {
        return 1947;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.qRv = (bna) this.hKp.hsk.hsr;
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
