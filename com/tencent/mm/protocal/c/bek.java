package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bek extends a {
    public int jOc;
    public int ufk;
    public String ufl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(2, this.jOc);
            aVar.eO(3, this.ufk);
            if (this.ufl != null) {
                aVar.e(4, this.ufl);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(2, this.jOc) + 0) + a.a.a.a.eL(3, this.ufk);
            if (this.ufl != null) {
                return r0 + a.a.a.b.b.a.f(4, this.ufl);
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
            bek com_tencent_mm_protocal_c_bek = (bek) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    com_tencent_mm_protocal_c_bek.jOc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bek.ufk = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bek.ufl = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
