package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class lq extends a {
    public String jNP;
    public int tdM;
    public String trY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.trY == null) {
                throw new b("Not all required fields were included: PkgId");
            }
            if (this.trY != null) {
                aVar.e(1, this.trY);
            }
            if (this.jNP != null) {
                aVar.e(2, this.jNP);
            }
            aVar.eO(3, this.tdM);
            return 0;
        } else if (i == 1) {
            if (this.trY != null) {
                r0 = a.a.a.b.b.a.f(1, this.trY) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNP != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNP);
            }
            return r0 + a.a.a.a.eL(3, this.tdM);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.trY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PkgId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            lq lqVar = (lq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lqVar.trY = aVar3.xmD.readString();
                    return 0;
                case 2:
                    lqVar.jNP = aVar3.xmD.readString();
                    return 0;
                case 3:
                    lqVar.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
