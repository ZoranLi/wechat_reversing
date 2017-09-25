package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bmk extends a {
    public b ulR;
    public b ulS;
    public b ulT;
    public b ulU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ulR != null) {
                aVar.b(1, this.ulR);
            }
            if (this.ulS != null) {
                aVar.b(2, this.ulS);
            }
            if (this.ulT != null) {
                aVar.b(3, this.ulT);
            }
            if (this.ulU == null) {
                return 0;
            }
            aVar.b(4, this.ulU);
            return 0;
        } else if (i == 1) {
            if (this.ulR != null) {
                r0 = a.a.a.a.a(1, this.ulR) + 0;
            } else {
                r0 = 0;
            }
            if (this.ulS != null) {
                r0 += a.a.a.a.a(2, this.ulS);
            }
            if (this.ulT != null) {
                r0 += a.a.a.a.a(3, this.ulT);
            }
            if (this.ulU != null) {
                r0 += a.a.a.a.a(4, this.ulU);
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
            bmk com_tencent_mm_protocal_c_bmk = (bmk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bmk.ulR = aVar3.cic();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bmk.ulS = aVar3.cic();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bmk.ulT = aVar3.cic();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bmk.ulU = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
