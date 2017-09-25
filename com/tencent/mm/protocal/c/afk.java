package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afk extends a {
    public String fDC;
    public String msN;
    public String muS;
    public String tKE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msN != null) {
                aVar.e(1, this.msN);
            }
            if (this.fDC != null) {
                aVar.e(2, this.fDC);
            }
            if (this.tKE != null) {
                aVar.e(3, this.tKE);
            }
            if (this.muS == null) {
                return 0;
            }
            aVar.e(4, this.muS);
            return 0;
        } else if (i == 1) {
            if (this.msN != null) {
                r0 = a.a.a.b.b.a.f(1, this.msN) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            if (this.tKE != null) {
                r0 += a.a.a.b.b.a.f(3, this.tKE);
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(4, this.muS);
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
            afk com_tencent_mm_protocal_c_afk = (afk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afk.msN = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afk.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afk.tKE = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afk.muS = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
