package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class cx extends a {
    public int iFa;
    public int tgl;
    public int tgm;
    public int tgn;
    public int tgo;
    public int tgp;
    public int tgq;
    public int tgr;
    public int tgs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tgl);
            aVar.eO(2, this.tgm);
            aVar.eO(3, this.tgn);
            aVar.eO(4, this.tgo);
            aVar.eO(5, this.tgp);
            aVar.eO(6, this.tgq);
            aVar.eO(7, this.tgr);
            aVar.eO(8, this.tgs);
            aVar.eO(9, this.iFa);
            return 0;
        } else if (i == 1) {
            return ((((((((a.a.a.a.eL(1, this.tgl) + 0) + a.a.a.a.eL(2, this.tgm)) + a.a.a.a.eL(3, this.tgn)) + a.a.a.a.eL(4, this.tgo)) + a.a.a.a.eL(5, this.tgp)) + a.a.a.a.eL(6, this.tgq)) + a.a.a.a.eL(7, this.tgr)) + a.a.a.a.eL(8, this.tgs)) + a.a.a.a.eL(9, this.iFa);
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
                cx cxVar = (cx) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cxVar.tgl = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        cxVar.tgm = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        cxVar.tgn = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        cxVar.tgo = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        cxVar.tgp = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        cxVar.tgq = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        cxVar.tgr = aVar3.xmD.mL();
                        return 0;
                    case 8:
                        cxVar.tgs = aVar3.xmD.mL();
                        return 0;
                    case 9:
                        cxVar.iFa = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
