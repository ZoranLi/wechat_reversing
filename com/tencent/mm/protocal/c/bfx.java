package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bfx extends a {
    public b ugo;
    public String ugp;
    public b ugq;
    public int uin;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ugo != null) {
                aVar.b(1, this.ugo);
            }
            if (this.ugp != null) {
                aVar.e(2, this.ugp);
            }
            if (this.ugq != null) {
                aVar.b(3, this.ugq);
            }
            aVar.eO(4, this.uin);
            return 0;
        } else if (i == 1) {
            if (this.ugo != null) {
                r0 = a.a.a.a.a(1, this.ugo) + 0;
            } else {
                r0 = 0;
            }
            if (this.ugp != null) {
                r0 += a.a.a.b.b.a.f(2, this.ugp);
            }
            if (this.ugq != null) {
                r0 += a.a.a.a.a(3, this.ugq);
            }
            return r0 + a.a.a.a.eL(4, this.uin);
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
            bfx com_tencent_mm_protocal_c_bfx = (bfx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bfx.ugo = aVar3.cic();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfx.ugp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfx.ugq = aVar3.cic();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfx.uin = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
