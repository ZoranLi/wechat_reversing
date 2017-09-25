package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class zj extends avh {
    public int mtF;
    public int tFK;
    public LinkedList<alu> tFL = new LinkedList();
    public int tFM;
    public LinkedList<ajw> tFN = new LinkedList();
    public int tdM;
    public String tuy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.mtF);
            if (this.tuy != null) {
                aVar.e(3, this.tuy);
            }
            aVar.eO(4, this.tFK);
            aVar.d(5, 8, this.tFL);
            aVar.eO(6, this.tFM);
            aVar.d(7, 8, this.tFN);
            aVar.eO(8, this.tdM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.mtF);
            if (this.tuy != null) {
                r0 += a.a.a.b.b.a.f(3, this.tuy);
            }
            return ((((r0 + a.a.a.a.eL(4, this.tFK)) + a.a.a.a.c(5, 8, this.tFL)) + a.a.a.a.eL(6, this.tFM)) + a.a.a.a.c(7, 8, this.tFN)) + a.a.a.a.eL(8, this.tdM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tFL.clear();
            this.tFN.clear();
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
            zj zjVar = (zj) objArr[1];
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
                        zjVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    zjVar.mtF = aVar3.xmD.mL();
                    return 0;
                case 3:
                    zjVar.tuy = aVar3.xmD.readString();
                    return 0;
                case 4:
                    zjVar.tFK = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new alu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zjVar.tFL.add(emVar);
                    }
                    return 0;
                case 6:
                    zjVar.tFM = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new ajw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zjVar.tFN.add(emVar);
                    }
                    return 0;
                case 8:
                    zjVar.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
