package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class pg extends a {
    public String muU;
    public int tiJ;
    public String tuP;
    public String tuQ;
    public int tuR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tuQ != null) {
                aVar.e(1, this.tuQ);
            }
            aVar.eO(2, this.tiJ);
            aVar.eO(3, this.tuR);
            if (this.muU != null) {
                aVar.e(4, this.muU);
            }
            if (this.tuP == null) {
                return 0;
            }
            aVar.e(5, this.tuP);
            return 0;
        } else if (i == 1) {
            if (this.tuQ != null) {
                r0 = a.a.a.b.b.a.f(1, this.tuQ) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tiJ)) + a.a.a.a.eL(3, this.tuR);
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(4, this.muU);
            }
            if (this.tuP != null) {
                r0 += a.a.a.b.b.a.f(5, this.tuP);
            }
            return r0;
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
            pg pgVar = (pg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pgVar.tuQ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    pgVar.tiJ = aVar3.xmD.mL();
                    return 0;
                case 3:
                    pgVar.tuR = aVar3.xmD.mL();
                    return 0;
                case 4:
                    pgVar.muU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    pgVar.tuP = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
