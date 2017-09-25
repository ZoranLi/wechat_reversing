package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class sy extends avp {
    public String fDC;
    public LinkedList<String> tAP = new LinkedList();
    public String tAQ;
    public LinkedList<String> tAR = new LinkedList();
    public LinkedList<String> tAS = new LinkedList();
    public LinkedList<sz> tAT = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.tAQ == null) {
                throw new b("Not all required fields were included: JsonData");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.fDC != null) {
                    aVar.e(2, this.fDC);
                }
                aVar.d(3, 1, this.tAP);
                if (this.tAQ != null) {
                    aVar.e(4, this.tAQ);
                }
                aVar.d(5, 1, this.tAR);
                aVar.d(6, 1, this.tAS);
                aVar.d(7, 8, this.tAT);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            r0 += a.a.a.a.c(3, 1, this.tAP);
            if (this.tAQ != null) {
                r0 += a.a.a.b.b.a.f(4, this.tAQ);
            }
            return ((r0 + a.a.a.a.c(5, 1, this.tAR)) + a.a.a.a.c(6, 1, this.tAS)) + a.a.a.a.c(7, 8, this.tAT);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tAP.clear();
            this.tAR.clear();
            this.tAS.clear();
            this.tAT.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.tAQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: JsonData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            sy syVar = (sy) objArr[1];
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
                        syVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    syVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    syVar.tAP.add(aVar3.xmD.readString());
                    return 0;
                case 4:
                    syVar.tAQ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    syVar.tAR.add(aVar3.xmD.readString());
                    return 0;
                case 6:
                    syVar.tAS.add(aVar3.xmD.readString());
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new sz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        syVar.tAT.add(enVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
