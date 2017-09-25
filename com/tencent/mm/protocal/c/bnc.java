package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bnc extends a {
    public String tgG;
    public long umx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgG == null) {
                throw new b("Not all required fields were included: Username");
            }
            aVar.O(1, this.umx);
            if (this.tgG != null) {
                aVar.e(2, this.tgG);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.umx) + 0;
            if (this.tgG != null) {
                return r0 + a.a.a.b.b.a.f(2, this.tgG);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tgG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Username");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bnc com_tencent_mm_protocal_c_bnc = (bnc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bnc.umx = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnc.tgG = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
