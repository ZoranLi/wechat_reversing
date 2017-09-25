package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class cw extends a {
    public long tgd;
    public int tge;
    public int tgf;
    public int tgg;
    public int tgh;
    public int tgi;
    public int tgj;
    public String tgk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.tgd);
            aVar.eO(2, this.tge);
            aVar.eO(3, this.tgf);
            aVar.eO(4, this.tgg);
            aVar.eO(5, this.tgh);
            aVar.eO(6, this.tgi);
            aVar.eO(7, this.tgj);
            if (this.tgk != null) {
                aVar.e(8, this.tgk);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((((((a.a.a.a.N(1, this.tgd) + 0) + a.a.a.a.eL(2, this.tge)) + a.a.a.a.eL(3, this.tgf)) + a.a.a.a.eL(4, this.tgg)) + a.a.a.a.eL(5, this.tgh)) + a.a.a.a.eL(6, this.tgi)) + a.a.a.a.eL(7, this.tgj);
            if (this.tgk != null) {
                return r0 + a.a.a.b.b.a.f(8, this.tgk);
            }
            return r0;
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
            cw cwVar = (cw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwVar.tgd = aVar3.xmD.mM();
                    return 0;
                case 2:
                    cwVar.tge = aVar3.xmD.mL();
                    return 0;
                case 3:
                    cwVar.tgf = aVar3.xmD.mL();
                    return 0;
                case 4:
                    cwVar.tgg = aVar3.xmD.mL();
                    return 0;
                case 5:
                    cwVar.tgh = aVar3.xmD.mL();
                    return 0;
                case 6:
                    cwVar.tgi = aVar3.xmD.mL();
                    return 0;
                case 7:
                    cwVar.tgj = aVar3.xmD.mL();
                    return 0;
                case 8:
                    cwVar.tgk = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
