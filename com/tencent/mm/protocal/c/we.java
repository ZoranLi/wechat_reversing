package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class we extends avh {
    public int fVn;
    public String sign;
    public String tDa;
    public String tDb;
    public String tcO;
    public String tcP;
    public int tcQ;
    public LinkedList<iu> tcT = new LinkedList();
    public String tfA;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.d(2, 8, this.tcT);
            aVar.eO(3, this.fVn);
            if (this.tDb != null) {
                aVar.e(4, this.tDb);
            }
            if (this.tfA != null) {
                aVar.e(5, this.tfA);
            }
            if (this.sign != null) {
                aVar.e(6, this.sign);
            }
            if (this.tcO != null) {
                aVar.e(7, this.tcO);
            }
            if (this.tcP != null) {
                aVar.e(8, this.tcP);
            }
            if (this.tDa != null) {
                aVar.e(9, this.tDa);
            }
            aVar.eO(10, this.tcQ);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.c(2, 8, this.tcT)) + a.a.a.a.eL(3, this.fVn);
            if (this.tDb != null) {
                r0 += a.a.a.b.b.a.f(4, this.tDb);
            }
            if (this.tfA != null) {
                r0 += a.a.a.b.b.a.f(5, this.tfA);
            }
            if (this.sign != null) {
                r0 += a.a.a.b.b.a.f(6, this.sign);
            }
            if (this.tcO != null) {
                r0 += a.a.a.b.b.a.f(7, this.tcO);
            }
            if (this.tcP != null) {
                r0 += a.a.a.b.b.a.f(8, this.tcP);
            }
            if (this.tDa != null) {
                r0 += a.a.a.b.b.a.f(9, this.tDa);
            }
            return r0 + a.a.a.a.eL(10, this.tcQ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tcT.clear();
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
            we weVar = (we) objArr[1];
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
                        weVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new iu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        weVar.tcT.add(emVar);
                    }
                    return 0;
                case 3:
                    weVar.fVn = aVar3.xmD.mL();
                    return 0;
                case 4:
                    weVar.tDb = aVar3.xmD.readString();
                    return 0;
                case 5:
                    weVar.tfA = aVar3.xmD.readString();
                    return 0;
                case 6:
                    weVar.sign = aVar3.xmD.readString();
                    return 0;
                case 7:
                    weVar.tcO = aVar3.xmD.readString();
                    return 0;
                case 8:
                    weVar.tcP = aVar3.xmD.readString();
                    return 0;
                case 9:
                    weVar.tDa = aVar3.xmD.readString();
                    return 0;
                case 10:
                    weVar.tcQ = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
