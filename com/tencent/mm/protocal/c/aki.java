package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aki extends a {
    public String fDC;
    public String tOb;
    public int teT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tOb != null) {
                aVar.e(1, this.tOb);
            }
            if (this.fDC != null) {
                aVar.e(2, this.fDC);
            }
            aVar.eO(3, this.teT);
            return 0;
        } else if (i == 1) {
            if (this.tOb != null) {
                r0 = a.a.a.b.b.a.f(1, this.tOb) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            return r0 + a.a.a.a.eL(3, this.teT);
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
            aki com_tencent_mm_protocal_c_aki = (aki) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aki.tOb = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aki.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aki.teT = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
