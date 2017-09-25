package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class asq extends avp {
    public int brD;
    public int fZh;
    public int kfH;
    public String kfI;
    public String tWB;
    public String tWE;
    public String tWW;
    public String tWX;
    public String tWY;
    public String tWZ;
    public int tXa;
    public LinkedList<og> tXb = new LinkedList();
    public int tXc;
    public LinkedList<og> tXd = new LinkedList();
    public og tXe;
    public LinkedList<og> tXf = new LinkedList();
    public og tXg;
    public alt tXh;
    public int tXi;
    public String tXj;

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
            aVar.eO(2, this.kfH);
            if (this.kfI != null) {
                aVar.e(3, this.kfI);
            }
            aVar.eO(4, this.brD);
            if (this.tWX != null) {
                aVar.e(5, this.tWX);
            }
            if (this.tWY != null) {
                aVar.e(6, this.tWY);
            }
            if (this.tWZ != null) {
                aVar.e(7, this.tWZ);
            }
            aVar.eO(8, this.tXa);
            aVar.d(9, 8, this.tXb);
            aVar.eO(10, this.fZh);
            aVar.eO(11, this.tXc);
            aVar.d(12, 8, this.tXd);
            if (this.tWB != null) {
                aVar.e(13, this.tWB);
            }
            if (this.tXe != null) {
                aVar.eQ(14, this.tXe.aUk());
                this.tXe.a(aVar);
            }
            aVar.d(15, 8, this.tXf);
            if (this.tXg != null) {
                aVar.eQ(16, this.tXg.aUk());
                this.tXg.a(aVar);
            }
            if (this.tXh != null) {
                aVar.eQ(17, this.tXh.aUk());
                this.tXh.a(aVar);
            }
            if (this.tWE != null) {
                aVar.e(18, this.tWE);
            }
            aVar.eO(19, this.tXi);
            if (this.tXj != null) {
                aVar.e(20, this.tXj);
            }
            if (this.tWW == null) {
                return 0;
            }
            aVar.e(21, this.tWW);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.kfH);
            if (this.kfI != null) {
                r0 += a.a.a.b.b.a.f(3, this.kfI);
            }
            r0 += a.a.a.a.eL(4, this.brD);
            if (this.tWX != null) {
                r0 += a.a.a.b.b.a.f(5, this.tWX);
            }
            if (this.tWY != null) {
                r0 += a.a.a.b.b.a.f(6, this.tWY);
            }
            if (this.tWZ != null) {
                r0 += a.a.a.b.b.a.f(7, this.tWZ);
            }
            r0 = ((((r0 + a.a.a.a.eL(8, this.tXa)) + a.a.a.a.c(9, 8, this.tXb)) + a.a.a.a.eL(10, this.fZh)) + a.a.a.a.eL(11, this.tXc)) + a.a.a.a.c(12, 8, this.tXd);
            if (this.tWB != null) {
                r0 += a.a.a.b.b.a.f(13, this.tWB);
            }
            if (this.tXe != null) {
                r0 += a.a.a.a.eN(14, this.tXe.aUk());
            }
            r0 += a.a.a.a.c(15, 8, this.tXf);
            if (this.tXg != null) {
                r0 += a.a.a.a.eN(16, this.tXg.aUk());
            }
            if (this.tXh != null) {
                r0 += a.a.a.a.eN(17, this.tXh.aUk());
            }
            if (this.tWE != null) {
                r0 += a.a.a.b.b.a.f(18, this.tWE);
            }
            r0 += a.a.a.a.eL(19, this.tXi);
            if (this.tXj != null) {
                r0 += a.a.a.b.b.a.f(20, this.tXj);
            }
            if (this.tWW != null) {
                r0 += a.a.a.b.b.a.f(21, this.tWW);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tXb.clear();
            this.tXd.clear();
            this.tXf.clear();
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
            asq com_tencent_mm_protocal_c_asq = (asq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asq.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asq.kfH = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asq.kfI = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asq.brD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asq.tWX = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asq.tWY = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_asq.tWZ = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_asq.tXa = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new og();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asq.tXb.add(enVar);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_asq.fZh = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_asq.tXc = aVar3.xmD.mL();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new og();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asq.tXd.add(enVar);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_asq.tWB = aVar3.xmD.readString();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new og();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asq.tXe = enVar;
                    }
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new og();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asq.tXf.add(enVar);
                    }
                    return 0;
                case 16:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new og();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asq.tXg = enVar;
                    }
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new alt();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asq.tXh = enVar;
                    }
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_asq.tWE = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_asq.tXi = aVar3.xmD.mL();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_asq.tXj = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_asq.tWW = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
