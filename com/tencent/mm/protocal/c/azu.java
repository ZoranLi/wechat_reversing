package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class azu extends a {
    public String fVl;
    public int kgV;
    public int tpx;
    public long ube;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fVl != null) {
                aVar.e(1, this.fVl);
            }
            aVar.eO(2, this.kgV);
            aVar.eO(3, this.tpx);
            aVar.O(4, this.ube);
            return 0;
        } else if (i == 1) {
            if (this.fVl != null) {
                r0 = a.a.a.b.b.a.f(1, this.fVl) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.eL(2, this.kgV)) + a.a.a.a.eL(3, this.tpx)) + a.a.a.a.N(4, this.ube);
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
            azu com_tencent_mm_protocal_c_azu = (azu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_azu.fVl = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azu.kgV = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azu.tpx = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azu.ube = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
