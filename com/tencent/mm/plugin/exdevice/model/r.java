package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.aep;
import com.tencent.mm.protocal.c.aeq;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class r extends k implements j {
    private String fGs;
    private b gUA = null;
    private e gUD = null;
    String ldD;

    public r(String str, String str2, String str3, int i, byte[] bArr) {
        a aVar = new a();
        aVar.hsm = new aep();
        aVar.hsn = new aeq();
        aVar.uri = "/cgi-bin/micromsg-bin/harddeviceauth";
        aVar.hsl = 541;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aep com_tencent_mm_protocal_c_aep = (aep) this.gUA.hsj.hsr;
        aen com_tencent_mm_protocal_c_aen = new aen();
        com_tencent_mm_protocal_c_aen.thD = str2;
        com_tencent_mm_protocal_c_aen.jNm = str3;
        com_tencent_mm_protocal_c_aep.tjo = com_tencent_mm_protocal_c_aen;
        com_tencent_mm_protocal_c_aep.tJP = i;
        com_tencent_mm_protocal_c_aep.tJQ = new avw().bb(bArr);
        this.ldD = str3;
        this.fGs = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        c vj = ad.apt().vj(this.ldD);
        if (i2 == 0 && i3 == 0) {
            aeq com_tencent_mm_protocal_c_aeq = (aeq) this.gUA.hsk.hsr;
            if (vj != null) {
                byte[] apn = apn();
                if (apn != null) {
                    vj.field_authBuf = apn;
                }
                vj.gtO = com_tencent_mm_protocal_c_aeq.tJU;
                vj.gtA = true;
                vj.gtN = com_tencent_mm_protocal_c_aeq.tJT;
                vj.gtA = true;
                byte[] vc = vc();
                if (vc != null) {
                    u.apU().a(vj.field_mac, vc, 2);
                    if (u.apV().laU != null) {
                        u.apV().laU.setChannelSessionKey(vj.field_mac, vc);
                    }
                    vj.field_sessionKey = vc;
                }
                vc = apo();
                if (vc != null) {
                    u.apU().a(vj.field_mac, vc, 3);
                    vj.field_sessionBuf = vc;
                }
                vc = apn();
                if (apn != null) {
                    u.apU().a(vj.field_mac, vc, 1);
                    vj.field_authBuf = apn;
                }
                vj.gtP = System.currentTimeMillis() / 1000;
                vj.gtA = true;
                if (2 == u.apU().bu(vj.field_mac)) {
                    ad.apE();
                    e.a(this.fGs, vj.field_url, 2, vj.field_deviceID);
                }
                u.apU().bx(vj.field_mac);
                boolean c = ad.apt().c(vj, new String[0]);
                w.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[]{Boolean.valueOf(c)});
            } else {
                w.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
            }
        } else {
            if (vj != null) {
                u.apU().by(vj.field_mac);
                ad.apE();
                e.a(this.fGs, vj.field_url, 4, vj.field_deviceID);
            }
            ad.apE();
            e.aM(this.fGs, 3);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 541;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    private byte[] vc() {
        try {
            return ((aeq) this.gUA.hsk.hsr).the.tZp.sYA;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    public final byte[] apn() {
        try {
            return ((aeq) this.gUA.hsk.hsr).tJS.tZp.sYA;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    private byte[] apo() {
        try {
            return ((aeq) this.gUA.hsk.hsr).tJR.tZp.sYA;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }
}
