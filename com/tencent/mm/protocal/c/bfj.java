package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bfj extends a {
    public String msj;
    public String tTU;
    public double tld;
    public double tle;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.tle);
            aVar.a(2, this.tld);
            if (this.msj != null) {
                aVar.e(3, this.msj);
            }
            if (this.tTU != null) {
                aVar.e(4, this.tTU);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.b.b.a.cH(1) + 8) + 0) + (a.a.a.b.b.a.cH(2) + 8);
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(3, this.msj);
            }
            if (this.tTU != null) {
                return r0 + a.a.a.b.b.a.f(4, this.tTU);
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
            bfj com_tencent_mm_protocal_c_bfj = (bfj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bfj.tle = aVar3.xmD.readDouble();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfj.tld = aVar3.xmD.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfj.msj = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfj.tTU = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
