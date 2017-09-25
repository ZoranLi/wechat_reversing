package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class em extends a {
    public int leD;
    public int tdM;
    public b tiA;
    public b tiB;
    public int tiC;
    public b tiD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tiA != null) {
                aVar.b(1, this.tiA);
            }
            aVar.eO(2, this.leD);
            if (this.tiB != null) {
                aVar.b(3, this.tiB);
            }
            aVar.eO(4, this.tiC);
            if (this.tiD != null) {
                aVar.b(5, this.tiD);
            }
            aVar.eO(6, this.tdM);
            return 0;
        } else if (i == 1) {
            if (this.tiA != null) {
                r0 = a.a.a.a.a(1, this.tiA) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.leD);
            if (this.tiB != null) {
                r0 += a.a.a.a.a(3, this.tiB);
            }
            r0 += a.a.a.a.eL(4, this.tiC);
            if (this.tiD != null) {
                r0 += a.a.a.a.a(5, this.tiD);
            }
            return r0 + a.a.a.a.eL(6, this.tdM);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            em emVar = (em) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emVar.tiA = aVar3.cic();
                    return 0;
                case 2:
                    emVar.leD = aVar3.xmD.mL();
                    return 0;
                case 3:
                    emVar.tiB = aVar3.cic();
                    return 0;
                case 4:
                    emVar.tiC = aVar3.xmD.mL();
                    return 0;
                case 5:
                    emVar.tiD = aVar3.cic();
                    return 0;
                case 6:
                    emVar.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
