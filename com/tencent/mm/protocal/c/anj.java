package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class anj extends a {
    public afd tjL;
    public hr tjM;
    public anh tjN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tjL != null) {
                aVar.eQ(1, this.tjL.aUk());
                this.tjL.a(aVar);
            }
            if (this.tjN != null) {
                aVar.eQ(2, this.tjN.aUk());
                this.tjN.a(aVar);
            }
            if (this.tjM == null) {
                return 0;
            }
            aVar.eQ(3, this.tjM.aUk());
            this.tjM.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tjL != null) {
                r0 = a.a.a.a.eN(1, this.tjL.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tjN != null) {
                r0 += a.a.a.a.eN(2, this.tjN.aUk());
            }
            if (this.tjM != null) {
                r0 += a.a.a.a.eN(3, this.tjM.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            anj com_tencent_mm_protocal_c_anj = (anj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_afd;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_afd = new afd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afd.a(aVar4, com_tencent_mm_protocal_c_afd, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anj.tjL = com_tencent_mm_protocal_c_afd;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_afd = new anh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afd.a(aVar4, com_tencent_mm_protocal_c_afd, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anj.tjN = com_tencent_mm_protocal_c_afd;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_afd = new hr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afd.a(aVar4, com_tencent_mm_protocal_c_afd, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anj.tjM = com_tencent_mm_protocal_c_afd;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
