package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bd.a;

public final class g extends a {
    public String qaQ;
    public int qaR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.qaQ != null) {
                aVar.e(1, this.qaQ);
            }
            aVar.eO(2, this.qaR);
            return 0;
        } else if (i == 1) {
            if (this.qaQ != null) {
                r0 = a.a.a.b.b.a.f(1, this.qaQ) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.eL(2, this.qaR);
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
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.qaQ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    gVar.qaR = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
