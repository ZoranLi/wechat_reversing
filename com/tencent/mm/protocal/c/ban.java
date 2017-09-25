package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ban extends avh {
    public String teW;
    public int tfW;
    public bav ubA;
    public avx ubB;
    public avx ubz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ubA == null) {
                throw new b("Not all required fields were included: Action");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.ubA != null) {
                aVar.eQ(2, this.ubA.aUk());
                this.ubA.a(aVar);
            }
            if (this.teW != null) {
                aVar.e(3, this.teW);
            }
            if (this.ubz != null) {
                aVar.eQ(4, this.ubz.aUk());
                this.ubz.a(aVar);
            }
            aVar.eO(5, this.tfW);
            if (this.ubB == null) {
                return 0;
            }
            aVar.eQ(6, this.ubB.aUk());
            this.ubB.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ubA != null) {
                r0 += a.a.a.a.eN(2, this.ubA.aUk());
            }
            if (this.teW != null) {
                r0 += a.a.a.b.b.a.f(3, this.teW);
            }
            if (this.ubz != null) {
                r0 += a.a.a.a.eN(4, this.ubz.aUk());
            }
            r0 += a.a.a.a.eL(5, this.tfW);
            if (this.ubB != null) {
                r0 += a.a.a.a.eN(6, this.ubB.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ubA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Action");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ban com_tencent_mm_protocal_c_ban = (ban) objArr[1];
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
                        com_tencent_mm_protocal_c_ban.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bav();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ban.ubA = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ban.teW = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ban.ubz = emVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ban.tfW = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ban.ubB = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
