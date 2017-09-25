package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ap extends a {
    public String hAI;
    public int jNB;
    public String jNj;
    public String jOp;
    public String tdA;
    public int tdB;
    public int tdC;
    public String tdD;
    public int tdE;
    public String tdF;
    public String tdG;
    public int tdH;
    public String tdI;
    public int tdy;
    public String tdz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNj != null) {
                aVar.e(1, this.jNj);
            }
            if (this.jOp != null) {
                aVar.e(2, this.jOp);
            }
            aVar.eO(3, this.tdy);
            if (this.tdz != null) {
                aVar.e(4, this.tdz);
            }
            if (this.tdA != null) {
                aVar.e(5, this.tdA);
            }
            if (this.hAI != null) {
                aVar.e(6, this.hAI);
            }
            aVar.eO(8, this.jNB);
            aVar.eO(9, this.tdB);
            aVar.eO(10, this.tdC);
            if (this.tdD != null) {
                aVar.e(11, this.tdD);
            }
            aVar.eO(12, this.tdE);
            if (this.tdF != null) {
                aVar.e(13, this.tdF);
            }
            if (this.tdG != null) {
                aVar.e(14, this.tdG);
            }
            aVar.eO(15, this.tdH);
            if (this.tdI == null) {
                return 0;
            }
            aVar.e(16, this.tdI);
            return 0;
        } else if (i == 1) {
            if (this.jNj != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNj) + 0;
            } else {
                r0 = 0;
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(2, this.jOp);
            }
            r0 += a.a.a.a.eL(3, this.tdy);
            if (this.tdz != null) {
                r0 += a.a.a.b.b.a.f(4, this.tdz);
            }
            if (this.tdA != null) {
                r0 += a.a.a.b.b.a.f(5, this.tdA);
            }
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(6, this.hAI);
            }
            r0 = ((r0 + a.a.a.a.eL(8, this.jNB)) + a.a.a.a.eL(9, this.tdB)) + a.a.a.a.eL(10, this.tdC);
            if (this.tdD != null) {
                r0 += a.a.a.b.b.a.f(11, this.tdD);
            }
            r0 += a.a.a.a.eL(12, this.tdE);
            if (this.tdF != null) {
                r0 += a.a.a.b.b.a.f(13, this.tdF);
            }
            if (this.tdG != null) {
                r0 += a.a.a.b.b.a.f(14, this.tdG);
            }
            r0 += a.a.a.a.eL(15, this.tdH);
            if (this.tdI != null) {
                r0 += a.a.a.b.b.a.f(16, this.tdI);
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
            ap apVar = (ap) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    apVar.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    apVar.tdy = aVar3.xmD.mL();
                    return 0;
                case 4:
                    apVar.tdz = aVar3.xmD.readString();
                    return 0;
                case 5:
                    apVar.tdA = aVar3.xmD.readString();
                    return 0;
                case 6:
                    apVar.hAI = aVar3.xmD.readString();
                    return 0;
                case 8:
                    apVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 9:
                    apVar.tdB = aVar3.xmD.mL();
                    return 0;
                case 10:
                    apVar.tdC = aVar3.xmD.mL();
                    return 0;
                case 11:
                    apVar.tdD = aVar3.xmD.readString();
                    return 0;
                case 12:
                    apVar.tdE = aVar3.xmD.mL();
                    return 0;
                case 13:
                    apVar.tdF = aVar3.xmD.readString();
                    return 0;
                case 14:
                    apVar.tdG = aVar3.xmD.readString();
                    return 0;
                case 15:
                    apVar.tdH = aVar3.xmD.mL();
                    return 0;
                case 16:
                    apVar.tdI = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
