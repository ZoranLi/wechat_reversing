package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ck extends a {
    public String tfC;
    public String tfD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfC != null) {
                aVar.e(1, this.tfC);
            }
            if (this.tfD == null) {
                return 0;
            }
            aVar.e(2, this.tfD);
            return 0;
        } else if (i == 1) {
            if (this.tfC != null) {
                r0 = a.a.a.b.b.a.f(1, this.tfC) + 0;
            } else {
                r0 = 0;
            }
            if (this.tfD != null) {
                r0 += a.a.a.b.b.a.f(2, this.tfD);
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
            ck ckVar = (ck) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckVar.tfC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    ckVar.tfD = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
