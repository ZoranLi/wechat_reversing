package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class k extends a {
    public String msP;
    public String msQ;
    public String msR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msP != null) {
                aVar.e(1, this.msP);
            }
            if (this.msQ != null) {
                aVar.e(2, this.msQ);
            }
            if (this.msR == null) {
                return 0;
            }
            aVar.e(3, this.msR);
            return 0;
        } else if (i == 1) {
            if (this.msP != null) {
                r0 = a.a.a.b.b.a.f(1, this.msP) + 0;
            } else {
                r0 = 0;
            }
            if (this.msQ != null) {
                r0 += a.a.a.b.b.a.f(2, this.msQ);
            }
            if (this.msR != null) {
                r0 += a.a.a.b.b.a.f(3, this.msR);
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
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.msP = aVar3.xmD.readString();
                    return 0;
                case 2:
                    kVar.msQ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    kVar.msR = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
