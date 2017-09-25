package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class nv extends a {
    public String ttB;
    public int ttC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttB != null) {
                aVar.e(1, this.ttB);
            }
            aVar.eO(2, this.ttC);
            return 0;
        } else if (i == 1) {
            if (this.ttB != null) {
                r0 = a.a.a.b.b.a.f(1, this.ttB) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.eL(2, this.ttC);
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
            nv nvVar = (nv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nvVar.ttB = aVar3.xmD.readString();
                    return 0;
                case 2:
                    nvVar.ttC = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
