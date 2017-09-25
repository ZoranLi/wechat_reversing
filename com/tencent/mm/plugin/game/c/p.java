package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class p extends a {
    public String jOp;
    public String mtf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtf != null) {
                aVar.e(1, this.mtf);
            }
            if (this.jOp == null) {
                return 0;
            }
            aVar.e(3, this.jOp);
            return 0;
        } else if (i == 1) {
            if (this.mtf != null) {
                r0 = a.a.a.b.b.a.f(1, this.mtf) + 0;
            } else {
                r0 = 0;
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(3, this.jOp);
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
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.mtf = aVar3.xmD.readString();
                    return 0;
                case 3:
                    pVar.jOp = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
