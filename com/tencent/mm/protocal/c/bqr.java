package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bqr extends a {
    public int uoF;
    public int uoG;
    public String uoH;
    public String uoI;
    public String uoJ;
    public int uoK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.uoF);
            aVar.eO(2, this.uoG);
            if (this.uoH != null) {
                aVar.e(3, this.uoH);
            }
            if (this.uoI != null) {
                aVar.e(4, this.uoI);
            }
            if (this.uoJ != null) {
                aVar.e(5, this.uoJ);
            }
            aVar.eO(6, this.uoK);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.uoF) + 0) + a.a.a.a.eL(2, this.uoG);
            if (this.uoH != null) {
                r0 += a.a.a.b.b.a.f(3, this.uoH);
            }
            if (this.uoI != null) {
                r0 += a.a.a.b.b.a.f(4, this.uoI);
            }
            if (this.uoJ != null) {
                r0 += a.a.a.b.b.a.f(5, this.uoJ);
            }
            return r0 + a.a.a.a.eL(6, this.uoK);
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
            bqr com_tencent_mm_protocal_c_bqr = (bqr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bqr.uoF = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqr.uoG = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqr.uoH = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqr.uoI = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqr.uoJ = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bqr.uoK = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
