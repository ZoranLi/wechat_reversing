package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class cg extends a {
    public String msE;
    public String msF;
    public String msG;
    public int mvT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msE != null) {
                aVar.e(1, this.msE);
            }
            if (this.msF != null) {
                aVar.e(2, this.msF);
            }
            aVar.eO(3, this.mvT);
            if (this.msG == null) {
                return 0;
            }
            aVar.e(4, this.msG);
            return 0;
        } else if (i == 1) {
            if (this.msE != null) {
                r0 = a.a.a.b.b.a.f(1, this.msE) + 0;
            } else {
                r0 = 0;
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(2, this.msF);
            }
            r0 += a.a.a.a.eL(3, this.mvT);
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
            cg cgVar = (cg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgVar.msE = aVar3.xmD.readString();
                    return 0;
                case 2:
                    cgVar.msF = aVar3.xmD.readString();
                    return 0;
                case 3:
                    cgVar.mvT = aVar3.xmD.mL();
                    return 0;
                case 4:
                    cgVar.msG = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
