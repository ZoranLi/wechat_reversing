package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bpc extends a {
    public String unB;
    public boolean unC;
    public int unD;
    public int unE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.unB != null) {
                aVar.e(1, this.unB);
            }
            aVar.an(2, this.unC);
            aVar.eO(3, this.unD);
            aVar.eO(4, this.unE);
            return 0;
        } else if (i == 1) {
            if (this.unB != null) {
                r0 = a.a.a.b.b.a.f(1, this.unB) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + (a.a.a.b.b.a.cH(2) + 1)) + a.a.a.a.eL(3, this.unD)) + a.a.a.a.eL(4, this.unE);
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
            bpc com_tencent_mm_protocal_c_bpc = (bpc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bpc.unB = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpc.unC = aVar3.cib();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bpc.unD = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bpc.unE = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
