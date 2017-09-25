package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bd.a;

public final class g extends a {
    public String country;
    public String gkB;
    public String gkC;
    public String hCE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.country != null) {
                aVar.e(1, this.country);
            }
            if (this.gkB != null) {
                aVar.e(2, this.gkB);
            }
            if (this.gkC != null) {
                aVar.e(3, this.gkC);
            }
            if (this.hCE == null) {
                return 0;
            }
            aVar.e(4, this.hCE);
            return 0;
        } else if (i == 1) {
            if (this.country != null) {
                r0 = a.a.a.b.b.a.f(1, this.country) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkB);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkC);
            }
            if (this.hCE != null) {
                r0 += a.a.a.b.b.a.f(4, this.hCE);
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
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.country = aVar3.xmD.readString();
                    return 0;
                case 2:
                    gVar.gkB = aVar3.xmD.readString();
                    return 0;
                case 3:
                    gVar.gkC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    gVar.hCE = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
