package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ana extends a {
    public double tRF;
    public long tRG;
    public String tgG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgG == null) {
                throw new b("Not all required fields were included: Username");
            }
            if (this.tgG != null) {
                aVar.e(1, this.tgG);
            }
            aVar.a(2, this.tRF);
            aVar.O(3, this.tRG);
            return 0;
        } else if (i == 1) {
            if (this.tgG != null) {
                r0 = a.a.a.b.b.a.f(1, this.tgG) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + (a.a.a.b.b.a.cH(2) + 8)) + a.a.a.a.N(3, this.tRG);
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
            ana com_tencent_mm_protocal_c_ana = (ana) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ana.tgG = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ana.tRF = aVar3.xmD.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ana.tRG = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
