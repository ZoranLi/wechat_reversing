package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class jn extends a {
    public String fVl;
    public int kdL;
    public String khm;
    public int tpx;
    public String tpy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fVl != null) {
                aVar.e(1, this.fVl);
            }
            if (this.khm != null) {
                aVar.e(2, this.khm);
            }
            aVar.eO(3, this.kdL);
            aVar.eO(4, this.tpx);
            if (this.tpy == null) {
                return 0;
            }
            aVar.e(5, this.tpy);
            return 0;
        } else if (i == 1) {
            if (this.fVl != null) {
                r0 = a.a.a.b.b.a.f(1, this.fVl) + 0;
            } else {
                r0 = 0;
            }
            if (this.khm != null) {
                r0 += a.a.a.b.b.a.f(2, this.khm);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.kdL)) + a.a.a.a.eL(4, this.tpx);
            if (this.tpy != null) {
                r0 += a.a.a.b.b.a.f(5, this.tpy);
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
            jn jnVar = (jn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jnVar.fVl = aVar3.xmD.readString();
                    return 0;
                case 2:
                    jnVar.khm = aVar3.xmD.readString();
                    return 0;
                case 3:
                    jnVar.kdL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    jnVar.tpx = aVar3.xmD.mL();
                    return 0;
                case 5:
                    jnVar.tpy = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
