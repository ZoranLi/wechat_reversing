package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afi extends a {
    public String mvE;
    public float tKC;
    public String tKD;
    public float tlp;
    public float tlq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.n(1, this.tlp);
            aVar.n(2, this.tlq);
            aVar.n(3, this.tKC);
            if (this.mvE != null) {
                aVar.e(4, this.mvE);
            }
            if (this.tKD != null) {
                aVar.e(5, this.tKD);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.b.b.a.cH(1) + 4) + 0) + (a.a.a.b.b.a.cH(2) + 4)) + (a.a.a.b.b.a.cH(3) + 4);
            if (this.mvE != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvE);
            }
            if (this.tKD != null) {
                return r0 + a.a.a.b.b.a.f(5, this.tKD);
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
            afi com_tencent_mm_protocal_c_afi = (afi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afi.tlp = aVar3.xmD.readFloat();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afi.tlq = aVar3.xmD.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afi.tKC = aVar3.xmD.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afi.mvE = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afi.tKD = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
