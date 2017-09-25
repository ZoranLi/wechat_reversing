package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class da extends a {
    public b tgu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgu == null) {
                throw new a.a.a.b("Not all required fields were included: Cookies");
            } else if (this.tgu == null) {
                return 0;
            } else {
                aVar.b(1, this.tgu);
                return 0;
            }
        } else if (i == 1) {
            if (this.tgu != null) {
                r0 = a.a.a.a.a(1, this.tgu) + 0;
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
            if (this.tgu != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Cookies");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            da daVar = (da) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    daVar.tgu = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
