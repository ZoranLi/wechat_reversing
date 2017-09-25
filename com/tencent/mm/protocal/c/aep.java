package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aep extends avh {
    public int tJP;
    public avw tJQ;
    public aen tjo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tjo == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.tJQ == null) {
                throw new b("Not all required fields were included: AuthBuffer");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tjo != null) {
                    aVar.eQ(2, this.tjo.aUk());
                    this.tjo.a(aVar);
                }
                aVar.eO(3, this.tJP);
                if (this.tJQ == null) {
                    return 0;
                }
                aVar.eQ(4, this.tJQ.aUk());
                this.tJQ.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tjo != null) {
                r0 += a.a.a.a.eN(2, this.tjo.aUk());
            }
            r0 += a.a.a.a.eL(3, this.tJP);
            if (this.tJQ != null) {
                r0 += a.a.a.a.eN(4, this.tJQ.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tjo == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.tJQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AuthBuffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aep com_tencent_mm_protocal_c_aep = (aep) objArr[1];
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
                        com_tencent_mm_protocal_c_aep.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new aen();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aep.tjo = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aep.tJP = aVar3.xmD.mL();
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
                        com_tencent_mm_protocal_c_aep.tJQ = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
