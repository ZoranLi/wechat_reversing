package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class xj extends a {
    public String tuq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tuq == null) {
                throw new b("Not all required fields were included: DesignerID");
            } else if (this.tuq == null) {
                return 0;
            } else {
                aVar.e(1, this.tuq);
                return 0;
            }
        } else if (i == 1) {
            if (this.tuq != null) {
                r0 = a.a.a.b.b.a.f(1, this.tuq) + 0;
            } else {
                r0 = 0;
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tuq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DesignerID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xj xjVar = (xj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xjVar.tuq = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
