package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afs extends a {
    public String msK;
    public String opH;
    public int tqS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tqS);
            if (this.opH != null) {
                aVar.e(2, this.opH);
            }
            if (this.msK != null) {
                aVar.e(3, this.msK);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tqS) + 0;
            if (this.opH != null) {
                r0 += a.a.a.b.b.a.f(2, this.opH);
            }
            if (this.msK != null) {
                return r0 + a.a.a.b.b.a.f(3, this.msK);
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
            afs com_tencent_mm_protocal_c_afs = (afs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afs.tqS = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afs.opH = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afs.msK = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
