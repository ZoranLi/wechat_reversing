package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class baf extends a {
    public int jOb;
    public b ubt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ubt == null) {
                throw new a.a.a.b("Not all required fields were included: Signature");
            }
            aVar.eO(1, this.jOb);
            if (this.ubt != null) {
                aVar.b(2, this.ubt);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.jOb) + 0;
            if (this.ubt != null) {
                return r0 + a.a.a.a.a(2, this.ubt);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ubt != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Signature");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            baf com_tencent_mm_protocal_c_baf = (baf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_baf.jOb = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_baf.ubt = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
