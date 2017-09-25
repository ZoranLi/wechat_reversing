package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aav extends avp {
    public int kAC;
    public String kAD;
    public String tGG;
    public String tGH;
    public String tGI;
    public String tGJ;
    public String tGK;
    public boolean tGL;
    public String tGM;
    public long tGN;
    public boolean tGO;
    public boolean tGP;
    public boolean tGQ;
    public String tGR;
    public String tGS;
    public String tGT;
    public String tGU;
    public boolean tGV;
    public LinkedList<String> tGW = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.eO(2, this.kAC);
            if (this.kAD != null) {
                aVar.e(3, this.kAD);
            }
            if (this.tGG != null) {
                aVar.e(4, this.tGG);
            }
            if (this.tGH != null) {
                aVar.e(5, this.tGH);
            }
            if (this.tGI != null) {
                aVar.e(6, this.tGI);
            }
            if (this.tGJ != null) {
                aVar.e(7, this.tGJ);
            }
            if (this.tGK != null) {
                aVar.e(8, this.tGK);
            }
            aVar.an(9, this.tGL);
            if (this.tGM != null) {
                aVar.e(10, this.tGM);
            }
            aVar.O(11, this.tGN);
            aVar.an(12, this.tGO);
            aVar.an(13, this.tGP);
            aVar.an(14, this.tGQ);
            if (this.tGR != null) {
                aVar.e(15, this.tGR);
            }
            if (this.tGS != null) {
                aVar.e(16, this.tGS);
            }
            if (this.tGT != null) {
                aVar.e(17, this.tGT);
            }
            if (this.tGU != null) {
                aVar.e(18, this.tGU);
            }
            aVar.an(19, this.tGV);
            aVar.d(20, 1, this.tGW);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.kAC);
            if (this.kAD != null) {
                r0 += a.a.a.b.b.a.f(3, this.kAD);
            }
            if (this.tGG != null) {
                r0 += a.a.a.b.b.a.f(4, this.tGG);
            }
            if (this.tGH != null) {
                r0 += a.a.a.b.b.a.f(5, this.tGH);
            }
            if (this.tGI != null) {
                r0 += a.a.a.b.b.a.f(6, this.tGI);
            }
            if (this.tGJ != null) {
                r0 += a.a.a.b.b.a.f(7, this.tGJ);
            }
            if (this.tGK != null) {
                r0 += a.a.a.b.b.a.f(8, this.tGK);
            }
            r0 += a.a.a.b.b.a.cH(9) + 1;
            if (this.tGM != null) {
                r0 += a.a.a.b.b.a.f(10, this.tGM);
            }
            r0 = (((r0 + a.a.a.a.N(11, this.tGN)) + (a.a.a.b.b.a.cH(12) + 1)) + (a.a.a.b.b.a.cH(13) + 1)) + (a.a.a.b.b.a.cH(14) + 1);
            if (this.tGR != null) {
                r0 += a.a.a.b.b.a.f(15, this.tGR);
            }
            if (this.tGS != null) {
                r0 += a.a.a.b.b.a.f(16, this.tGS);
            }
            if (this.tGT != null) {
                r0 += a.a.a.b.b.a.f(17, this.tGT);
            }
            if (this.tGU != null) {
                r0 += a.a.a.b.b.a.f(18, this.tGU);
            }
            return (r0 + (a.a.a.b.b.a.cH(19) + 1)) + a.a.a.a.c(20, 1, this.tGW);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tGW.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aav com_tencent_mm_protocal_c_aav = (aav) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aav.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aav.kAC = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aav.kAD = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aav.tGG = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aav.tGH = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aav.tGI = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aav.tGJ = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aav.tGK = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aav.tGL = aVar3.cib();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aav.tGM = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aav.tGN = aVar3.xmD.mM();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aav.tGO = aVar3.cib();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aav.tGP = aVar3.cib();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aav.tGQ = aVar3.cib();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aav.tGR = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aav.tGS = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aav.tGT = aVar3.xmD.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_aav.tGU = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aav.tGV = aVar3.cib();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aav.tGW.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
