package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afv extends a {
    public int fDB;
    public int tKS;
    public int tKT;
    public int tKU;
    public int tKV;
    public int tKW;
    public int tKX;
    public int tKY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tKS);
            aVar.eO(2, this.fDB);
            aVar.eO(3, this.tKT);
            aVar.eO(4, this.tKU);
            aVar.eO(5, this.tKV);
            aVar.eO(6, this.tKW);
            aVar.eO(7, this.tKX);
            aVar.eO(8, this.tKY);
            return 0;
        } else if (i == 1) {
            return (((((((a.a.a.a.eL(1, this.tKS) + 0) + a.a.a.a.eL(2, this.fDB)) + a.a.a.a.eL(3, this.tKT)) + a.a.a.a.eL(4, this.tKU)) + a.a.a.a.eL(5, this.tKV)) + a.a.a.a.eL(6, this.tKW)) + a.a.a.a.eL(7, this.tKX)) + a.a.a.a.eL(8, this.tKY);
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
                afv com_tencent_mm_protocal_c_afv = (afv) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_afv.tKS = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_afv.fDB = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_afv.tKT = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_afv.tKU = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_afv.tKV = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_afv.tKW = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_afv.tKX = aVar3.xmD.mL();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_afv.tKY = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
