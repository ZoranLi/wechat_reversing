package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bfa extends avh {
    public int mtd;
    public String tON;
    public int tVg;
    public int tgJ;
    public int tgK;
    public avw tsM;
    public int tue;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsM == null) {
                throw new b("Not all required fields were included: Content");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.mtd);
            aVar.eO(3, this.tVg);
            if (this.tsM != null) {
                aVar.eQ(4, this.tsM.aUk());
                this.tsM.a(aVar);
            }
            aVar.eO(5, this.tgK);
            aVar.eO(6, this.tgJ);
            if (this.tON != null) {
                aVar.e(7, this.tON);
            }
            aVar.eO(8, this.tue);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.mtd)) + a.a.a.a.eL(3, this.tVg);
            if (this.tsM != null) {
                r0 += a.a.a.a.eN(4, this.tsM.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(5, this.tgK)) + a.a.a.a.eL(6, this.tgJ);
            if (this.tON != null) {
                r0 += a.a.a.b.b.a.f(7, this.tON);
            }
            return r0 + a.a.a.a.eL(8, this.tue);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Content");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bfa com_tencent_mm_protocal_c_bfa = (bfa) objArr[1];
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
                        com_tencent_mm_protocal_c_bfa.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfa.mtd = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfa.tVg = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfa.tsM = emVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfa.tgK = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfa.tgJ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfa.tON = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfa.tue = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
