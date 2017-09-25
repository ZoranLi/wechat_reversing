package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class aeu extends a {
    public int mtF;
    public b tiB;
    public b tiD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tiD != null) {
                aVar.b(1, this.tiD);
            }
            if (this.tiB != null) {
                aVar.b(2, this.tiB);
            }
            aVar.eO(3, this.mtF);
            return 0;
        } else if (i == 1) {
            if (this.tiD != null) {
                r0 = a.a.a.a.a(1, this.tiD) + 0;
            } else {
                r0 = 0;
            }
            if (this.tiB != null) {
                r0 += a.a.a.a.a(2, this.tiB);
            }
            return r0 + a.a.a.a.eL(3, this.mtF);
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
            aeu com_tencent_mm_protocal_c_aeu = (aeu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aeu.tiD = aVar3.cic();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aeu.tiB = aVar3.cic();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aeu.mtF = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
