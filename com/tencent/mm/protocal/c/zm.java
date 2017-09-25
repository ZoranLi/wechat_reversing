package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zm extends avp {
    public int tfc;
    public avx tfd;
    public avx tfe;
    public long tfk;
    public int tgJ;
    public int tgK;
    public int tgL;
    public avw tsk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
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
                if (this.tsk != null) {
                    aVar.eQ(8, this.tsk.aUk());
                    this.tsk.a(aVar);
                }
                aVar.O(9, this.tfk);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
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
            r0 = ((r0 + a.a.a.a.eL(5, this.tgJ)) + a.a.a.a.eL(6, this.tgK)) + a.a.a.a.eL(7, this.tgL);
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(8, this.tsk.aUk());
            }
            return r0 + a.a.a.a.N(9, this.tfk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tfd == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.tsk != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            zm zmVar = (zm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zmVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    zmVar.tfc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zmVar.tfd = enVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zmVar.tfe = enVar;
                    }
                    return 0;
                case 5:
                    zmVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    zmVar.tgK = aVar3.xmD.mL();
                    return 0;
                case 7:
                    zmVar.tgL = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zmVar.tsk = enVar;
                    }
                    return 0;
                case 9:
                    zmVar.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
