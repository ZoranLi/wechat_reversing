package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class tk extends a {
    public int tBp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).eO(1, this.tBp);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.eL(1, this.tBp) + 0;
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
                tk tkVar = (tk) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        tkVar.tBp = aVar2.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
