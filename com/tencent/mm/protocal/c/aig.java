package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class aig extends a {
    public int jNd;
    public int tMh;
    public b tMi;
    public int tMp;
    public int tMq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tMh);
            if (this.tMi != null) {
                aVar.b(2, this.tMi);
            }
            aVar.eO(3, this.tMp);
            aVar.eO(4, this.jNd);
            aVar.eO(5, this.tMq);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tMh) + 0;
            if (this.tMi != null) {
                r0 += a.a.a.a.a(2, this.tMi);
            }
            return ((r0 + a.a.a.a.eL(3, this.tMp)) + a.a.a.a.eL(4, this.jNd)) + a.a.a.a.eL(5, this.tMq);
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
            aig com_tencent_mm_protocal_c_aig = (aig) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aig.tMh = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aig.tMi = aVar3.cic();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aig.tMp = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aig.jNd = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aig.tMq = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
