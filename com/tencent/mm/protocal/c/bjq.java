package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bjq extends a {
    public int tfX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).eO(1, this.tfX);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.eL(1, this.tfX) + 0;
        } else {
            if (i == 2) {
                a.a.a.a.a aVar = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar2 = (a.a.a.a.a) objArr[0];
                bjq com_tencent_mm_protocal_c_bjq = (bjq) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bjq.tfX = aVar2.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
