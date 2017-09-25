package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aix extends a {
    public String fDC;
    public int jOc;
    public String nWY;
    public float nWZ;
    public int nXa;
    public LinkedList<Integer> nXb = new LinkedList();
    public int nXc;
    public LinkedList<avx> nXd = new LinkedList();
    public float nXe;
    public String nXf;
    public avw nXg;
    public String tMX;
    public avw tMY;
    public int tMZ;
    public int tNa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.nWY != null) {
                aVar.e(1, this.nWY);
            }
            if (this.fDC != null) {
                aVar.e(2, this.fDC);
            }
            aVar.n(3, this.nWZ);
            aVar.eO(4, this.nXa);
            aVar.c(5, this.nXb);
            aVar.eO(6, this.nXc);
            aVar.d(7, 8, this.nXd);
            aVar.n(8, this.nXe);
            if (this.nXf != null) {
                aVar.e(9, this.nXf);
            }
            aVar.eO(10, this.jOc);
            if (this.nXg != null) {
                aVar.eQ(11, this.nXg.aUk());
                this.nXg.a(aVar);
            }
            if (this.tMX != null) {
                aVar.e(12, this.tMX);
            }
            if (this.tMY != null) {
                aVar.eQ(13, this.tMY.aUk());
                this.tMY.a(aVar);
            }
            aVar.eO(14, this.tMZ);
            aVar.eO(15, this.tNa);
            return 0;
        } else if (i == 1) {
            if (this.nWY != null) {
                r0 = a.a.a.b.b.a.f(1, this.nWY) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            r0 = (((((r0 + (a.a.a.b.b.a.cH(3) + 4)) + a.a.a.a.eL(4, this.nXa)) + a.a.a.a.b(5, this.nXb)) + a.a.a.a.eL(6, this.nXc)) + a.a.a.a.c(7, 8, this.nXd)) + (a.a.a.b.b.a.cH(8) + 4);
            if (this.nXf != null) {
                r0 += a.a.a.b.b.a.f(9, this.nXf);
            }
            r0 += a.a.a.a.eL(10, this.jOc);
            if (this.nXg != null) {
                r0 += a.a.a.a.eN(11, this.nXg.aUk());
            }
            if (this.tMX != null) {
                r0 += a.a.a.b.b.a.f(12, this.tMX);
            }
            if (this.tMY != null) {
                r0 += a.a.a.a.eN(13, this.tMY.aUk());
            }
            return (r0 + a.a.a.a.eL(14, this.tMZ)) + a.a.a.a.eL(15, this.tNa);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nXb.clear();
            this.nXd.clear();
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
            aix com_tencent_mm_protocal_c_aix = (aix) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aix.nWY = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aix.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aix.nWZ = aVar3.xmD.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aix.nXa = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aix.nXb = new a.a.a.a.a(aVar3.cic().sYA, unknownTagHandler).chZ();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aix.nXc = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aix.nXd.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aix.nXe = aVar3.xmD.readFloat();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aix.nXf = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aix.jOc = aVar3.xmD.mL();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aix.nXg = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aix.tMX = aVar3.xmD.readString();
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aix.tMY = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aix.tMZ = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aix.tNa = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
