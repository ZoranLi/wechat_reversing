package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class lm extends a implements bah {
    public int thX;
    public int trK;
    public int trL;
    public int trM;
    public LinkedList<bds> trN = new LinkedList();
    public LinkedList<bds> trO = new LinkedList();
    public LinkedList<bds> trP = new LinkedList();
    public int trQ;
    public int trR;
    public int trS;
    public aez trT;

    public final int getRet() {
        return this.thX;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.thX);
            aVar.eO(2, this.trK);
            aVar.eO(3, this.trL);
            aVar.eO(4, this.trM);
            aVar.d(5, 8, this.trN);
            aVar.d(6, 8, this.trO);
            aVar.d(7, 8, this.trP);
            aVar.eO(8, this.trQ);
            aVar.eO(9, this.trR);
            aVar.eO(10, this.trS);
            if (this.trT != null) {
                aVar.eQ(11, this.trT.aUk());
                this.trT.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((((((((a.a.a.a.eL(1, this.thX) + 0) + a.a.a.a.eL(2, this.trK)) + a.a.a.a.eL(3, this.trL)) + a.a.a.a.eL(4, this.trM)) + a.a.a.a.c(5, 8, this.trN)) + a.a.a.a.c(6, 8, this.trO)) + a.a.a.a.c(7, 8, this.trP)) + a.a.a.a.eL(8, this.trQ)) + a.a.a.a.eL(9, this.trR)) + a.a.a.a.eL(10, this.trS);
            if (this.trT != null) {
                return r0 + a.a.a.a.eN(11, this.trT.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.trN.clear();
            this.trO.clear();
            this.trP.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            lm lmVar = (lm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_bds;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    lmVar.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    lmVar.trK = aVar3.xmD.mL();
                    return 0;
                case 3:
                    lmVar.trL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    lmVar.trM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bds = new bds();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bds.a(aVar4, com_tencent_mm_protocal_c_bds, a.a(aVar4))) {
                        }
                        lmVar.trN.add(com_tencent_mm_protocal_c_bds);
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bds = new bds();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bds.a(aVar4, com_tencent_mm_protocal_c_bds, a.a(aVar4))) {
                        }
                        lmVar.trO.add(com_tencent_mm_protocal_c_bds);
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bds = new bds();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bds.a(aVar4, com_tencent_mm_protocal_c_bds, a.a(aVar4))) {
                        }
                        lmVar.trP.add(com_tencent_mm_protocal_c_bds);
                    }
                    return 0;
                case 8:
                    lmVar.trQ = aVar3.xmD.mL();
                    return 0;
                case 9:
                    lmVar.trR = aVar3.xmD.mL();
                    return 0;
                case 10:
                    lmVar.trS = aVar3.xmD.mL();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bds = new aez();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bds.a(aVar4, com_tencent_mm_protocal_c_bds, a.a(aVar4))) {
                        }
                        lmVar.trT = com_tencent_mm_protocal_c_bds;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
