package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bfu extends a {
    public int thX;
    public int ugh;
    public String ugk;
    public String ugl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ugh);
            if (this.ugk != null) {
                aVar.e(2, this.ugk);
            }
            aVar.eO(3, this.thX);
            if (this.ugl != null) {
                aVar.e(4, this.ugl);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.ugh) + 0;
            if (this.ugk != null) {
                r0 += a.a.a.b.b.a.f(2, this.ugk);
            }
            r0 += a.a.a.a.eL(3, this.thX);
            if (this.ugl != null) {
                return r0 + a.a.a.b.b.a.f(4, this.ugl);
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
            bfu com_tencent_mm_protocal_c_bfu = (bfu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bfu.ugh = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfu.ugk = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfu.thX = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfu.ugl = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
