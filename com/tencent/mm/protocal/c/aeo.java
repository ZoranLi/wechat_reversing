package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aeo extends a {
    public int gtV;
    public long gtW;
    public String gtX;
    public String gtY;
    public String gtZ;
    public String gua;
    public String hAI;
    public String msF;
    public String muU;
    public String tJE;
    public String tJF;
    public int tJG;
    public int tJH;
    public int tJI;
    public int tJJ;
    public String tJK;
    public String tJL;
    public String tJM;
    public String tJN;
    public int tJO;
    public String thm;
    public String tiU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tJE != null) {
                aVar.e(1, this.tJE);
            }
            if (this.thm != null) {
                aVar.e(2, this.thm);
            }
            if (this.tiU != null) {
                aVar.e(3, this.tiU);
            }
            if (this.tJF != null) {
                aVar.e(4, this.tJF);
            }
            aVar.eO(5, this.tJG);
            aVar.eO(6, this.tJH);
            aVar.eO(7, this.tJI);
            aVar.eO(8, this.tJJ);
            if (this.tJK != null) {
                aVar.e(9, this.tJK);
            }
            if (this.hAI != null) {
                aVar.e(10, this.hAI);
            }
            if (this.muU != null) {
                aVar.e(11, this.muU);
            }
            if (this.msF != null) {
                aVar.e(12, this.msF);
            }
            if (this.tJL != null) {
                aVar.e(13, this.tJL);
            }
            if (this.tJM != null) {
                aVar.e(14, this.tJM);
            }
            if (this.tJN != null) {
                aVar.e(15, this.tJN);
            }
            aVar.eO(16, this.tJO);
            aVar.eO(17, this.gtV);
            aVar.O(18, this.gtW);
            if (this.gtX != null) {
                aVar.e(19, this.gtX);
            }
            if (this.gtY != null) {
                aVar.e(20, this.gtY);
            }
            if (this.gtZ != null) {
                aVar.e(21, this.gtZ);
            }
            if (this.gua == null) {
                return 0;
            }
            aVar.e(22, this.gua);
            return 0;
        } else if (i == 1) {
            if (this.tJE != null) {
                r0 = a.a.a.b.b.a.f(1, this.tJE) + 0;
            } else {
                r0 = 0;
            }
            if (this.thm != null) {
                r0 += a.a.a.b.b.a.f(2, this.thm);
            }
            if (this.tiU != null) {
                r0 += a.a.a.b.b.a.f(3, this.tiU);
            }
            if (this.tJF != null) {
                r0 += a.a.a.b.b.a.f(4, this.tJF);
            }
            r0 = (((r0 + a.a.a.a.eL(5, this.tJG)) + a.a.a.a.eL(6, this.tJH)) + a.a.a.a.eL(7, this.tJI)) + a.a.a.a.eL(8, this.tJJ);
            if (this.tJK != null) {
                r0 += a.a.a.b.b.a.f(9, this.tJK);
            }
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(10, this.hAI);
            }
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(11, this.muU);
            }
            if (this.msF != null) {
                r0 += a.a.a.b.b.a.f(12, this.msF);
            }
            if (this.tJL != null) {
                r0 += a.a.a.b.b.a.f(13, this.tJL);
            }
            if (this.tJM != null) {
                r0 += a.a.a.b.b.a.f(14, this.tJM);
            }
            if (this.tJN != null) {
                r0 += a.a.a.b.b.a.f(15, this.tJN);
            }
            r0 = ((r0 + a.a.a.a.eL(16, this.tJO)) + a.a.a.a.eL(17, this.gtV)) + a.a.a.a.N(18, this.gtW);
            if (this.gtX != null) {
                r0 += a.a.a.b.b.a.f(19, this.gtX);
            }
            if (this.gtY != null) {
                r0 += a.a.a.b.b.a.f(20, this.gtY);
            }
            if (this.gtZ != null) {
                r0 += a.a.a.b.b.a.f(21, this.gtZ);
            }
            if (this.gua != null) {
                r0 += a.a.a.b.b.a.f(22, this.gua);
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
            aeo com_tencent_mm_protocal_c_aeo = (aeo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aeo.tJE = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aeo.thm = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aeo.tiU = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aeo.tJF = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aeo.tJG = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aeo.tJH = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aeo.tJI = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aeo.tJJ = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aeo.tJK = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aeo.hAI = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aeo.muU = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aeo.msF = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aeo.tJL = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aeo.tJM = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aeo.tJN = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aeo.tJO = aVar3.xmD.mL();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aeo.gtV = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_aeo.gtW = aVar3.xmD.mM();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aeo.gtX = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aeo.gtY = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aeo.gtZ = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_aeo.gua = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
