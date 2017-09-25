package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ako extends a {
    public int jOc;
    public int scene;
    public long tOi;
    public long tOj;
    public String tlt;
    public String tmb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.scene);
            if (this.tlt != null) {
                aVar.e(2, this.tlt);
            }
            aVar.O(3, this.tOi);
            aVar.O(4, this.tOj);
            if (this.tmb != null) {
                aVar.e(5, this.tmb);
            }
            aVar.eO(6, this.jOc);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.scene) + 0;
            if (this.tlt != null) {
                r0 += a.a.a.b.b.a.f(2, this.tlt);
            }
            r0 = (r0 + a.a.a.a.N(3, this.tOi)) + a.a.a.a.N(4, this.tOj);
            if (this.tmb != null) {
                r0 += a.a.a.b.b.a.f(5, this.tmb);
            }
            return r0 + a.a.a.a.eL(6, this.jOc);
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
            ako com_tencent_mm_protocal_c_ako = (ako) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ako.scene = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ako.tlt = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ako.tOi = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ako.tOj = aVar3.xmD.mM();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ako.tmb = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ako.jOc = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
