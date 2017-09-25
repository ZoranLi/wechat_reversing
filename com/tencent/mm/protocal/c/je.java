package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class je extends a {
    public String toW;
    public String toX;
    public int toY;
    public int toZ;
    public int tpa;
    public int tpb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.toW != null) {
                aVar.e(1, this.toW);
            }
            if (this.toX != null) {
                aVar.e(2, this.toX);
            }
            aVar.eO(3, this.toY);
            aVar.eO(4, this.toZ);
            aVar.eO(5, this.tpa);
            aVar.eO(6, this.tpb);
            return 0;
        } else if (i == 1) {
            if (this.toW != null) {
                r0 = a.a.a.b.b.a.f(1, this.toW) + 0;
            } else {
                r0 = 0;
            }
            if (this.toX != null) {
                r0 += a.a.a.b.b.a.f(2, this.toX);
            }
            return (((r0 + a.a.a.a.eL(3, this.toY)) + a.a.a.a.eL(4, this.toZ)) + a.a.a.a.eL(5, this.tpa)) + a.a.a.a.eL(6, this.tpb);
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
            je jeVar = (je) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jeVar.toW = aVar3.xmD.readString();
                    return 0;
                case 2:
                    jeVar.toX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    jeVar.toY = aVar3.xmD.mL();
                    return 0;
                case 4:
                    jeVar.toZ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    jeVar.tpa = aVar3.xmD.mL();
                    return 0;
                case 6:
                    jeVar.tpb = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
