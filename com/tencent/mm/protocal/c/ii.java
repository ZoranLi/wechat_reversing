package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ii extends avp {
    public String mvU;
    public String mvV;
    public int ogM;
    public long tfk;
    public String tmV;
    public String tng;
    public String tnk;

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
            if (this.tmV != null) {
                aVar.e(3, this.tmV);
            }
            if (this.mvV != null) {
                aVar.e(4, this.mvV);
            }
            if (this.mvU != null) {
                aVar.e(5, this.mvU);
            }
            aVar.eO(9, this.ogM);
            aVar.O(10, this.tfk);
            if (this.tng != null) {
                aVar.e(11, this.tng);
            }
            if (this.tnk == null) {
                return 0;
            }
            aVar.e(12, this.tnk);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tmV != null) {
                r0 += a.a.a.b.b.a.f(3, this.tmV);
            }
            if (this.mvV != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvV);
            }
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(5, this.mvU);
            }
            r0 = (r0 + a.a.a.a.eL(9, this.ogM)) + a.a.a.a.N(10, this.tfk);
            if (this.tng != null) {
                r0 += a.a.a.b.b.a.f(11, this.tng);
            }
            if (this.tnk != null) {
                r0 += a.a.a.b.b.a.f(12, this.tnk);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ii iiVar = (ii) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        iiVar.tZe = enVar;
                    }
                    return 0;
                case 3:
                    iiVar.tmV = aVar3.xmD.readString();
                    return 0;
                case 4:
                    iiVar.mvV = aVar3.xmD.readString();
                    return 0;
                case 5:
                    iiVar.mvU = aVar3.xmD.readString();
                    return 0;
                case 9:
                    iiVar.ogM = aVar3.xmD.mL();
                    return 0;
                case 10:
                    iiVar.tfk = aVar3.xmD.mM();
                    return 0;
                case 11:
                    iiVar.tng = aVar3.xmD.readString();
                    return 0;
                case 12:
                    iiVar.tnk = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
