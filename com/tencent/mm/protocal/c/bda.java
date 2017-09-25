package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bda extends a {
    public int udQ;
    public int udR;
    public int udS;
    public bjx udT;
    public int udU;
    public int udV;
    public int udW;
    public int udX;
    public LinkedList<Integer> udY = new LinkedList();
    public int udZ;
    public LinkedList<Integer> uea = new LinkedList();
    public int ueb;
    public LinkedList<Integer> uec = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.udT == null) {
                throw new b("Not all required fields were included: Addr");
            }
            aVar.eO(1, this.udQ);
            aVar.eO(2, this.udR);
            aVar.eO(3, this.udS);
            if (this.udT != null) {
                aVar.eQ(4, this.udT.aUk());
                this.udT.a(aVar);
            }
            aVar.eO(5, this.udU);
            aVar.eO(6, this.udV);
            aVar.eO(7, this.udW);
            aVar.eO(8, this.udX);
            aVar.c(9, this.udY);
            aVar.eO(10, this.udZ);
            aVar.c(11, this.uea);
            aVar.eO(12, this.ueb);
            aVar.c(13, this.uec);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.udQ) + 0) + a.a.a.a.eL(2, this.udR)) + a.a.a.a.eL(3, this.udS);
            if (this.udT != null) {
                r0 += a.a.a.a.eN(4, this.udT.aUk());
            }
            return ((((((((r0 + a.a.a.a.eL(5, this.udU)) + a.a.a.a.eL(6, this.udV)) + a.a.a.a.eL(7, this.udW)) + a.a.a.a.eL(8, this.udX)) + a.a.a.a.b(9, this.udY)) + a.a.a.a.eL(10, this.udZ)) + a.a.a.a.b(11, this.uea)) + a.a.a.a.eL(12, this.ueb)) + a.a.a.a.b(13, this.uec);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.udY.clear();
            this.uea.clear();
            this.uec.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.udT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Addr");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bda com_tencent_mm_protocal_c_bda = (bda) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bda.udQ = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bda.udR = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bda.udS = aVar3.xmD.mL();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bjx = new bjx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bjx.a(aVar4, com_tencent_mm_protocal_c_bjx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bda.udT = com_tencent_mm_protocal_c_bjx;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bda.udU = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bda.udV = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bda.udW = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bda.udX = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bda.udY = new a.a.a.a.a(aVar3.cic().sYA, unknownTagHandler).chZ();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bda.udZ = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bda.uea = new a.a.a.a.a(aVar3.cic().sYA, unknownTagHandler).chZ();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bda.ueb = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bda.uec = new a.a.a.a.a(aVar3.cic().sYA, unknownTagHandler).chZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
