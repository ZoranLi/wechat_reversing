package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bmj extends a {
    public LinkedList<bmk> tCt = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).d(1, 8, this.tCt);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.c(1, 8, this.tCt) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tCt.clear();
                a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar2 = (a.a.a.a.a) objArr[0];
                bmj com_tencent_mm_protocal_c_bmj = (bmj) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList En = aVar2.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_bmk = new bmk();
                            a.a.a.a.a aVar3 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bmk.a(aVar3, com_tencent_mm_protocal_c_bmk, a.a(aVar3))) {
                            }
                            com_tencent_mm_protocal_c_bmj.tCt.add(com_tencent_mm_protocal_c_bmk);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
