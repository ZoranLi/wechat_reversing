package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bkx extends avh {
    public int tWi;
    public avw tij;
    public int tvL;
    public long tvM;
    public int ukl;
    public int ukm;
    public int ukn;
    public int uko;
    public int ukp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tij == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tvL);
            aVar.O(3, this.tvM);
            aVar.eO(4, this.tWi);
            aVar.eO(5, this.ukl);
            aVar.eO(6, this.ukm);
            aVar.eO(7, this.ukn);
            aVar.eO(8, this.uko);
            aVar.eO(9, this.ukp);
            if (this.tij == null) {
                return 0;
            }
            aVar.eQ(10, this.tij.aUk());
            this.tij.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((((((r0 + a.a.a.a.eL(2, this.tvL)) + a.a.a.a.N(3, this.tvM)) + a.a.a.a.eL(4, this.tWi)) + a.a.a.a.eL(5, this.ukl)) + a.a.a.a.eL(6, this.ukm)) + a.a.a.a.eL(7, this.ukn)) + a.a.a.a.eL(8, this.uko)) + a.a.a.a.eL(9, this.ukp);
            if (this.tij != null) {
                r0 += a.a.a.a.eN(10, this.tij.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tij != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bkx com_tencent_mm_protocal_c_bkx = (bkx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkx.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkx.tvL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkx.tvM = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bkx.tWi = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bkx.ukl = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkx.ukm = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bkx.ukn = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bkx.uko = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bkx.ukp = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkx.tij = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
