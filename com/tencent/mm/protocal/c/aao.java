package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aao extends avh {
    public int tGt;
    public avw tGu;
    public int tGv;
    public int tGw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tGu == null) {
                throw new b("Not all required fields were included: Url");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tGt);
            if (this.tGu != null) {
                aVar.eQ(3, this.tGu.aUk());
                this.tGu.a(aVar);
            }
            aVar.eO(4, this.tGv);
            aVar.eO(5, this.tGw);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tGt);
            if (this.tGu != null) {
                r0 += a.a.a.a.eN(3, this.tGu.aUk());
            }
            return (r0 + a.a.a.a.eL(4, this.tGv)) + a.a.a.a.eL(5, this.tGw);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tGu != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Url");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aao com_tencent_mm_protocal_c_aao = (aao) objArr[1];
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
                        com_tencent_mm_protocal_c_aao.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aao.tGt = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aao.tGu = emVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aao.tGv = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aao.tGw = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
