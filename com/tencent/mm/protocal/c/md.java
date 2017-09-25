package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class md extends a {
    public String fEL;
    public String fEM;
    public int tso;
    public int tsp;
    public String tsq;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.version);
            aVar.eO(2, this.tso);
            aVar.eO(3, this.tsp);
            if (this.fEM != null) {
                aVar.e(4, this.fEM);
            }
            if (this.tsq != null) {
                aVar.e(5, this.tsq);
            }
            if (this.fEL != null) {
                aVar.e(6, this.fEL);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.version) + 0) + a.a.a.a.eL(2, this.tso)) + a.a.a.a.eL(3, this.tsp);
            if (this.fEM != null) {
                r0 += a.a.a.b.b.a.f(4, this.fEM);
            }
            if (this.tsq != null) {
                r0 += a.a.a.b.b.a.f(5, this.tsq);
            }
            if (this.fEL != null) {
                return r0 + a.a.a.b.b.a.f(6, this.fEL);
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
            md mdVar = (md) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mdVar.version = aVar3.xmD.mL();
                    return 0;
                case 2:
                    mdVar.tso = aVar3.xmD.mL();
                    return 0;
                case 3:
                    mdVar.tsp = aVar3.xmD.mL();
                    return 0;
                case 4:
                    mdVar.fEM = aVar3.xmD.readString();
                    return 0;
                case 5:
                    mdVar.tsq = aVar3.xmD.readString();
                    return 0;
                case 6:
                    mdVar.fEL = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
