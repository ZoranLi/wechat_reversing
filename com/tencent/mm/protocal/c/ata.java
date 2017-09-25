package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ata extends a {
    public avx teL;
    public avx ttp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.teL == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.ttp == null) {
                throw new b("Not all required fields were included: UserName");
            } else {
                if (this.teL != null) {
                    aVar.eQ(1, this.teL.aUk());
                    this.teL.a(aVar);
                }
                if (this.ttp == null) {
                    return 0;
                }
                aVar.eQ(2, this.ttp.aUk());
                this.ttp.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.teL != null) {
                r0 = a.a.a.a.eN(1, this.teL.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ttp != null) {
                r0 += a.a.a.a.eN(2, this.ttp.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.teL == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.ttp != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: UserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ata com_tencent_mm_protocal_c_ata = (ata) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ata.teL = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ata.ttp = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
