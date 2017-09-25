package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bcn extends avh {
    public int jOc;
    public String mtb;
    public int tPE;
    public int tPF;
    public int tQZ;
    public bfw tVq;
    public String teW;
    public int tgJ;
    public int tgK;
    public String tgT;
    public avw tij;
    public int trD;
    public String tuy;
    public int udC;
    public int udD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tij == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.jOc);
            aVar.eO(3, this.tgK);
            aVar.eO(4, this.tgJ);
            if (this.tij != null) {
                aVar.eQ(5, this.tij.aUk());
                this.tij.a(aVar);
            }
            if (this.teW != null) {
                aVar.e(6, this.teW);
            }
            aVar.eO(7, this.tPE);
            aVar.eO(8, this.tPF);
            if (this.tgT != null) {
                aVar.e(9, this.tgT);
            }
            aVar.eO(10, this.udC);
            aVar.eO(11, this.trD);
            if (this.tVq != null) {
                aVar.eQ(12, this.tVq.aUk());
                this.tVq.a(aVar);
            }
            if (this.mtb != null) {
                aVar.e(13, this.mtb);
            }
            aVar.eO(14, this.tQZ);
            if (this.tuy != null) {
                aVar.e(15, this.tuy);
            }
            aVar.eO(16, this.udD);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.eL(2, this.jOc)) + a.a.a.a.eL(3, this.tgK)) + a.a.a.a.eL(4, this.tgJ);
            if (this.tij != null) {
                r0 += a.a.a.a.eN(5, this.tij.aUk());
            }
            if (this.teW != null) {
                r0 += a.a.a.b.b.a.f(6, this.teW);
            }
            r0 = (r0 + a.a.a.a.eL(7, this.tPE)) + a.a.a.a.eL(8, this.tPF);
            if (this.tgT != null) {
                r0 += a.a.a.b.b.a.f(9, this.tgT);
            }
            r0 = (r0 + a.a.a.a.eL(10, this.udC)) + a.a.a.a.eL(11, this.trD);
            if (this.tVq != null) {
                r0 += a.a.a.a.eN(12, this.tVq.aUk());
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(13, this.mtb);
            }
            r0 += a.a.a.a.eL(14, this.tQZ);
            if (this.tuy != null) {
                r0 += a.a.a.b.b.a.f(15, this.tuy);
            }
            return r0 + a.a.a.a.eL(16, this.udD);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tij != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bcn com_tencent_mm_protocal_c_bcn = (bcn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcn.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcn.jOc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bcn.tgK = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcn.tgJ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcn.tij = emVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcn.teW = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bcn.tPE = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcn.tPF = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bcn.tgT = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bcn.udC = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bcn.trD = aVar3.xmD.mL();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bfw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcn.tVq = emVar;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bcn.mtb = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bcn.tQZ = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bcn.tuy = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bcn.udD = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
