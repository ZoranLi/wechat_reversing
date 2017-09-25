package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class bpm extends a {
    public LinkedList<bdp> unR = new LinkedList();
    public b unS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.unR);
            if (this.unS != null) {
                aVar.b(2, this.unS);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.unR) + 0;
            if (this.unS != null) {
                return r0 + a.a.a.a.a(2, this.unS);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.unR.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            bpm com_tencent_mm_protocal_c_bpm = (bpm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bdp = new bdp();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdp.a(aVar4, com_tencent_mm_protocal_c_bdp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bpm.unR.add(com_tencent_mm_protocal_c_bdp);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpm.unS = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
