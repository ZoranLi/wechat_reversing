package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ajr extends a {
    public String leE;
    public String tNw;
    public String tNx;
    public String tNy;
    public double tld;
    public double tle;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.tle);
            aVar.a(2, this.tld);
            if (this.leE != null) {
                aVar.e(3, this.leE);
            }
            if (this.tNw != null) {
                aVar.e(4, this.tNw);
            }
            if (this.tNx != null) {
                aVar.e(5, this.tNx);
            }
            if (this.tNy != null) {
                aVar.e(6, this.tNy);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.b.b.a.cH(1) + 8) + 0) + (a.a.a.b.b.a.cH(2) + 8);
            if (this.leE != null) {
                r0 += a.a.a.b.b.a.f(3, this.leE);
            }
            if (this.tNw != null) {
                r0 += a.a.a.b.b.a.f(4, this.tNw);
            }
            if (this.tNx != null) {
                r0 += a.a.a.b.b.a.f(5, this.tNx);
            }
            if (this.tNy != null) {
                return r0 + a.a.a.b.b.a.f(6, this.tNy);
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
            ajr com_tencent_mm_protocal_c_ajr = (ajr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ajr.tle = aVar3.xmD.readDouble();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajr.tld = aVar3.xmD.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajr.leE = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajr.tNw = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajr.tNx = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ajr.tNy = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
