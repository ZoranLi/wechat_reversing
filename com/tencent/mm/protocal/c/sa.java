package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class sa extends a {
    public int aMU;
    public String sgP;
    public String tzs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.sgP == null) {
                throw new b("Not all required fields were included: tagName");
            } else if (this.tzs == null) {
                throw new b("Not all required fields were included: tagPinYin");
            } else {
                if (this.sgP != null) {
                    aVar.e(1, this.sgP);
                }
                if (this.tzs != null) {
                    aVar.e(2, this.tzs);
                }
                aVar.eO(3, this.aMU);
                return 0;
            }
        } else if (i == 1) {
            if (this.sgP != null) {
                r0 = a.a.a.b.b.a.f(1, this.sgP) + 0;
            } else {
                r0 = 0;
            }
            if (this.tzs != null) {
                r0 += a.a.a.b.b.a.f(2, this.tzs);
            }
            return r0 + a.a.a.a.eL(3, this.aMU);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.sgP == null) {
                throw new b("Not all required fields were included: tagName");
            } else if (this.tzs != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: tagPinYin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            sa saVar = (sa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    saVar.sgP = aVar3.xmD.readString();
                    return 0;
                case 2:
                    saVar.tzs = aVar3.xmD.readString();
                    return 0;
                case 3:
                    saVar.aMU = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
