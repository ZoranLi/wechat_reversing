package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class xd extends avh {
    public int tDK;
    public int tDL;
    public LinkedList<avx> tDM = new LinkedList();
    public int tDN;
    public LinkedList<avx> tDO = new LinkedList();
    public int tDP;
    public avx tDQ;
    public LinkedList<avx> tiO = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tDK);
            aVar.d(3, 8, this.tiO);
            aVar.eO(4, this.tDL);
            aVar.d(5, 8, this.tDM);
            aVar.eO(6, this.tDN);
            aVar.d(7, 8, this.tDO);
            aVar.eO(8, this.tDP);
            if (this.tDQ == null) {
                return 0;
            }
            aVar.eQ(9, this.tDQ.aUk());
            this.tDQ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((r0 + a.a.a.a.eL(2, this.tDK)) + a.a.a.a.c(3, 8, this.tiO)) + a.a.a.a.eL(4, this.tDL)) + a.a.a.a.c(5, 8, this.tDM)) + a.a.a.a.eL(6, this.tDN)) + a.a.a.a.c(7, 8, this.tDO)) + a.a.a.a.eL(8, this.tDP);
            if (this.tDQ != null) {
                r0 += a.a.a.a.eN(9, this.tDQ.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tiO.clear();
            this.tDM.clear();
            this.tDO.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xd xdVar = (xd) objArr[1];
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
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        xdVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    xdVar.tDK = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        xdVar.tiO.add(emVar);
                    }
                    return 0;
                case 4:
                    xdVar.tDL = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        xdVar.tDM.add(emVar);
                    }
                    return 0;
                case 6:
                    xdVar.tDN = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        xdVar.tDO.add(emVar);
                    }
                    return 0;
                case 8:
                    xdVar.tDP = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        xdVar.tDQ = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
