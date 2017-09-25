package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.bgd;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class x extends k implements j {
    private b gUA;
    private e gUD;
    public aen ldG;

    public x(aen com_tencent_mm_protocal_c_aen, int i) {
        this.ldG = com_tencent_mm_protocal_c_aen;
        a aVar = new a();
        aVar.hsm = new bgd();
        aVar.hsn = new bge();
        aVar.hsl = 537;
        aVar.uri = "/cgi-bin/micromsg-bin/unbindharddevice";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bgd com_tencent_mm_protocal_c_bgd = (bgd) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bgd.tjo = com_tencent_mm_protocal_c_aen;
        com_tencent_mm_protocal_c_bgd.teT = i;
    }

    public final int getType() {
        return 537;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        i iVar = i.ldm;
        i.bp(0);
        com.tencent.mm.plugin.exdevice.h.b vj = ad.apt().vj(this.ldG.jNm);
        if (vj != null) {
            if (!(u.apV().laU == null || u.apV().laU.bB(vj.field_mac))) {
                w.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
            }
            if (!ad.apt().bV(this.ldG.jNm, this.ldG.thD)) {
                w.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
            }
        } else {
            w.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[]{this.ldG.jNm});
        }
        if (!(i2 == 0 && i3 == 0)) {
            w.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[]{Integer.valueOf(537)});
        }
        bge com_tencent_mm_protocal_c_bge = (this.gUA == null || this.gUA.hsk.hsr == null) ? null : (bge) this.gUA.hsk.hsr;
        if (com_tencent_mm_protocal_c_bge == null) {
            w.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
        }
        this.gUD.a(i2, i3, str, this);
    }
}
