package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bdj extends a {
    public int cGa;
    public int hTr;
    public String qna;
    public String ueD;
    public String ueE;
    public int ueF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.hTr);
            if (this.ueD != null) {
                aVar.e(2, this.ueD);
            }
            if (this.ueE != null) {
                aVar.e(3, this.ueE);
            }
            aVar.eO(4, this.cGa);
            if (this.qna != null) {
                aVar.e(5, this.qna);
            }
            aVar.eO(6, this.ueF);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.hTr) + 0;
            if (this.ueD != null) {
                r0 += a.a.a.b.b.a.f(2, this.ueD);
            }
            if (this.ueE != null) {
                r0 += a.a.a.b.b.a.f(3, this.ueE);
            }
            r0 += a.a.a.a.eL(4, this.cGa);
            if (this.qna != null) {
                r0 += a.a.a.b.b.a.f(5, this.qna);
            }
            return r0 + a.a.a.a.eL(6, this.ueF);
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
            bdj com_tencent_mm_protocal_c_bdj = (bdj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bdj.hTr = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdj.ueD = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bdj.ueE = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdj.cGa = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bdj.qna = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bdj.ueF = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
