package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bma extends a {
    public String hAM;
    public String ulM;
    public int ulN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ulM != null) {
                aVar.e(1, this.ulM);
            }
            if (this.hAM != null) {
                aVar.e(2, this.hAM);
            }
            aVar.eO(3, this.ulN);
            return 0;
        } else if (i == 1) {
            if (this.ulM != null) {
                r0 = a.a.a.b.b.a.f(1, this.ulM) + 0;
            } else {
                r0 = 0;
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(2, this.hAM);
            }
            return r0 + a.a.a.a.eL(3, this.ulN);
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
            bma com_tencent_mm_protocal_c_bma = (bma) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bma.ulM = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bma.hAM = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bma.ulN = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
