package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class pn extends a {
    public String muU;
    public String tgW;
    public String tuV;
    public String tuW;
    public String tuX;
    public String tuY;
    public int tuZ;
    public int tvD;
    public String tvE;
    public String tvF;
    public String tvG;
    public int tva;
    public String tvd;
    public int tve;
    public String tvf;
    public String tvg;
    public String tvh;
    public String tvi;
    public String tvm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgW != null) {
                aVar.e(1, this.tgW);
            }
            if (this.muU != null) {
                aVar.e(2, this.muU);
            }
            if (this.tuV != null) {
                aVar.e(3, this.tuV);
            }
            if (this.tuW != null) {
                aVar.e(4, this.tuW);
            }
            if (this.tuX != null) {
                aVar.e(5, this.tuX);
            }
            if (this.tuY != null) {
                aVar.e(6, this.tuY);
            }
            aVar.eO(7, this.tuZ);
            aVar.eO(8, this.tva);
            if (this.tvd != null) {
                aVar.e(9, this.tvd);
            }
            aVar.eO(10, this.tve);
            if (this.tvf != null) {
                aVar.e(11, this.tvf);
            }
            aVar.eO(12, this.tvD);
            if (this.tvi != null) {
                aVar.e(13, this.tvi);
            }
            if (this.tvg != null) {
                aVar.e(14, this.tvg);
            }
            if (this.tvh != null) {
                aVar.e(15, this.tvh);
            }
            if (this.tvE != null) {
                aVar.e(16, this.tvE);
            }
            if (this.tvm != null) {
                aVar.e(17, this.tvm);
            }
            if (this.tvF != null) {
                aVar.e(18, this.tvF);
            }
            if (this.tvG == null) {
                return 0;
            }
            aVar.e(19, this.tvG);
            return 0;
        } else if (i == 1) {
            if (this.tgW != null) {
                r0 = a.a.a.b.b.a.f(1, this.tgW) + 0;
            } else {
                r0 = 0;
            }
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(2, this.muU);
            }
            if (this.tuV != null) {
                r0 += a.a.a.b.b.a.f(3, this.tuV);
            }
            if (this.tuW != null) {
                r0 += a.a.a.b.b.a.f(4, this.tuW);
            }
            if (this.tuX != null) {
                r0 += a.a.a.b.b.a.f(5, this.tuX);
            }
            if (this.tuY != null) {
                r0 += a.a.a.b.b.a.f(6, this.tuY);
            }
            r0 = (r0 + a.a.a.a.eL(7, this.tuZ)) + a.a.a.a.eL(8, this.tva);
            if (this.tvd != null) {
                r0 += a.a.a.b.b.a.f(9, this.tvd);
            }
            r0 += a.a.a.a.eL(10, this.tve);
            if (this.tvf != null) {
                r0 += a.a.a.b.b.a.f(11, this.tvf);
            }
            r0 += a.a.a.a.eL(12, this.tvD);
            if (this.tvi != null) {
                r0 += a.a.a.b.b.a.f(13, this.tvi);
            }
            if (this.tvg != null) {
                r0 += a.a.a.b.b.a.f(14, this.tvg);
            }
            if (this.tvh != null) {
                r0 += a.a.a.b.b.a.f(15, this.tvh);
            }
            if (this.tvE != null) {
                r0 += a.a.a.b.b.a.f(16, this.tvE);
            }
            if (this.tvm != null) {
                r0 += a.a.a.b.b.a.f(17, this.tvm);
            }
            if (this.tvF != null) {
                r0 += a.a.a.b.b.a.f(18, this.tvF);
            }
            if (this.tvG != null) {
                r0 += a.a.a.b.b.a.f(19, this.tvG);
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
            pn pnVar = (pn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pnVar.tgW = aVar3.xmD.readString();
                    return 0;
                case 2:
                    pnVar.muU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    pnVar.tuV = aVar3.xmD.readString();
                    return 0;
                case 4:
                    pnVar.tuW = aVar3.xmD.readString();
                    return 0;
                case 5:
                    pnVar.tuX = aVar3.xmD.readString();
                    return 0;
                case 6:
                    pnVar.tuY = aVar3.xmD.readString();
                    return 0;
                case 7:
                    pnVar.tuZ = aVar3.xmD.mL();
                    return 0;
                case 8:
                    pnVar.tva = aVar3.xmD.mL();
                    return 0;
                case 9:
                    pnVar.tvd = aVar3.xmD.readString();
                    return 0;
                case 10:
                    pnVar.tve = aVar3.xmD.mL();
                    return 0;
                case 11:
                    pnVar.tvf = aVar3.xmD.readString();
                    return 0;
                case 12:
                    pnVar.tvD = aVar3.xmD.mL();
                    return 0;
                case 13:
                    pnVar.tvi = aVar3.xmD.readString();
                    return 0;
                case 14:
                    pnVar.tvg = aVar3.xmD.readString();
                    return 0;
                case 15:
                    pnVar.tvh = aVar3.xmD.readString();
                    return 0;
                case 16:
                    pnVar.tvE = aVar3.xmD.readString();
                    return 0;
                case 17:
                    pnVar.tvm = aVar3.xmD.readString();
                    return 0;
                case 18:
                    pnVar.tvF = aVar3.xmD.readString();
                    return 0;
                case 19:
                    pnVar.tvG = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
