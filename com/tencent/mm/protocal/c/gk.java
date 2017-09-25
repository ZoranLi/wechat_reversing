package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class gk extends a {
    public b tkj;
    public b tkk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tkj != null) {
                aVar.b(1, this.tkj);
            }
            if (this.tkk == null) {
                return 0;
            }
            aVar.b(2, this.tkk);
            return 0;
        } else if (i == 1) {
            if (this.tkj != null) {
                r0 = a.a.a.a.a(1, this.tkj) + 0;
            } else {
                r0 = 0;
            }
            if (this.tkk != null) {
                r0 += a.a.a.a.a(2, this.tkk);
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
            gk gkVar = (gk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gkVar.tkj = aVar3.cic();
                    return 0;
                case 2:
                    gkVar.tkk = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
