package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bij extends avp {
    public String mvU;
    public String mvV;
    public int ogM;
    public String tfU;
    public int tfc;
    public long tfk;
    public int tiL;
    public int tll;
    public int tuc;
    public int tue;
    public int tuf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mvV != null) {
                aVar.e(1, this.mvV);
            }
            if (this.mvU != null) {
                aVar.e(2, this.mvU);
            }
            aVar.eO(3, this.tll);
            aVar.eO(4, this.tuc);
            aVar.eO(5, this.ogM);
            if (this.tfU != null) {
                aVar.e(6, this.tfU);
            }
            aVar.eO(7, this.tfc);
            aVar.eO(8, this.tue);
            aVar.eO(9, this.tiL);
            if (this.tZe != null) {
                aVar.eQ(10, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.eO(11, this.tuf);
            aVar.O(12, this.tfk);
            return 0;
        } else if (i == 1) {
            if (this.mvV != null) {
                r0 = a.a.a.b.b.a.f(1, this.mvV) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvU);
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.tll)) + a.a.a.a.eL(4, this.tuc)) + a.a.a.a.eL(5, this.ogM);
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(6, this.tfU);
            }
            r0 = ((r0 + a.a.a.a.eL(7, this.tfc)) + a.a.a.a.eL(8, this.tue)) + a.a.a.a.eL(9, this.tiL);
            if (this.tZe != null) {
                r0 += a.a.a.a.eN(10, this.tZe.aUk());
            }
            return (r0 + a.a.a.a.eL(11, this.tuf)) + a.a.a.a.N(12, this.tfk);
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
            bij com_tencent_mm_protocal_c_bij = (bij) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bij.mvV = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bij.mvU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bij.tll = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bij.tuc = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bij.ogM = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bij.tfU = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bij.tfc = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bij.tue = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bij.tiL = aVar3.xmD.mL();
                    return 0;
                case 10:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bij.tZe = enVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bij.tuf = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bij.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
