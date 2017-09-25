package com.tencent.mm.sandbox.a;

import com.tencent.mm.b.i;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.pluginsdk.l.u;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j, u {
    public final b gUA;
    private e gUD;

    public a(int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new abz();
        aVar.hsn = new aca();
        aVar.uri = "/cgi-bin/micromsg-bin/getupdateinfo";
        this.gUA = aVar.BE();
        abz com_tencent_mm_protocal_c_abz = (abz) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_abz.tHy = i;
        com_tencent_mm_protocal_c_abz.tcg = f.fuV;
        if (10012 == r.iiW && r.iiX > 0) {
            com_tencent_mm_protocal_c_abz.tcg = r.iiX;
        }
        switch (i) {
            case 1:
                g.oUh.a(405, 3, 1, true);
                break;
            case 2:
                g.oUh.a(405, 4, 1, true);
                break;
            case 3:
                g.oUh.a(405, 5, 1, true);
                break;
            case 4:
                g.oUh.a(405, 6, 1, true);
                break;
        }
        w.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", Integer.valueOf(com_tencent_mm_protocal_c_abz.tHy), Integer.valueOf(com_tencent_mm_protocal_c_abz.tcg), Integer.valueOf(f.fuV), bg.bJZ());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 11;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            g.oUh.a(405, 7, 1, true);
        } else {
            g.oUh.a(405, 8, 1, true);
            if (i2 == 4) {
                g.oUh.a(405, 9, 1, true);
                if (i3 == -16) {
                    g.oUh.a(405, 10, 1, true);
                } else if (i3 == -17) {
                    g.oUh.a(405, 11, 1, true);
                } else if (i3 == -18) {
                    g.oUh.a(405, 12, 1, true);
                }
            }
        }
        this.gUD.a(i2, i3, str, this);
        String bHK = bHK();
        if (bHK != null) {
            w.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", Integer.valueOf(i.bc(bHK).versionCode));
            ap.vd().a(new ak(ab.getPackageName(), r0), 0);
            g.oUh.a(405, 13, 1, true);
            return;
        }
        w.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
        g.oUh.a(405, 14, 1, true);
    }

    public final int bHI() {
        return ((aca) this.gUA.hsk.hsr).tHB;
    }

    public final String bHJ() {
        return ((aca) this.gUA.hsk.hsr).tHA;
    }

    public final int bCp() {
        return ((aca) this.gUA.hsk.hsr).tHz;
    }

    public final String[] bCq() {
        aca com_tencent_mm_protocal_c_aca = (aca) this.gUA.hsk.hsr;
        String[] strArr = new String[com_tencent_mm_protocal_c_aca.tHE.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = ((avx) com_tencent_mm_protocal_c_aca.tHE.get(i)).tZr;
        }
        return strArr;
    }

    public final String bHK() {
        w.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", ((aca) this.gUA.hsk.hsr).tHF, bg.bJZ());
        return ((aca) this.gUA.hsk.hsr).tHF;
    }

    public final aca bCr() {
        int i = 1;
        if (SubCoreSandBox.oVx) {
            aca com_tencent_mm_protocal_c_aca = (aca) this.gUA.hsk.hsr;
            com_tencent_mm_protocal_c_aca.tHG = 1;
            com_tencent_mm_protocal_c_aca.tHH = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
            if (!SubCoreSandBox.oVy) {
                i = 0;
            }
            com_tencent_mm_protocal_c_aca.tHI = i;
        }
        return (aca) this.gUA.hsk.hsr;
    }
}
