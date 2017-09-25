package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class cr extends a {
    public String jNP;
    public String mQY;
    public String muS;
    public String tfL;
    public String tfM;
    public int tfN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mQY != null) {
                aVar.e(1, this.mQY);
            }
            if (this.jNP != null) {
                aVar.e(2, this.jNP);
            }
            if (this.muS != null) {
                aVar.e(3, this.muS);
            }
            if (this.tfL != null) {
                aVar.e(4, this.tfL);
            }
            if (this.tfM != null) {
                aVar.e(5, this.tfM);
            }
            aVar.eO(6, this.tfN);
            return 0;
        } else if (i == 1) {
            if (this.mQY != null) {
                r0 = a.a.a.b.b.a.f(1, this.mQY) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNP != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNP);
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(3, this.muS);
            }
            if (this.tfL != null) {
                r0 += a.a.a.b.b.a.f(4, this.tfL);
            }
            if (this.tfM != null) {
                r0 += a.a.a.b.b.a.f(5, this.tfM);
            }
            return r0 + a.a.a.a.eL(6, this.tfN);
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
            cr crVar = (cr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crVar.mQY = aVar3.xmD.readString();
                    return 0;
                case 2:
                    crVar.jNP = aVar3.xmD.readString();
                    return 0;
                case 3:
                    crVar.muS = aVar3.xmD.readString();
                    return 0;
                case 4:
                    crVar.tfL = aVar3.xmD.readString();
                    return 0;
                case 5:
                    crVar.tfM = aVar3.xmD.readString();
                    return 0;
                case 6:
                    crVar.tfN = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
