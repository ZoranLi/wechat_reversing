package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class axe extends avh {
    public avx tLj;
    public int tZS;
    public int tce;
    public avw tfG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.tfG == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tLj != null) {
                    aVar.eQ(2, this.tLj.aUk());
                    this.tLj.a(aVar);
                }
                aVar.eO(3, this.tce);
                aVar.eO(4, this.tZS);
                if (this.tfG == null) {
                    return 0;
                }
                aVar.eQ(5, this.tfG.aUk());
                this.tfG.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tLj != null) {
                r0 += a.a.a.a.eN(2, this.tLj.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tce)) + a.a.a.a.eL(4, this.tZS);
            if (this.tfG != null) {
                r0 += a.a.a.a.eN(5, this.tfG.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.tfG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axe com_tencent_mm_protocal_c_axe = (axe) objArr[1];
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
                        com_tencent_mm_protocal_c_axe.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axe.tLj = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axe.tce = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axe.tZS = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axe.tfG = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
