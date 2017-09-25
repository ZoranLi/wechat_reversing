package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bcp extends a {
    public int hAO;
    public String hAP;
    public long hAQ;
    public int udF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.hAO);
            if (this.hAP != null) {
                aVar.e(2, this.hAP);
            }
            aVar.O(3, this.hAQ);
            aVar.eO(4, this.udF);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.hAO) + 0;
            if (this.hAP != null) {
                r0 += a.a.a.b.b.a.f(2, this.hAP);
            }
            return (r0 + a.a.a.a.N(3, this.hAQ)) + a.a.a.a.eL(4, this.udF);
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
            bcp com_tencent_mm_protocal_c_bcp = (bcp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bcp.hAO = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcp.hAP = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bcp.hAQ = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcp.udF = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
