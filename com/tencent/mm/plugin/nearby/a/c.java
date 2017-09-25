package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.ajb;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.h;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class c extends k implements j {
    private final b gUA;
    private e gUD;

    public c(int i, float f, float f2, int i2, int i3, String str, String str2) {
        if (!(i == 1 || i == 2 || i == 3 || i == 4)) {
            w.e("MicroMsg.NetSceneLbsP", "OpCode Error :" + i);
        }
        a aVar = new a();
        aVar.hsm = new aja();
        aVar.hsn = new ajb();
        aVar.uri = "/cgi-bin/micromsg-bin/lbsfind";
        aVar.hsl = JsApiScanCode.CTRL_INDEX;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aja com_tencent_mm_protocal_c_aja = (aja) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aja.tce = i;
        com_tencent_mm_protocal_c_aja.tmZ = f;
        com_tencent_mm_protocal_c_aja.tna = f2;
        com_tencent_mm_protocal_c_aja.twQ = i2;
        com_tencent_mm_protocal_c_aja.twR = str;
        com_tencent_mm_protocal_c_aja.twS = str2;
        com_tencent_mm_protocal_c_aja.twT = i3;
        com_tencent_mm_protocal_c_aja.tNc = new avw().bb(d.nZC.aPl());
        w.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i2 + " gpsSource:" + i3 + " mac" + str + " cell:" + str2 + " ccdLen:" + com_tencent_mm_protocal_c_aja.tNc.tZn);
        n.a(MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN, f, f2, i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return JsApiScanCode.CTRL_INDEX;
    }

    public final int AJ() {
        return ((aja) this.gUA.hsj.hsr).tce;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ajb com_tencent_mm_protocal_c_ajb = (ajb) ((b) pVar).hsk.hsr;
        List arrayList = new ArrayList();
        for (int i4 = 0; i4 < com_tencent_mm_protocal_c_ajb.tDS.size(); i4++) {
            h hVar = new h();
            hVar.username = ((aiw) com_tencent_mm_protocal_c_ajb.tDS.get(i4)).jNj;
            hVar.gkq = ((aiw) com_tencent_mm_protocal_c_ajb.tDS.get(i4)).tfg;
            hVar.hrB = ((aiw) com_tencent_mm_protocal_c_ajb.tDS.get(i4)).tqb;
            hVar.hrA = ((aiw) com_tencent_mm_protocal_c_ajb.tDS.get(i4)).tqc;
            hVar.aV(true);
            arrayList.add(hVar);
        }
        com.tencent.mm.x.n.Bm().z(arrayList);
        if (AJ() == 1 || AJ() == 3 || AJ() == 4) {
            if (i2 == 0 || i3 != -2001) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(8210, Long.valueOf(System.currentTimeMillis() + ((long) (com_tencent_mm_protocal_c_ajb.tNd * 1000))));
            } else {
                ap.yY();
                com.tencent.mm.u.c.vr().set(8210, Long.valueOf(0));
                this.gUD.a(i2, i3, str, this);
                return;
            }
        } else if (AJ() == 2) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(8210, Long.valueOf(0));
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final boolean aOD() {
        return ((ajb) this.gUA.hsk.hsr).tNe == 1;
    }

    public final int aOE() {
        return ((ajb) this.gUA.hsk.hsr).tNf;
    }

    public final List<aiw> aOF() {
        List<aiw> list = ((ajb) this.gUA.hsk.hsr).tDS;
        if (list != null) {
            for (aiw com_tencent_mm_protocal_c_aiw : list) {
                ap.yY();
                com.tencent.mm.u.c.xB().eI(com_tencent_mm_protocal_c_aiw.jNj, com_tencent_mm_protocal_c_aiw.tBM);
            }
        }
        return list;
    }
}
