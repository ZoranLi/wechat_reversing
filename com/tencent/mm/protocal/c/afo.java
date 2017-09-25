package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afo extends a {
    public double hQZ;
    public int major;
    public int minor;
    public String mry;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mry != null) {
                aVar.e(1, this.mry);
            }
            aVar.eO(2, this.major);
            aVar.eO(3, this.minor);
            aVar.a(4, this.hQZ);
            return 0;
        } else if (i == 1) {
            if (this.mry != null) {
                r0 = a.a.a.b.b.a.f(1, this.mry) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.eL(2, this.major)) + a.a.a.a.eL(3, this.minor)) + (a.a.a.b.b.a.cH(4) + 8);
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
            afo com_tencent_mm_protocal_c_afo = (afo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afo.mry = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afo.major = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afo.minor = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afo.hQZ = aVar3.xmD.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
