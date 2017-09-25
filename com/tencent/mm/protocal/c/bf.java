package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bf extends a {
    public int teD;
    public b teE;
    public long teF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.teD);
            if (this.teE != null) {
                aVar.b(2, this.teE);
            }
            aVar.O(3, this.teF);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.teD) + 0;
            if (this.teE != null) {
                r0 += a.a.a.a.a(2, this.teE);
            }
            return r0 + a.a.a.a.N(3, this.teF);
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
            bf bfVar = (bf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfVar.teD = aVar3.xmD.mL();
                    return 0;
                case 2:
                    bfVar.teE = aVar3.cic();
                    return 0;
                case 3:
                    bfVar.teF = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
