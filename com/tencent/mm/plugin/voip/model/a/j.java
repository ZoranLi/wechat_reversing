package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bln;
import com.tencent.mm.protocal.c.blo;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class j extends n<bln, blo> {
    public j(long j, long j2, int i, String str, String str2, int i2, int i3, int[] iArr) {
        a aVar = new a();
        aVar.hsm = new bln();
        aVar.hsn = new blo();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedresult";
        aVar.hsl = 901;
        aVar.hso = 901;
        aVar.hsp = 1000000901;
        this.gUA = aVar.BE();
        bln com_tencent_mm_protocal_c_bln = (bln) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bln.ulr = j;
        com_tencent_mm_protocal_c_bln.tvM = j2;
        com_tencent_mm_protocal_c_bln.trD = i;
        com_tencent_mm_protocal_c_bln.uls = new avx().OV(str);
        com_tencent_mm_protocal_c_bln.ult = new avx().OV(str2);
        com_tencent_mm_protocal_c_bln.tld = 0.0d;
        com_tencent_mm_protocal_c_bln.tle = 0.0d;
        com_tencent_mm_protocal_c_bln.tvL = i2;
        com_tencent_mm_protocal_c_bln.ulu = i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            bda com_tencent_mm_protocal_c_bda = new bda();
            int i6 = i4 + 1;
            com_tencent_mm_protocal_c_bda.udQ = iArr[i4];
            i4 = i6 + 1;
            com_tencent_mm_protocal_c_bda.udR = iArr[i6];
            i6 = i4 + 1;
            com_tencent_mm_protocal_c_bda.udS = iArr[i4];
            com_tencent_mm_protocal_c_bda.udT = new bjx();
            int i7 = i6 + 1;
            com_tencent_mm_protocal_c_bda.udT.ufq = iArr[i6];
            i4 = i7 + 1;
            com_tencent_mm_protocal_c_bda.udT.tVV = iArr[i7];
            i6 = i4 + 1;
            com_tencent_mm_protocal_c_bda.udU = iArr[i4];
            i4 = i6 + 1;
            com_tencent_mm_protocal_c_bda.udV = iArr[i6];
            i6 = i4 + 1;
            com_tencent_mm_protocal_c_bda.udW = iArr[i4];
            i4 = i6 + 1;
            com_tencent_mm_protocal_c_bda.udX = iArr[i6];
            for (i6 = 0; i6 < com_tencent_mm_protocal_c_bda.udX; i6++) {
                if (i4 < iArr.length) {
                    i7 = i4 + 1;
                    com_tencent_mm_protocal_c_bda.udY.add(Integer.valueOf(iArr[i4]));
                    i4 = i7;
                }
            }
            if (i4 < iArr.length) {
                i6 = i4 + 1;
                com_tencent_mm_protocal_c_bda.udZ = iArr[i4];
                i4 = i6;
            }
            for (i6 = 0; i6 < com_tencent_mm_protocal_c_bda.udZ; i6++) {
                if (i4 < iArr.length) {
                    i7 = i4 + 1;
                    com_tencent_mm_protocal_c_bda.uea.add(Integer.valueOf(iArr[i4]));
                    i4 = i7;
                }
            }
            if (i4 < iArr.length) {
                i6 = i4 + 1;
                com_tencent_mm_protocal_c_bda.ueb = iArr[i4];
                i4 = i6;
            }
            for (i6 = 0; i6 < com_tencent_mm_protocal_c_bda.ueb; i6++) {
                if (i4 < iArr.length) {
                    i7 = i4 + 1;
                    com_tencent_mm_protocal_c_bda.uec.add(Integer.valueOf(iArr[i4]));
                    i4 = i7;
                }
            }
            com_tencent_mm_protocal_c_bln.tEZ.add(com_tencent_mm_protocal_c_bda);
        }
    }

    public final int getType() {
        return 901;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ j rjA;

            {
                this.rjA = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + i + " errCode=" + i2 + " errMsg=" + str);
                this.rjA.rgj.bpg();
            }
        };
    }
}
