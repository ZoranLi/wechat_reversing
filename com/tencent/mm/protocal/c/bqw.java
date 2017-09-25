package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bqw extends a {
    public int tLJ;
    public int tdM;
    public int tkv;
    public int uoR;
    public int uoS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tLJ);
            aVar.eO(2, this.tkv);
            aVar.eO(3, this.uoR);
            aVar.eO(4, this.tdM);
            aVar.eO(10, this.uoS);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.eL(1, this.tLJ) + 0) + a.a.a.a.eL(2, this.tkv)) + a.a.a.a.eL(3, this.uoR)) + a.a.a.a.eL(4, this.tdM)) + a.a.a.a.eL(10, this.uoS);
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
                bqw com_tencent_mm_protocal_c_bqw = (bqw) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bqw.tLJ = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bqw.tkv = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bqw.uoR = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bqw.tdM = aVar3.xmD.mL();
                        return 0;
                    case 10:
                        com_tencent_mm_protocal_c_bqw.uoS = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
