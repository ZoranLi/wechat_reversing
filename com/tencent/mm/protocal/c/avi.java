package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class avi extends a {
    public int sFI;
    public int tEV;
    public int tKt;
    public int tVQ;
    public avl tYO;
    public avk tYP;
    public int tYQ;
    public String tYR;
    public int tYS;
    public int tYT;
    public int tYU;
    public int tmG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tYR == null) {
                throw new b("Not all required fields were included: SampleId");
            }
            aVar.eO(1, this.tVQ);
            if (this.tYO != null) {
                aVar.eQ(2, this.tYO.aUk());
                this.tYO.a(aVar);
            }
            if (this.tYP != null) {
                aVar.eQ(3, this.tYP.aUk());
                this.tYP.a(aVar);
            }
            aVar.eO(4, this.tEV);
            aVar.eO(5, this.tYQ);
            if (this.tYR != null) {
                aVar.e(6, this.tYR);
            }
            aVar.eO(7, this.tmG);
            aVar.eO(8, this.tYS);
            aVar.eO(9, this.sFI);
            aVar.eO(10, this.tYT);
            aVar.eO(11, this.tYU);
            aVar.eO(12, this.tKt);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tVQ) + 0;
            if (this.tYO != null) {
                r0 += a.a.a.a.eN(2, this.tYO.aUk());
            }
            if (this.tYP != null) {
                r0 += a.a.a.a.eN(3, this.tYP.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(4, this.tEV)) + a.a.a.a.eL(5, this.tYQ);
            if (this.tYR != null) {
                r0 += a.a.a.b.b.a.f(6, this.tYR);
            }
            return (((((r0 + a.a.a.a.eL(7, this.tmG)) + a.a.a.a.eL(8, this.tYS)) + a.a.a.a.eL(9, this.sFI)) + a.a.a.a.eL(10, this.tYT)) + a.a.a.a.eL(11, this.tYU)) + a.a.a.a.eL(12, this.tKt);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tYR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SampleId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            avi com_tencent_mm_protocal_c_avi = (avi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avl;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_avi.tVQ = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avl = new avl();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avl.a(aVar4, com_tencent_mm_protocal_c_avl, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avi.tYO = com_tencent_mm_protocal_c_avl;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avl = new avk();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avl.a(aVar4, com_tencent_mm_protocal_c_avl, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avi.tYP = com_tencent_mm_protocal_c_avl;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avi.tEV = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avi.tYQ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avi.tYR = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avi.tmG = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avi.tYS = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_avi.sFI = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_avi.tYT = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_avi.tYU = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_avi.tKt = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
