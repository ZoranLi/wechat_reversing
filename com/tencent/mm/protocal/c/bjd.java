package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bjd extends a {
    public String oTN;
    public String tBM;
    public String tZg;
    public String uiJ;
    public int uiK;
    public String uiL;
    public String uiM;
    public int uiN;
    public String uiO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.oTN != null) {
                aVar.e(1, this.oTN);
            }
            if (this.uiJ != null) {
                aVar.e(2, this.uiJ);
            }
            if (this.tBM != null) {
                aVar.e(3, this.tBM);
            }
            aVar.eO(4, this.uiK);
            if (this.tZg != null) {
                aVar.e(5, this.tZg);
            }
            if (this.uiL != null) {
                aVar.e(6, this.uiL);
            }
            if (this.uiM != null) {
                aVar.e(7, this.uiM);
            }
            aVar.eO(8, this.uiN);
            if (this.uiO == null) {
                return 0;
            }
            aVar.e(9, this.uiO);
            return 0;
        } else if (i == 1) {
            if (this.oTN != null) {
                r0 = a.a.a.b.b.a.f(1, this.oTN) + 0;
            } else {
                r0 = 0;
            }
            if (this.uiJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.uiJ);
            }
            if (this.tBM != null) {
                r0 += a.a.a.b.b.a.f(3, this.tBM);
            }
            r0 += a.a.a.a.eL(4, this.uiK);
            if (this.tZg != null) {
                r0 += a.a.a.b.b.a.f(5, this.tZg);
            }
            if (this.uiL != null) {
                r0 += a.a.a.b.b.a.f(6, this.uiL);
            }
            if (this.uiM != null) {
                r0 += a.a.a.b.b.a.f(7, this.uiM);
            }
            r0 += a.a.a.a.eL(8, this.uiN);
            if (this.uiO != null) {
                r0 += a.a.a.b.b.a.f(9, this.uiO);
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
            bjd com_tencent_mm_protocal_c_bjd = (bjd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bjd.oTN = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjd.uiJ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjd.tBM = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjd.uiK = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjd.tZg = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjd.uiL = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bjd.uiM = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bjd.uiN = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bjd.uiO = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
