package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bjt extends a {
    public int tiL;
    public int uje;
    public String uji;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.uje);
            aVar.eO(2, this.tiL);
            if (this.uji != null) {
                aVar.e(3, this.uji);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.uje) + 0) + a.a.a.a.eL(2, this.tiL);
            if (this.uji != null) {
                return r0 + a.a.a.b.b.a.f(3, this.uji);
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
            bjt com_tencent_mm_protocal_c_bjt = (bjt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bjt.uje = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjt.tiL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjt.uji = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
