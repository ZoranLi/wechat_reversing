package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class aex extends a {
    public long fZT;
    public b tKg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.fZT);
            if (this.tKg != null) {
                aVar.b(2, this.tKg);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.fZT) + 0;
            if (this.tKg != null) {
                return r0 + a.a.a.a.a(2, this.tKg);
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
            aex com_tencent_mm_protocal_c_aex = (aex) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aex.fZT = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aex.tKg = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
