package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class pi extends a {
    public String fDC;
    public String msk;
    public String tuS;
    public String tuT;
    public String tuU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC != null) {
                aVar.e(1, this.fDC);
            }
            if (this.tuS != null) {
                aVar.e(2, this.tuS);
            }
            if (this.tuT != null) {
                aVar.e(3, this.tuT);
            }
            if (this.msk != null) {
                aVar.e(4, this.msk);
            }
            if (this.tuU == null) {
                return 0;
            }
            aVar.e(5, this.tuU);
            return 0;
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.tuS != null) {
                r0 += a.a.a.b.b.a.f(2, this.tuS);
            }
            if (this.tuT != null) {
                r0 += a.a.a.b.b.a.f(3, this.tuT);
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(4, this.msk);
            }
            if (this.tuU != null) {
                r0 += a.a.a.b.b.a.f(5, this.tuU);
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
            pi piVar = (pi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    piVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    piVar.tuS = aVar3.xmD.readString();
                    return 0;
                case 3:
                    piVar.tuT = aVar3.xmD.readString();
                    return 0;
                case 4:
                    piVar.msk = aVar3.xmD.readString();
                    return 0;
                case 5:
                    piVar.tuU = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
