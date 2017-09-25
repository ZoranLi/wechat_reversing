package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class lh extends avp {
    public int jNB;
    public int trA;
    public bjt trx;
    public bif try;
    public asw trz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.trx == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.try == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.trz == null) {
                throw new b("Not all required fields were included: QueryCtx");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.eO(2, this.jNB);
                if (this.trx != null) {
                    aVar.eQ(3, this.trx.aUk());
                    this.trx.a(aVar);
                }
                if (this.try != null) {
                    aVar.eQ(4, this.try.aUk());
                    this.try.a(aVar);
                }
                if (this.trz != null) {
                    aVar.eQ(5, this.trz.aUk());
                    this.trz.a(aVar);
                }
                aVar.eO(6, this.trA);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.jNB);
            if (this.trx != null) {
                r0 += a.a.a.a.eN(3, this.trx.aUk());
            }
            if (this.try != null) {
                r0 += a.a.a.a.eN(4, this.try.aUk());
            }
            if (this.trz != null) {
                r0 += a.a.a.a.eN(5, this.trz.aUk());
            }
            return r0 + a.a.a.a.eL(6, this.trA);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.trx == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.try == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.trz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: QueryCtx");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            lh lhVar = (lh) objArr[1];
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
                        lhVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    lhVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bjt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        lhVar.trx = enVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bif();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        lhVar.try = enVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new asw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        lhVar.trz = enVar;
                    }
                    return 0;
                case 6:
                    lhVar.trA = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
