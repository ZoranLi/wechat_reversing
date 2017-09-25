package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class tz extends a {
    public int jOc;
    public String mtb;
    public int tCe;
    public int tfI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtb != null) {
                aVar.e(1, this.mtb);
            }
            aVar.eO(2, this.jOc);
            aVar.eO(3, this.tfI);
            aVar.eO(4, this.tCe);
            return 0;
        } else if (i == 1) {
            if (this.mtb != null) {
                r0 = a.a.a.b.b.a.f(1, this.mtb) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.eL(2, this.jOc)) + a.a.a.a.eL(3, this.tfI)) + a.a.a.a.eL(4, this.tCe);
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
            tz tzVar = (tz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tzVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 2:
                    tzVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    tzVar.tfI = aVar3.xmD.mL();
                    return 0;
                case 4:
                    tzVar.tCe = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
