package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class bf extends a {
    public String fDC;
    public String msE;
    public String msF;
    public String msk;
    public int muW;
    public String muX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC != null) {
                aVar.e(1, this.fDC);
            }
            if (this.msk != null) {
                aVar.e(2, this.msk);
            }
            if (this.msE != null) {
                aVar.e(3, this.msE);
            }
            aVar.eO(4, this.muW);
            if (this.muX != null) {
                aVar.e(5, this.muX);
            }
            if (this.msF == null) {
                return 0;
            }
            aVar.e(6, this.msF);
            return 0;
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(2, this.msk);
            }
            if (this.msE != null) {
                r0 += a.a.a.b.b.a.f(3, this.msE);
            }
            r0 += a.a.a.a.eL(4, this.muW);
            if (this.muX != null) {
                r0 += a.a.a.b.b.a.f(5, this.muX);
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(6, this.msF);
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
            bf bfVar = (bf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    bfVar.msk = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bfVar.msE = aVar3.xmD.readString();
                    return 0;
                case 4:
                    bfVar.muW = aVar3.xmD.mL();
                    return 0;
                case 5:
                    bfVar.muX = aVar3.xmD.readString();
                    return 0;
                case 6:
                    bfVar.msF = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
