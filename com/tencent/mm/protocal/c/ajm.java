package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ajm extends a {
    public int jNB;
    public String jNj;
    public String jOp;
    public String oTN;
    public String tBM;
    public String tqb;
    public String tqc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.oTN != null) {
                aVar.e(1, this.oTN);
            }
            if (this.jNj != null) {
                aVar.e(2, this.jNj);
            }
            aVar.eO(3, this.jNB);
            if (this.tqb != null) {
                aVar.e(4, this.tqb);
            }
            if (this.tqc != null) {
                aVar.e(5, this.tqc);
            }
            if (this.jOp != null) {
                aVar.e(6, this.jOp);
            }
            if (this.tBM == null) {
                return 0;
            }
            aVar.e(7, this.tBM);
            return 0;
        } else if (i == 1) {
            if (this.oTN != null) {
                r0 = a.a.a.b.b.a.f(1, this.oTN) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            r0 += a.a.a.a.eL(3, this.jNB);
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(4, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(5, this.tqc);
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(6, this.jOp);
            }
            if (this.tBM != null) {
                r0 += a.a.a.b.b.a.f(7, this.tBM);
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
            ajm com_tencent_mm_protocal_c_ajm = (ajm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ajm.oTN = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajm.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajm.jNB = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajm.tqb = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajm.tqc = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ajm.jOp = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ajm.tBM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
