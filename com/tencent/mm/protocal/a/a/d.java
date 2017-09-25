package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class d extends a {
    public int count;
    public int poY;
    public int tan;
    public b taw;
    public int tax;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.taw == null) {
                throw new a.a.a.b("Not all required fields were included: value");
            }
            aVar.eO(1, this.tan);
            if (this.taw != null) {
                aVar.b(2, this.taw);
            }
            aVar.eO(3, this.tax);
            aVar.eO(4, this.poY);
            aVar.eO(5, this.count);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tan) + 0;
            if (this.taw != null) {
                r0 += a.a.a.a.a(2, this.taw);
            }
            return ((r0 + a.a.a.a.eL(3, this.tax)) + a.a.a.a.eL(4, this.poY)) + a.a.a.a.eL(5, this.count);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.taw != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: value");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.tan = aVar3.xmD.mL();
                    return 0;
                case 2:
                    dVar.taw = aVar3.cic();
                    return 0;
                case 3:
                    dVar.tax = aVar3.xmD.mL();
                    return 0;
                case 4:
                    dVar.poY = aVar3.xmD.mL();
                    return 0;
                case 5:
                    dVar.count = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
