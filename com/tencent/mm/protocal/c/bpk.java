package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bpk extends a {
    public int tkv;
    public String unO;
    public String unP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tkv);
            if (this.unO != null) {
                aVar.e(2, this.unO);
            }
            if (this.unP != null) {
                aVar.e(3, this.unP);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tkv) + 0;
            if (this.unO != null) {
                r0 += a.a.a.b.b.a.f(2, this.unO);
            }
            if (this.unP != null) {
                return r0 + a.a.a.b.b.a.f(3, this.unP);
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
            bpk com_tencent_mm_protocal_c_bpk = (bpk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bpk.tkv = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpk.unO = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bpk.unP = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
