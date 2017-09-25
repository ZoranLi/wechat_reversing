package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bak extends a {
    public String tgW;
    public int tiI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgW == null) {
                throw new b("Not all required fields were included: ProductID");
            }
            if (this.tgW != null) {
                aVar.e(1, this.tgW);
            }
            aVar.eO(2, this.tiI);
            return 0;
        } else if (i == 1) {
            if (this.tgW != null) {
                r0 = a.a.a.b.b.a.f(1, this.tgW) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.eL(2, this.tiI);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tgW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ProductID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bak com_tencent_mm_protocal_c_bak = (bak) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bak.tgW = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bak.tiI = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
