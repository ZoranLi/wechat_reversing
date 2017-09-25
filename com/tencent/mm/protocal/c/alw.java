package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class alw extends a {
    public int hAD;
    public String hAE;
    public String hAF;
    public String hAG;
    public String hAM;
    public String jNj;
    public int jOc;
    public int tQB;
    public int tQC;
    public String tqb;
    public String tqc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNj != null) {
                aVar.e(1, this.jNj);
            }
            aVar.eO(2, this.jOc);
            aVar.eO(3, this.hAD);
            if (this.hAF != null) {
                aVar.e(4, this.hAF);
            }
            if (this.hAE != null) {
                aVar.e(5, this.hAE);
            }
            if (this.hAG != null) {
                aVar.e(6, this.hAG);
            }
            aVar.eO(7, this.tQB);
            aVar.eO(8, this.tQC);
            if (this.hAM != null) {
                aVar.e(9, this.hAM);
            }
            if (this.tqb != null) {
                aVar.e(10, this.tqb);
            }
            if (this.tqc == null) {
                return 0;
            }
            aVar.e(11, this.tqc);
            return 0;
        } else if (i == 1) {
            if (this.jNj != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNj) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.jOc)) + a.a.a.a.eL(3, this.hAD);
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(4, this.hAF);
            }
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(5, this.hAE);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(6, this.hAG);
            }
            r0 = (r0 + a.a.a.a.eL(7, this.tQB)) + a.a.a.a.eL(8, this.tQC);
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(9, this.hAM);
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(10, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(11, this.tqc);
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
            alw com_tencent_mm_protocal_c_alw = (alw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_alw.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alw.jOc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alw.hAD = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alw.hAF = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alw.hAE = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_alw.hAG = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_alw.tQB = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_alw.tQC = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_alw.hAM = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_alw.tqb = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_alw.tqc = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
