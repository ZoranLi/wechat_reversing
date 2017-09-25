package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bd.a;

public final class f extends a {
    public int qaN;
    public long qaP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.qaP);
            aVar.eO(2, this.qaN);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.N(1, this.qaP) + 0) + a.a.a.a.eL(2, this.qaN);
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
                f fVar = (f) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        fVar.qaP = aVar3.xmD.mM();
                        return 0;
                    case 2:
                        fVar.qaN = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
