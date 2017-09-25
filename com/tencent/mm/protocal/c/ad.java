package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ad extends a {
    public String tcD;
    public int tcE;
    public int tcF;
    public int tcG;
    public int tcH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tcD != null) {
                aVar.e(1, this.tcD);
            }
            aVar.eO(2, this.tcE);
            aVar.eO(3, this.tcF);
            aVar.eO(4, this.tcG);
            aVar.eO(5, this.tcH);
            return 0;
        } else if (i == 1) {
            if (this.tcD != null) {
                r0 = a.a.a.b.b.a.f(1, this.tcD) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.eL(2, this.tcE)) + a.a.a.a.eL(3, this.tcF)) + a.a.a.a.eL(4, this.tcG)) + a.a.a.a.eL(5, this.tcH);
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
            ad adVar = (ad) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    adVar.tcD = aVar3.xmD.readString();
                    return 0;
                case 2:
                    adVar.tcE = aVar3.xmD.mL();
                    return 0;
                case 3:
                    adVar.tcF = aVar3.xmD.mL();
                    return 0;
                case 4:
                    adVar.tcG = aVar3.xmD.mL();
                    return 0;
                case 5:
                    adVar.tcH = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
