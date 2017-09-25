package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ate extends a {
    public String tXm;
    public String tXn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tXm != null) {
                aVar.e(1, this.tXm);
            }
            if (this.tXn == null) {
                return 0;
            }
            aVar.e(2, this.tXn);
            return 0;
        } else if (i == 1) {
            if (this.tXm != null) {
                r0 = a.a.a.b.b.a.f(1, this.tXm) + 0;
            } else {
                r0 = 0;
            }
            if (this.tXn != null) {
                r0 += a.a.a.b.b.a.f(2, this.tXn);
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
            ate com_tencent_mm_protocal_c_ate = (ate) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ate.tXm = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ate.tXn = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
