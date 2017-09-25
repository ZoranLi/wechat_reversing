package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class aym extends a {
    public b tMi;
    public b uaw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.uaw == null) {
                throw new a.a.a.b("Not all required fields were included: Name");
            } else if (this.tMi == null) {
                throw new a.a.a.b("Not all required fields were included: Value");
            } else {
                if (this.uaw != null) {
                    aVar.b(1, this.uaw);
                }
                if (this.tMi == null) {
                    return 0;
                }
                aVar.b(2, this.tMi);
                return 0;
            }
        } else if (i == 1) {
            if (this.uaw != null) {
                r0 = a.a.a.a.a(1, this.uaw) + 0;
            } else {
                r0 = 0;
            }
            if (this.tMi != null) {
                r0 += a.a.a.a.a(2, this.tMi);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uaw == null) {
                throw new a.a.a.b("Not all required fields were included: Name");
            } else if (this.tMi != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Value");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aym com_tencent_mm_protocal_c_aym = (aym) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aym.uaw = aVar3.cic();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aym.tMi = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
