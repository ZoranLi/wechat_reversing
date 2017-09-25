package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bd.a;

public final class n extends a {
    public int fRW;
    public String fTO;
    public String name;
    public String oqk;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fTO != null) {
                aVar.e(1, this.fTO);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.oqk != null) {
                aVar.e(3, this.oqk);
            }
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            aVar.eO(5, this.fRW);
            return 0;
        } else if (i == 1) {
            if (this.fTO != null) {
                r0 = a.a.a.b.b.a.f(1, this.fTO) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            if (this.oqk != null) {
                r0 += a.a.a.b.b.a.f(3, this.oqk);
            }
            if (this.username != null) {
                r0 += a.a.a.b.b.a.f(4, this.username);
            }
            return r0 + a.a.a.a.eL(5, this.fRW);
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
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.fTO = aVar3.xmD.readString();
                    return 0;
                case 2:
                    nVar.name = aVar3.xmD.readString();
                    return 0;
                case 3:
                    nVar.oqk = aVar3.xmD.readString();
                    return 0;
                case 4:
                    nVar.username = aVar3.xmD.readString();
                    return 0;
                case 5:
                    nVar.fRW = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
