package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bd.a;

public final class c extends a {
    public int kAM;
    public int nlT;
    public double nlU;
    public String nlV;
    public String nlW;
    public double nlX;
    public double nlY;
    public double nlZ;
    public int nma;
    public String nmb;
    public String nmc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.nlT);
            aVar.a(2, this.nlU);
            if (this.nlV != null) {
                aVar.e(3, this.nlV);
            }
            if (this.nlW != null) {
                aVar.e(4, this.nlW);
            }
            aVar.a(5, this.nlX);
            aVar.a(6, this.nlY);
            aVar.a(7, this.nlZ);
            aVar.eO(8, this.nma);
            aVar.eO(9, this.kAM);
            if (this.nmb != null) {
                aVar.e(10, this.nmb);
            }
            if (this.nmc != null) {
                aVar.e(11, this.nmc);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.nlT) + 0) + (a.a.a.b.b.a.cH(2) + 8);
            if (this.nlV != null) {
                r0 += a.a.a.b.b.a.f(3, this.nlV);
            }
            if (this.nlW != null) {
                r0 += a.a.a.b.b.a.f(4, this.nlW);
            }
            r0 = ((((r0 + (a.a.a.b.b.a.cH(5) + 8)) + (a.a.a.b.b.a.cH(6) + 8)) + (a.a.a.b.b.a.cH(7) + 8)) + a.a.a.a.eL(8, this.nma)) + a.a.a.a.eL(9, this.kAM);
            if (this.nmb != null) {
                r0 += a.a.a.b.b.a.f(10, this.nmb);
            }
            if (this.nmc != null) {
                return r0 + a.a.a.b.b.a.f(11, this.nmc);
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
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.nlT = aVar3.xmD.mL();
                    return 0;
                case 2:
                    cVar.nlU = aVar3.xmD.readDouble();
                    return 0;
                case 3:
                    cVar.nlV = aVar3.xmD.readString();
                    return 0;
                case 4:
                    cVar.nlW = aVar3.xmD.readString();
                    return 0;
                case 5:
                    cVar.nlX = aVar3.xmD.readDouble();
                    return 0;
                case 6:
                    cVar.nlY = aVar3.xmD.readDouble();
                    return 0;
                case 7:
                    cVar.nlZ = aVar3.xmD.readDouble();
                    return 0;
                case 8:
                    cVar.nma = aVar3.xmD.mL();
                    return 0;
                case 9:
                    cVar.kAM = aVar3.xmD.mL();
                    return 0;
                case 10:
                    cVar.nmb = aVar3.xmD.readString();
                    return 0;
                case 11:
                    cVar.nmc = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
