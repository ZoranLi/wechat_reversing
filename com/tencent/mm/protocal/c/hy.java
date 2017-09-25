package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class hy extends a {
    public String fDC;
    public String msN;
    public String tme;
    public String tmf;
    public int tmg;
    public String tmh;
    public int tmi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.msN == null) {
                throw new b("Not all required fields were included: Url");
            } else if (this.tme == null) {
                throw new b("Not all required fields were included: Position");
            } else if (this.tmf == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else {
                if (this.fDC != null) {
                    aVar.e(1, this.fDC);
                }
                if (this.msN != null) {
                    aVar.e(2, this.msN);
                }
                if (this.tme != null) {
                    aVar.e(3, this.tme);
                }
                if (this.tmf != null) {
                    aVar.e(4, this.tmf);
                }
                aVar.eO(5, this.tmg);
                if (this.tmh != null) {
                    aVar.e(6, this.tmh);
                }
                aVar.eO(7, this.tmi);
                return 0;
            }
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(2, this.msN);
            }
            if (this.tme != null) {
                r0 += a.a.a.b.b.a.f(3, this.tme);
            }
            if (this.tmf != null) {
                r0 += a.a.a.b.b.a.f(4, this.tmf);
            }
            r0 += a.a.a.a.eL(5, this.tmg);
            if (this.tmh != null) {
                r0 += a.a.a.b.b.a.f(6, this.tmh);
            }
            return r0 + a.a.a.a.eL(7, this.tmi);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.msN == null) {
                throw new b("Not all required fields were included: Url");
            } else if (this.tme == null) {
                throw new b("Not all required fields were included: Position");
            } else if (this.tmf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DetailInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hy hyVar = (hy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hyVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    hyVar.msN = aVar3.xmD.readString();
                    return 0;
                case 3:
                    hyVar.tme = aVar3.xmD.readString();
                    return 0;
                case 4:
                    hyVar.tmf = aVar3.xmD.readString();
                    return 0;
                case 5:
                    hyVar.tmg = aVar3.xmD.mL();
                    return 0;
                case 6:
                    hyVar.tmh = aVar3.xmD.readString();
                    return 0;
                case 7:
                    hyVar.tmi = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
