package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bov extends a {
    public long unm;
    public ho unn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.unm);
            if (this.unn != null) {
                aVar.eQ(2, this.unn.aUk());
                this.unn.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.unm) + 0;
            if (this.unn != null) {
                return r0 + a.a.a.a.eN(2, this.unn.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bov com_tencent_mm_protocal_c_bov = (bov) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bov.unm = aVar3.xmD.mM();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a hoVar = new ho();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hoVar.a(aVar4, hoVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bov.unn = hoVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
