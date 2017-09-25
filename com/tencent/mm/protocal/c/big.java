package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class big extends avh {
    public String trv;
    public bjo trw;
    public bif try;
    public avw tsk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.trw == null) {
                throw new b("Not all required fields were included: VoiceAttr");
            } else if (this.try == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.trv != null) {
                    aVar.e(2, this.trv);
                }
                if (this.trw != null) {
                    aVar.eQ(3, this.trw.aUk());
                    this.trw.a(aVar);
                }
                if (this.try != null) {
                    aVar.eQ(4, this.try.aUk());
                    this.try.a(aVar);
                }
                if (this.tsk == null) {
                    return 0;
                }
                aVar.eQ(5, this.tsk.aUk());
                this.tsk.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.trv != null) {
                r0 += a.a.a.b.b.a.f(2, this.trv);
            }
            if (this.trw != null) {
                r0 += a.a.a.a.eN(3, this.trw.aUk());
            }
            if (this.try != null) {
                r0 += a.a.a.a.eN(4, this.try.aUk());
            }
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(5, this.tsk.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.trw == null) {
                throw new b("Not all required fields were included: VoiceAttr");
            } else if (this.try == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.tsk != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            big com_tencent_mm_protocal_c_big = (big) objArr[1];
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
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_big.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_big.trv = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bjo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_big.trw = emVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new bif();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_big.try = emVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_big.tsk = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
