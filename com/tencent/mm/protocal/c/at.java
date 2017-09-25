package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class at extends a {
    public String gkB;
    public String gkC;
    public double latitude;
    public double longitude;
    public long tdW;
    public String tdX;
    public String tdY;
    public String tdZ;
    public String tea;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkB != null) {
                aVar.e(1, this.gkB);
            }
            if (this.gkC != null) {
                aVar.e(2, this.gkC);
            }
            aVar.a(3, this.latitude);
            aVar.a(4, this.longitude);
            aVar.O(5, this.tdW);
            if (this.tdX != null) {
                aVar.e(6, this.tdX);
            }
            if (this.tdY != null) {
                aVar.e(7, this.tdY);
            }
            if (this.tdZ != null) {
                aVar.e(8, this.tdZ);
            }
            if (this.tea == null) {
                return 0;
            }
            aVar.e(9, this.tea);
            return 0;
        } else if (i == 1) {
            if (this.gkB != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkB) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkC);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cH(3) + 8)) + (a.a.a.b.b.a.cH(4) + 8)) + a.a.a.a.N(5, this.tdW);
            if (this.tdX != null) {
                r0 += a.a.a.b.b.a.f(6, this.tdX);
            }
            if (this.tdY != null) {
                r0 += a.a.a.b.b.a.f(7, this.tdY);
            }
            if (this.tdZ != null) {
                r0 += a.a.a.b.b.a.f(8, this.tdZ);
            }
            if (this.tea != null) {
                r0 += a.a.a.b.b.a.f(9, this.tea);
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
            at atVar = (at) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atVar.gkB = aVar3.xmD.readString();
                    return 0;
                case 2:
                    atVar.gkC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    atVar.latitude = aVar3.xmD.readDouble();
                    return 0;
                case 4:
                    atVar.longitude = aVar3.xmD.readDouble();
                    return 0;
                case 5:
                    atVar.tdW = aVar3.xmD.mM();
                    return 0;
                case 6:
                    atVar.tdX = aVar3.xmD.readString();
                    return 0;
                case 7:
                    atVar.tdY = aVar3.xmD.readString();
                    return 0;
                case 8:
                    atVar.tdZ = aVar3.xmD.readString();
                    return 0;
                case 9:
                    atVar.tea = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
