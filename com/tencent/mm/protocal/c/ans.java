package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ans extends a {
    public int tMh;
    public int tSM;
    public int tSN;
    public int tSO;
    public int tSP;
    public int tSQ;
    public int tSR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tMh);
            aVar.eO(2, this.tSM);
            aVar.eO(3, this.tSN);
            aVar.eO(4, this.tSO);
            aVar.eO(5, this.tSP);
            aVar.eO(6, this.tSQ);
            aVar.eO(7, this.tSR);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.eL(1, this.tMh) + 0) + a.a.a.a.eL(2, this.tSM)) + a.a.a.a.eL(3, this.tSN)) + a.a.a.a.eL(4, this.tSO)) + a.a.a.a.eL(5, this.tSP)) + a.a.a.a.eL(6, this.tSQ)) + a.a.a.a.eL(7, this.tSR);
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
                ans com_tencent_mm_protocal_c_ans = (ans) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_ans.tMh = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_ans.tSM = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_ans.tSN = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_ans.tSO = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_ans.tSP = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_ans.tSQ = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_ans.tSR = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
