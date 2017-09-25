package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class aqm extends a {
    public aiy ttj;
    public int tvD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttj != null) {
                aVar.eQ(1, this.ttj.aUk());
                this.ttj.a(aVar);
            }
            aVar.eO(2, this.tvD);
            return 0;
        } else if (i == 1) {
            if (this.ttj != null) {
                r0 = a.a.a.a.eN(1, this.ttj.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.eL(2, this.tvD);
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
            aqm com_tencent_mm_protocal_c_aqm = (aqm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aiy = new aiy();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aiy.a(aVar4, com_tencent_mm_protocal_c_aiy, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqm.ttj = com_tencent_mm_protocal_c_aiy;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqm.tvD = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
