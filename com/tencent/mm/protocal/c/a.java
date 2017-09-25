package com.tencent.mm.protocal.c;

public final class a extends com.tencent.mm.bd.a {
    public String fNG;
    public int fRW;
    public String kAJ;
    public String nnP;
    public String nnQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.fRW);
            if (this.fNG != null) {
                aVar.e(2, this.fNG);
            }
            if (this.nnP != null) {
                aVar.e(3, this.nnP);
            }
            if (this.nnQ != null) {
                aVar.e(4, this.nnQ);
            }
            if (this.kAJ != null) {
                aVar.e(5, this.kAJ);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.fRW) + 0;
            if (this.fNG != null) {
                r0 += a.a.a.b.b.a.f(2, this.fNG);
            }
            if (this.nnP != null) {
                r0 += a.a.a.b.b.a.f(3, this.nnP);
            }
            if (this.nnQ != null) {
                r0 += a.a.a.b.b.a.f(4, this.nnQ);
            }
            if (this.kAJ != null) {
                return r0 + a.a.a.b.b.a.f(5, this.kAJ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.fRW = aVar3.xmD.mL();
                    return 0;
                case 2:
                    aVar4.fNG = aVar3.xmD.readString();
                    return 0;
                case 3:
                    aVar4.nnP = aVar3.xmD.readString();
                    return 0;
                case 4:
                    aVar4.nnQ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    aVar4.kAJ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
