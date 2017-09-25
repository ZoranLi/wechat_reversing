package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class alq extends a {
    public int jOc;
    public int ogM;
    public String opI;
    public int tQw;
    public avx tfe;
    public String tfi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfe == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            if (this.tfe != null) {
                aVar.eQ(1, this.tfe.aUk());
                this.tfe.a(aVar);
            }
            if (this.opI != null) {
                aVar.e(2, this.opI);
            }
            aVar.eO(3, this.jOc);
            aVar.eO(4, this.ogM);
            aVar.eO(5, this.tQw);
            if (this.tfi == null) {
                return 0;
            }
            aVar.e(6, this.tfi);
            return 0;
        } else if (i == 1) {
            if (this.tfe != null) {
                r0 = a.a.a.a.eN(1, this.tfe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(2, this.opI);
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.jOc)) + a.a.a.a.eL(4, this.ogM)) + a.a.a.a.eL(5, this.tQw);
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(6, this.tfi);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
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
            alq com_tencent_mm_protocal_c_alq = (alq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avx = new avx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alq.tfe = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alq.opI = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alq.jOc = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alq.ogM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alq.tQw = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_alq.tfi = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
