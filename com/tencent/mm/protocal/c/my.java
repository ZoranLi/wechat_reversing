package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class my extends a {
    public int hAR;
    public String hAS;
    public String hAT;
    public String hAU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.hAR);
            if (this.hAS != null) {
                aVar.e(2, this.hAS);
            }
            if (this.hAT != null) {
                aVar.e(3, this.hAT);
            }
            if (this.hAU != null) {
                aVar.e(4, this.hAU);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.hAR) + 0;
            if (this.hAS != null) {
                r0 += a.a.a.b.b.a.f(2, this.hAS);
            }
            if (this.hAT != null) {
                r0 += a.a.a.b.b.a.f(3, this.hAT);
            }
            if (this.hAU != null) {
                return r0 + a.a.a.b.b.a.f(4, this.hAU);
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
            my myVar = (my) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    myVar.hAR = aVar3.xmD.mL();
                    return 0;
                case 2:
                    myVar.hAS = aVar3.xmD.readString();
                    return 0;
                case 3:
                    myVar.hAT = aVar3.xmD.readString();
                    return 0;
                case 4:
                    myVar.hAU = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
