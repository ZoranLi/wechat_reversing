package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class amo extends a {
    public int tQU;
    public int tRk;
    public int tRl;
    public avx ttp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttp == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.ttp != null) {
                aVar.eQ(1, this.ttp.aUk());
                this.ttp.a(aVar);
            }
            aVar.eO(2, this.tRk);
            aVar.eO(3, this.tRl);
            aVar.eO(4, this.tQU);
            return 0;
        } else if (i == 1) {
            if (this.ttp != null) {
                r0 = a.a.a.a.eN(1, this.ttp.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.eL(2, this.tRk)) + a.a.a.a.eL(3, this.tRl)) + a.a.a.a.eL(4, this.tQU);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ttp != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            amo com_tencent_mm_protocal_c_amo = (amo) objArr[1];
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
                        com_tencent_mm_protocal_c_amo.ttp = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amo.tRk = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amo.tRl = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_amo.tQU = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
