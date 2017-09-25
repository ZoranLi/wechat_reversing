package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class asj extends a {
    public String tAB;
    public int tGq;
    public int tWL;
    public String tuy;
    public int tvO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tGq);
            if (this.tAB != null) {
                aVar.e(2, this.tAB);
            }
            if (this.tuy != null) {
                aVar.e(3, this.tuy);
            }
            aVar.eO(4, this.tvO);
            aVar.eO(5, this.tWL);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tGq) + 0;
            if (this.tAB != null) {
                r0 += a.a.a.b.b.a.f(2, this.tAB);
            }
            if (this.tuy != null) {
                r0 += a.a.a.b.b.a.f(3, this.tuy);
            }
            return (r0 + a.a.a.a.eL(4, this.tvO)) + a.a.a.a.eL(5, this.tWL);
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
            asj com_tencent_mm_protocal_c_asj = (asj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_asj.tGq = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asj.tAB = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asj.tuy = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asj.tvO = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asj.tWL = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
