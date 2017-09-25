package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class alr extends avp {
    public int jOc;
    public int ogM;
    public int tQw;
    public int tQx;
    public int tfc;
    public avx tfe;
    public long tfk;
    public int thX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            aVar.eO(1, this.thX);
            if (this.tfe != null) {
                aVar.eQ(2, this.tfe.aUk());
                this.tfe.a(aVar);
            }
            aVar.eO(3, this.tfc);
            aVar.eO(4, this.tQw);
            aVar.eO(5, this.ogM);
            aVar.eO(6, this.tQx);
            aVar.eO(7, this.jOc);
            aVar.O(8, this.tfk);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.thX) + 0;
            if (this.tfe != null) {
                r0 += a.a.a.a.eN(2, this.tfe.aUk());
            }
            return (((((r0 + a.a.a.a.eL(3, this.tfc)) + a.a.a.a.eL(4, this.tQw)) + a.a.a.a.eL(5, this.ogM)) + a.a.a.a.eL(6, this.tQx)) + a.a.a.a.eL(7, this.jOc)) + a.a.a.a.N(8, this.tfk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tfe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ToUserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            alr com_tencent_mm_protocal_c_alr = (alr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_alr.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a com_tencent_mm_protocal_c_avx = new avx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alr.tfe = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alr.tfc = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alr.tQw = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alr.ogM = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_alr.tQx = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_alr.jOc = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_alr.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
