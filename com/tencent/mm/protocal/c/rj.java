package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class rj extends a {
    public int jNB;
    public String jNj;
    public String jOp;
    public String tuS;
    public String twU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNj != null) {
                aVar.e(1, this.jNj);
            }
            if (this.twU != null) {
                aVar.e(2, this.twU);
            }
            if (this.jOp != null) {
                aVar.e(3, this.jOp);
            }
            if (this.tuS != null) {
                aVar.e(4, this.tuS);
            }
            aVar.eO(5, this.jNB);
            return 0;
        } else if (i == 1) {
            if (this.jNj != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNj) + 0;
            } else {
                r0 = 0;
            }
            if (this.twU != null) {
                r0 += a.a.a.b.b.a.f(2, this.twU);
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(3, this.jOp);
            }
            if (this.tuS != null) {
                r0 += a.a.a.b.b.a.f(4, this.tuS);
            }
            return r0 + a.a.a.a.eL(5, this.jNB);
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
            rj rjVar = (rj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rjVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    rjVar.twU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    rjVar.jOp = aVar3.xmD.readString();
                    return 0;
                case 4:
                    rjVar.tuS = aVar3.xmD.readString();
                    return 0;
                case 5:
                    rjVar.jNB = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
