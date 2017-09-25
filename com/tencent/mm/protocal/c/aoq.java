package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aoq extends a {
    public String msD;
    public String msh;
    public int msp;
    public String muS;
    public String tTF;
    public String tTG;
    public String tTH;
    public String tTI;
    public String tTJ;
    public String tTK;
    public String tee;
    public String teg;
    public String tku;
    public int tkv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msh != null) {
                aVar.e(1, this.msh);
            }
            if (this.muS != null) {
                aVar.e(2, this.muS);
            }
            if (this.tTF != null) {
                aVar.e(3, this.tTF);
            }
            if (this.tee != null) {
                aVar.e(4, this.tee);
            }
            if (this.msD != null) {
                aVar.e(5, this.msD);
            }
            aVar.eO(6, this.tkv);
            if (this.tTG != null) {
                aVar.e(7, this.tTG);
            }
            if (this.teg != null) {
                aVar.e(8, this.teg);
            }
            if (this.tku != null) {
                aVar.e(9, this.tku);
            }
            if (this.tTH != null) {
                aVar.e(10, this.tTH);
            }
            if (this.tTI != null) {
                aVar.e(11, this.tTI);
            }
            if (this.tTJ != null) {
                aVar.e(12, this.tTJ);
            }
            if (this.tTK != null) {
                aVar.e(13, this.tTK);
            }
            aVar.eO(14, this.msp);
            return 0;
        } else if (i == 1) {
            if (this.msh != null) {
                r0 = a.a.a.b.b.a.f(1, this.msh) + 0;
            } else {
                r0 = 0;
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(2, this.muS);
            }
            if (this.tTF != null) {
                r0 += a.a.a.b.b.a.f(3, this.tTF);
            }
            if (this.tee != null) {
                r0 += a.a.a.b.b.a.f(4, this.tee);
            }
            if (this.msD != null) {
                r0 += a.a.a.b.b.a.f(5, this.msD);
            }
            r0 += a.a.a.a.eL(6, this.tkv);
            if (this.tTG != null) {
                r0 += a.a.a.b.b.a.f(7, this.tTG);
            }
            if (this.teg != null) {
                r0 += a.a.a.b.b.a.f(8, this.teg);
            }
            if (this.tku != null) {
                r0 += a.a.a.b.b.a.f(9, this.tku);
            }
            if (this.tTH != null) {
                r0 += a.a.a.b.b.a.f(10, this.tTH);
            }
            if (this.tTI != null) {
                r0 += a.a.a.b.b.a.f(11, this.tTI);
            }
            if (this.tTJ != null) {
                r0 += a.a.a.b.b.a.f(12, this.tTJ);
            }
            if (this.tTK != null) {
                r0 += a.a.a.b.b.a.f(13, this.tTK);
            }
            return r0 + a.a.a.a.eL(14, this.msp);
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
            aoq com_tencent_mm_protocal_c_aoq = (aoq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aoq.msh = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aoq.muS = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aoq.tTF = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aoq.tee = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aoq.msD = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aoq.tkv = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aoq.tTG = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aoq.teg = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aoq.tku = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aoq.tTH = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aoq.tTI = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aoq.tTJ = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aoq.tTK = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aoq.msp = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
