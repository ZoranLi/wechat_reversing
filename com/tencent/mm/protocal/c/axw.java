package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class axw extends avh {
    public int jNd;
    public LinkedList<alq> jNe = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            aVar.eO(1, this.jNd);
            aVar.d(2, 8, this.jNe);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.eL(1, this.jNd) + 0) + a.a.a.a.c(2, 8, this.jNe);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.jNe.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = com.tencent.mm.bd.a.a(aVar2); a > 0; a = com.tencent.mm.bd.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                axw com_tencent_mm_protocal_c_axw = (axw) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_axw.jNd = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            com.tencent.mm.bd.a com_tencent_mm_protocal_c_alq = new alq();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_alq.a(aVar4, com_tencent_mm_protocal_c_alq, com.tencent.mm.bd.a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_axw.jNe.add(com_tencent_mm_protocal_c_alq);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
