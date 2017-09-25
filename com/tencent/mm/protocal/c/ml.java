package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ml extends a {
    public int jNB;
    public int tfc;
    public long tfk;
    public String tsQ;
    public int tsR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tfc);
            if (this.tsQ != null) {
                aVar.e(2, this.tsQ);
            }
            aVar.eO(3, this.jNB);
            aVar.eO(4, this.tsR);
            aVar.O(5, this.tfk);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tfc) + 0;
            if (this.tsQ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tsQ);
            }
            return ((r0 + a.a.a.a.eL(3, this.jNB)) + a.a.a.a.eL(4, this.tsR)) + a.a.a.a.N(5, this.tfk);
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
            ml mlVar = (ml) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mlVar.tfc = aVar3.xmD.mL();
                    return 0;
                case 2:
                    mlVar.tsQ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    mlVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 4:
                    mlVar.tsR = aVar3.xmD.mL();
                    return 0;
                case 5:
                    mlVar.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
