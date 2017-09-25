package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class boo extends a {
    public int tQx;
    public int thX;
    public long umI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.thX);
            aVar.eO(2, this.tQx);
            aVar.O(3, this.umI);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.eL(1, this.thX) + 0) + a.a.a.a.eL(2, this.tQx)) + a.a.a.a.N(3, this.umI);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                boo com_tencent_mm_protocal_c_boo = (boo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_boo.thX = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_boo.tQx = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_boo.umI = aVar3.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
