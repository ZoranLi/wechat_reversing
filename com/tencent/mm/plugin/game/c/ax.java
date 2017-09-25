package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ax extends a {
    public String fDC;
    public String mse;
    public String mtg;
    public String muM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.muM == null) {
                throw new b("Not all required fields were included: LogoURL");
            } else if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.mtg == null) {
                throw new b("Not all required fields were included: Detail");
            } else if (this.mse == null) {
                throw new b("Not all required fields were included: WebURL");
            } else {
                if (this.muM != null) {
                    aVar.e(1, this.muM);
                }
                if (this.fDC != null) {
                    aVar.e(2, this.fDC);
                }
                if (this.mtg != null) {
                    aVar.e(3, this.mtg);
                }
                if (this.mse == null) {
                    return 0;
                }
                aVar.e(4, this.mse);
                return 0;
            }
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
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.muM == null) {
                throw new b("Not all required fields were included: LogoURL");
            } else if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.mtg == null) {
                throw new b("Not all required fields were included: Detail");
            } else if (this.mse != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: WebURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ax axVar = (ax) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axVar.muM = aVar3.xmD.readString();
                    return 0;
                case 2:
                    axVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    axVar.mtg = aVar3.xmD.readString();
                    return 0;
                case 4:
                    axVar.mse = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
