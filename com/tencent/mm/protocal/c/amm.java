package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class amm extends a {
    public int jOc;
    public String muQ;
    public String oTN;
    public String tRi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.muQ != null) {
                aVar.e(1, this.muQ);
            }
            if (this.tRi != null) {
                aVar.e(2, this.tRi);
            }
            if (this.oTN != null) {
                aVar.e(3, this.oTN);
            }
            aVar.eO(4, this.jOc);
            return 0;
        } else if (i == 1) {
            if (this.muQ != null) {
                r0 = a.a.a.b.b.a.f(1, this.muQ) + 0;
            } else {
                r0 = 0;
            }
            if (this.tRi != null) {
                r0 += a.a.a.b.b.a.f(2, this.tRi);
            }
            if (this.oTN != null) {
                r0 += a.a.a.b.b.a.f(3, this.oTN);
            }
            return r0 + a.a.a.a.eL(4, this.jOc);
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
            amm com_tencent_mm_protocal_c_amm = (amm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_amm.muQ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amm.tRi = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amm.oTN = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_amm.jOc = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
