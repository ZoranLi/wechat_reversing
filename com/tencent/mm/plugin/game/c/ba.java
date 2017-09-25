package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ba extends a {
    public String fDC;
    public String mse;
    public String mtg;
    public String muM;
    public String muQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.muM != null) {
                aVar.e(1, this.muM);
            }
            if (this.fDC != null) {
                aVar.e(2, this.fDC);
            }
            if (this.mtg != null) {
                aVar.e(3, this.mtg);
            }
            if (this.mse != null) {
                aVar.e(4, this.mse);
            }
            if (this.muQ == null) {
                return 0;
            }
            aVar.e(5, this.muQ);
            return 0;
        } else if (i == 1) {
            if (this.muM != null) {
                r0 = a.a.a.b.b.a.f(1, this.muM) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            if (this.mtg != null) {
                r0 += a.a.a.b.b.a.f(3, this.mtg);
            }
            if (this.mse != null) {
                r0 += a.a.a.b.b.a.f(4, this.mse);
            }
            if (this.muQ != null) {
                r0 += a.a.a.b.b.a.f(5, this.muQ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.fDC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ba baVar = (ba) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    baVar.muM = aVar3.xmD.readString();
                    return 0;
                case 2:
                    baVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    baVar.mtg = aVar3.xmD.readString();
                    return 0;
                case 4:
                    baVar.mse = aVar3.xmD.readString();
                    return 0;
                case 5:
                    baVar.muQ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
