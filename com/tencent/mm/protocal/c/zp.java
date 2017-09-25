package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zp extends avp {
    public int tFR;
    public LinkedList<aog> tFS = new LinkedList();
    public String tFT;
    public int tFU;
    public int teT;

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
            aVar.eO(2, this.tFR);
            aVar.d(3, 8, this.tFS);
            if (this.tFT != null) {
                aVar.e(4, this.tFT);
            }
            aVar.eO(5, this.teT);
            aVar.eO(6, this.tFU);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tFR)) + a.a.a.a.c(3, 8, this.tFS);
            if (this.tFT != null) {
                r0 += a.a.a.b.b.a.f(4, this.tFT);
            }
            return (r0 + a.a.a.a.eL(5, this.teT)) + a.a.a.a.eL(6, this.tFU);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tFS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
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
            zp zpVar = (zp) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zpVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    zpVar.tFR = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new aog();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zpVar.tFS.add(enVar);
                    }
                    return 0;
                case 4:
                    zpVar.tFT = aVar3.xmD.readString();
                    return 0;
                case 5:
                    zpVar.teT = aVar3.xmD.mL();
                    return 0;
                case 6:
                    zpVar.tFU = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
