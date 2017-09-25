package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.fz;
import com.tencent.mm.protocal.c.ga;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j {
    private b gUA = null;
    private e gUD = null;

    public l(String str, int i) {
        a aVar = new a();
        aVar.hsm = new fz();
        aVar.hsn = new ga();
        aVar.uri = "/cgi-bin/micromsg-bin/bindharddevice";
        aVar.hsl = 536;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        fz fzVar = (fz) this.gUA.hsj.hsr;
        fzVar.tiZ = bg.mz(str);
        fzVar.tjn = bg.f(Integer.valueOf(i));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            int i4;
            ga apm = apm();
            w.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[]{apm.tjo.jNm, apm.tjo.thD});
            String str2 = "MicroMsg.exdevice.NetSceneBindHardDevice";
            String str3 = "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s";
            Object[] objArr = new Object[6];
            objArr[0] = apm.tjp.thm;
            objArr[1] = apm.tjp.tJE;
            objArr[2] = apm.tjp.tiU;
            objArr[3] = apm.tjp.tJF;
            objArr[4] = Integer.valueOf(apm.tjp.tJG);
            objArr[5] = apm.teT == 0 ? "sync" : "async";
            w.i(str2, str3, objArr);
            if (ad.apt().bU(apm.tjp.tJE, apm.tjo.jNm) != null) {
                w.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[]{apm.tjp.tJE, Boolean.valueOf(ad.apt().bV(apm.tjo.jNm, apm.tjp.tJE))});
                if (ad.apt().bV(apm.tjo.jNm, apm.tjp.tJE)) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 1;
            }
            c bVar = new com.tencent.mm.plugin.exdevice.h.b();
            f.a(bVar, apm.tjo, apm.tjp);
            bVar.field_url = "";
            f.a bv = u.apU().bv(bVar.field_mac);
            if (bv != null && bv.fHm == 2) {
                w.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
                ad.apA();
                d.bj(bVar.field_mac);
                f apU = u.apU();
                long j = bVar.field_mac;
                if (apU.lgI.containsKey(Long.valueOf(j))) {
                    apU.lgI.remove(Long.valueOf(j));
                    w.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[]{Long.valueOf(j)});
                } else {
                    w.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[]{Long.valueOf(j)});
                }
            }
            if (i4 != 0) {
                ad.apt().b(bVar);
            } else {
                ad.apt().e(bVar);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 536;
    }

    public final ga apm() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (ga) this.gUA.hsk.hsr;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
