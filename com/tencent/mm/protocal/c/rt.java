package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class rt extends a {
    public int jNB;
    public int teS;
    public int teT;
    public int teU;
    public int teV;
    public String teZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.teS);
            aVar.eO(2, this.jNB);
            if (this.teZ != null) {
                aVar.e(3, this.teZ);
            }
            aVar.eO(4, this.teT);
            aVar.eO(5, this.teU);
            aVar.eO(6, this.teV);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.teS) + 0) + a.a.a.a.eL(2, this.jNB);
            if (this.teZ != null) {
                r0 += a.a.a.b.b.a.f(3, this.teZ);
            }
            return ((r0 + a.a.a.a.eL(4, this.teT)) + a.a.a.a.eL(5, this.teU)) + a.a.a.a.eL(6, this.teV);
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
            rt rtVar = (rt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rtVar.teS = aVar3.xmD.mL();
                    return 0;
                case 2:
                    rtVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 3:
                    rtVar.teZ = aVar3.xmD.readString();
                    return 0;
                case 4:
                    rtVar.teT = aVar3.xmD.mL();
                    return 0;
                case 5:
                    rtVar.teU = aVar3.xmD.mL();
                    return 0;
                case 6:
                    rtVar.teV = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
