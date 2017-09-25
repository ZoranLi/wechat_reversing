package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bqy;
import com.tencent.mm.protocal.c.bqz;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ak extends k implements j {
    private e gUD;
    private final b hRS;
    private int retryCount = 3;

    public ak(String str, int i) {
        a aVar = new a();
        aVar.hsm = new bqy();
        aVar.hsn = new bqz();
        aVar.uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
        aVar.hsl = 729;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hRS = aVar.BE();
        bqy com_tencent_mm_protocal_c_bqy = (bqy) this.hRS.hsj.hsr;
        com_tencent_mm_protocal_c_bqy.leO = v.bIN();
        com_tencent_mm_protocal_c_bqy.thA = d.nZC.qx(0);
        com_tencent_mm_protocal_c_bqy.uoV = str;
        com_tencent_mm_protocal_c_bqy.msn = i;
        w.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", com_tencent_mm_protocal_c_bqy.leO, str, Integer.valueOf(i), bg.bJZ());
    }

    public final int getType() {
        return 729;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hRS, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bqy com_tencent_mm_protocal_c_bqy = (bqy) this.hRS.hsj.hsr;
        bqz com_tencent_mm_protocal_c_bqz = (bqz) this.hRS.hsk.hsr;
        w.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(com_tencent_mm_protocal_c_bqz.uoW), com_tencent_mm_protocal_c_bqz.uoX);
        g gVar;
        Object[] objArr;
        if (i2 == 0 && i3 == 0) {
            if (com_tencent_mm_protocal_c_bqz.uoW == 2 || com_tencent_mm_protocal_c_bqz.uoW == 3) {
                this.retryCount--;
                if (this.retryCount <= 0) {
                    w.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
                    g.oUh.a(322, 2, 1, false);
                    gVar = g.oUh;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4002);
                    objArr[1] = String.format("%s,%d", new Object[]{com_tencent_mm_protocal_c_bqy.uoV, Integer.valueOf(com_tencent_mm_protocal_c_bqy.msn)});
                    gVar.i(11098, objArr);
                    this.gUD.a(3, -1, "", this);
                    return;
                }
                w.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", Integer.valueOf(this.retryCount));
                a(this.hsD, this.gUD);
            } else if (com_tencent_mm_protocal_c_bqz.uoW == 1) {
                MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "yyb_pkg_sig_prefs", 4).edit().remove(com_tencent_mm_protocal_c_bqy.uoV).commit();
                g.oUh.a(322, 5, 1, false);
                gVar = g.oUh;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4005);
                objArr[1] = String.format("%s,%d", new Object[]{com_tencent_mm_protocal_c_bqy.uoV, Integer.valueOf(com_tencent_mm_protocal_c_bqy.msn)});
                gVar.i(11098, objArr);
                w.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", com_tencent_mm_protocal_c_bqz.uoX);
            } else if (com_tencent_mm_protocal_c_bqz.uoW == 4) {
                w.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
                g.oUh.a(322, 4, 1, false);
                gVar = g.oUh;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4004);
                objArr[1] = String.format("%s,%d", new Object[]{com_tencent_mm_protocal_c_bqy.uoV, Integer.valueOf(com_tencent_mm_protocal_c_bqy.msn)});
                gVar.i(11098, objArr);
            } else {
                w.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", com_tencent_mm_protocal_c_bqz.uoX);
                MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "yyb_pkg_sig_prefs", 4).edit().putString(com_tencent_mm_protocal_c_bqy.uoV, com_tencent_mm_protocal_c_bqz.uoX).commit();
                g.oUh.a(322, 3, 1, false);
                gVar = g.oUh;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4003);
                objArr[1] = String.format("%s,%d,%s", new Object[]{com_tencent_mm_protocal_c_bqy.uoV, Integer.valueOf(com_tencent_mm_protocal_c_bqy.msn), com_tencent_mm_protocal_c_bqz.uoX});
                gVar.i(11098, objArr);
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        w.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
        g.oUh.a(322, 1, 1, false);
        gVar = g.oUh;
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(4001);
        objArr[1] = String.format("%s,%d,%d,%d", new Object[]{com_tencent_mm_protocal_c_bqy.uoV, Integer.valueOf(com_tencent_mm_protocal_c_bqy.msn), Integer.valueOf(i2), Integer.valueOf(i3)});
        gVar.i(11098, objArr);
        this.gUD.a(i2, i3, str, this);
    }
}
