package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ft extends a {
    public int tiC;
    public int tjh;
    public int tji;
    public int tjj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tiC);
            aVar.eO(2, this.tjh);
            aVar.eO(3, this.tji);
            aVar.eO(4, this.tjj);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.eL(1, this.tiC) + 0) + a.a.a.a.eL(2, this.tjh)) + a.a.a.a.eL(3, this.tji)) + a.a.a.a.eL(4, this.tjj);
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
                ft ftVar = (ft) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        ftVar.tiC = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        ftVar.tjh = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        ftVar.tji = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        ftVar.tjj = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
