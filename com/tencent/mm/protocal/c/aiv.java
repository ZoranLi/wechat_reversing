package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aiv extends a {
    public String kgX;
    public double latitude;
    public double longitude;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.latitude);
            aVar.a(2, this.longitude);
            if (this.kgX != null) {
                aVar.e(3, this.kgX);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.b.b.a.cH(1) + 8) + 0) + (a.a.a.b.b.a.cH(2) + 8);
            if (this.kgX != null) {
                return r0 + a.a.a.b.b.a.f(3, this.kgX);
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
            aiv com_tencent_mm_protocal_c_aiv = (aiv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aiv.latitude = aVar3.xmD.readDouble();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aiv.longitude = aVar3.xmD.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aiv.kgX = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
