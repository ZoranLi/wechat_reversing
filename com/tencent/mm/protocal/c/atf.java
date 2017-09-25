package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class atf extends a {
    public String jNj;
    public String tBM;
    public String twU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNj != null) {
                aVar.e(1, this.jNj);
            }
            if (this.tBM != null) {
                aVar.e(2, this.tBM);
            }
            if (this.twU == null) {
                return 0;
            }
            aVar.e(3, this.twU);
            return 0;
        } else if (i == 1) {
            if (this.jNj != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNj) + 0;
            } else {
                r0 = 0;
            }
            if (this.tBM != null) {
                r0 += a.a.a.b.b.a.f(2, this.tBM);
            }
            if (this.twU != null) {
                r0 += a.a.a.b.b.a.f(3, this.twU);
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
            atf com_tencent_mm_protocal_c_atf = (atf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_atf.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_atf.tBM = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_atf.twU = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
