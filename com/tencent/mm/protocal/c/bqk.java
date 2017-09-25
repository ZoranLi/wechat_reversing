package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bqk extends a {
    public b tkC;
    public String uoB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.uoB != null) {
                aVar.e(1, this.uoB);
            }
            if (this.tkC == null) {
                return 0;
            }
            aVar.b(2, this.tkC);
            return 0;
        } else if (i == 1) {
            if (this.uoB != null) {
                r0 = a.a.a.b.b.a.f(1, this.uoB) + 0;
            } else {
                r0 = 0;
            }
            if (this.tkC != null) {
                r0 += a.a.a.a.a(2, this.tkC);
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
            bqk com_tencent_mm_protocal_c_bqk = (bqk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bqk.uoB = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqk.tkC = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
