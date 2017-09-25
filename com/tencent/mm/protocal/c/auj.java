package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class auj extends avh {
    public int jOc;
    public int mtE;
    public biq tYa;
    public bfj tYb;
    public String tvV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYa == null) {
                throw new b("Not all required fields were included: UserPosition");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tvV != null) {
                aVar.e(2, this.tvV);
            }
            aVar.eO(3, this.jOc);
            if (this.tYa != null) {
                aVar.eQ(4, this.tYa.aUk());
                this.tYa.a(aVar);
            }
            aVar.eO(5, this.mtE);
            if (this.tYb == null) {
                return 0;
            }
            aVar.eQ(6, this.tYb.aUk());
            this.tYb.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tvV != null) {
                r0 += a.a.a.b.b.a.f(2, this.tvV);
            }
            r0 += a.a.a.a.eL(3, this.jOc);
            if (this.tYa != null) {
                r0 += a.a.a.a.eN(4, this.tYa.aUk());
            }
            r0 += a.a.a.a.eL(5, this.mtE);
            if (this.tYb != null) {
                r0 += a.a.a.a.eN(6, this.tYb.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tYa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserPosition");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            auj com_tencent_mm_protocal_c_auj = (auj) objArr[1];
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
                        com_tencent_mm_protocal_c_auj.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auj.tvV = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auj.jOc = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new biq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auj.tYa = emVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_auj.mtE = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bfj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auj.tYb = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
