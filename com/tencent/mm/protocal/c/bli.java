package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bli extends avp {
    public int tWi;
    public int tvL;
    public long tvM;
    public int ule;
    public LinkedList<bjx> ulf = new LinkedList();
    public int ulg;
    public LinkedList<bjx> ulh = new LinkedList();
    public int uli;
    public LinkedList<bjx> ulj = new LinkedList();
    public int ulk;
    public int ull;

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
            aVar.eO(2, this.tvL);
            aVar.eO(3, this.ule);
            aVar.d(4, 8, this.ulf);
            aVar.eO(5, this.ulg);
            aVar.d(6, 8, this.ulh);
            aVar.O(7, this.tvM);
            aVar.eO(8, this.tWi);
            aVar.eO(9, this.uli);
            aVar.d(10, 8, this.ulj);
            aVar.eO(11, this.ulk);
            aVar.eO(12, this.ull);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return ((((((((((r0 + a.a.a.a.eL(2, this.tvL)) + a.a.a.a.eL(3, this.ule)) + a.a.a.a.c(4, 8, this.ulf)) + a.a.a.a.eL(5, this.ulg)) + a.a.a.a.c(6, 8, this.ulh)) + a.a.a.a.N(7, this.tvM)) + a.a.a.a.eL(8, this.tWi)) + a.a.a.a.eL(9, this.uli)) + a.a.a.a.c(10, 8, this.ulj)) + a.a.a.a.eL(11, this.ulk)) + a.a.a.a.eL(12, this.ull);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ulf.clear();
            this.ulh.clear();
            this.ulj.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
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
            bli com_tencent_mm_protocal_c_bli = (bli) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bli.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bli.tvL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bli.ule = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bjx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bli.ulf.add(enVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bli.ulg = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bjx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bli.ulh.add(enVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bli.tvM = aVar3.xmD.mM();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bli.tWi = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bli.uli = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bjx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bli.ulj.add(enVar);
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bli.ulk = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bli.ull = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
