package com.tencent.mm.u;

import com.tencent.mm.bd.a;

public final class bk extends a {
    public String hnS;
    public long hnT;
    public int key;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.key);
            if (this.hnS != null) {
                aVar.e(2, this.hnS);
            }
            aVar.O(3, this.hnT);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.key) + 0;
            if (this.hnS != null) {
                r0 += a.a.a.b.b.a.f(2, this.hnS);
            }
            return r0 + a.a.a.a.N(3, this.hnT);
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
            bk bkVar = (bk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkVar.key = aVar3.xmD.mL();
                    return 0;
                case 2:
                    bkVar.hnS = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bkVar.hnT = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
