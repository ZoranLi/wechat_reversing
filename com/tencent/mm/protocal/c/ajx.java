package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ajx extends a {
    public String hAC;
    public int hAD;
    public String hAE;
    public String hAF;
    public String hAG;
    public int hAH;
    public String hAI;
    public int hAJ;
    public int hAK;
    public String hAL;
    public String hAM;
    public String hAN;
    public String tBM;
    public bcp tMV;
    public my tMW;
    public qq tNA;
    public String tNz;
    public String tgG;
    public String tqb;
    public String tqc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgG != null) {
                aVar.e(1, this.tgG);
            }
            if (this.tNz != null) {
                aVar.e(2, this.tNz);
            }
            if (this.hAC != null) {
                aVar.e(3, this.hAC);
            }
            aVar.eO(4, this.hAD);
            if (this.hAE != null) {
                aVar.e(5, this.hAE);
            }
            if (this.hAF != null) {
                aVar.e(6, this.hAF);
            }
            if (this.hAG != null) {
                aVar.e(7, this.hAG);
            }
            aVar.eO(8, this.hAH);
            if (this.hAI != null) {
                aVar.e(9, this.hAI);
            }
            if (this.tNA != null) {
                aVar.eQ(10, this.tNA.aUk());
                this.tNA.a(aVar);
            }
            aVar.eO(11, this.hAJ);
            aVar.eO(12, this.hAK);
            if (this.hAL != null) {
                aVar.e(13, this.hAL);
            }
            if (this.tMV != null) {
                aVar.eQ(14, this.tMV.aUk());
                this.tMV.a(aVar);
            }
            if (this.hAM != null) {
                aVar.e(15, this.hAM);
            }
            if (this.hAN != null) {
                aVar.e(16, this.hAN);
            }
            if (this.tMW != null) {
                aVar.eQ(17, this.tMW.aUk());
                this.tMW.a(aVar);
            }
            if (this.tqb != null) {
                aVar.e(20, this.tqb);
            }
            if (this.tqc != null) {
                aVar.e(21, this.tqc);
            }
            if (this.tBM == null) {
                return 0;
            }
            aVar.e(22, this.tBM);
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
            if (this.hAC != null) {
                r0 += a.a.a.b.b.a.f(3, this.hAC);
            }
            r0 += a.a.a.a.eL(4, this.hAD);
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(5, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(6, this.hAF);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(7, this.hAG);
            }
            r0 += a.a.a.a.eL(8, this.hAH);
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(9, this.hAI);
            }
            if (this.tNA != null) {
                r0 += a.a.a.a.eN(10, this.tNA.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(11, this.hAJ)) + a.a.a.a.eL(12, this.hAK);
            if (this.hAL != null) {
                r0 += a.a.a.b.b.a.f(13, this.hAL);
            }
            if (this.tMV != null) {
                r0 += a.a.a.a.eN(14, this.tMV.aUk());
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(15, this.hAM);
            }
            if (this.hAN != null) {
                r0 += a.a.a.b.b.a.f(16, this.hAN);
            }
            if (this.tMW != null) {
                r0 += a.a.a.a.eN(17, this.tMW.aUk());
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(20, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(21, this.tqc);
            }
            if (this.tBM != null) {
                r0 += a.a.a.b.b.a.f(22, this.tBM);
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
            ajx com_tencent_mm_protocal_c_ajx = (ajx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a qqVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ajx.tgG = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajx.tNz = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajx.hAC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajx.hAD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajx.hAE = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ajx.hAF = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ajx.hAG = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ajx.hAH = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ajx.hAI = aVar3.xmD.readString();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        qqVar = new qq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qqVar.a(aVar4, qqVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajx.tNA = qqVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ajx.hAJ = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ajx.hAK = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ajx.hAL = aVar3.xmD.readString();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        qqVar = new bcp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qqVar.a(aVar4, qqVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajx.tMV = qqVar;
                    }
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ajx.hAM = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ajx.hAN = aVar3.xmD.readString();
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        qqVar = new my();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qqVar.a(aVar4, qqVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajx.tMW = qqVar;
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ajx.tqb = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ajx.tqc = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_ajx.tBM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
