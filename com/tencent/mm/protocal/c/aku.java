package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aku extends a {
    public akv tOB;
    public akt tOC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tOB == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.tOC == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.tOB != null) {
                    aVar.eQ(1, this.tOB.aUk());
                    this.tOB.a(aVar);
                }
                if (this.tOC == null) {
                    return 0;
                }
                aVar.eQ(2, this.tOC.aUk());
                this.tOC.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tOB != null) {
                r0 = a.a.a.a.eN(1, this.tOB.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tOC != null) {
                r0 += a.a.a.a.eN(2, this.tOC.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tOB == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.tOC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aku com_tencent_mm_protocal_c_aku = (aku) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_akv;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_akv = new akv();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_akv.a(aVar4, com_tencent_mm_protocal_c_akv, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aku.tOB = com_tencent_mm_protocal_c_akv;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_akv = new akt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_akv.a(aVar4, com_tencent_mm_protocal_c_akv, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aku.tOC = com_tencent_mm_protocal_c_akv;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
