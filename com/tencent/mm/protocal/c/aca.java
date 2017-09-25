package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aca extends avp {
    public String tHA;
    public int tHB;
    public String tHC;
    public int tHD;
    public LinkedList<avx> tHE = new LinkedList();
    public String tHF;
    public int tHG;
    public String tHH;
    public int tHI;
    public avw tHJ;
    public int tHz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.eO(2, this.tHz);
            if (this.tHA != null) {
                aVar.e(3, this.tHA);
            }
            aVar.eO(4, this.tHB);
            if (this.tHC != null) {
                aVar.e(5, this.tHC);
            }
            aVar.eO(6, this.tHD);
            aVar.d(7, 8, this.tHE);
            if (this.tHF != null) {
                aVar.e(8, this.tHF);
            }
            aVar.eO(9, this.tHG);
            if (this.tHH != null) {
                aVar.e(10, this.tHH);
            }
            aVar.eO(11, this.tHI);
            if (this.tHJ == null) {
                return 0;
            }
            aVar.eQ(12, this.tHJ.aUk());
            this.tHJ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tHz);
            if (this.tHA != null) {
                r0 += a.a.a.b.b.a.f(3, this.tHA);
            }
            r0 += a.a.a.a.eL(4, this.tHB);
            if (this.tHC != null) {
                r0 += a.a.a.b.b.a.f(5, this.tHC);
            }
            r0 = (r0 + a.a.a.a.eL(6, this.tHD)) + a.a.a.a.c(7, 8, this.tHE);
            if (this.tHF != null) {
                r0 += a.a.a.b.b.a.f(8, this.tHF);
            }
            r0 += a.a.a.a.eL(9, this.tHG);
            if (this.tHH != null) {
                r0 += a.a.a.b.b.a.f(10, this.tHH);
            }
            r0 += a.a.a.a.eL(11, this.tHI);
            if (this.tHJ != null) {
                r0 += a.a.a.a.eN(12, this.tHJ.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tHE.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aca com_tencent_mm_protocal_c_aca = (aca) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aca.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aca.tHz = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aca.tHA = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aca.tHB = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aca.tHC = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aca.tHD = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aca.tHE.add(enVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aca.tHF = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aca.tHG = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aca.tHH = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aca.tHI = aVar3.xmD.mL();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aca.tHJ = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
