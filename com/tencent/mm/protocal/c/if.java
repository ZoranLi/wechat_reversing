package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class if extends a {
    public int leD;
    public int tmF;
    public int tmG;
    public int tmH;
    public int tmI;
    public LinkedList<avx> tmJ = new LinkedList();
    public String tmK;
    public avw tmL;
    public int tmM;
    public int tmN;
    public LinkedList<avx> tmO = new LinkedList();
    public LinkedList<ig> tmP = new LinkedList();
    public LinkedList<ig> tmQ = new LinkedList();
    public int tmR;
    public int tmS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tmL == null) {
                throw new b("Not all required fields were included: AuthKey");
            }
            aVar.eO(1, this.tmF);
            aVar.eO(2, this.leD);
            aVar.eO(3, this.tmG);
            aVar.eO(4, this.tmH);
            aVar.eO(5, this.tmI);
            aVar.d(6, 8, this.tmJ);
            if (this.tmK != null) {
                aVar.e(7, this.tmK);
            }
            if (this.tmL != null) {
                aVar.eQ(8, this.tmL.aUk());
                this.tmL.a(aVar);
            }
            aVar.eO(9, this.tmM);
            aVar.eO(10, this.tmN);
            aVar.d(11, 8, this.tmO);
            aVar.d(12, 8, this.tmP);
            aVar.d(13, 8, this.tmQ);
            aVar.eO(14, this.tmR);
            aVar.eO(15, this.tmS);
            return 0;
        } else if (i == 1) {
            r0 = (((((a.a.a.a.eL(1, this.tmF) + 0) + a.a.a.a.eL(2, this.leD)) + a.a.a.a.eL(3, this.tmG)) + a.a.a.a.eL(4, this.tmH)) + a.a.a.a.eL(5, this.tmI)) + a.a.a.a.c(6, 8, this.tmJ);
            if (this.tmK != null) {
                r0 += a.a.a.b.b.a.f(7, this.tmK);
            }
            if (this.tmL != null) {
                r0 += a.a.a.a.eN(8, this.tmL.aUk());
            }
            return ((((((r0 + a.a.a.a.eL(9, this.tmM)) + a.a.a.a.eL(10, this.tmN)) + a.a.a.a.c(11, 8, this.tmO)) + a.a.a.a.c(12, 8, this.tmP)) + a.a.a.a.c(13, 8, this.tmQ)) + a.a.a.a.eL(14, this.tmR)) + a.a.a.a.eL(15, this.tmS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tmJ.clear();
            this.tmO.clear();
            this.tmP.clear();
            this.tmQ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tmL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            if ifVar = (if) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ifVar.tmF = aVar3.xmD.mL();
                    return 0;
                case 2:
                    ifVar.leD = aVar3.xmD.mL();
                    return 0;
                case 3:
                    ifVar.tmG = aVar3.xmD.mL();
                    return 0;
                case 4:
                    ifVar.tmH = aVar3.xmD.mL();
                    return 0;
                case 5:
                    ifVar.tmI = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ifVar.tmJ.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 7:
                    ifVar.tmK = aVar3.xmD.readString();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ifVar.tmL = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 9:
                    ifVar.tmM = aVar3.xmD.mL();
                    return 0;
                case 10:
                    ifVar.tmN = aVar3.xmD.mL();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ifVar.tmO.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new ig();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ifVar.tmP.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new ig();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        ifVar.tmQ.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 14:
                    ifVar.tmR = aVar3.xmD.mL();
                    return 0;
                case 15:
                    ifVar.tmS = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
