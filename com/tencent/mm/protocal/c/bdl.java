package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bdl extends avh {
    public String mvU;
    public String mvV;
    public String tfU;
    public int ueH;
    public int ueI;
    public LinkedList<bdn> ueJ = new LinkedList();
    public bdk ueK;
    public int ueL;
    public LinkedList<bdk> ueM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.ueH);
            if (this.mvV != null) {
                aVar.e(3, this.mvV);
            }
            if (this.mvU != null) {
                aVar.e(4, this.mvU);
            }
            if (this.tfU != null) {
                aVar.e(5, this.tfU);
            }
            aVar.eO(6, this.ueI);
            aVar.d(7, 8, this.ueJ);
            if (this.ueK != null) {
                aVar.eQ(8, this.ueK.aUk());
                this.ueK.a(aVar);
            }
            aVar.eO(9, this.ueL);
            aVar.d(10, 8, this.ueM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.ueH);
            if (this.mvV != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvV);
            }
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvU);
            }
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(5, this.tfU);
            }
            r0 = (r0 + a.a.a.a.eL(6, this.ueI)) + a.a.a.a.c(7, 8, this.ueJ);
            if (this.ueK != null) {
                r0 += a.a.a.a.eN(8, this.ueK.aUk());
            }
            return (r0 + a.a.a.a.eL(9, this.ueL)) + a.a.a.a.c(10, 8, this.ueM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ueJ.clear();
            this.ueM.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bdl com_tencent_mm_protocal_c_bdl = (bdl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdl.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdl.ueH = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bdl.mvV = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdl.mvU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bdl.tfU = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bdl.ueI = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bdn();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdl.ueJ.add(emVar);
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bdk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdl.ueK = emVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bdl.ueL = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bdk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdl.ueM.add(emVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
