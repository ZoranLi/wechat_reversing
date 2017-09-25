package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class qq extends a {
    public String msj;
    public long oUv;
    public int tws;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.oUv);
            if (this.msj != null) {
                aVar.e(2, this.msj);
            }
            aVar.eO(3, this.tws);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.oUv) + 0;
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(2, this.msj);
            }
            return r0 + a.a.a.a.eL(3, this.tws);
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
            qq qqVar = (qq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qqVar.oUv = aVar3.xmD.mM();
                    return 0;
                case 2:
                    qqVar.msj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    qqVar.tws = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
