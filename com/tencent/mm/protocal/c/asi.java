package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class asi extends a {
    public int jNd;
    public int tGq;
    public LinkedList<ash> tWK = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tGq);
            aVar.eO(2, this.jNd);
            aVar.d(3, 8, this.tWK);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.eL(1, this.tGq) + 0) + a.a.a.a.eL(2, this.jNd)) + a.a.a.a.c(3, 8, this.tWK);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tWK.clear();
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
                asi com_tencent_mm_protocal_c_asi = (asi) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_asi.tGq = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_asi.jNd = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_ash = new ash();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_ash.a(aVar4, com_tencent_mm_protocal_c_ash, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_asi.tWK.add(com_tencent_mm_protocal_c_ash);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
