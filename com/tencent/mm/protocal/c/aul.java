package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aul extends a {
    public String leE;
    public int tXk;
    public String tiU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.leE != null) {
                aVar.e(1, this.leE);
            }
            if (this.tiU != null) {
                aVar.e(2, this.tiU);
            }
            aVar.eO(3, this.tXk);
            return 0;
        } else if (i == 1) {
            if (this.leE != null) {
                r0 = a.a.a.b.b.a.f(1, this.leE) + 0;
            } else {
                r0 = 0;
            }
            if (this.tiU != null) {
                r0 += a.a.a.b.b.a.f(2, this.tiU);
            }
            return r0 + a.a.a.a.eL(3, this.tXk);
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
            aul com_tencent_mm_protocal_c_aul = (aul) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aul.leE = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aul.tiU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aul.tXk = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
