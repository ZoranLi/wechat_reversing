package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bhc extends avp {
    public String jNj;
    public String mtb;
    public int ogM;
    public int tgJ;
    public int tgK;
    public int tgL;
    public String ttW;
    public String ugK;

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
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            if (this.ttW != null) {
                aVar.e(3, this.ttW);
            }
            if (this.ugK != null) {
                aVar.e(4, this.ugK);
            }
            if (this.jNj != null) {
                aVar.e(5, this.jNj);
            }
            aVar.eO(6, this.tgJ);
            aVar.eO(7, this.tgK);
            aVar.eO(8, this.tgL);
            aVar.eO(9, this.ogM);
            return 0;
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
            if (this.ugK != null) {
                r0 += a.a.a.b.b.a.f(4, this.ugK);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(5, this.jNj);
            }
            return (((r0 + a.a.a.a.eL(6, this.tgJ)) + a.a.a.a.eL(7, this.tgK)) + a.a.a.a.eL(8, this.tgL)) + a.a.a.a.eL(9, this.ogM);
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
            bhc com_tencent_mm_protocal_c_bhc = (bhc) objArr[1];
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
                        com_tencent_mm_protocal_c_bhc.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhc.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhc.ttW = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhc.ugK = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhc.jNj = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhc.tgJ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhc.tgK = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhc.tgL = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bhc.ogM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
