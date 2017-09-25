package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ara extends a {
    public int tVv;
    public int tVw;
    public String tVx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tVv);
            aVar.eO(2, this.tVw);
            if (this.tVx != null) {
                aVar.e(3, this.tVx);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.tVv) + 0) + a.a.a.a.eL(2, this.tVw);
            if (this.tVx != null) {
                return r0 + a.a.a.b.b.a.f(3, this.tVx);
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
            ara com_tencent_mm_protocal_c_ara = (ara) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ara.tVv = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ara.tVw = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ara.tVx = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
