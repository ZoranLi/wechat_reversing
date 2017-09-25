package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bpx extends a {
    public LinkedList<aqq> unY = new LinkedList();
    public LinkedList<ahw> unZ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.unY);
            aVar.d(2, 8, this.unZ);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 8, this.unY) + 0) + a.a.a.a.c(2, 8, this.unZ);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.unY.clear();
                this.unZ.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                bpx com_tencent_mm_protocal_c_bpx = (bpx) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList En;
                int size;
                a com_tencent_mm_protocal_c_aqq;
                a.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            com_tencent_mm_protocal_c_aqq = new aqq();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_aqq.a(aVar4, com_tencent_mm_protocal_c_aqq, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bpx.unY.add(com_tencent_mm_protocal_c_aqq);
                        }
                        return 0;
                    case 2:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            com_tencent_mm_protocal_c_aqq = new ahw();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_aqq.a(aVar4, com_tencent_mm_protocal_c_aqq, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bpx.unZ.add(com_tencent_mm_protocal_c_aqq);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
