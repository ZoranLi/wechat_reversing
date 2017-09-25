package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bba extends a {
    public int jOc;
    public int ogM;
    public String opI;
    public String tNz;
    public int tQU;
    public int tfW;
    public String tgG;
    public int ubJ;
    public int ubK;
    public int ubL;
    public long ubM;
    public long ubN;
    public int ubP;
    public String uce;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgG != null) {
                aVar.e(1, this.tgG);
            }
            if (this.tNz != null) {
                aVar.e(2, this.tNz);
            }
            aVar.eO(3, this.tfW);
            aVar.eO(4, this.jOc);
            if (this.opI != null) {
                aVar.e(5, this.opI);
            }
            aVar.eO(6, this.ogM);
            aVar.eO(7, this.ubK);
            aVar.eO(8, this.ubJ);
            if (this.uce != null) {
                aVar.e(9, this.uce);
            }
            aVar.eO(10, this.ubL);
            aVar.O(11, this.ubM);
            aVar.O(12, this.ubN);
            aVar.eO(13, this.tQU);
            aVar.eO(14, this.ubP);
            return 0;
        } else if (i == 1) {
            if (this.tgG != null) {
                r0 = a.a.a.b.b.a.f(1, this.tgG) + 0;
            } else {
                r0 = 0;
            }
            if (this.tNz != null) {
                r0 += a.a.a.b.b.a.f(2, this.tNz);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tfW)) + a.a.a.a.eL(4, this.jOc);
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(5, this.opI);
            }
            r0 = ((r0 + a.a.a.a.eL(6, this.ogM)) + a.a.a.a.eL(7, this.ubK)) + a.a.a.a.eL(8, this.ubJ);
            if (this.uce != null) {
                r0 += a.a.a.b.b.a.f(9, this.uce);
            }
            return ((((r0 + a.a.a.a.eL(10, this.ubL)) + a.a.a.a.N(11, this.ubM)) + a.a.a.a.N(12, this.ubN)) + a.a.a.a.eL(13, this.tQU)) + a.a.a.a.eL(14, this.ubP);
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
            bba com_tencent_mm_protocal_c_bba = (bba) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bba.tgG = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bba.tNz = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bba.tfW = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bba.jOc = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bba.opI = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bba.ogM = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bba.ubK = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bba.ubJ = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bba.uce = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bba.ubL = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bba.ubM = aVar3.xmD.mM();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bba.ubN = aVar3.xmD.mM();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bba.tQU = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bba.ubP = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
