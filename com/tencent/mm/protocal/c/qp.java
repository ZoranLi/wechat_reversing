package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class qp extends a {
    public int tvY;
    public String tvZ;
    public String twa;
    public String twm;
    public String twn;
    public int two;
    public int twp;
    public String twq;
    public String twr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tvY);
            if (this.tvZ != null) {
                aVar.e(2, this.tvZ);
            }
            if (this.twm != null) {
                aVar.e(3, this.twm);
            }
            if (this.twn != null) {
                aVar.e(4, this.twn);
            }
            aVar.eO(5, this.two);
            aVar.eO(6, this.twp);
            if (this.twq != null) {
                aVar.e(7, this.twq);
            }
            if (this.twa != null) {
                aVar.e(8, this.twa);
            }
            if (this.twr != null) {
                aVar.e(9, this.twr);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tvY) + 0;
            if (this.tvZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tvZ);
            }
            if (this.twm != null) {
                r0 += a.a.a.b.b.a.f(3, this.twm);
            }
            if (this.twn != null) {
                r0 += a.a.a.b.b.a.f(4, this.twn);
            }
            r0 = (r0 + a.a.a.a.eL(5, this.two)) + a.a.a.a.eL(6, this.twp);
            if (this.twq != null) {
                r0 += a.a.a.b.b.a.f(7, this.twq);
            }
            if (this.twa != null) {
                r0 += a.a.a.b.b.a.f(8, this.twa);
            }
            if (this.twr != null) {
                return r0 + a.a.a.b.b.a.f(9, this.twr);
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
            qp qpVar = (qp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qpVar.tvY = aVar3.xmD.mL();
                    return 0;
                case 2:
                    qpVar.tvZ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    qpVar.twm = aVar3.xmD.readString();
                    return 0;
                case 4:
                    qpVar.twn = aVar3.xmD.readString();
                    return 0;
                case 5:
                    qpVar.two = aVar3.xmD.mL();
                    return 0;
                case 6:
                    qpVar.twp = aVar3.xmD.mL();
                    return 0;
                case 7:
                    qpVar.twq = aVar3.xmD.readString();
                    return 0;
                case 8:
                    qpVar.twa = aVar3.xmD.readString();
                    return 0;
                case 9:
                    qpVar.twr = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
