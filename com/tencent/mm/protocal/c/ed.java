package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ed extends avh {
    public long jNx;
    public int tdM;
    public int thR;
    public LinkedList<me> thS = new LinkedList();
    public String thT;
    public String thU;
    public String thV;
    public String thW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.thR);
            aVar.d(3, 8, this.thS);
            if (this.thT != null) {
                aVar.e(4, this.thT);
            }
            if (this.thU != null) {
                aVar.e(5, this.thU);
            }
            aVar.eO(6, this.tdM);
            aVar.O(7, this.jNx);
            if (this.thV != null) {
                aVar.e(8, this.thV);
            }
            if (this.thW == null) {
                return 0;
            }
            aVar.e(9, this.thW);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.thR)) + a.a.a.a.c(3, 8, this.thS);
            if (this.thT != null) {
                r0 += a.a.a.b.b.a.f(4, this.thT);
            }
            if (this.thU != null) {
                r0 += a.a.a.b.b.a.f(5, this.thU);
            }
            r0 = (r0 + a.a.a.a.eL(6, this.tdM)) + a.a.a.a.N(7, this.jNx);
            if (this.thV != null) {
                r0 += a.a.a.b.b.a.f(8, this.thV);
            }
            if (this.thW != null) {
                r0 += a.a.a.b.b.a.f(9, this.thW);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.thS.clear();
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
            ed edVar = (ed) objArr[1];
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
                        edVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    edVar.thR = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new me();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        edVar.thS.add(emVar);
                    }
                    return 0;
                case 4:
                    edVar.thT = aVar3.xmD.readString();
                    return 0;
                case 5:
                    edVar.thU = aVar3.xmD.readString();
                    return 0;
                case 6:
                    edVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 7:
                    edVar.jNx = aVar3.xmD.mM();
                    return 0;
                case 8:
                    edVar.thV = aVar3.xmD.readString();
                    return 0;
                case 9:
                    edVar.thW = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
