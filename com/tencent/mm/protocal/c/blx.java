package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class blx extends a {
    public String fDC;
    public String tVE;
    public String tgW;
    public int ulE;
    public String ulF;
    public String ulG;
    public String ulH;
    public String ulI;
    public String ulJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC != null) {
                aVar.e(1, this.fDC);
            }
            if (this.tgW != null) {
                aVar.e(2, this.tgW);
            }
            aVar.eO(3, this.ulE);
            if (this.ulF != null) {
                aVar.e(4, this.ulF);
            }
            if (this.tVE != null) {
                aVar.e(5, this.tVE);
            }
            if (this.ulG != null) {
                aVar.e(6, this.ulG);
            }
            if (this.ulH != null) {
                aVar.e(7, this.ulH);
            }
            if (this.ulI != null) {
                aVar.e(8, this.ulI);
            }
            if (this.ulJ == null) {
                return 0;
            }
            aVar.e(9, this.ulJ);
            return 0;
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.tgW != null) {
                r0 += a.a.a.b.b.a.f(2, this.tgW);
            }
            r0 += a.a.a.a.eL(3, this.ulE);
            if (this.ulF != null) {
                r0 += a.a.a.b.b.a.f(4, this.ulF);
            }
            if (this.tVE != null) {
                r0 += a.a.a.b.b.a.f(5, this.tVE);
            }
            if (this.ulG != null) {
                r0 += a.a.a.b.b.a.f(6, this.ulG);
            }
            if (this.ulH != null) {
                r0 += a.a.a.b.b.a.f(7, this.ulH);
            }
            if (this.ulI != null) {
                r0 += a.a.a.b.b.a.f(8, this.ulI);
            }
            if (this.ulJ != null) {
                r0 += a.a.a.b.b.a.f(9, this.ulJ);
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
            blx com_tencent_mm_protocal_c_blx = (blx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_blx.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blx.tgW = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blx.ulE = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_blx.ulF = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_blx.tVE = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_blx.ulG = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_blx.ulH = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_blx.ulI = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_blx.ulJ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
