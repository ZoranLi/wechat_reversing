package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afj extends a {
    public String fDC;
    public int jOc;
    public String msN;
    public String muS;
    public String tKE;
    public String tKF;
    public String tKG;
    public String tKH;
    public int tKI;
    public String tKJ;
    public String trc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC != null) {
                aVar.e(1, this.fDC);
            }
            if (this.tKE != null) {
                aVar.e(2, this.tKE);
            }
            aVar.eO(3, this.jOc);
            if (this.msN != null) {
                aVar.e(4, this.msN);
            }
            if (this.tKF != null) {
                aVar.e(5, this.tKF);
            }
            if (this.trc != null) {
                aVar.e(6, this.trc);
            }
            if (this.tKG != null) {
                aVar.e(7, this.tKG);
            }
            if (this.muS != null) {
                aVar.e(8, this.muS);
            }
            if (this.tKH != null) {
                aVar.e(9, this.tKH);
            }
            aVar.eO(10, this.tKI);
            if (this.tKJ == null) {
                return 0;
            }
            aVar.e(11, this.tKJ);
            return 0;
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.tKE != null) {
                r0 += a.a.a.b.b.a.f(2, this.tKE);
            }
            r0 += a.a.a.a.eL(3, this.jOc);
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(4, this.msN);
            }
            if (this.tKF != null) {
                r0 += a.a.a.b.b.a.f(5, this.tKF);
            }
            if (this.trc != null) {
                r0 += a.a.a.b.b.a.f(6, this.trc);
            }
            if (this.tKG != null) {
                r0 += a.a.a.b.b.a.f(7, this.tKG);
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(8, this.muS);
            }
            if (this.tKH != null) {
                r0 += a.a.a.b.b.a.f(9, this.tKH);
            }
            r0 += a.a.a.a.eL(10, this.tKI);
            if (this.tKJ != null) {
                r0 += a.a.a.b.b.a.f(11, this.tKJ);
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
            afj com_tencent_mm_protocal_c_afj = (afj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afj.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afj.tKE = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afj.jOc = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afj.msN = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afj.tKF = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_afj.trc = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_afj.tKG = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_afj.muS = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_afj.tKH = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_afj.tKI = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_afj.tKJ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
