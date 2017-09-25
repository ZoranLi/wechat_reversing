package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bp extends a {
    public int jOc;
    public int teS;
    public int teT;
    public int teU;
    public int teV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.teS);
            aVar.eO(2, this.jOc);
            aVar.eO(3, this.teT);
            aVar.eO(4, this.teU);
            aVar.eO(5, this.teV);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.eL(1, this.teS) + 0) + a.a.a.a.eL(2, this.jOc)) + a.a.a.a.eL(3, this.teT)) + a.a.a.a.eL(4, this.teU)) + a.a.a.a.eL(5, this.teV);
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
                bp bpVar = (bp) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bpVar.teS = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        bpVar.jOc = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        bpVar.teT = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        bpVar.teU = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        bpVar.teV = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
