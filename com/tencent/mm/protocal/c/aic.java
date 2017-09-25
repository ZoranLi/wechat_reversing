package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class aic extends a {
    public int jNd;
    public int tMh;
    public b tMi;
    public int tMj;
    public int tMk;
    public int ttQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tMh);
            if (this.tMi != null) {
                aVar.b(2, this.tMi);
            }
            aVar.eO(3, this.tMj);
            aVar.eO(4, this.ttQ);
            aVar.eO(5, this.jNd);
            aVar.eO(6, this.tMk);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tMh) + 0;
            if (this.tMi != null) {
                r0 += a.a.a.a.a(2, this.tMi);
            }
            return (((r0 + a.a.a.a.eL(3, this.tMj)) + a.a.a.a.eL(4, this.ttQ)) + a.a.a.a.eL(5, this.jNd)) + a.a.a.a.eL(6, this.tMk);
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
            aic com_tencent_mm_protocal_c_aic = (aic) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aic.tMh = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aic.tMi = aVar3.cic();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aic.tMj = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aic.ttQ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aic.jNd = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aic.tMk = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
