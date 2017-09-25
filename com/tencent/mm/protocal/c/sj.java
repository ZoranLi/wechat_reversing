package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class sj extends avp {
    public int tAq;
    public String tAr;
    public String tAs;
    public int tAt;
    public String tAu;

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
            aVar.eO(2, this.tAq);
            if (this.tAr != null) {
                aVar.e(3, this.tAr);
            }
            if (this.tAs != null) {
                aVar.e(4, this.tAs);
            }
            aVar.eO(5, this.tAt);
            if (this.tAu == null) {
                return 0;
            }
            aVar.e(6, this.tAu);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tAq);
            if (this.tAr != null) {
                r0 += a.a.a.b.b.a.f(3, this.tAr);
            }
            if (this.tAs != null) {
                r0 += a.a.a.b.b.a.f(4, this.tAs);
            }
            r0 += a.a.a.a.eL(5, this.tAt);
            if (this.tAu != null) {
                r0 += a.a.a.b.b.a.f(6, this.tAu);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
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
            sj sjVar = (sj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        sjVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    sjVar.tAq = aVar3.xmD.mL();
                    return 0;
                case 3:
                    sjVar.tAr = aVar3.xmD.readString();
                    return 0;
                case 4:
                    sjVar.tAs = aVar3.xmD.readString();
                    return 0;
                case 5:
                    sjVar.tAt = aVar3.xmD.mL();
                    return 0;
                case 6:
                    sjVar.tAu = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
