package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class gm extends a {
    public String msj;
    public int msp;
    public String mtb;
    public String teg;
    public String teh;
    public String tgT;
    public String tgZ;
    public String thb;
    public long tkA;
    public String tkm;
    public String tkn;
    public String tko;
    public String tkp;
    public String tkq;
    public String tkr;
    public String tks;
    public String tkt;
    public String tku;
    public int tkv;
    public int tkw;
    public String tkx;
    public String tky;
    public String tkz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtb != null) {
                aVar.e(1, this.mtb);
            }
            if (this.msj != null) {
                aVar.e(2, this.msj);
            }
            if (this.tgT != null) {
                aVar.e(3, this.tgT);
            }
            if (this.tkm != null) {
                aVar.e(4, this.tkm);
            }
            if (this.tkn != null) {
                aVar.e(5, this.tkn);
            }
            if (this.tko != null) {
                aVar.e(6, this.tko);
            }
            if (this.tkp != null) {
                aVar.e(7, this.tkp);
            }
            if (this.tkq != null) {
                aVar.e(8, this.tkq);
            }
            if (this.tkr != null) {
                aVar.e(9, this.tkr);
            }
            if (this.tks != null) {
                aVar.e(10, this.tks);
            }
            if (this.tkt != null) {
                aVar.e(11, this.tkt);
            }
            if (this.teg != null) {
                aVar.e(12, this.teg);
            }
            if (this.tku != null) {
                aVar.e(13, this.tku);
            }
            if (this.tgZ != null) {
                aVar.e(14, this.tgZ);
            }
            if (this.thb != null) {
                aVar.e(15, this.thb);
            }
            aVar.eO(16, this.msp);
            aVar.eO(17, this.tkv);
            aVar.eO(18, this.tkw);
            if (this.tkx != null) {
                aVar.e(19, this.tkx);
            }
            if (this.tky != null) {
                aVar.e(20, this.tky);
            }
            if (this.tkz != null) {
                aVar.e(21, this.tkz);
            }
            if (this.teh != null) {
                aVar.e(22, this.teh);
            }
            aVar.O(23, this.tkA);
            return 0;
        } else if (i == 1) {
            if (this.mtb != null) {
                r0 = a.a.a.b.b.a.f(1, this.mtb) + 0;
            } else {
                r0 = 0;
            }
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(2, this.msj);
            }
            if (this.tgT != null) {
                r0 += a.a.a.b.b.a.f(3, this.tgT);
            }
            if (this.tkm != null) {
                r0 += a.a.a.b.b.a.f(4, this.tkm);
            }
            if (this.tkn != null) {
                r0 += a.a.a.b.b.a.f(5, this.tkn);
            }
            if (this.tko != null) {
                r0 += a.a.a.b.b.a.f(6, this.tko);
            }
            if (this.tkp != null) {
                r0 += a.a.a.b.b.a.f(7, this.tkp);
            }
            if (this.tkq != null) {
                r0 += a.a.a.b.b.a.f(8, this.tkq);
            }
            if (this.tkr != null) {
                r0 += a.a.a.b.b.a.f(9, this.tkr);
            }
            if (this.tks != null) {
                r0 += a.a.a.b.b.a.f(10, this.tks);
            }
            if (this.tkt != null) {
                r0 += a.a.a.b.b.a.f(11, this.tkt);
            }
            if (this.teg != null) {
                r0 += a.a.a.b.b.a.f(12, this.teg);
            }
            if (this.tku != null) {
                r0 += a.a.a.b.b.a.f(13, this.tku);
            }
            if (this.tgZ != null) {
                r0 += a.a.a.b.b.a.f(14, this.tgZ);
            }
            if (this.thb != null) {
                r0 += a.a.a.b.b.a.f(15, this.thb);
            }
            r0 = ((r0 + a.a.a.a.eL(16, this.msp)) + a.a.a.a.eL(17, this.tkv)) + a.a.a.a.eL(18, this.tkw);
            if (this.tkx != null) {
                r0 += a.a.a.b.b.a.f(19, this.tkx);
            }
            if (this.tky != null) {
                r0 += a.a.a.b.b.a.f(20, this.tky);
            }
            if (this.tkz != null) {
                r0 += a.a.a.b.b.a.f(21, this.tkz);
            }
            if (this.teh != null) {
                r0 += a.a.a.b.b.a.f(22, this.teh);
            }
            return r0 + a.a.a.a.N(23, this.tkA);
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
            gm gmVar = (gm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gmVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 2:
                    gmVar.msj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    gmVar.tgT = aVar3.xmD.readString();
                    return 0;
                case 4:
                    gmVar.tkm = aVar3.xmD.readString();
                    return 0;
                case 5:
                    gmVar.tkn = aVar3.xmD.readString();
                    return 0;
                case 6:
                    gmVar.tko = aVar3.xmD.readString();
                    return 0;
                case 7:
                    gmVar.tkp = aVar3.xmD.readString();
                    return 0;
                case 8:
                    gmVar.tkq = aVar3.xmD.readString();
                    return 0;
                case 9:
                    gmVar.tkr = aVar3.xmD.readString();
                    return 0;
                case 10:
                    gmVar.tks = aVar3.xmD.readString();
                    return 0;
                case 11:
                    gmVar.tkt = aVar3.xmD.readString();
                    return 0;
                case 12:
                    gmVar.teg = aVar3.xmD.readString();
                    return 0;
                case 13:
                    gmVar.tku = aVar3.xmD.readString();
                    return 0;
                case 14:
                    gmVar.tgZ = aVar3.xmD.readString();
                    return 0;
                case 15:
                    gmVar.thb = aVar3.xmD.readString();
                    return 0;
                case 16:
                    gmVar.msp = aVar3.xmD.mL();
                    return 0;
                case 17:
                    gmVar.tkv = aVar3.xmD.mL();
                    return 0;
                case 18:
                    gmVar.tkw = aVar3.xmD.mL();
                    return 0;
                case 19:
                    gmVar.tkx = aVar3.xmD.readString();
                    return 0;
                case 20:
                    gmVar.tky = aVar3.xmD.readString();
                    return 0;
                case 21:
                    gmVar.tkz = aVar3.xmD.readString();
                    return 0;
                case 22:
                    gmVar.teh = aVar3.xmD.readString();
                    return 0;
                case 23:
                    gmVar.tkA = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
