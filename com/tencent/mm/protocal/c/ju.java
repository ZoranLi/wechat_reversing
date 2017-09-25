package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ju extends a {
    public String ofg;
    public int tpJ;
    public String tpK;
    public String tpL;
    public String tpM;
    public int tpN;
    public String tpO;
    public int tpP;
    public String tpQ;
    public int tpR;
    public String tpS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tpJ);
            if (this.tpK != null) {
                aVar.e(2, this.tpK);
            }
            if (this.tpL != null) {
                aVar.e(3, this.tpL);
            }
            if (this.tpM != null) {
                aVar.e(4, this.tpM);
            }
            aVar.eO(5, this.tpN);
            if (this.tpO != null) {
                aVar.e(6, this.tpO);
            }
            aVar.eO(7, this.tpP);
            if (this.ofg != null) {
                aVar.e(8, this.ofg);
            }
            if (this.tpQ != null) {
                aVar.e(9, this.tpQ);
            }
            aVar.eO(10, this.tpR);
            if (this.tpS != null) {
                aVar.e(11, this.tpS);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tpJ) + 0;
            if (this.tpK != null) {
                r0 += a.a.a.b.b.a.f(2, this.tpK);
            }
            if (this.tpL != null) {
                r0 += a.a.a.b.b.a.f(3, this.tpL);
            }
            if (this.tpM != null) {
                r0 += a.a.a.b.b.a.f(4, this.tpM);
            }
            r0 += a.a.a.a.eL(5, this.tpN);
            if (this.tpO != null) {
                r0 += a.a.a.b.b.a.f(6, this.tpO);
            }
            r0 += a.a.a.a.eL(7, this.tpP);
            if (this.ofg != null) {
                r0 += a.a.a.b.b.a.f(8, this.ofg);
            }
            if (this.tpQ != null) {
                r0 += a.a.a.b.b.a.f(9, this.tpQ);
            }
            r0 += a.a.a.a.eL(10, this.tpR);
            if (this.tpS != null) {
                return r0 + a.a.a.b.b.a.f(11, this.tpS);
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
            ju juVar = (ju) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    juVar.tpJ = aVar3.xmD.mL();
                    return 0;
                case 2:
                    juVar.tpK = aVar3.xmD.readString();
                    return 0;
                case 3:
                    juVar.tpL = aVar3.xmD.readString();
                    return 0;
                case 4:
                    juVar.tpM = aVar3.xmD.readString();
                    return 0;
                case 5:
                    juVar.tpN = aVar3.xmD.mL();
                    return 0;
                case 6:
                    juVar.tpO = aVar3.xmD.readString();
                    return 0;
                case 7:
                    juVar.tpP = aVar3.xmD.mL();
                    return 0;
                case 8:
                    juVar.ofg = aVar3.xmD.readString();
                    return 0;
                case 9:
                    juVar.tpQ = aVar3.xmD.readString();
                    return 0;
                case 10:
                    juVar.tpR = aVar3.xmD.mL();
                    return 0;
                case 11:
                    juVar.tpS = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
