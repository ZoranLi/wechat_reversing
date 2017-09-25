package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ash extends a {
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
    public String jNj;
    public String jOp;
    public String tBM;
    public bcp tMV;
    public my tMW;
    public int tWG;
    public String tWH;
    public int tWI;
    public String tWJ;
    public String tqb;
    public String tqc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tWG);
            if (this.jNj != null) {
                aVar.e(2, this.jNj);
            }
            if (this.jOp != null) {
                aVar.e(3, this.jOp);
            }
            if (this.tWH != null) {
                aVar.e(4, this.tWH);
            }
            aVar.eO(5, this.tWI);
            if (this.tWJ != null) {
                aVar.e(6, this.tWJ);
            }
            aVar.eO(7, this.hAD);
            if (this.hAE != null) {
                aVar.e(8, this.hAE);
            }
            if (this.hAF != null) {
                aVar.e(9, this.hAF);
            }
            if (this.hAG != null) {
                aVar.e(10, this.hAG);
            }
            aVar.eO(11, this.hAH);
            if (this.hAI != null) {
                aVar.e(12, this.hAI);
            }
            aVar.eO(13, this.hAJ);
            aVar.eO(14, this.hAK);
            if (this.hAL != null) {
                aVar.e(15, this.hAL);
            }
            if (this.tMV != null) {
                aVar.eQ(16, this.tMV.aUk());
                this.tMV.a(aVar);
            }
            if (this.hAM != null) {
                aVar.e(17, this.hAM);
            }
            if (this.hAN != null) {
                aVar.e(18, this.hAN);
            }
            if (this.tMW != null) {
                aVar.eQ(19, this.tMW.aUk());
                this.tMW.a(aVar);
            }
            if (this.tqb != null) {
                aVar.e(20, this.tqb);
            }
            if (this.tqc != null) {
                aVar.e(21, this.tqc);
            }
            if (this.tBM != null) {
                aVar.e(22, this.tBM);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tWG) + 0;
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(3, this.jOp);
            }
            if (this.tWH != null) {
                r0 += a.a.a.b.b.a.f(4, this.tWH);
            }
            r0 += a.a.a.a.eL(5, this.tWI);
            if (this.tWJ != null) {
                r0 += a.a.a.b.b.a.f(6, this.tWJ);
            }
            r0 += a.a.a.a.eL(7, this.hAD);
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(8, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(9, this.hAF);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(10, this.hAG);
            }
            r0 += a.a.a.a.eL(11, this.hAH);
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(12, this.hAI);
            }
            r0 = (r0 + a.a.a.a.eL(13, this.hAJ)) + a.a.a.a.eL(14, this.hAK);
            if (this.hAL != null) {
                r0 += a.a.a.b.b.a.f(15, this.hAL);
            }
            if (this.tMV != null) {
                r0 += a.a.a.a.eN(16, this.tMV.aUk());
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(17, this.hAM);
            }
            if (this.hAN != null) {
                r0 += a.a.a.b.b.a.f(18, this.hAN);
            }
            if (this.tMW != null) {
                r0 += a.a.a.a.eN(19, this.tMW.aUk());
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(20, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(21, this.tqc);
            }
            if (this.tBM != null) {
                return r0 + a.a.a.b.b.a.f(22, this.tBM);
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
            ash com_tencent_mm_protocal_c_ash = (ash) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bcp;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ash.tWG = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ash.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ash.jOp = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ash.tWH = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ash.tWI = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ash.tWJ = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ash.hAD = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ash.hAE = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ash.hAF = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ash.hAG = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ash.hAH = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ash.hAI = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ash.hAJ = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ash.hAK = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ash.hAL = aVar3.xmD.readString();
                    return 0;
                case 16:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bcp = new bcp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcp.a(aVar4, com_tencent_mm_protocal_c_bcp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ash.tMV = com_tencent_mm_protocal_c_bcp;
                    }
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ash.hAM = aVar3.xmD.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ash.hAN = aVar3.xmD.readString();
                    return 0;
                case 19:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bcp = new my();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcp.a(aVar4, com_tencent_mm_protocal_c_bcp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ash.tMW = com_tencent_mm_protocal_c_bcp;
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ash.tqb = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ash.tqc = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_ash.tBM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
