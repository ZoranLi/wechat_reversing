package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class blk extends a {
    public int ulm;
    public int uln;
    public int ulo;
    public int ulp;
    public int ulq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ulm);
            aVar.eO(2, this.uln);
            aVar.eO(3, this.ulo);
            aVar.eO(4, this.ulp);
            aVar.eO(5, this.ulq);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.eL(1, this.ulm) + 0) + a.a.a.a.eL(2, this.uln)) + a.a.a.a.eL(3, this.ulo)) + a.a.a.a.eL(4, this.ulp)) + a.a.a.a.eL(5, this.ulq);
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
                blk com_tencent_mm_protocal_c_blk = (blk) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_blk.ulm = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_blk.uln = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_blk.ulo = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_blk.ulp = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_blk.ulq = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
