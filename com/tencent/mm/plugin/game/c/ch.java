package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class ch extends a {
    public String fDC;
    public String msF;
    public String msG;
    public String muU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.muU != null) {
                aVar.e(1, this.muU);
            }
            if (this.fDC != null) {
                aVar.e(2, this.fDC);
            }
            if (this.msF != null) {
                aVar.e(3, this.msF);
            }
            if (this.msG == null) {
                return 0;
            }
            aVar.e(4, this.msG);
            return 0;
        } else if (i == 1) {
            if (this.muU != null) {
                r0 = a.a.a.b.b.a.f(1, this.muU) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(3, this.msF);
            }
            if (this.msG != null) {
                r0 += a.a.a.b.b.a.f(4, this.msG);
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
            ch chVar = (ch) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chVar.muU = aVar3.xmD.readString();
                    return 0;
                case 2:
                    chVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    chVar.msF = aVar3.xmD.readString();
                    return 0;
                case 4:
                    chVar.msG = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
