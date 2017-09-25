package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class di extends a {
    public int tgM;
    public int tgN;
    public int tgO;
    public int tgP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tgM);
            aVar.eO(2, this.tgN);
            aVar.eO(3, this.tgO);
            aVar.eO(4, this.tgP);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.eL(1, this.tgM) + 0) + a.a.a.a.eL(2, this.tgN)) + a.a.a.a.eL(3, this.tgO)) + a.a.a.a.eL(4, this.tgP);
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
                di diVar = (di) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        diVar.tgM = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        diVar.tgN = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        diVar.tgO = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        diVar.tgP = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
