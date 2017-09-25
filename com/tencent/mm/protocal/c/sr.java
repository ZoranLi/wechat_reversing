package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class sr extends a {
    public String jNj;
    public String jOp;
    public String msH;
    public String mtf;
    public String tAC;
    public String tAD;
    public int tci;
    public String teQ;
    public String tju;
    public String trh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.teQ != null) {
                aVar.e(1, this.teQ);
            }
            if (this.jOp != null) {
                aVar.e(2, this.jOp);
            }
            if (this.jNj != null) {
                aVar.e(3, this.jNj);
            }
            if (this.mtf != null) {
                aVar.e(4, this.mtf);
            }
            if (this.tAC != null) {
                aVar.e(5, this.tAC);
            }
            if (this.tAD != null) {
                aVar.e(6, this.tAD);
            }
            if (this.tju != null) {
                aVar.e(7, this.tju);
            }
            if (this.trh != null) {
                aVar.e(8, this.trh);
            }
            if (this.msH != null) {
                aVar.e(9, this.msH);
            }
            aVar.eO(10, this.tci);
            return 0;
        } else if (i == 1) {
            if (this.teQ != null) {
                r0 = a.a.a.b.b.a.f(1, this.teQ) + 0;
            } else {
                r0 = 0;
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(2, this.jOp);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(3, this.jNj);
            }
            if (this.mtf != null) {
                r0 += a.a.a.b.b.a.f(4, this.mtf);
            }
            if (this.tAC != null) {
                r0 += a.a.a.b.b.a.f(5, this.tAC);
            }
            if (this.tAD != null) {
                r0 += a.a.a.b.b.a.f(6, this.tAD);
            }
            if (this.tju != null) {
                r0 += a.a.a.b.b.a.f(7, this.tju);
            }
            if (this.trh != null) {
                r0 += a.a.a.b.b.a.f(8, this.trh);
            }
            if (this.msH != null) {
                r0 += a.a.a.b.b.a.f(9, this.msH);
            }
            return r0 + a.a.a.a.eL(10, this.tci);
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
            sr srVar = (sr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    srVar.teQ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    srVar.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    srVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 4:
                    srVar.mtf = aVar3.xmD.readString();
                    return 0;
                case 5:
                    srVar.tAC = aVar3.xmD.readString();
                    return 0;
                case 6:
                    srVar.tAD = aVar3.xmD.readString();
                    return 0;
                case 7:
                    srVar.tju = aVar3.xmD.readString();
                    return 0;
                case 8:
                    srVar.trh = aVar3.xmD.readString();
                    return 0;
                case 9:
                    srVar.msH = aVar3.xmD.readString();
                    return 0;
                case 10:
                    srVar.tci = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
