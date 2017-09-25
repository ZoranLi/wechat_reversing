package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bii extends avh {
    public String mvU;
    public String mvV;
    public int tOZ;
    public String tfU;
    public int tfc;
    public String tfi;
    public long tfk;
    public int tiL;
    public int tll;
    public avw tsk;
    public int tuG;
    public int tuc;
    public int tue;
    public int tuf;
    public int uhR;
    public int uhS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.mvV != null) {
                aVar.e(1, this.mvV);
            }
            if (this.mvU != null) {
                aVar.e(2, this.mvU);
            }
            aVar.eO(3, this.tll);
            aVar.eO(4, this.tuc);
            if (this.tfU != null) {
                aVar.e(5, this.tfU);
            }
            aVar.eO(6, this.tfc);
            aVar.eO(7, this.tue);
            if (this.tsk != null) {
                aVar.eQ(8, this.tsk.aUk());
                this.tsk.a(aVar);
            }
            aVar.eO(9, this.tiL);
            if (this.tYN != null) {
                aVar.eQ(10, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(11, this.tuf);
            if (this.tfi != null) {
                aVar.e(12, this.tfi);
            }
            aVar.eO(13, this.tOZ);
            aVar.eO(14, this.uhR);
            aVar.eO(15, this.uhS);
            aVar.O(16, this.tfk);
            aVar.eO(17, this.tuG);
            return 0;
        } else if (i == 1) {
            if (this.mvV != null) {
                r0 = a.a.a.b.b.a.f(1, this.mvV) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvU);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tll)) + a.a.a.a.eL(4, this.tuc);
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(5, this.tfU);
            }
            r0 = (r0 + a.a.a.a.eL(6, this.tfc)) + a.a.a.a.eL(7, this.tue);
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(8, this.tsk.aUk());
            }
            r0 += a.a.a.a.eL(9, this.tiL);
            if (this.tYN != null) {
                r0 += a.a.a.a.eN(10, this.tYN.aUk());
            }
            r0 += a.a.a.a.eL(11, this.tuf);
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(12, this.tfi);
            }
            return ((((r0 + a.a.a.a.eL(13, this.tOZ)) + a.a.a.a.eL(14, this.uhR)) + a.a.a.a.eL(15, this.uhS)) + a.a.a.a.N(16, this.tfk)) + a.a.a.a.eL(17, this.tuG);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bii com_tencent_mm_protocal_c_bii = (bii) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bii.mvV = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bii.mvU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bii.tll = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bii.tuc = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bii.tfU = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bii.tfc = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bii.tue = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bii.tsk = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bii.tiL = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bii.tYN = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bii.tuf = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bii.tfi = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bii.tOZ = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bii.uhR = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bii.uhS = aVar3.xmD.mL();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bii.tfk = aVar3.xmD.mM();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bii.tuG = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
