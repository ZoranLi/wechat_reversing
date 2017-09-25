package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class hz extends a {
    public String ohr;
    public String tmj;
    public String tmk;
    public String tml;
    public int tmm;
    public String tmn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tmj == null) {
                throw new b("Not all required fields were included: ProductId");
            } else if (this.ohr == null) {
                throw new b("Not all required fields were included: ProductName");
            } else if (this.tmk == null) {
                throw new b("Not all required fields were included: SellerName");
            } else if (this.tml == null) {
                throw new b("Not all required fields were included: SellerUserName");
            } else {
                if (this.tmj != null) {
                    aVar.e(1, this.tmj);
                }
                if (this.ohr != null) {
                    aVar.e(2, this.ohr);
                }
                if (this.tmk != null) {
                    aVar.e(3, this.tmk);
                }
                if (this.tml != null) {
                    aVar.e(4, this.tml);
                }
                aVar.eO(5, this.tmm);
                if (this.tmn == null) {
                    return 0;
                }
                aVar.e(6, this.tmn);
                return 0;
            }
        } else if (i == 1) {
            if (this.tmj != null) {
                r0 = a.a.a.b.b.a.f(1, this.tmj) + 0;
            } else {
                r0 = 0;
            }
            if (this.ohr != null) {
                r0 += a.a.a.b.b.a.f(2, this.ohr);
            }
            if (this.tmk != null) {
                r0 += a.a.a.b.b.a.f(3, this.tmk);
            }
            if (this.tml != null) {
                r0 += a.a.a.b.b.a.f(4, this.tml);
            }
            r0 += a.a.a.a.eL(5, this.tmm);
            if (this.tmn != null) {
                r0 += a.a.a.b.b.a.f(6, this.tmn);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tmj == null) {
                throw new b("Not all required fields were included: ProductId");
            } else if (this.ohr == null) {
                throw new b("Not all required fields were included: ProductName");
            } else if (this.tmk == null) {
                throw new b("Not all required fields were included: SellerName");
            } else if (this.tml != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SellerUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hz hzVar = (hz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hzVar.tmj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    hzVar.ohr = aVar3.xmD.readString();
                    return 0;
                case 3:
                    hzVar.tmk = aVar3.xmD.readString();
                    return 0;
                case 4:
                    hzVar.tml = aVar3.xmD.readString();
                    return 0;
                case 5:
                    hzVar.tmm = aVar3.xmD.mL();
                    return 0;
                case 6:
                    hzVar.tmn = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
