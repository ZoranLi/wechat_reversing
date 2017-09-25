package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class k extends a {
    public long fZT;
    public int state;
    public String tbh;
    public String tbi;
    public String tbr;
    public int tbs;
    public String tbt;
    public String tbu;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tbh != null) {
                aVar.e(1, this.tbh);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            aVar.O(3, this.fZT);
            if (this.tbr != null) {
                aVar.e(5, this.tbr);
            }
            aVar.eO(10, this.state);
            aVar.eO(11, this.tbs);
            if (this.tbt != null) {
                aVar.e(12, this.tbt);
            }
            if (this.tbi != null) {
                aVar.e(13, this.tbi);
            }
            if (this.tbu == null) {
                return 0;
            }
            aVar.e(14, this.tbu);
            return 0;
        } else if (i == 1) {
            if (this.tbh != null) {
                r0 = a.a.a.b.b.a.f(1, this.tbh) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(2, this.title);
            }
            r0 += a.a.a.a.N(3, this.fZT);
            if (this.tbr != null) {
                r0 += a.a.a.b.b.a.f(5, this.tbr);
            }
            r0 = (r0 + a.a.a.a.eL(10, this.state)) + a.a.a.a.eL(11, this.tbs);
            if (this.tbt != null) {
                r0 += a.a.a.b.b.a.f(12, this.tbt);
            }
            if (this.tbi != null) {
                r0 += a.a.a.b.b.a.f(13, this.tbi);
            }
            if (this.tbu != null) {
                r0 += a.a.a.b.b.a.f(14, this.tbu);
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
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.tbh = aVar3.xmD.readString();
                    return 0;
                case 2:
                    kVar.title = aVar3.xmD.readString();
                    return 0;
                case 3:
                    kVar.fZT = aVar3.xmD.mM();
                    return 0;
                case 5:
                    kVar.tbr = aVar3.xmD.readString();
                    return 0;
                case 10:
                    kVar.state = aVar3.xmD.mL();
                    return 0;
                case 11:
                    kVar.tbs = aVar3.xmD.mL();
                    return 0;
                case 12:
                    kVar.tbt = aVar3.xmD.readString();
                    return 0;
                case 13:
                    kVar.tbi = aVar3.xmD.readString();
                    return 0;
                case 14:
                    kVar.tbu = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
