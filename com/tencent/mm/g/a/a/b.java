package com.tencent.mm.g.a.a;

import com.tencent.mm.bd.a;

public final class b extends a {
    public String gMX;
    public int gMY;
    public String gMZ;
    public String userName;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.userName != null) {
                aVar.e(1, this.userName);
            }
            if (this.gMX != null) {
                aVar.e(2, this.gMX);
            }
            aVar.eO(3, this.gMY);
            if (this.gMZ == null) {
                return 0;
            }
            aVar.e(4, this.gMZ);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                r0 = a.a.a.b.b.a.f(1, this.userName) + 0;
            } else {
                r0 = 0;
            }
            if (this.gMX != null) {
                r0 += a.a.a.b.b.a.f(2, this.gMX);
            }
            r0 += a.a.a.a.eL(3, this.gMY);
            if (this.gMZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.gMZ);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.userName = aVar3.xmD.readString();
                    return 0;
                case 2:
                    bVar.gMX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bVar.gMY = aVar3.xmD.mL();
                    return 0;
                case 4:
                    bVar.gMZ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
