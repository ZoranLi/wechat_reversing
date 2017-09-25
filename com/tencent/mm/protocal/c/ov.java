package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ov extends a {
    public String msN;
    public String ohq;
    public String tgW;
    public String tup;
    public String tuq;
    public String tur;
    public String tus;
    public String tut;
    public String tuu;
    public String tuv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tup == null) {
                throw new b("Not all required fields were included: Md5");
            }
            if (this.tup != null) {
                aVar.e(1, this.tup);
            }
            if (this.msN != null) {
                aVar.e(2, this.msN);
            }
            if (this.ohq != null) {
                aVar.e(3, this.ohq);
            }
            if (this.tuq != null) {
                aVar.e(4, this.tuq);
            }
            if (this.tur != null) {
                aVar.e(5, this.tur);
            }
            if (this.tus != null) {
                aVar.e(6, this.tus);
            }
            if (this.tgW != null) {
                aVar.e(7, this.tgW);
            }
            if (this.tut != null) {
                aVar.e(8, this.tut);
            }
            if (this.tuu != null) {
                aVar.e(9, this.tuu);
            }
            if (this.tuv == null) {
                return 0;
            }
            aVar.e(10, this.tuv);
            return 0;
        } else if (i == 1) {
            if (this.tup != null) {
                r0 = a.a.a.b.b.a.f(1, this.tup) + 0;
            } else {
                r0 = 0;
            }
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(2, this.msN);
            }
            if (this.ohq != null) {
                r0 += a.a.a.b.b.a.f(3, this.ohq);
            }
            if (this.tuq != null) {
                r0 += a.a.a.b.b.a.f(4, this.tuq);
            }
            if (this.tur != null) {
                r0 += a.a.a.b.b.a.f(5, this.tur);
            }
            if (this.tus != null) {
                r0 += a.a.a.b.b.a.f(6, this.tus);
            }
            if (this.tgW != null) {
                r0 += a.a.a.b.b.a.f(7, this.tgW);
            }
            if (this.tut != null) {
                r0 += a.a.a.b.b.a.f(8, this.tut);
            }
            if (this.tuu != null) {
                r0 += a.a.a.b.b.a.f(9, this.tuu);
            }
            if (this.tuv != null) {
                r0 += a.a.a.b.b.a.f(10, this.tuv);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tup != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Md5");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ov ovVar = (ov) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ovVar.tup = aVar3.xmD.readString();
                    return 0;
                case 2:
                    ovVar.msN = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ovVar.ohq = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ovVar.tuq = aVar3.xmD.readString();
                    return 0;
                case 5:
                    ovVar.tur = aVar3.xmD.readString();
                    return 0;
                case 6:
                    ovVar.tus = aVar3.xmD.readString();
                    return 0;
                case 7:
                    ovVar.tgW = aVar3.xmD.readString();
                    return 0;
                case 8:
                    ovVar.tut = aVar3.xmD.readString();
                    return 0;
                case 9:
                    ovVar.tuu = aVar3.xmD.readString();
                    return 0;
                case 10:
                    ovVar.tuv = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
