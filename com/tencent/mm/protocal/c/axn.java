package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class axn extends avp {
    public int jOc;
    public String mtb;
    public String mvU;
    public String mvV;
    public int ogM;
    public String tfU;
    public int tfc;
    public long tfk;
    public String tng;

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
            if (this.mvV != null) {
                aVar.e(3, this.mvV);
            }
            if (this.mvU != null) {
                aVar.e(4, this.mvU);
            }
            aVar.eO(5, this.tfc);
            if (this.tfU != null) {
                aVar.e(6, this.tfU);
            }
            aVar.eO(7, this.ogM);
            aVar.eO(8, this.jOc);
            aVar.O(9, this.tfk);
            if (this.tng == null) {
                return 0;
            }
            aVar.e(10, this.tng);
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
            if (this.mvV != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvV);
            }
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvU);
            }
            r0 += a.a.a.a.eL(5, this.tfc);
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(6, this.tfU);
            }
            r0 = ((r0 + a.a.a.a.eL(7, this.ogM)) + a.a.a.a.eL(8, this.jOc)) + a.a.a.a.N(9, this.tfk);
            if (this.tng != null) {
                r0 += a.a.a.b.b.a.f(10, this.tng);
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
            axn com_tencent_mm_protocal_c_axn = (axn) objArr[1];
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
                        com_tencent_mm_protocal_c_axn.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axn.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axn.mvV = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axn.mvU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axn.tfc = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axn.tfU = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axn.ogM = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axn.jOc = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axn.tfk = aVar3.xmD.mM();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_axn.tng = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
