package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bqm extends a {
    public int tOh;
    public int teU;
    public int uoD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tOh);
            aVar.eO(2, this.teU);
            aVar.eO(3, this.uoD);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.eL(1, this.tOh) + 0) + a.a.a.a.eL(2, this.teU)) + a.a.a.a.eL(3, this.uoD);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
                bqm com_tencent_mm_protocal_c_bqm = (bqm) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bqm.tOh = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bqm.teU = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bqm.uoD = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
