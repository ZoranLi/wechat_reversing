package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ic extends a {
    public long tmx;
    public String tmy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tmy == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            aVar.O(1, this.tmx);
            if (this.tmy != null) {
                aVar.e(2, this.tmy);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.tmx) + 0;
            if (this.tmy != null) {
                return r0 + a.a.a.b.b.a.f(2, this.tmy);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tmy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ic icVar = (ic) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    icVar.tmx = aVar3.xmD.mM();
                    return 0;
                case 2:
                    icVar.tmy = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
