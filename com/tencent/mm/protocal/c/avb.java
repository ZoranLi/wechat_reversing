package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class avb extends a {
    public int tKX;
    public String tOp;
    public long tVW;
    public String tYA;
    public int tYB;
    public int tYC;
    public int tYD;
    public String tYE;
    public String tYF;
    public String tYG;
    public String tYz;
    public int tdM;
    public long tlY;
    public int trV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tdM);
            if (this.tOp != null) {
                aVar.e(2, this.tOp);
            }
            if (this.tYz != null) {
                aVar.e(3, this.tYz);
            }
            aVar.O(4, this.tlY);
            if (this.tYA != null) {
                aVar.e(5, this.tYA);
            }
            aVar.eO(6, this.tYB);
            aVar.eO(7, this.tYC);
            aVar.eO(8, this.tYD);
            aVar.O(9, this.tVW);
            aVar.eO(10, this.tKX);
            if (this.tYE != null) {
                aVar.e(11, this.tYE);
            }
            aVar.eO(12, this.trV);
            if (this.tYF != null) {
                aVar.e(13, this.tYF);
            }
            if (this.tYG != null) {
                aVar.e(14, this.tYG);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tdM) + 0;
            if (this.tOp != null) {
                r0 += a.a.a.b.b.a.f(2, this.tOp);
            }
            if (this.tYz != null) {
                r0 += a.a.a.b.b.a.f(3, this.tYz);
            }
            r0 += a.a.a.a.N(4, this.tlY);
            if (this.tYA != null) {
                r0 += a.a.a.b.b.a.f(5, this.tYA);
            }
            r0 = ((((r0 + a.a.a.a.eL(6, this.tYB)) + a.a.a.a.eL(7, this.tYC)) + a.a.a.a.eL(8, this.tYD)) + a.a.a.a.N(9, this.tVW)) + a.a.a.a.eL(10, this.tKX);
            if (this.tYE != null) {
                r0 += a.a.a.b.b.a.f(11, this.tYE);
            }
            r0 += a.a.a.a.eL(12, this.trV);
            if (this.tYF != null) {
                r0 += a.a.a.b.b.a.f(13, this.tYF);
            }
            if (this.tYG != null) {
                return r0 + a.a.a.b.b.a.f(14, this.tYG);
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
            avb com_tencent_mm_protocal_c_avb = (avb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_avb.tdM = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avb.tOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avb.tYz = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avb.tlY = aVar3.xmD.mM();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avb.tYA = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avb.tYB = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avb.tYC = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avb.tYD = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_avb.tVW = aVar3.xmD.mM();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_avb.tKX = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_avb.tYE = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_avb.trV = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_avb.tYF = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_avb.tYG = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
