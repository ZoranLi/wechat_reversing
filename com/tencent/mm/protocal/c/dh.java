package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class dh extends a {
    public int tgJ;
    public int tgK;
    public int tgL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tgJ);
            aVar.eO(2, this.tgK);
            aVar.eO(3, this.tgL);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.eL(1, this.tgJ) + 0) + a.a.a.a.eL(2, this.tgK)) + a.a.a.a.eL(3, this.tgL);
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
                dh dhVar = (dh) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        dhVar.tgJ = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        dhVar.tgK = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        dhVar.tgL = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
