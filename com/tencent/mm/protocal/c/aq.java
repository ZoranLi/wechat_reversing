package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aq extends a {
    public String mtb;
    public String tdJ;
    public String tdK;
    public String tdL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtb != null) {
                aVar.e(1, this.mtb);
            }
            if (this.tdJ != null) {
                aVar.e(2, this.tdJ);
            }
            if (this.tdK != null) {
                aVar.e(3, this.tdK);
            }
            if (this.tdL == null) {
                return 0;
            }
            aVar.e(4, this.tdL);
            return 0;
        } else if (i == 1) {
            if (this.mtb != null) {
                r0 = a.a.a.b.b.a.f(1, this.mtb) + 0;
            } else {
                r0 = 0;
            }
            if (this.tdJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tdJ);
            }
            if (this.tdK != null) {
                r0 += a.a.a.b.b.a.f(3, this.tdK);
            }
            if (this.tdL != null) {
                r0 += a.a.a.b.b.a.f(4, this.tdL);
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
            aq aqVar = (aq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 2:
                    aqVar.tdJ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    aqVar.tdK = aVar3.xmD.readString();
                    return 0;
                case 4:
                    aqVar.tdL = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
