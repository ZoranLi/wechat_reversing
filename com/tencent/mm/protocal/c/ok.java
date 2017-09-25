package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ok extends avp {
    public String jNj;
    public String mtb;
    public int tgJ;
    public int tgK;
    public int tgL;
    public avw tsk;
    public String ttW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.mtb != null) {
                    aVar.e(2, this.mtb);
                }
                if (this.ttW != null) {
                    aVar.e(3, this.ttW);
                }
                if (this.jNj != null) {
                    aVar.e(4, this.jNj);
                }
                aVar.eO(5, this.tgJ);
                aVar.eO(6, this.tgK);
                aVar.eO(7, this.tgL);
                if (this.tsk == null) {
                    return 0;
                }
                aVar.eQ(8, this.tsk.aUk());
                this.tsk.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtb);
            }
            if (this.ttW != null) {
                r0 += a.a.a.b.b.a.f(3, this.ttW);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(4, this.jNj);
            }
            r0 = ((r0 + a.a.a.a.eL(5, this.tgJ)) + a.a.a.a.eL(6, this.tgK)) + a.a.a.a.eL(7, this.tgL);
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(8, this.tsk.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tsk != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ok okVar = (ok) objArr[1];
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
                        okVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    okVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    okVar.ttW = aVar3.xmD.readString();
                    return 0;
                case 4:
                    okVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 5:
                    okVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    okVar.tgK = aVar3.xmD.mL();
                    return 0;
                case 7:
                    okVar.tgL = aVar3.xmD.mL();
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
                        okVar.tsk = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
