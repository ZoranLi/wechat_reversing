package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bpp extends a {
    public int tLJ;
    public int tOe;
    public int tOf;
    public String tOg;
    public int tdM;
    public int tkv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tLJ);
            aVar.eO(2, this.tkv);
            aVar.eO(3, this.tdM);
            if (this.tOg != null) {
                aVar.e(4, this.tOg);
            }
            aVar.eO(5, this.tOf);
            aVar.eO(6, this.tOe);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.tLJ) + 0) + a.a.a.a.eL(2, this.tkv)) + a.a.a.a.eL(3, this.tdM);
            if (this.tOg != null) {
                r0 += a.a.a.b.b.a.f(4, this.tOg);
            }
            return (r0 + a.a.a.a.eL(5, this.tOf)) + a.a.a.a.eL(6, this.tOe);
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
            bpp com_tencent_mm_protocal_c_bpp = (bpp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bpp.tLJ = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpp.tkv = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bpp.tdM = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bpp.tOg = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bpp.tOf = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bpp.tOe = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
