package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class lg extends avh {
    public int tfc;
    public long tfk;
    public int tgJ;
    public String trv;
    public bjo trw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.trv != null) {
                aVar.e(2, this.trv);
            }
            aVar.eO(3, this.tgJ);
            aVar.eO(4, this.tfc);
            if (this.trw != null) {
                aVar.eQ(5, this.trw.aUk());
                this.trw.a(aVar);
            }
            aVar.O(6, this.tfk);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.trv != null) {
                r0 += a.a.a.b.b.a.f(2, this.trv);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tgJ)) + a.a.a.a.eL(4, this.tfc);
            if (this.trw != null) {
                r0 += a.a.a.a.eN(5, this.trw.aUk());
            }
            return r0 + a.a.a.a.N(6, this.tfk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            lg lgVar = (lg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        lgVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    lgVar.trv = aVar3.xmD.readString();
                    return 0;
                case 3:
                    lgVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    lgVar.tfc = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bjo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        lgVar.trw = emVar;
                    }
                    return 0;
                case 6:
                    lgVar.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
