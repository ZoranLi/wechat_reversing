package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bfc extends a {
    public int hhv;
    public String jNj;
    public String mQY;
    public int ogM;
    public as pYt;
    public String qsQ;
    public String qui;
    public String sLS;
    public String sLT;
    public int tPk;
    public cr ufA;
    public mk ufB;
    public String ufC;
    public int ufD;
    public int ufE;
    public String ufF;
    public bdt ufG;
    public bnb ufH;
    public int ufI;
    public String ufy;
    public ajq ufz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mQY != null) {
                aVar.e(1, this.mQY);
            }
            if (this.jNj != null) {
                aVar.e(2, this.jNj);
            }
            aVar.eO(3, this.tPk);
            aVar.eO(4, this.ogM);
            if (this.ufy != null) {
                aVar.e(5, this.ufy);
            }
            if (this.ufz != null) {
                aVar.eQ(6, this.ufz.aUk());
                this.ufz.a(aVar);
            }
            if (this.ufA != null) {
                aVar.eQ(7, this.ufA.aUk());
                this.ufA.a(aVar);
            }
            if (this.ufB != null) {
                aVar.eQ(8, this.ufB.aUk());
                this.ufB.a(aVar);
            }
            if (this.sLS != null) {
                aVar.e(9, this.sLS);
            }
            if (this.sLT != null) {
                aVar.e(10, this.sLT);
            }
            if (this.ufC != null) {
                aVar.e(11, this.ufC);
            }
            aVar.eO(12, this.ufD);
            aVar.eO(13, this.ufE);
            if (this.ufF != null) {
                aVar.e(14, this.ufF);
            }
            if (this.pYt != null) {
                aVar.eQ(15, this.pYt.aUk());
                this.pYt.a(aVar);
            }
            aVar.eO(16, this.hhv);
            if (this.ufG != null) {
                aVar.eQ(17, this.ufG.aUk());
                this.ufG.a(aVar);
            }
            if (this.qui != null) {
                aVar.e(18, this.qui);
            }
            if (this.qsQ != null) {
                aVar.e(19, this.qsQ);
            }
            if (this.ufH != null) {
                aVar.eQ(20, this.ufH.aUk());
                this.ufH.a(aVar);
            }
            aVar.eO(21, this.ufI);
            return 0;
        } else if (i == 1) {
            if (this.mQY != null) {
                r0 = a.a.a.b.b.a.f(1, this.mQY) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tPk)) + a.a.a.a.eL(4, this.ogM);
            if (this.ufy != null) {
                r0 += a.a.a.b.b.a.f(5, this.ufy);
            }
            if (this.ufz != null) {
                r0 += a.a.a.a.eN(6, this.ufz.aUk());
            }
            if (this.ufA != null) {
                r0 += a.a.a.a.eN(7, this.ufA.aUk());
            }
            if (this.ufB != null) {
                r0 += a.a.a.a.eN(8, this.ufB.aUk());
            }
            if (this.sLS != null) {
                r0 += a.a.a.b.b.a.f(9, this.sLS);
            }
            if (this.sLT != null) {
                r0 += a.a.a.b.b.a.f(10, this.sLT);
            }
            if (this.ufC != null) {
                r0 += a.a.a.b.b.a.f(11, this.ufC);
            }
            r0 = (r0 + a.a.a.a.eL(12, this.ufD)) + a.a.a.a.eL(13, this.ufE);
            if (this.ufF != null) {
                r0 += a.a.a.b.b.a.f(14, this.ufF);
            }
            if (this.pYt != null) {
                r0 += a.a.a.a.eN(15, this.pYt.aUk());
            }
            r0 += a.a.a.a.eL(16, this.hhv);
            if (this.ufG != null) {
                r0 += a.a.a.a.eN(17, this.ufG.aUk());
            }
            if (this.qui != null) {
                r0 += a.a.a.b.b.a.f(18, this.qui);
            }
            if (this.qsQ != null) {
                r0 += a.a.a.b.b.a.f(19, this.qsQ);
            }
            if (this.ufH != null) {
                r0 += a.a.a.a.eN(20, this.ufH.aUk());
            }
            return r0 + a.a.a.a.eL(21, this.ufI);
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
            bfc com_tencent_mm_protocal_c_bfc = (bfc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_ajq;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bfc.mQY = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfc.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfc.tPk = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfc.ogM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfc.ufy = aVar3.xmD.readString();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajq = new ajq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajq.a(aVar4, com_tencent_mm_protocal_c_ajq, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfc.ufz = com_tencent_mm_protocal_c_ajq;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajq = new cr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajq.a(aVar4, com_tencent_mm_protocal_c_ajq, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfc.ufA = com_tencent_mm_protocal_c_ajq;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajq = new mk();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajq.a(aVar4, com_tencent_mm_protocal_c_ajq, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfc.ufB = com_tencent_mm_protocal_c_ajq;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bfc.sLS = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bfc.sLT = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bfc.ufC = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bfc.ufD = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bfc.ufE = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bfc.ufF = aVar3.xmD.readString();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajq = new as();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajq.a(aVar4, com_tencent_mm_protocal_c_ajq, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfc.pYt = com_tencent_mm_protocal_c_ajq;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bfc.hhv = aVar3.xmD.mL();
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajq = new bdt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajq.a(aVar4, com_tencent_mm_protocal_c_ajq, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfc.ufG = com_tencent_mm_protocal_c_ajq;
                    }
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bfc.qui = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bfc.qsQ = aVar3.xmD.readString();
                    return 0;
                case 20:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ajq = new bnb();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajq.a(aVar4, com_tencent_mm_protocal_c_ajq, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfc.ufH = com_tencent_mm_protocal_c_ajq;
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bfc.ufI = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
