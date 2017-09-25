package com.tencent.mm.t;

import com.tencent.mm.bd.a;

public final class l extends a {
    public int hkA;
    public String hkB;
    public String hkC;
    public String hkD;
    public String hkE;
    public String hkq;
    public String hkr;
    public String hks;
    public String hkt;
    public String hku;
    public int hkv;
    public int hkw;
    public String hkx;
    public String hky;
    public int hkz;
    public long time;
    public String title;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.hkq != null) {
                aVar.e(3, this.hkq);
            }
            if (this.hkr != null) {
                aVar.e(4, this.hkr);
            }
            aVar.O(5, this.time);
            if (this.hks != null) {
                aVar.e(6, this.hks);
            }
            if (this.hkt != null) {
                aVar.e(7, this.hkt);
            }
            if (this.hku != null) {
                aVar.e(8, this.hku);
            }
            aVar.eO(9, this.type);
            aVar.eO(10, this.hkv);
            aVar.eO(11, this.hkw);
            if (this.hkx != null) {
                aVar.e(12, this.hkx);
            }
            if (this.hky != null) {
                aVar.e(13, this.hky);
            }
            aVar.eO(14, this.hkz);
            aVar.eO(15, this.hkA);
            if (this.hkB != null) {
                aVar.e(16, this.hkB);
            }
            if (this.hkC != null) {
                aVar.e(17, this.hkC);
            }
            if (this.hkD != null) {
                aVar.e(18, this.hkD);
            }
            if (this.hkE == null) {
                return 0;
            }
            aVar.e(19, this.hkE);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(2, this.url);
            }
            if (this.hkq != null) {
                r0 += a.a.a.b.b.a.f(3, this.hkq);
            }
            if (this.hkr != null) {
                r0 += a.a.a.b.b.a.f(4, this.hkr);
            }
            r0 += a.a.a.a.N(5, this.time);
            if (this.hks != null) {
                r0 += a.a.a.b.b.a.f(6, this.hks);
            }
            if (this.hkt != null) {
                r0 += a.a.a.b.b.a.f(7, this.hkt);
            }
            if (this.hku != null) {
                r0 += a.a.a.b.b.a.f(8, this.hku);
            }
            r0 = ((r0 + a.a.a.a.eL(9, this.type)) + a.a.a.a.eL(10, this.hkv)) + a.a.a.a.eL(11, this.hkw);
            if (this.hkx != null) {
                r0 += a.a.a.b.b.a.f(12, this.hkx);
            }
            if (this.hky != null) {
                r0 += a.a.a.b.b.a.f(13, this.hky);
            }
            r0 = (r0 + a.a.a.a.eL(14, this.hkz)) + a.a.a.a.eL(15, this.hkA);
            if (this.hkB != null) {
                r0 += a.a.a.b.b.a.f(16, this.hkB);
            }
            if (this.hkC != null) {
                r0 += a.a.a.b.b.a.f(17, this.hkC);
            }
            if (this.hkD != null) {
                r0 += a.a.a.b.b.a.f(18, this.hkD);
            }
            if (this.hkE != null) {
                r0 += a.a.a.b.b.a.f(19, this.hkE);
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
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    lVar.url = aVar3.xmD.readString();
                    return 0;
                case 3:
                    lVar.hkq = aVar3.xmD.readString();
                    return 0;
                case 4:
                    lVar.hkr = aVar3.xmD.readString();
                    return 0;
                case 5:
                    lVar.time = aVar3.xmD.mM();
                    return 0;
                case 6:
                    lVar.hks = aVar3.xmD.readString();
                    return 0;
                case 7:
                    lVar.hkt = aVar3.xmD.readString();
                    return 0;
                case 8:
                    lVar.hku = aVar3.xmD.readString();
                    return 0;
                case 9:
                    lVar.type = aVar3.xmD.mL();
                    return 0;
                case 10:
                    lVar.hkv = aVar3.xmD.mL();
                    return 0;
                case 11:
                    lVar.hkw = aVar3.xmD.mL();
                    return 0;
                case 12:
                    lVar.hkx = aVar3.xmD.readString();
                    return 0;
                case 13:
                    lVar.hky = aVar3.xmD.readString();
                    return 0;
                case 14:
                    lVar.hkz = aVar3.xmD.mL();
                    return 0;
                case 15:
                    lVar.hkA = aVar3.xmD.mL();
                    return 0;
                case 16:
                    lVar.hkB = aVar3.xmD.readString();
                    return 0;
                case 17:
                    lVar.hkC = aVar3.xmD.readString();
                    return 0;
                case 18:
                    lVar.hkD = aVar3.xmD.readString();
                    return 0;
                case 19:
                    lVar.hkE = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
