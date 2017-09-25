package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aer extends a {
    public int jOc;
    public int ogM;
    public long tJW;
    public avw tij;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tij == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            aVar.O(1, this.tJW);
            aVar.eO(2, this.ogM);
            if (this.tij != null) {
                aVar.eQ(3, this.tij.aUk());
                this.tij.a(aVar);
            }
            aVar.eO(4, this.jOc);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.N(1, this.tJW) + 0) + a.a.a.a.eL(2, this.ogM);
            if (this.tij != null) {
                r0 += a.a.a.a.eN(3, this.tij.aUk());
            }
            return r0 + a.a.a.a.eL(4, this.jOc);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tij != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aer com_tencent_mm_protocal_c_aer = (aer) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aer.tJW = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aer.ogM = aVar3.xmD.mL();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aer.tij = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aer.jOc = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
