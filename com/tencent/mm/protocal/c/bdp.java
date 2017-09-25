package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bdp extends a {
    public int jOa;
    public int tvD;
    public int ueQ;
    public int ueR;
    public int ueS;
    public int ueT;
    public int ueU;
    public int ueV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jOa);
            aVar.eO(2, this.tvD);
            aVar.eO(3, this.ueQ);
            aVar.eO(4, this.ueR);
            aVar.eO(5, this.ueS);
            aVar.eO(6, this.ueT);
            aVar.eO(7, this.ueU);
            aVar.eO(8, this.ueV);
            return 0;
        } else if (i == 1) {
            return (((((((a.a.a.a.eL(1, this.jOa) + 0) + a.a.a.a.eL(2, this.tvD)) + a.a.a.a.eL(3, this.ueQ)) + a.a.a.a.eL(4, this.ueR)) + a.a.a.a.eL(5, this.ueS)) + a.a.a.a.eL(6, this.ueT)) + a.a.a.a.eL(7, this.ueU)) + a.a.a.a.eL(8, this.ueV);
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
                bdp com_tencent_mm_protocal_c_bdp = (bdp) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bdp.jOa = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bdp.tvD = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bdp.ueQ = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bdp.ueR = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_bdp.ueS = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_bdp.ueT = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_bdp.ueU = aVar3.xmD.mL();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_bdp.ueV = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
