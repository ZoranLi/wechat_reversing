package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ali extends a {
    public String fFF;
    public String fUX;
    public int fZG;
    public int hqX;
    public int tPE;
    public int tPF;
    public LinkedList<ajp> tPG = new LinkedList();
    public LinkedList<bcs> tPH = new LinkedList();
    public int tPI;
    public long tPJ;
    public int tPK;
    public LinkedList<Long> tPL = new LinkedList();
    public int tPM;
    public int tPN;
    public String tPO;
    public int tPP;
    public LinkedList<avx> tPQ = new LinkedList();
    public bbu tPR;
    public LinkedList<bca> tPS = new LinkedList();
    public String tPT;
    public long tPU;
    public String tPV;
    public boolean tPW;
    public baw tPX;
    public int tPk;
    public String teW;
    public String token;
    public String tuo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tPE);
            aVar.eO(2, this.tPF);
            aVar.eO(3, this.tPk);
            if (this.teW != null) {
                aVar.e(4, this.teW);
            }
            aVar.d(5, 8, this.tPG);
            aVar.d(6, 8, this.tPH);
            aVar.eO(7, this.tPI);
            aVar.eO(8, this.hqX);
            aVar.O(9, this.tPJ);
            aVar.eO(10, this.tPK);
            aVar.d(11, 3, this.tPL);
            aVar.eO(12, this.tPM);
            aVar.eO(13, this.tPN);
            if (this.token != null) {
                aVar.e(14, this.token);
            }
            if (this.tPO != null) {
                aVar.e(15, this.tPO);
            }
            aVar.eO(16, this.tPP);
            aVar.d(17, 8, this.tPQ);
            if (this.tPR != null) {
                aVar.eQ(18, this.tPR.aUk());
                this.tPR.a(aVar);
            }
            if (this.fUX != null) {
                aVar.e(19, this.fUX);
            }
            aVar.d(20, 8, this.tPS);
            if (this.fFF != null) {
                aVar.e(21, this.fFF);
            }
            if (this.tPT != null) {
                aVar.e(22, this.tPT);
            }
            if (this.tuo != null) {
                aVar.e(23, this.tuo);
            }
            aVar.eO(24, this.fZG);
            aVar.O(25, this.tPU);
            if (this.tPV != null) {
                aVar.e(26, this.tPV);
            }
            aVar.an(27, this.tPW);
            if (this.tPX != null) {
                aVar.eQ(28, this.tPX.aUk());
                this.tPX.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.tPE) + 0) + a.a.a.a.eL(2, this.tPF)) + a.a.a.a.eL(3, this.tPk);
            if (this.teW != null) {
                r0 += a.a.a.b.b.a.f(4, this.teW);
            }
            r0 = ((((((((r0 + a.a.a.a.c(5, 8, this.tPG)) + a.a.a.a.c(6, 8, this.tPH)) + a.a.a.a.eL(7, this.tPI)) + a.a.a.a.eL(8, this.hqX)) + a.a.a.a.N(9, this.tPJ)) + a.a.a.a.eL(10, this.tPK)) + a.a.a.a.c(11, 3, this.tPL)) + a.a.a.a.eL(12, this.tPM)) + a.a.a.a.eL(13, this.tPN);
            if (this.token != null) {
                r0 += a.a.a.b.b.a.f(14, this.token);
            }
            if (this.tPO != null) {
                r0 += a.a.a.b.b.a.f(15, this.tPO);
            }
            r0 = (r0 + a.a.a.a.eL(16, this.tPP)) + a.a.a.a.c(17, 8, this.tPQ);
            if (this.tPR != null) {
                r0 += a.a.a.a.eN(18, this.tPR.aUk());
            }
            if (this.fUX != null) {
                r0 += a.a.a.b.b.a.f(19, this.fUX);
            }
            r0 += a.a.a.a.c(20, 8, this.tPS);
            if (this.fFF != null) {
                r0 += a.a.a.b.b.a.f(21, this.fFF);
            }
            if (this.tPT != null) {
                r0 += a.a.a.b.b.a.f(22, this.tPT);
            }
            if (this.tuo != null) {
                r0 += a.a.a.b.b.a.f(23, this.tuo);
            }
            r0 = (r0 + a.a.a.a.eL(24, this.fZG)) + a.a.a.a.N(25, this.tPU);
            if (this.tPV != null) {
                r0 += a.a.a.b.b.a.f(26, this.tPV);
            }
            r0 += a.a.a.b.b.a.cH(27) + 1;
            if (this.tPX != null) {
                return r0 + a.a.a.a.eN(28, this.tPX.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tPG.clear();
            this.tPH.clear();
            this.tPL.clear();
            this.tPQ.clear();
            this.tPS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            ali com_tencent_mm_protocal_c_ali = (ali) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_ajp;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ali.tPE = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ali.tPF = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ali.tPk = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ali.teW = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajp = new ajp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajp.a(aVar4, com_tencent_mm_protocal_c_ajp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ali.tPG.add(com_tencent_mm_protocal_c_ajp);
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajp = new bcs();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajp.a(aVar4, com_tencent_mm_protocal_c_ajp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ali.tPH.add(com_tencent_mm_protocal_c_ajp);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ali.tPI = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ali.hqX = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ali.tPJ = aVar3.xmD.mM();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ali.tPK = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ali.tPL.add(Long.valueOf(aVar3.xmD.mM()));
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ali.tPM = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ali.tPN = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ali.token = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ali.tPO = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ali.tPP = aVar3.xmD.mL();
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajp = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajp.a(aVar4, com_tencent_mm_protocal_c_ajp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ali.tPQ.add(com_tencent_mm_protocal_c_ajp);
                    }
                    return 0;
                case 18:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajp = new bbu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajp.a(aVar4, com_tencent_mm_protocal_c_ajp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ali.tPR = com_tencent_mm_protocal_c_ajp;
                    }
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ali.fUX = aVar3.xmD.readString();
                    return 0;
                case 20:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajp = new bca();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajp.a(aVar4, com_tencent_mm_protocal_c_ajp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ali.tPS.add(com_tencent_mm_protocal_c_ajp);
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ali.fFF = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_ali.tPT = aVar3.xmD.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_ali.tuo = aVar3.xmD.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_ali.fZG = aVar3.xmD.mL();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_ali.tPU = aVar3.xmD.mM();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_ali.tPV = aVar3.xmD.readString();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_ali.tPW = aVar3.cib();
                    return 0;
                case 28:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajp = new baw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajp.a(aVar4, com_tencent_mm_protocal_c_ajp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ali.tPX = com_tencent_mm_protocal_c_ajp;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
