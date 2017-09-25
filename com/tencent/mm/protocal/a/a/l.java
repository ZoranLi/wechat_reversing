package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bd.a;

public final class l extends a {
    public int action;
    public int taM;
    public int taN;
    public int taO;
    public int taP;
    public int taQ;
    public int taR;
    public int taS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.taM);
            aVar.eO(2, this.action);
            aVar.eO(3, this.taN);
            aVar.eO(4, this.taO);
            aVar.eO(5, this.taP);
            aVar.eO(6, this.taQ);
            aVar.eO(7, this.taR);
            aVar.eO(8, this.taS);
            return 0;
        } else if (i == 1) {
            return (((((((a.a.a.a.eL(1, this.taM) + 0) + a.a.a.a.eL(2, this.action)) + a.a.a.a.eL(3, this.taN)) + a.a.a.a.eL(4, this.taO)) + a.a.a.a.eL(5, this.taP)) + a.a.a.a.eL(6, this.taQ)) + a.a.a.a.eL(7, this.taR)) + a.a.a.a.eL(8, this.taS);
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
                l lVar = (l) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        lVar.taM = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        lVar.action = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        lVar.taN = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        lVar.taO = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        lVar.taP = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        lVar.taQ = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        lVar.taR = aVar3.xmD.mL();
                        return 0;
                    case 8:
                        lVar.taS = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
