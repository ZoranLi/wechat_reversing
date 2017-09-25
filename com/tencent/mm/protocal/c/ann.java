package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ann extends avh {
    public String jNj;
    public String leO;
    public avw tSq;
    public avw tSr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tSq == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.tSr == null) {
                throw new b("Not all required fields were included: MaxSynckey");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.jNj != null) {
                    aVar.e(2, this.jNj);
                }
                if (this.tSq != null) {
                    aVar.eQ(3, this.tSq.aUk());
                    this.tSq.a(aVar);
                }
                if (this.tSr != null) {
                    aVar.eQ(4, this.tSr.aUk());
                    this.tSr.a(aVar);
                }
                if (this.leO == null) {
                    return 0;
                }
                aVar.e(5, this.leO);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            if (this.tSq != null) {
                r0 += a.a.a.a.eN(3, this.tSq.aUk());
            }
            if (this.tSr != null) {
                r0 += a.a.a.a.eN(4, this.tSr.aUk());
            }
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(5, this.leO);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tSq == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.tSr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MaxSynckey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ann com_tencent_mm_protocal_c_ann = (ann) objArr[1];
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
                        com_tencent_mm_protocal_c_ann.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ann.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ann.tSq = emVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ann.tSr = emVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ann.leO = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
