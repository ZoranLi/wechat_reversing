package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bee;
import com.tencent.mm.protocal.c.bef;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class q extends k implements j {
    private b gUA;
    private e gUD;
    public boolean lvj = false;
    public boolean lvk = false;

    public q(int i) {
        a aVar = new a();
        aVar.hsm = new bee();
        aVar.hsn = new bef();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopface";
        aVar.hsl = 938;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((bee) this.gUA.hsj.hsr).tce = i;
    }

    public final int getType() {
        return 938;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bef com_tencent_mm_protocal_c_bef = (bef) ((b) pVar).hsk.hsr;
        this.lvj = com_tencent_mm_protocal_c_bef.ufg;
        this.lvk = com_tencent_mm_protocal_c_bef.ufh;
        w.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.lvj), Boolean.valueOf(this.lvk)});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
