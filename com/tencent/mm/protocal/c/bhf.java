package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bhf extends avh {
    public int aOD;
    public String fGl;
    public String fwJ;
    public String hiE;
    public String tZC;
    public int ugL;
    public int ugM;
    public String ugN;
    public int ugO;
    public String ugP;
    public LinkedList<bdd> ugQ = new LinkedList();
    public int ugR;
    public int ugS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.fwJ != null) {
                aVar.e(2, this.fwJ);
            }
            if (this.fGl != null) {
                aVar.e(3, this.fGl);
            }
            aVar.eO(4, this.ugL);
            aVar.eO(5, this.ugM);
            aVar.eO(6, this.aOD);
            if (this.ugN != null) {
                aVar.e(7, this.ugN);
            }
            if (this.tZC != null) {
                aVar.e(8, this.tZC);
            }
            if (this.hiE != null) {
                aVar.e(9, this.hiE);
            }
            aVar.eO(10, this.ugO);
            if (this.ugP != null) {
                aVar.e(11, this.ugP);
            }
            aVar.d(12, 8, this.ugQ);
            aVar.eO(13, this.ugR);
            aVar.eO(14, this.ugS);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fwJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.fwJ);
            }
            if (this.fGl != null) {
                r0 += a.a.a.b.b.a.f(3, this.fGl);
            }
            r0 = ((r0 + a.a.a.a.eL(4, this.ugL)) + a.a.a.a.eL(5, this.ugM)) + a.a.a.a.eL(6, this.aOD);
            if (this.ugN != null) {
                r0 += a.a.a.b.b.a.f(7, this.ugN);
            }
            if (this.tZC != null) {
                r0 += a.a.a.b.b.a.f(8, this.tZC);
            }
            if (this.hiE != null) {
                r0 += a.a.a.b.b.a.f(9, this.hiE);
            }
            r0 += a.a.a.a.eL(10, this.ugO);
            if (this.ugP != null) {
                r0 += a.a.a.b.b.a.f(11, this.ugP);
            }
            return ((r0 + a.a.a.a.c(12, 8, this.ugQ)) + a.a.a.a.eL(13, this.ugR)) + a.a.a.a.eL(14, this.ugS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ugQ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhf com_tencent_mm_protocal_c_bhf = (bhf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhf.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhf.fwJ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhf.fGl = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhf.ugL = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhf.ugM = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhf.aOD = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhf.ugN = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhf.tZC = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bhf.hiE = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bhf.ugO = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bhf.ugP = aVar3.xmD.readString();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bdd();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bhf.ugQ.add(emVar);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bhf.ugR = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bhf.ugS = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
