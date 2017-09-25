package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class y extends a {
    public String nnO;
    public String nnP;
    public String nnQ;
    public String nnR;
    public int tca;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tca);
            if (this.nnO != null) {
                aVar.e(2, this.nnO);
            }
            if (this.nnP != null) {
                aVar.e(3, this.nnP);
            }
            if (this.nnQ != null) {
                aVar.e(4, this.nnQ);
            }
            if (this.nnR != null) {
                aVar.e(5, this.nnR);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tca) + 0;
            if (this.nnO != null) {
                r0 += a.a.a.b.b.a.f(2, this.nnO);
            }
            if (this.nnP != null) {
                r0 += a.a.a.b.b.a.f(3, this.nnP);
            }
            if (this.nnQ != null) {
                r0 += a.a.a.b.b.a.f(4, this.nnQ);
            }
            if (this.nnR != null) {
                return r0 + a.a.a.b.b.a.f(5, this.nnR);
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
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.tca = aVar3.xmD.mL();
                    return 0;
                case 2:
                    yVar.nnO = aVar3.xmD.readString();
                    return 0;
                case 3:
                    yVar.nnP = aVar3.xmD.readString();
                    return 0;
                case 4:
                    yVar.nnQ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    yVar.nnR = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
