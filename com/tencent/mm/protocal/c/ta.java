package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ta extends avh {
    public String hAM;
    public String mtJ;
    public LinkedList<String> tAO = new LinkedList();
    public LinkedList<String> tAV = new LinkedList();
    public int tAW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.d(2, 1, this.tAV);
            aVar.d(3, 1, this.tAO);
            if (this.mtJ != null) {
                aVar.e(4, this.mtJ);
            }
            if (this.hAM != null) {
                aVar.e(5, this.hAM);
            }
            aVar.eO(6, this.tAW);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.c(2, 1, this.tAV)) + a.a.a.a.c(3, 1, this.tAO);
            if (this.mtJ != null) {
                r0 += a.a.a.b.b.a.f(4, this.mtJ);
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(5, this.hAM);
            }
            return r0 + a.a.a.a.eL(6, this.tAW);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tAV.clear();
            this.tAO.clear();
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
            ta taVar = (ta) objArr[1];
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
                        taVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    taVar.tAV.add(aVar3.xmD.readString());
                    return 0;
                case 3:
                    taVar.tAO.add(aVar3.xmD.readString());
                    return 0;
                case 4:
                    taVar.mtJ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    taVar.hAM = aVar3.xmD.readString();
                    return 0;
                case 6:
                    taVar.tAW = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
