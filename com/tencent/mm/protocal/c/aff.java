package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aff extends a {
    public int jNW;
    public String msN;
    public String msj;
    public String tng;
    public String tnk;
    public String tup;
    public String tvt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tvt != null) {
                aVar.e(1, this.tvt);
            }
            if (this.msj != null) {
                aVar.e(2, this.msj);
            }
            aVar.eO(3, this.jNW);
            if (this.tup != null) {
                aVar.e(4, this.tup);
            }
            if (this.tnk != null) {
                aVar.e(5, this.tnk);
            }
            if (this.tng != null) {
                aVar.e(6, this.tng);
            }
            if (this.msN == null) {
                return 0;
            }
            aVar.e(7, this.msN);
            return 0;
        } else if (i == 1) {
            if (this.tvt != null) {
                r0 = a.a.a.b.b.a.f(1, this.tvt) + 0;
            } else {
                r0 = 0;
            }
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(2, this.msj);
            }
            r0 += a.a.a.a.eL(3, this.jNW);
            if (this.tup != null) {
                r0 += a.a.a.b.b.a.f(4, this.tup);
            }
            if (this.tnk != null) {
                r0 += a.a.a.b.b.a.f(5, this.tnk);
            }
            if (this.tng != null) {
                r0 += a.a.a.b.b.a.f(6, this.tng);
            }
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(7, this.msN);
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
            aff com_tencent_mm_protocal_c_aff = (aff) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aff.tvt = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aff.msj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aff.jNW = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aff.tup = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aff.tnk = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aff.tng = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aff.msN = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
