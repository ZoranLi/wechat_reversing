package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afq extends a {
    public double latitude;
    public double longitude;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.latitude);
            aVar.a(2, this.longitude);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.b.b.a.cH(1) + 8) + 0) + (a.a.a.b.b.a.cH(2) + 8);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                afq com_tencent_mm_protocal_c_afq = (afq) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_afq.latitude = aVar3.xmD.readDouble();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_afq.longitude = aVar3.xmD.readDouble();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
