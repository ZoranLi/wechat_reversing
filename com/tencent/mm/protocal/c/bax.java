package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bax extends a {
    public int jOc;
    public String msN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msN != null) {
                aVar.e(1, this.msN);
            }
            aVar.eO(2, this.jOc);
            return 0;
        } else if (i == 1) {
            if (this.msN != null) {
                r0 = a.a.a.b.b.a.f(1, this.msN) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.eL(2, this.jOc);
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
            bax com_tencent_mm_protocal_c_bax = (bax) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bax.msN = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bax.jOc = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
