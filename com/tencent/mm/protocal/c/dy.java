package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class dy extends a {
    public String hAG;
    public String jNj;
    public String jOp;
    public int lXF;
    public String teQ;
    public int thK;
    public String thL;
    public String thM;

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
            aVar.eO(4, this.thK);
            if (this.thL != null) {
                aVar.e(5, this.thL);
            }
            if (this.hAG != null) {
                aVar.e(6, this.hAG);
            }
            if (this.thM != null) {
                aVar.e(7, this.thM);
            }
            aVar.eO(8, this.lXF);
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
            r0 += a.a.a.a.eL(4, this.thK);
            if (this.thL != null) {
                r0 += a.a.a.b.b.a.f(5, this.thL);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(6, this.hAG);
            }
            if (this.thM != null) {
                r0 += a.a.a.b.b.a.f(7, this.thM);
            }
            return r0 + a.a.a.a.eL(8, this.lXF);
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
            dy dyVar = (dy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dyVar.teQ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    dyVar.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    dyVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 4:
                    dyVar.thK = aVar3.xmD.mL();
                    return 0;
                case 5:
                    dyVar.thL = aVar3.xmD.readString();
                    return 0;
                case 6:
                    dyVar.hAG = aVar3.xmD.readString();
                    return 0;
                case 7:
                    dyVar.thM = aVar3.xmD.readString();
                    return 0;
                case 8:
                    dyVar.lXF = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
