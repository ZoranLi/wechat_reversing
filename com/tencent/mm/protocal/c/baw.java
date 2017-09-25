package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class baw extends a {
    public String jNj;
    public int tMZ;
    public String ubT;
    public int ubU;
    public String ubV;
    public int ubW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ubT != null) {
                aVar.e(1, this.ubT);
            }
            aVar.eO(2, this.ubU);
            if (this.jNj != null) {
                aVar.e(3, this.jNj);
            }
            if (this.ubV != null) {
                aVar.e(4, this.ubV);
            }
            aVar.eO(5, this.tMZ);
            aVar.eO(6, this.ubW);
            return 0;
        } else if (i == 1) {
            if (this.ubT != null) {
                r0 = a.a.a.b.b.a.f(1, this.ubT) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.ubU);
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(3, this.jNj);
            }
            if (this.ubV != null) {
                r0 += a.a.a.b.b.a.f(4, this.ubV);
            }
            return (r0 + a.a.a.a.eL(5, this.tMZ)) + a.a.a.a.eL(6, this.ubW);
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
            baw com_tencent_mm_protocal_c_baw = (baw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_baw.ubT = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_baw.ubU = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_baw.jNj = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_baw.ubV = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_baw.tMZ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_baw.ubW = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
