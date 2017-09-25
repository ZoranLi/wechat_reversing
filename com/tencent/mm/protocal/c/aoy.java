package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public class aoy extends a {
    public String hAE;
    public String hAF;
    public String msj;
    public String nXf;
    public String tTU;
    public String tTV;
    public String tTW;
    public String tTX;
    public double tld;
    public double tle;
    public String tth;
    public String tti;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msj != null) {
                aVar.e(1, this.msj);
            }
            if (this.tTU != null) {
                aVar.e(2, this.tTU);
            }
            aVar.a(3, this.tld);
            aVar.a(4, this.tle);
            if (this.tTV != null) {
                aVar.e(5, this.tTV);
            }
            if (this.nXf != null) {
                aVar.e(6, this.nXf);
            }
            if (this.tTW != null) {
                aVar.e(7, this.tTW);
            }
            if (this.hAE != null) {
                aVar.e(8, this.hAE);
            }
            if (this.hAF != null) {
                aVar.e(9, this.hAF);
            }
            if (this.tth != null) {
                aVar.e(10, this.tth);
            }
            if (this.tti != null) {
                aVar.e(11, this.tti);
            }
            if (this.tTX == null) {
                return 0;
            }
            aVar.e(12, this.tTX);
            return 0;
        } else if (i == 1) {
            if (this.msj != null) {
                r0 = a.a.a.b.b.a.f(1, this.msj) + 0;
            } else {
                r0 = 0;
            }
            if (this.tTU != null) {
                r0 += a.a.a.b.b.a.f(2, this.tTU);
            }
            r0 = (r0 + (a.a.a.b.b.a.cH(3) + 8)) + (a.a.a.b.b.a.cH(4) + 8);
            if (this.tTV != null) {
                r0 += a.a.a.b.b.a.f(5, this.tTV);
            }
            if (this.nXf != null) {
                r0 += a.a.a.b.b.a.f(6, this.nXf);
            }
            if (this.tTW != null) {
                r0 += a.a.a.b.b.a.f(7, this.tTW);
            }
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(8, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(9, this.hAF);
            }
            if (this.tth != null) {
                r0 += a.a.a.b.b.a.f(10, this.tth);
            }
            if (this.tti != null) {
                r0 += a.a.a.b.b.a.f(11, this.tti);
            }
            if (this.tTX != null) {
                r0 += a.a.a.b.b.a.f(12, this.tTX);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aoy com_tencent_mm_protocal_c_aoy = (aoy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aoy.msj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aoy.tTU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aoy.tld = aVar3.xmD.readDouble();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aoy.tle = aVar3.xmD.readDouble();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aoy.tTV = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aoy.nXf = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aoy.tTW = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aoy.hAE = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aoy.hAF = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aoy.tth = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aoy.tti = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aoy.tTX = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
