package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afy extends a {
    public int key;
    public int length;
    public long tLb;
    public int tLc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.key);
            aVar.O(2, this.tLb);
            aVar.eO(3, this.length);
            aVar.eO(4, this.tLc);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.eL(1, this.key) + 0) + a.a.a.a.N(2, this.tLb)) + a.a.a.a.eL(3, this.length)) + a.a.a.a.eL(4, this.tLc);
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
                afy com_tencent_mm_protocal_c_afy = (afy) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_afy.key = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_afy.tLb = aVar3.xmD.mM();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_afy.length = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_afy.tLc = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
