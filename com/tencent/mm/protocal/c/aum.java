package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class aum extends avh {
    public String tCE;
    public long tCF;
    public String tYe;
    public String tYf;
    public avw tjF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.O(2, this.tCF);
            if (this.tYe != null) {
                aVar.e(3, this.tYe);
            }
            if (this.tYf != null) {
                aVar.e(4, this.tYf);
            }
            if (this.tCE != null) {
                aVar.e(5, this.tCE);
            }
            if (this.tjF == null) {
                return 0;
            }
            aVar.eQ(6, this.tjF.aUk());
            this.tjF.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.N(2, this.tCF);
            if (this.tYe != null) {
                r0 += a.a.a.b.b.a.f(3, this.tYe);
            }
            if (this.tYf != null) {
                r0 += a.a.a.b.b.a.f(4, this.tYf);
            }
            if (this.tCE != null) {
                r0 += a.a.a.b.b.a.f(5, this.tCE);
            }
            if (this.tjF != null) {
                r0 += a.a.a.a.eN(6, this.tjF.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aum com_tencent_mm_protocal_c_aum = (aum) objArr[1];
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
                        com_tencent_mm_protocal_c_aum.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aum.tCF = aVar3.xmD.mM();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aum.tYe = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aum.tYf = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aum.tCE = aVar3.xmD.readString();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aum.tjF = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
