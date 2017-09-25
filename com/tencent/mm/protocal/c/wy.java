package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class wy extends a implements bah {
    public int tDD;
    public int tDE;
    public int tDF;
    public LinkedList<bds> tDG = new LinkedList();
    public LinkedList<bds> tDH = new LinkedList();
    public LinkedList<bds> tDI = new LinkedList();
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
            aVar.eO(11, this.tDD);
            aVar.eO(12, this.tDE);
            aVar.eO(13, this.tDF);
            aVar.d(14, 8, this.tDG);
            aVar.d(15, 8, this.tDH);
            aVar.d(16, 8, this.tDI);
            if (this.trT != null) {
                aVar.eQ(17, this.trT.aUk());
                this.trT.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((((((((((((((a.a.a.a.eL(1, this.thX) + 0) + a.a.a.a.eL(2, this.trK)) + a.a.a.a.eL(3, this.trL)) + a.a.a.a.eL(4, this.trM)) + a.a.a.a.c(5, 8, this.trN)) + a.a.a.a.c(6, 8, this.trO)) + a.a.a.a.c(7, 8, this.trP)) + a.a.a.a.eL(8, this.trQ)) + a.a.a.a.eL(9, this.trR)) + a.a.a.a.eL(10, this.trS)) + a.a.a.a.eL(11, this.tDD)) + a.a.a.a.eL(12, this.tDE)) + a.a.a.a.eL(13, this.tDF)) + a.a.a.a.c(14, 8, this.tDG)) + a.a.a.a.c(15, 8, this.tDH)) + a.a.a.a.c(16, 8, this.tDI);
            if (this.trT != null) {
                return r0 + a.a.a.a.eN(17, this.trT.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.trN.clear();
            this.trO.clear();
            this.trP.clear();
            this.tDG.clear();
            this.tDH.clear();
            this.tDI.clear();
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
            wy wyVar = (wy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_bds;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    wyVar.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    wyVar.trK = aVar3.xmD.mL();
                    return 0;
                case 3:
                    wyVar.trL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    wyVar.trM = aVar3.xmD.mL();
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
                        wyVar.trN.add(com_tencent_mm_protocal_c_bds);
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
                        wyVar.trO.add(com_tencent_mm_protocal_c_bds);
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
                        wyVar.trP.add(com_tencent_mm_protocal_c_bds);
                    }
                    return 0;
                case 8:
                    wyVar.trQ = aVar3.xmD.mL();
                    return 0;
                case 9:
                    wyVar.trR = aVar3.xmD.mL();
                    return 0;
                case 10:
                    wyVar.trS = aVar3.xmD.mL();
                    return 0;
                case 11:
                    wyVar.tDD = aVar3.xmD.mL();
                    return 0;
                case 12:
                    wyVar.tDE = aVar3.xmD.mL();
                    return 0;
                case 13:
                    wyVar.tDF = aVar3.xmD.mL();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bds = new bds();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bds.a(aVar4, com_tencent_mm_protocal_c_bds, a.a(aVar4))) {
                        }
                        wyVar.tDG.add(com_tencent_mm_protocal_c_bds);
                    }
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bds = new bds();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bds.a(aVar4, com_tencent_mm_protocal_c_bds, a.a(aVar4))) {
                        }
                        wyVar.tDH.add(com_tencent_mm_protocal_c_bds);
                    }
                    return 0;
                case 16:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bds = new bds();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bds.a(aVar4, com_tencent_mm_protocal_c_bds, a.a(aVar4))) {
                        }
                        wyVar.tDI.add(com_tencent_mm_protocal_c_bds);
                    }
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bds = new aez();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bds.a(aVar4, com_tencent_mm_protocal_c_bds, a.a(aVar4))) {
                        }
                        wyVar.trT = com_tencent_mm_protocal_c_bds;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
