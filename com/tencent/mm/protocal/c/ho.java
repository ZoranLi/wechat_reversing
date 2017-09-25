package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ho extends a {
    public String fTO;
    public int tlI;
    public int tlJ;
    public String tlK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fTO != null) {
                aVar.e(1, this.fTO);
            }
            aVar.eO(2, this.tlI);
            aVar.eO(3, this.tlJ);
            if (this.tlK == null) {
                return 0;
            }
            aVar.e(4, this.tlK);
            return 0;
        } else if (i == 1) {
            if (this.fTO != null) {
                r0 = a.a.a.b.b.a.f(1, this.fTO) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tlI)) + a.a.a.a.eL(3, this.tlJ);
            if (this.tlK != null) {
                r0 += a.a.a.b.b.a.f(4, this.tlK);
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
            ho hoVar = (ho) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hoVar.fTO = aVar3.xmD.readString();
                    return 0;
                case 2:
                    hoVar.tlI = aVar3.xmD.mL();
                    return 0;
                case 3:
                    hoVar.tlJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    hoVar.tlK = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
