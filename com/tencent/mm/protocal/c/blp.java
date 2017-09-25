package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class blp extends avh {
    public int trD;
    public int tvL;
    public int ued;
    public int uee;
    public int uef;
    public int ueg;
    public int ueh;
    public LinkedList<Integer> uei = new LinkedList();
    public int uej;
    public int uek;
    public LinkedList<Integer> uel = new LinkedList();
    public int uem;
    public int uen;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tvL);
            aVar.eO(3, this.ued);
            aVar.eO(4, this.trD);
            aVar.eO(5, this.uee);
            aVar.eO(6, this.uef);
            aVar.eO(7, this.ueg);
            aVar.eO(8, this.ueh);
            aVar.c(9, this.uei);
            aVar.eO(10, this.uej);
            aVar.eO(11, this.uek);
            aVar.c(12, this.uel);
            aVar.eO(13, this.uem);
            aVar.eO(14, this.uen);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return ((((((((((((r0 + a.a.a.a.eL(2, this.tvL)) + a.a.a.a.eL(3, this.ued)) + a.a.a.a.eL(4, this.trD)) + a.a.a.a.eL(5, this.uee)) + a.a.a.a.eL(6, this.uef)) + a.a.a.a.eL(7, this.ueg)) + a.a.a.a.eL(8, this.ueh)) + a.a.a.a.b(9, this.uei)) + a.a.a.a.eL(10, this.uej)) + a.a.a.a.eL(11, this.uek)) + a.a.a.a.b(12, this.uel)) + a.a.a.a.eL(13, this.uem)) + a.a.a.a.eL(14, this.uen);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.uei.clear();
            this.uel.clear();
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
            blp com_tencent_mm_protocal_c_blp = (blp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blp.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blp.tvL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blp.ued = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_blp.trD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_blp.uee = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_blp.uef = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_blp.ueg = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_blp.ueh = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_blp.uei = new a.a.a.a.a(aVar3.cic().sYA, unknownTagHandler).chZ();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_blp.uej = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_blp.uek = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_blp.uel = new a.a.a.a.a(aVar3.cic().sYA, unknownTagHandler).chZ();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_blp.uem = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_blp.uen = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
