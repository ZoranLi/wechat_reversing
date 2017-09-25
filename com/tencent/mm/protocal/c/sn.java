package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class sn extends a {
    public int fIz;
    public String id;
    public int lUf;
    public String tAx;
    public long tAy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            aVar.eO(2, this.lUf);
            if (this.tAx != null) {
                aVar.e(3, this.tAx);
            }
            aVar.O(4, this.tAy);
            aVar.eO(5, this.fIz);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                r0 = a.a.a.b.b.a.f(1, this.id) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.lUf);
            if (this.tAx != null) {
                r0 += a.a.a.b.b.a.f(3, this.tAx);
            }
            return (r0 + a.a.a.a.N(4, this.tAy)) + a.a.a.a.eL(5, this.fIz);
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
            sn snVar = (sn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    snVar.id = aVar3.xmD.readString();
                    return 0;
                case 2:
                    snVar.lUf = aVar3.xmD.mL();
                    return 0;
                case 3:
                    snVar.tAx = aVar3.xmD.readString();
                    return 0;
                case 4:
                    snVar.tAy = aVar3.xmD.mM();
                    return 0;
                case 5:
                    snVar.fIz = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
