package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bir extends a {
    public String jNn;
    public String muS;
    public String muU;
    public String tJF;
    public String tUl;
    public String thD;
    public String tst;
    public long uiv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tst != null) {
                aVar.e(1, this.tst);
            }
            if (this.thD != null) {
                aVar.e(2, this.thD);
            }
            if (this.tUl != null) {
                aVar.e(3, this.tUl);
            }
            if (this.muS != null) {
                aVar.e(4, this.muS);
            }
            if (this.jNn != null) {
                aVar.e(5, this.jNn);
            }
            if (this.muU != null) {
                aVar.e(6, this.muU);
            }
            if (this.tJF != null) {
                aVar.e(7, this.tJF);
            }
            aVar.O(8, this.uiv);
            return 0;
        } else if (i == 1) {
            if (this.tst != null) {
                r0 = a.a.a.b.b.a.f(1, this.tst) + 0;
            } else {
                r0 = 0;
            }
            if (this.thD != null) {
                r0 += a.a.a.b.b.a.f(2, this.thD);
            }
            if (this.tUl != null) {
                r0 += a.a.a.b.b.a.f(3, this.tUl);
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(4, this.muS);
            }
            if (this.jNn != null) {
                r0 += a.a.a.b.b.a.f(5, this.jNn);
            }
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(6, this.muU);
            }
            if (this.tJF != null) {
                r0 += a.a.a.b.b.a.f(7, this.tJF);
            }
            return r0 + a.a.a.a.N(8, this.uiv);
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
            bir com_tencent_mm_protocal_c_bir = (bir) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bir.tst = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bir.thD = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bir.tUl = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bir.muS = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bir.jNn = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bir.muU = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bir.tJF = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bir.uiv = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
