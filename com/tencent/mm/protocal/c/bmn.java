package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bmn extends a {
    public b ulR;
    public b ulW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ulR != null) {
                aVar.b(1, this.ulR);
            }
            if (this.ulW == null) {
                return 0;
            }
            aVar.b(2, this.ulW);
            return 0;
        } else if (i == 1) {
            if (this.ulR != null) {
                r0 = a.a.a.a.a(1, this.ulR) + 0;
            } else {
                r0 = 0;
            }
            if (this.ulW != null) {
                r0 += a.a.a.a.a(2, this.ulW);
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
            bmn com_tencent_mm_protocal_c_bmn = (bmn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bmn.ulR = aVar3.cic();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bmn.ulW = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
