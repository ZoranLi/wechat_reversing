package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aoz extends a {
    public int tTY;
    public String tTZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tTY);
            if (this.tTZ != null) {
                aVar.e(2, this.tTZ);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tTY) + 0;
            if (this.tTZ != null) {
                return r0 + a.a.a.b.b.a.f(2, this.tTZ);
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
            aoz com_tencent_mm_protocal_c_aoz = (aoz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aoz.tTY = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aoz.tTZ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
