package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class blg extends a {
    public int jOc;
    public int ukX;
    public int ukY;
    public int ukZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jOc);
            aVar.eO(2, this.ukX);
            aVar.eO(3, this.ukY);
            aVar.eO(4, this.ukZ);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.eL(1, this.jOc) + 0) + a.a.a.a.eL(2, this.ukX)) + a.a.a.a.eL(3, this.ukY)) + a.a.a.a.eL(4, this.ukZ);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                blg com_tencent_mm_protocal_c_blg = (blg) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_blg.jOc = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_blg.ukX = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_blg.ukY = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_blg.ukZ = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
