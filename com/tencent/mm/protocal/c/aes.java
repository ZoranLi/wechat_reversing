package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class aes extends a {
    public b tJX;
    public b tiB;
    public b tiD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tiD != null) {
                aVar.b(1, this.tiD);
            }
            if (this.tiB != null) {
                aVar.b(2, this.tiB);
            }
            if (this.tJX == null) {
                return 0;
            }
            aVar.b(3, this.tJX);
            return 0;
        } else if (i == 1) {
            if (this.tiD != null) {
                r0 = a.a.a.a.a(1, this.tiD) + 0;
            } else {
                r0 = 0;
            }
            if (this.tiB != null) {
                r0 += a.a.a.a.a(2, this.tiB);
            }
            if (this.tJX != null) {
                r0 += a.a.a.a.a(3, this.tJX);
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
            aes com_tencent_mm_protocal_c_aes = (aes) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aes.tiD = aVar3.cic();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aes.tiB = aVar3.cic();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aes.tJX = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
