package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class te extends a {
    public int bHh;
    public String fDC;
    public String msk;
    public String mtb;
    public String muS;
    public String ohq;
    public String tAM;
    public int tBh;
    public int tBi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.msk == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.ohq == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else {
                if (this.fDC != null) {
                    aVar.e(1, this.fDC);
                }
                if (this.msk != null) {
                    aVar.e(2, this.msk);
                }
                if (this.ohq != null) {
                    aVar.e(3, this.ohq);
                }
                if (this.tAM != null) {
                    aVar.e(4, this.tAM);
                }
                aVar.eO(5, this.tBh);
                aVar.eO(6, this.tBi);
                if (this.mtb != null) {
                    aVar.e(7, this.mtb);
                }
                aVar.eO(8, this.bHh);
                if (this.muS == null) {
                    return 0;
                }
                aVar.e(9, this.muS);
                return 0;
            }
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(2, this.msk);
            }
            if (this.ohq != null) {
                r0 += a.a.a.b.b.a.f(3, this.ohq);
            }
            if (this.tAM != null) {
                r0 += a.a.a.b.b.a.f(4, this.tAM);
            }
            r0 = (r0 + a.a.a.a.eL(5, this.tBh)) + a.a.a.a.eL(6, this.tBi);
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(7, this.mtb);
            }
            r0 += a.a.a.a.eL(8, this.bHh);
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(9, this.muS);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.msk == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.ohq != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            te teVar = (te) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    teVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    teVar.msk = aVar3.xmD.readString();
                    return 0;
                case 3:
                    teVar.ohq = aVar3.xmD.readString();
                    return 0;
                case 4:
                    teVar.tAM = aVar3.xmD.readString();
                    return 0;
                case 5:
                    teVar.tBh = aVar3.xmD.mL();
                    return 0;
                case 6:
                    teVar.tBi = aVar3.xmD.mL();
                    return 0;
                case 7:
                    teVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 8:
                    teVar.bHh = aVar3.xmD.mL();
                    return 0;
                case 9:
                    teVar.muS = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
