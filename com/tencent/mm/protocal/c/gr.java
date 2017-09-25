package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class gr extends a {
    public String tkF;
    public String tkL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tkL != null) {
                aVar.e(2, this.tkL);
            }
            if (this.tkF == null) {
                return 0;
            }
            aVar.e(3, this.tkF);
            return 0;
        } else if (i == 1) {
            if (this.tkL != null) {
                r0 = a.a.a.b.b.a.f(2, this.tkL) + 0;
            } else {
                r0 = 0;
            }
            if (this.tkF != null) {
                r0 += a.a.a.b.b.a.f(3, this.tkF);
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
            gr grVar = (gr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    grVar.tkL = aVar3.xmD.readString();
                    return 0;
                case 3:
                    grVar.tkF = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
