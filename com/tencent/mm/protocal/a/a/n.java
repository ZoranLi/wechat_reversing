package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bd.a;

public final class n extends a {
    public int taW;
    public int taX;
    public int taY;
    public int taZ;
    public int tan;
    public int tba;
    public int tbb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tan);
            aVar.eO(2, this.taW);
            aVar.eO(3, this.taX);
            aVar.eO(4, this.taY);
            aVar.eO(5, this.taZ);
            aVar.eO(6, this.tba);
            aVar.eO(7, this.tbb);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.eL(1, this.tan) + 0) + a.a.a.a.eL(2, this.taW)) + a.a.a.a.eL(3, this.taX)) + a.a.a.a.eL(4, this.taY)) + a.a.a.a.eL(5, this.taZ)) + a.a.a.a.eL(6, this.tba)) + a.a.a.a.eL(7, this.tbb);
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
                n nVar = (n) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        nVar.tan = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        nVar.taW = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        nVar.taX = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        nVar.taY = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        nVar.taZ = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        nVar.tba = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        nVar.tbb = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
