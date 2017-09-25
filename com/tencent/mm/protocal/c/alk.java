package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class alk extends a {
    public String fFW;
    public int fII;
    public String fTO;
    public String fVB;
    public int hqX;
    public int jFe;
    public String msk;
    public String tPD;
    public int tPE;
    public int tPF;
    public int tPN;
    public String tPO;
    public int tPk;
    public ale tQb;
    public int tQc;
    public LinkedList<ale> tQd = new LinkedList();
    public int tQe;
    public String tQf;
    public String tQg;
    public String tQh;
    public aks tQi;
    public int tQj;
    public String token;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tPE);
            aVar.eO(2, this.tPF);
            aVar.eO(3, this.tPk);
            if (this.tQb != null) {
                aVar.eQ(4, this.tQb.aUk());
                this.tQb.a(aVar);
            }
            aVar.eO(5, this.tQc);
            aVar.d(6, 8, this.tQd);
            aVar.eO(7, this.hqX);
            aVar.eO(8, this.tQe);
            if (this.msk != null) {
                aVar.e(9, this.msk);
            }
            if (this.tQf != null) {
                aVar.e(10, this.tQf);
            }
            if (this.token != null) {
                aVar.e(11, this.token);
            }
            if (this.tPO != null) {
                aVar.e(12, this.tPO);
            }
            aVar.eO(13, this.tPN);
            if (this.fVB != null) {
                aVar.e(14, this.fVB);
            }
            if (this.tQg != null) {
                aVar.e(15, this.tQg);
            }
            if (this.tQh != null) {
                aVar.e(16, this.tQh);
            }
            if (this.fFW != null) {
                aVar.e(17, this.fFW);
            }
            if (this.fTO != null) {
                aVar.e(18, this.fTO);
            }
            aVar.eO(19, this.jFe);
            aVar.eO(20, this.fII);
            if (this.tPD != null) {
                aVar.e(21, this.tPD);
            }
            if (this.tQi != null) {
                aVar.eQ(22, this.tQi.aUk());
                this.tQi.a(aVar);
            }
            aVar.eO(23, this.tQj);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.tPE) + 0) + a.a.a.a.eL(2, this.tPF)) + a.a.a.a.eL(3, this.tPk);
            if (this.tQb != null) {
                r0 += a.a.a.a.eN(4, this.tQb.aUk());
            }
            r0 = (((r0 + a.a.a.a.eL(5, this.tQc)) + a.a.a.a.c(6, 8, this.tQd)) + a.a.a.a.eL(7, this.hqX)) + a.a.a.a.eL(8, this.tQe);
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(9, this.msk);
            }
            if (this.tQf != null) {
                r0 += a.a.a.b.b.a.f(10, this.tQf);
            }
            if (this.token != null) {
                r0 += a.a.a.b.b.a.f(11, this.token);
            }
            if (this.tPO != null) {
                r0 += a.a.a.b.b.a.f(12, this.tPO);
            }
            r0 += a.a.a.a.eL(13, this.tPN);
            if (this.fVB != null) {
                r0 += a.a.a.b.b.a.f(14, this.fVB);
            }
            if (this.tQg != null) {
                r0 += a.a.a.b.b.a.f(15, this.tQg);
            }
            if (this.tQh != null) {
                r0 += a.a.a.b.b.a.f(16, this.tQh);
            }
            if (this.fFW != null) {
                r0 += a.a.a.b.b.a.f(17, this.fFW);
            }
            if (this.fTO != null) {
                r0 += a.a.a.b.b.a.f(18, this.fTO);
            }
            r0 = (r0 + a.a.a.a.eL(19, this.jFe)) + a.a.a.a.eL(20, this.fII);
            if (this.tPD != null) {
                r0 += a.a.a.b.b.a.f(21, this.tPD);
            }
            if (this.tQi != null) {
                r0 += a.a.a.a.eN(22, this.tQi.aUk());
            }
            return r0 + a.a.a.a.eL(23, this.tQj);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tQd.clear();
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
            alk com_tencent_mm_protocal_c_alk = (alk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_ale;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_alk.tPE = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alk.tPF = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alk.tPk = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ale = new ale();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ale.a(aVar4, com_tencent_mm_protocal_c_ale, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alk.tQb = com_tencent_mm_protocal_c_ale;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alk.tQc = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ale = new ale();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ale.a(aVar4, com_tencent_mm_protocal_c_ale, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alk.tQd.add(com_tencent_mm_protocal_c_ale);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_alk.hqX = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_alk.tQe = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_alk.msk = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_alk.tQf = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_alk.token = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_alk.tPO = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_alk.tPN = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_alk.fVB = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_alk.tQg = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_alk.tQh = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_alk.fFW = aVar3.xmD.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_alk.fTO = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_alk.jFe = aVar3.xmD.mL();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_alk.fII = aVar3.xmD.mL();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_alk.tPD = aVar3.xmD.readString();
                    return 0;
                case 22:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ale = new aks();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ale.a(aVar4, com_tencent_mm_protocal_c_ale, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alk.tQi = com_tencent_mm_protocal_c_ale;
                    }
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_alk.tQj = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
