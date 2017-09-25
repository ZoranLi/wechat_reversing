package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class akb extends a {
    public String tNV;
    public String tNW;
    public String tNX;
    public int tpP;
    public String type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tNV != null) {
                aVar.e(1, this.tNV);
            }
            if (this.tNW != null) {
                aVar.e(2, this.tNW);
            }
            if (this.type != null) {
                aVar.e(3, this.type);
            }
            aVar.eO(4, this.tpP);
            if (this.tNX == null) {
                return 0;
            }
            aVar.e(5, this.tNX);
            return 0;
        } else if (i == 1) {
            if (this.tNV != null) {
                r0 = a.a.a.b.b.a.f(1, this.tNV) + 0;
            } else {
                r0 = 0;
            }
            if (this.tNW != null) {
                r0 += a.a.a.b.b.a.f(2, this.tNW);
            }
            if (this.type != null) {
                r0 += a.a.a.b.b.a.f(3, this.type);
            }
            r0 += a.a.a.a.eL(4, this.tpP);
            if (this.tNX != null) {
                r0 += a.a.a.b.b.a.f(5, this.tNX);
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
            akb com_tencent_mm_protocal_c_akb = (akb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akb.tNV = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akb.tNW = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akb.type = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akb.tpP = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akb.tNX = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
