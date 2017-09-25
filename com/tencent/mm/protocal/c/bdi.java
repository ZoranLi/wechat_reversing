package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bdi extends a {
    public bdj ueA;
    public bdh ueB;
    public bdg ueC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ueA != null) {
                aVar.eQ(1, this.ueA.aUk());
                this.ueA.a(aVar);
            }
            if (this.ueB != null) {
                aVar.eQ(2, this.ueB.aUk());
                this.ueB.a(aVar);
            }
            if (this.ueC == null) {
                return 0;
            }
            aVar.eQ(3, this.ueC.aUk());
            this.ueC.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.ueA != null) {
                r0 = a.a.a.a.eN(1, this.ueA.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ueB != null) {
                r0 += a.a.a.a.eN(2, this.ueB.aUk());
            }
            if (this.ueC != null) {
                r0 += a.a.a.a.eN(3, this.ueC.aUk());
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
            bdi com_tencent_mm_protocal_c_bdi = (bdi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdj;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bdj = new bdj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdj.a(aVar4, com_tencent_mm_protocal_c_bdj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdi.ueA = com_tencent_mm_protocal_c_bdj;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bdj = new bdh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdj.a(aVar4, com_tencent_mm_protocal_c_bdj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdi.ueB = com_tencent_mm_protocal_c_bdj;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bdj = new bdg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdj.a(aVar4, com_tencent_mm_protocal_c_bdj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdi.ueC = com_tencent_mm_protocal_c_bdj;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
