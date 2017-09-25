package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class bh extends a {
    public String fDC;
    public String msE;
    public String msF;
    public String msG;
    public String msk;
    public String muQ;
    public String muZ;
    public String mva;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.muQ != null) {
                aVar.e(1, this.muQ);
            }
            if (this.muZ != null) {
                aVar.e(2, this.muZ);
            }
            if (this.fDC != null) {
                aVar.e(3, this.fDC);
            }
            if (this.msk != null) {
                aVar.e(4, this.msk);
            }
            if (this.mva != null) {
                aVar.e(5, this.mva);
            }
            if (this.msF != null) {
                aVar.e(6, this.msF);
            }
            if (this.msE != null) {
                aVar.e(7, this.msE);
            }
            if (this.msG == null) {
                return 0;
            }
            aVar.e(8, this.msG);
            return 0;
        } else if (i == 1) {
            if (this.muQ != null) {
                r0 = a.a.a.b.b.a.f(1, this.muQ) + 0;
            } else {
                r0 = 0;
            }
            if (this.muZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.muZ);
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(3, this.fDC);
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(4, this.msk);
            }
            if (this.mva != null) {
                r0 += a.a.a.b.b.a.f(5, this.mva);
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(6, this.msF);
            }
            if (this.msE != null) {
                r0 += a.a.a.b.b.a.f(7, this.msE);
            }
            if (this.msG != null) {
                r0 += a.a.a.b.b.a.f(8, this.msG);
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
            bh bhVar = (bh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhVar.muQ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    bhVar.muZ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bhVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    bhVar.msk = aVar3.xmD.readString();
                    return 0;
                case 5:
                    bhVar.mva = aVar3.xmD.readString();
                    return 0;
                case 6:
                    bhVar.msF = aVar3.xmD.readString();
                    return 0;
                case 7:
                    bhVar.msE = aVar3.xmD.readString();
                    return 0;
                case 8:
                    bhVar.msG = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
