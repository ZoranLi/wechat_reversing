package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bns extends a {
    public long umI;
    public long umJ;
    public String umK;
    public LinkedList<bnt> umL = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.umK == null) {
                throw new b("Not all required fields were included: TotalMsg");
            }
            aVar.O(1, this.umJ);
            aVar.O(2, this.umI);
            if (this.umK != null) {
                aVar.e(3, this.umK);
            }
            aVar.d(4, 8, this.umL);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.N(1, this.umJ) + 0) + a.a.a.a.N(2, this.umI);
            if (this.umK != null) {
                r0 += a.a.a.b.b.a.f(3, this.umK);
            }
            return r0 + a.a.a.a.c(4, 8, this.umL);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.umL.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.umK != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TotalMsg");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bns com_tencent_mm_protocal_c_bns = (bns) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bns.umJ = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bns.umI = aVar3.xmD.mM();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bns.umK = aVar3.xmD.readString();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bnt = new bnt();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bnt.a(aVar4, com_tencent_mm_protocal_c_bnt, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bns.umL.add(com_tencent_mm_protocal_c_bnt);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
