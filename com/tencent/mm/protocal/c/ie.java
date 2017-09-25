package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ie extends a {
    public int tmA;
    public int tmB;
    public int tmC;
    public int tmD;
    public int tmE;
    public int tmz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tmz);
            aVar.eO(2, this.tmA);
            aVar.eO(3, this.tmB);
            aVar.eO(4, this.tmC);
            aVar.eO(5, this.tmD);
            aVar.eO(6, this.tmE);
            return 0;
        } else if (i == 1) {
            return (((((a.a.a.a.eL(1, this.tmz) + 0) + a.a.a.a.eL(2, this.tmA)) + a.a.a.a.eL(3, this.tmB)) + a.a.a.a.eL(4, this.tmC)) + a.a.a.a.eL(5, this.tmD)) + a.a.a.a.eL(6, this.tmE);
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
                ie ieVar = (ie) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        ieVar.tmz = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        ieVar.tmA = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        ieVar.tmB = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        ieVar.tmC = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        ieVar.tmD = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        ieVar.tmE = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
