package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class t extends a {
    public String tbD;
    public long tbE;
    public int tbF;
    public long tbq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tbD != null) {
                aVar.e(1, this.tbD);
            }
            aVar.O(2, this.tbq);
            aVar.O(3, this.tbE);
            aVar.eO(4, this.tbF);
            return 0;
        } else if (i == 1) {
            if (this.tbD != null) {
                r0 = a.a.a.b.b.a.f(1, this.tbD) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.N(2, this.tbq)) + a.a.a.a.N(3, this.tbE)) + a.a.a.a.eL(4, this.tbF);
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
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.tbD = aVar3.xmD.readString();
                    return 0;
                case 2:
                    tVar.tbq = aVar3.xmD.mM();
                    return 0;
                case 3:
                    tVar.tbE = aVar3.xmD.mM();
                    return 0;
                case 4:
                    tVar.tbF = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
