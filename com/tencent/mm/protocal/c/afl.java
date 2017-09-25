package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afl extends a {
    public int jNW;
    public String msN;
    public String msj;
    public String tup;
    public String tvt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tvt != null) {
                aVar.e(1, this.tvt);
            }
            aVar.eO(2, this.jNW);
            if (this.tup != null) {
                aVar.e(3, this.tup);
            }
            if (this.msN != null) {
                aVar.e(4, this.msN);
            }
            if (this.msj == null) {
                return 0;
            }
            aVar.e(5, this.msj);
            return 0;
        } else if (i == 1) {
            if (this.tvt != null) {
                r0 = a.a.a.b.b.a.f(1, this.tvt) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.jNW);
            if (this.tup != null) {
                r0 += a.a.a.b.b.a.f(3, this.tup);
            }
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(4, this.msN);
            }
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(5, this.msj);
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
            afl com_tencent_mm_protocal_c_afl = (afl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afl.tvt = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afl.jNW = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afl.tup = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afl.msN = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afl.msj = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
