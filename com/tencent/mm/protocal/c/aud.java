package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aud extends a {
    public bby tXT;
    public avx tXU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tXT == null) {
                throw new b("Not all required fields were included: SnsRecommendObject");
            }
            if (this.tXT != null) {
                aVar.eQ(1, this.tXT.aUk());
                this.tXT.a(aVar);
            }
            if (this.tXU == null) {
                return 0;
            }
            aVar.eQ(2, this.tXU.aUk());
            this.tXU.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tXT != null) {
                r0 = a.a.a.a.eN(1, this.tXT.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tXU != null) {
                r0 += a.a.a.a.eN(2, this.tXU.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tXT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsRecommendObject");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aud com_tencent_mm_protocal_c_aud = (aud) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bby;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bby = new bby();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bby.a(aVar4, com_tencent_mm_protocal_c_bby, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aud.tXT = com_tencent_mm_protocal_c_bby;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bby = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bby.a(aVar4, com_tencent_mm_protocal_c_bby, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aud.tXU = com_tencent_mm_protocal_c_bby;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
