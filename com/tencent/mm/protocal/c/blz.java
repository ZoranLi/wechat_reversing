package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class blz extends a {
    public String mtf;
    public String mvV;
    public String tVE;
    public String ulK;
    public String ulL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tVE != null) {
                aVar.e(1, this.tVE);
            }
            if (this.ulK != null) {
                aVar.e(2, this.ulK);
            }
            if (this.mvV != null) {
                aVar.e(3, this.mvV);
            }
            if (this.mtf != null) {
                aVar.e(4, this.mtf);
            }
            if (this.ulL == null) {
                return 0;
            }
            aVar.e(5, this.ulL);
            return 0;
        } else if (i == 1) {
            if (this.tVE != null) {
                r0 = a.a.a.b.b.a.f(1, this.tVE) + 0;
            } else {
                r0 = 0;
            }
            if (this.ulK != null) {
                r0 += a.a.a.b.b.a.f(2, this.ulK);
            }
            if (this.mvV != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvV);
            }
            if (this.mtf != null) {
                r0 += a.a.a.b.b.a.f(4, this.mtf);
            }
            if (this.ulL != null) {
                r0 += a.a.a.b.b.a.f(5, this.ulL);
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
            blz com_tencent_mm_protocal_c_blz = (blz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_blz.tVE = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blz.ulK = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blz.mvV = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_blz.mtf = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_blz.ulL = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
