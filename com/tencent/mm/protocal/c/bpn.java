package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bpn extends a {
    public String tHi;
    public String tHj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tHi != null) {
                aVar.e(1, this.tHi);
            }
            if (this.tHj == null) {
                return 0;
            }
            aVar.e(2, this.tHj);
            return 0;
        } else if (i == 1) {
            if (this.tHi != null) {
                r0 = a.a.a.b.b.a.f(1, this.tHi) + 0;
            } else {
                r0 = 0;
            }
            if (this.tHj != null) {
                r0 += a.a.a.b.b.a.f(2, this.tHj);
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
            bpn com_tencent_mm_protocal_c_bpn = (bpn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bpn.tHi = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpn.tHj = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
