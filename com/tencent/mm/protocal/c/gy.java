package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class gy extends a {
    public String tkL;
    public int tkV;
    public int tkW;
    public int tkX;
    public int tkY;
    public long tkZ;
    public long tla;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tkL == null) {
                throw new b("Not all required fields were included: brand_user_name");
            }
            if (this.tkL != null) {
                aVar.e(1, this.tkL);
            }
            aVar.eO(2, this.tkV);
            aVar.eO(3, this.tkW);
            aVar.eO(4, this.tkX);
            aVar.eO(5, this.tkY);
            aVar.O(6, this.tkZ);
            aVar.O(7, this.tla);
            return 0;
        } else if (i == 1) {
            if (this.tkL != null) {
                r0 = a.a.a.b.b.a.f(1, this.tkL) + 0;
            } else {
                r0 = 0;
            }
            return (((((r0 + a.a.a.a.eL(2, this.tkV)) + a.a.a.a.eL(3, this.tkW)) + a.a.a.a.eL(4, this.tkX)) + a.a.a.a.eL(5, this.tkY)) + a.a.a.a.N(6, this.tkZ)) + a.a.a.a.N(7, this.tla);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tkL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: brand_user_name");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            gy gyVar = (gy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gyVar.tkL = aVar3.xmD.readString();
                    return 0;
                case 2:
                    gyVar.tkV = aVar3.xmD.mL();
                    return 0;
                case 3:
                    gyVar.tkW = aVar3.xmD.mL();
                    return 0;
                case 4:
                    gyVar.tkX = aVar3.xmD.mL();
                    return 0;
                case 5:
                    gyVar.tkY = aVar3.xmD.mL();
                    return 0;
                case 6:
                    gyVar.tkZ = aVar3.xmD.mM();
                    return 0;
                case 7:
                    gyVar.tla = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
