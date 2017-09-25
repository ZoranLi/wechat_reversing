package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aqq extends a {
    public String tVm;
    public String tVn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tVm != null) {
                aVar.e(1, this.tVm);
            }
            if (this.tVn == null) {
                return 0;
            }
            aVar.e(2, this.tVn);
            return 0;
        } else if (i == 1) {
            if (this.tVm != null) {
                r0 = a.a.a.b.b.a.f(1, this.tVm) + 0;
            } else {
                r0 = 0;
            }
            if (this.tVn != null) {
                r0 += a.a.a.b.b.a.f(2, this.tVn);
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
            aqq com_tencent_mm_protocal_c_aqq = (aqq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqq.tVm = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqq.tVn = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
