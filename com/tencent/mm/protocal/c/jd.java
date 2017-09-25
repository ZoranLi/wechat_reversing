package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class jd extends a {
    public int jNB;
    public int teU;
    public String toT;
    public long toU;
    public int toV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.toT != null) {
                aVar.e(1, this.toT);
            }
            aVar.O(2, this.toU);
            aVar.eO(3, this.toV);
            aVar.eO(4, this.teU);
            aVar.eO(5, this.jNB);
            return 0;
        } else if (i == 1) {
            if (this.toT != null) {
                r0 = a.a.a.b.b.a.f(1, this.toT) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.N(2, this.toU)) + a.a.a.a.eL(3, this.toV)) + a.a.a.a.eL(4, this.teU)) + a.a.a.a.eL(5, this.jNB);
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
            jd jdVar = (jd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jdVar.toT = aVar3.xmD.readString();
                    return 0;
                case 2:
                    jdVar.toU = aVar3.xmD.mM();
                    return 0;
                case 3:
                    jdVar.toV = aVar3.xmD.mL();
                    return 0;
                case 4:
                    jdVar.teU = aVar3.xmD.mL();
                    return 0;
                case 5:
                    jdVar.jNB = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
