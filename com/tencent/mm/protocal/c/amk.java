package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class amk extends avh {
    public int tRe;
    public LinkedList<amj> tRf = new LinkedList();
    public int tRg;
    public String tRh;
    public int teS;
    public LinkedList<amm> tiQ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.teS);
            aVar.eO(3, this.tRe);
            aVar.d(4, 8, this.tRf);
            aVar.eO(5, this.tRg);
            aVar.d(6, 8, this.tiQ);
            if (this.tRh == null) {
                return 0;
            }
            aVar.e(7, this.tRh);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.eL(2, this.teS)) + a.a.a.a.eL(3, this.tRe)) + a.a.a.a.c(4, 8, this.tRf)) + a.a.a.a.eL(5, this.tRg)) + a.a.a.a.c(6, 8, this.tiQ);
            if (this.tRh != null) {
                r0 += a.a.a.b.b.a.f(7, this.tRh);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tRf.clear();
            this.tiQ.clear();
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
            amk com_tencent_mm_protocal_c_amk = (amk) objArr[1];
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
                        com_tencent_mm_protocal_c_amk.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amk.teS = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amk.tRe = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new amj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amk.tRf.add(emVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_amk.tRg = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new amm();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amk.tiQ.add(emVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_amk.tRh = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
