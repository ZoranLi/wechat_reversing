package com.tencent.mm.plugin.luckymoney.b;

public final class a extends com.tencent.mm.bd.a {
    public int gPD;
    public String nlP;
    public String nlQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.gPD);
            if (this.nlP != null) {
                aVar.e(2, this.nlP);
            }
            if (this.nlQ != null) {
                aVar.e(3, this.nlQ);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.gPD) + 0;
            if (this.nlP != null) {
                r0 += a.a.a.b.b.a.f(2, this.nlP);
            }
            if (this.nlQ != null) {
                return r0 + a.a.a.b.b.a.f(3, this.nlQ);
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
                    aVar4.gPD = aVar3.xmD.mL();
                    return 0;
                case 2:
                    aVar4.nlP = aVar3.xmD.readString();
                    return 0;
                case 3:
                    aVar4.nlQ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
