package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bbn extends a {
    public int mtF;
    public avw tUb;
    public long tmx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.tmx);
            aVar.eO(2, this.mtF);
            if (this.tUb != null) {
                aVar.eQ(3, this.tUb.aUk());
                this.tUb.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.N(1, this.tmx) + 0) + a.a.a.a.eL(2, this.mtF);
            if (this.tUb != null) {
                return r0 + a.a.a.a.eN(3, this.tUb.aUk());
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
            bbn com_tencent_mm_protocal_c_bbn = (bbn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bbn.tmx = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbn.mtF = aVar3.xmD.mL();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbn.tUb = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
