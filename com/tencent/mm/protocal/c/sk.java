package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class sk extends a {
    public int index;
    public int kzY;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.index);
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.eO(3, this.kzY);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.index) + 0;
            if (this.username != null) {
                r0 += a.a.a.b.b.a.f(2, this.username);
            }
            return r0 + a.a.a.a.eL(3, this.kzY);
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
            sk skVar = (sk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    skVar.index = aVar3.xmD.mL();
                    return 0;
                case 2:
                    skVar.username = aVar3.xmD.readString();
                    return 0;
                case 3:
                    skVar.kzY = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
