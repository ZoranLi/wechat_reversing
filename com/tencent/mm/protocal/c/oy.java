package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class oy extends a {
    public long tfk;
    public int tgJ;
    public int tgK;
    public int thX;
    public int tuE;
    public String tuy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.thX);
            aVar.eO(2, this.tgK);
            aVar.eO(3, this.tgJ);
            if (this.tuy != null) {
                aVar.e(4, this.tuy);
            }
            aVar.eO(5, this.tuE);
            aVar.O(6, this.tfk);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.thX) + 0) + a.a.a.a.eL(2, this.tgK)) + a.a.a.a.eL(3, this.tgJ);
            if (this.tuy != null) {
                r0 += a.a.a.b.b.a.f(4, this.tuy);
            }
            return (r0 + a.a.a.a.eL(5, this.tuE)) + a.a.a.a.N(6, this.tfk);
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
            oy oyVar = (oy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oyVar.thX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    oyVar.tgK = aVar3.xmD.mL();
                    return 0;
                case 3:
                    oyVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    oyVar.tuy = aVar3.xmD.readString();
                    return 0;
                case 5:
                    oyVar.tuE = aVar3.xmD.mL();
                    return 0;
                case 6:
                    oyVar.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
