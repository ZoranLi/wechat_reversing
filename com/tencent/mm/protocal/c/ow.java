package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ow extends a {
    public int tuw;
    public String tux;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tux == null) {
                throw new b("Not all required fields were included: TagDesc");
            }
            aVar.eO(1, this.tuw);
            if (this.tux != null) {
                aVar.e(2, this.tux);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tuw) + 0;
            if (this.tux != null) {
                return r0 + a.a.a.b.b.a.f(2, this.tux);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tux != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TagDesc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ow owVar = (ow) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    owVar.tuw = aVar3.xmD.mL();
                    return 0;
                case 2:
                    owVar.tux = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
