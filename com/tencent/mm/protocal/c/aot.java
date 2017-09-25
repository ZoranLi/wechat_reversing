package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aot extends a {
    public String fVl;
    public String kfv;
    public int tTQ;
    public int tTR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fVl != null) {
                aVar.e(1, this.fVl);
            }
            if (this.kfv != null) {
                aVar.e(2, this.kfv);
            }
            aVar.eO(3, this.tTQ);
            aVar.eO(4, this.tTR);
            return 0;
        } else if (i == 1) {
            if (this.fVl != null) {
                r0 = a.a.a.b.b.a.f(1, this.fVl) + 0;
            } else {
                r0 = 0;
            }
            if (this.kfv != null) {
                r0 += a.a.a.b.b.a.f(2, this.kfv);
            }
            return (r0 + a.a.a.a.eL(3, this.tTQ)) + a.a.a.a.eL(4, this.tTR);
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
            aot com_tencent_mm_protocal_c_aot = (aot) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aot.fVl = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aot.kfv = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aot.tTQ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aot.tTR = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
