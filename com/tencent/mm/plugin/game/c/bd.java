package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class bd extends a {
    public String fDC;
    public String msF;
    public String muU;
    public String muV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC != null) {
                aVar.e(1, this.fDC);
            }
            if (this.muU != null) {
                aVar.e(2, this.muU);
            }
            if (this.msF != null) {
                aVar.e(3, this.msF);
            }
            if (this.muV == null) {
                return 0;
            }
            aVar.e(4, this.muV);
            return 0;
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(2, this.muU);
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(3, this.msF);
            }
            if (this.muV != null) {
                r0 += a.a.a.b.b.a.f(4, this.muV);
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
            bd bdVar = (bd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    bdVar.muU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bdVar.msF = aVar3.xmD.readString();
                    return 0;
                case 4:
                    bdVar.muV = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
