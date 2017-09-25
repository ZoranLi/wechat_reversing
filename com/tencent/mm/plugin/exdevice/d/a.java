package com.tencent.mm.plugin.exdevice.d;

public final class a extends com.tencent.mm.bd.a {
    public int leD;
    public String leE;
    public String leF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.leD);
            if (this.leE != null) {
                aVar.e(2, this.leE);
            }
            if (this.leF != null) {
                aVar.e(3, this.leF);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.leD) + 0;
            if (this.leE != null) {
                r0 += a.a.a.b.b.a.f(2, this.leE);
            }
            if (this.leF != null) {
                return r0 + a.a.a.b.b.a.f(3, this.leF);
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
                    aVar4.leD = aVar3.xmD.mL();
                    return 0;
                case 2:
                    aVar4.leE = aVar3.xmD.readString();
                    return 0;
                case 3:
                    aVar4.leF = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
