package com.tencent.mm.plugin.product.c;

public final class a extends com.tencent.mm.bd.a {
    public int jOc;
    public String msj;
    public String muU;
    public String opH;
    public String opI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msj != null) {
                aVar.e(1, this.msj);
            }
            if (this.opH != null) {
                aVar.e(2, this.opH);
            }
            aVar.eO(3, this.jOc);
            if (this.opI != null) {
                aVar.e(4, this.opI);
            }
            if (this.muU == null) {
                return 0;
            }
            aVar.e(5, this.muU);
            return 0;
        } else if (i == 1) {
            if (this.msj != null) {
                r0 = a.a.a.b.b.a.f(1, this.msj) + 0;
            } else {
                r0 = 0;
            }
            if (this.opH != null) {
                r0 += a.a.a.b.b.a.f(2, this.opH);
            }
            r0 += a.a.a.a.eL(3, this.jOc);
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(4, this.opI);
            }
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(5, this.muU);
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
                    aVar4.msj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    aVar4.opH = aVar3.xmD.readString();
                    return 0;
                case 3:
                    aVar4.jOc = aVar3.xmD.mL();
                    return 0;
                case 4:
                    aVar4.opI = aVar3.xmD.readString();
                    return 0;
                case 5:
                    aVar4.muU = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
