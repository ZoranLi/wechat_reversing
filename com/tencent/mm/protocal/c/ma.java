package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ma extends a {
    public String arH;
    public long tsi;
    public String tsj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.arH == null) {
                throw new b("Not all required fields were included: key");
            }
            if (this.arH != null) {
                aVar.e(1, this.arH);
            }
            aVar.O(2, this.tsi);
            if (this.tsj == null) {
                return 0;
            }
            aVar.e(3, this.tsj);
            return 0;
        } else if (i == 1) {
            if (this.arH != null) {
                r0 = a.a.a.b.b.a.f(1, this.arH) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.N(2, this.tsi);
            if (this.tsj != null) {
                r0 += a.a.a.b.b.a.f(3, this.tsj);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.arH != null) {
                return 0;
            }
            throw new b("Not all required fields were included: key");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ma maVar = (ma) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    maVar.arH = aVar3.xmD.readString();
                    return 0;
                case 2:
                    maVar.tsi = aVar3.xmD.mM();
                    return 0;
                case 3:
                    maVar.tsj = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
