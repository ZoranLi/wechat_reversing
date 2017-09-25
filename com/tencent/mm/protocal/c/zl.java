package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zl extends avh {
    public int tFO;
    public int tfc;
    public avx tfd;
    public avx tfe;
    public long tfk;
    public int tgJ;
    public int tgK;
    public int tgL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                aVar.eO(2, this.tfc);
                if (this.tfd != null) {
                    aVar.eQ(3, this.tfd.aUk());
                    this.tfd.a(aVar);
                }
                if (this.tfe != null) {
                    aVar.eQ(4, this.tfe.aUk());
                    this.tfe.a(aVar);
                }
                aVar.eO(5, this.tgJ);
                aVar.eO(6, this.tgK);
                aVar.eO(7, this.tgL);
                aVar.eO(8, this.tFO);
                aVar.O(9, this.tfk);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tfc);
            if (this.tfd != null) {
                r0 += a.a.a.a.eN(3, this.tfd.aUk());
            }
            if (this.tfe != null) {
                r0 += a.a.a.a.eN(4, this.tfe.aUk());
            }
            return ((((r0 + a.a.a.a.eL(5, this.tgJ)) + a.a.a.a.eL(6, this.tgK)) + a.a.a.a.eL(7, this.tgL)) + a.a.a.a.eL(8, this.tFO)) + a.a.a.a.N(9, this.tfk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ToUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            zl zlVar = (zl) objArr[1];
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
                        zlVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    zlVar.tfc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zlVar.tfd = emVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zlVar.tfe = emVar;
                    }
                    return 0;
                case 5:
                    zlVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    zlVar.tgK = aVar3.xmD.mL();
                    return 0;
                case 7:
                    zlVar.tgL = aVar3.xmD.mL();
                    return 0;
                case 8:
                    zlVar.tFO = aVar3.xmD.mL();
                    return 0;
                case 9:
                    zlVar.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
