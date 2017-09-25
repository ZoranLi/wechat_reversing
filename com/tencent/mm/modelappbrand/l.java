package com.tencent.mm.modelappbrand;

import com.tencent.mm.as.a;
import com.tencent.mm.as.d;
import com.tencent.mm.e.a.ho;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aiz;
import com.tencent.mm.protocal.c.bmr;
import com.tencent.mm.protocal.c.bms;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class l extends a implements j {
    private e gWW;
    private final b hpV;
    private bms hpW;

    public l(d.b bVar) {
        this.hPh = bVar.fDs;
        this.wa = bVar.offset;
        this.hPi = bVar.scene;
        b.a aVar = new b.a();
        aVar.hsm = new bmr();
        aVar.hsn = new bms();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearch";
        aVar.hsl = 1162;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hpV = aVar.BE();
        bmr com_tencent_mm_protocal_c_bmr = (bmr) this.hpV.hsj.hsr;
        aiz AU = AU();
        com_tencent_mm_protocal_c_bmr.jOc = bVar.hPq;
        com_tencent_mm_protocal_c_bmr.tDX = bVar.fDs;
        com_tencent_mm_protocal_c_bmr.tll = bVar.offset;
        com_tencent_mm_protocal_c_bmr.tmb = bVar.hPt;
        com_tencent_mm_protocal_c_bmr.umg = bVar.hPz;
        com.tencent.mm.sdk.b.b hoVar = new ho();
        com.tencent.mm.sdk.b.a.urY.m(hoVar);
        com_tencent_mm_protocal_c_bmr.umf = hoVar.fNc.fNd;
        if (AU != null) {
            com_tencent_mm_protocal_c_bmr.umh = (double) AU.tmZ;
            com_tencent_mm_protocal_c_bmr.umi = (double) AU.tna;
        }
        com_tencent_mm_protocal_c_bmr.umj = b.hpQ;
        com_tencent_mm_protocal_c_bmr.umm = bVar.hPv;
        com_tencent_mm_protocal_c_bmr.umn = bVar.hPA;
        com_tencent_mm_protocal_c_bmr.umo = bVar.hPB;
        com_tencent_mm_protocal_c_bmr.umk = b.hpR;
        com_tencent_mm_protocal_c_bmr.tVQ = bVar.hPr;
        w.i("MicroMsg.NetSceneWeAppSearch", "NetSceneWeAppSearch oreh SessionID : %s, KeywordID : %s, LocationX : %s, LocationY : %s", new Object[]{com_tencent_mm_protocal_c_bmr.umj, com_tencent_mm_protocal_c_bmr.umk, Double.valueOf(com_tencent_mm_protocal_c_bmr.umh), Double.valueOf(com_tencent_mm_protocal_c_bmr.umi)});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneWeAppSearch", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.hpW = (bms) this.hpV.hsk.hsr;
        if (this.hpW != null) {
            w.v("MicroMsg.NetSceneWeAppSearch", "return data\n%s", new Object[]{this.hpW.tlt});
        }
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1162;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneWeAppSearch", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.hpV, this);
    }

    public final String AS() {
        return this.hpW != null ? this.hpW.tlt : "";
    }

    public final int AT() {
        return this.hpW != null ? this.hpW.ump : 0;
    }

    private static aiz AU() {
        try {
            ap.yY();
            String str = (String) c.vr().get(67591, null);
            if (str != null) {
                aiz com_tencent_mm_protocal_c_aiz = new aiz();
                String[] split = str.split(",");
                com_tencent_mm_protocal_c_aiz.twQ = Integer.valueOf(split[0]).intValue();
                com_tencent_mm_protocal_c_aiz.twT = Integer.valueOf(split[1]).intValue();
                com_tencent_mm_protocal_c_aiz.tna = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                com_tencent_mm_protocal_c_aiz.tmZ = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                w.i("MicroMsg.NetSceneWeAppSearch", "lbs location is not null, %f, %f", new Object[]{Float.valueOf(com_tencent_mm_protocal_c_aiz.tna), Float.valueOf(com_tencent_mm_protocal_c_aiz.tmZ)});
                return com_tencent_mm_protocal_c_aiz;
            }
            w.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            w.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, reason %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
