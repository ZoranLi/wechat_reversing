package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class mu extends avh {
    public int ksW;
    public int tdM;
    public LinkedList<all> teK = new LinkedList();
    public avx ttd;
    public avw tte;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ttd == null) {
                throw new b("Not all required fields were included: Topic");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.ttd != null) {
                aVar.eQ(2, this.ttd.aUk());
                this.ttd.a(aVar);
            }
            aVar.eO(3, this.ksW);
            aVar.d(4, 8, this.teK);
            aVar.eO(5, this.tdM);
            if (this.tte == null) {
                return 0;
            }
            aVar.eQ(6, this.tte.aUk());
            this.tte.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ttd != null) {
                r0 += a.a.a.a.eN(2, this.ttd.aUk());
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.ksW)) + a.a.a.a.c(4, 8, this.teK)) + a.a.a.a.eL(5, this.tdM);
            if (this.tte != null) {
                r0 += a.a.a.a.eN(6, this.tte.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.teK.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ttd != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Topic");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            mu muVar = (mu) objArr[1];
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
                        muVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        muVar.ttd = emVar;
                    }
                    return 0;
                case 3:
                    muVar.ksW = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new all();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        muVar.teK.add(emVar);
                    }
                    return 0;
                case 5:
                    muVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        muVar.tte = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
