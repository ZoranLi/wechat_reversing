package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class avm extends a {
    public int sFI;
    public int tVQ;
    public int tYW;
    public int tYY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tVQ);
            aVar.eO(2, this.tYY);
            aVar.eO(3, this.tYW);
            aVar.eO(4, this.sFI);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.eL(1, this.tVQ) + 0) + a.a.a.a.eL(2, this.tYY)) + a.a.a.a.eL(3, this.tYW)) + a.a.a.a.eL(4, this.sFI);
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
                avm com_tencent_mm_protocal_c_avm = (avm) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_avm.tVQ = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_avm.tYY = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_avm.tYW = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_avm.sFI = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
