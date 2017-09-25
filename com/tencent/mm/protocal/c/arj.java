package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class arj extends a {
    public String fNG;
    public String tVU;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fNG != null) {
                aVar.e(1, this.fNG);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.tVU == null) {
                return 0;
            }
            aVar.e(3, this.tVU);
            return 0;
        } else if (i == 1) {
            if (this.fNG != null) {
                r0 = a.a.a.b.b.a.f(1, this.fNG) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(2, this.url);
            }
            if (this.tVU != null) {
                r0 += a.a.a.b.b.a.f(3, this.tVU);
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
            arj com_tencent_mm_protocal_c_arj = (arj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_arj.fNG = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_arj.url = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arj.tVU = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
