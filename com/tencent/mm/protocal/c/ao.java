package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ao extends a {
    public String keH;
    public String keI;
    public String keJ;
    public String keK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.keH != null) {
                aVar.e(1, this.keH);
            }
            if (this.keI != null) {
                aVar.e(2, this.keI);
            }
            if (this.keJ != null) {
                aVar.e(3, this.keJ);
            }
            if (this.keK == null) {
                return 0;
            }
            aVar.e(4, this.keK);
            return 0;
        } else if (i == 1) {
            if (this.keH != null) {
                r0 = a.a.a.b.b.a.f(1, this.keH) + 0;
            } else {
                r0 = 0;
            }
            if (this.keI != null) {
                r0 += a.a.a.b.b.a.f(2, this.keI);
            }
            if (this.keJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.keJ);
            }
            if (this.keK != null) {
                r0 += a.a.a.b.b.a.f(4, this.keK);
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
            ao aoVar = (ao) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aoVar.keH = aVar3.xmD.readString();
                    return 0;
                case 2:
                    aoVar.keI = aVar3.xmD.readString();
                    return 0;
                case 3:
                    aoVar.keJ = aVar3.xmD.readString();
                    return 0;
                case 4:
                    aoVar.keK = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
