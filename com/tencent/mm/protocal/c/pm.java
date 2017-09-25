package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class pm extends a {
    public int teT;
    public int tvA;
    public int tvB;
    public String tvC;
    public String tvv;
    public String tvw;
    public String tvx;
    public String tvy;
    public String tvz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tvv == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.tvw == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.tvx == null) {
                throw new b("Not all required fields were included: ThanksPicUrl");
            } else {
                if (this.tvv != null) {
                    aVar.e(1, this.tvv);
                }
                if (this.tvw != null) {
                    aVar.e(2, this.tvw);
                }
                if (this.tvx != null) {
                    aVar.e(3, this.tvx);
                }
                if (this.tvy != null) {
                    aVar.e(4, this.tvy);
                }
                if (this.tvz != null) {
                    aVar.e(5, this.tvz);
                }
                aVar.eO(6, this.tvA);
                aVar.eO(7, this.tvB);
                if (this.tvC != null) {
                    aVar.e(8, this.tvC);
                }
                aVar.eO(9, this.teT);
                return 0;
            }
        } else if (i == 1) {
            if (this.tvv != null) {
                r0 = a.a.a.b.b.a.f(1, this.tvv) + 0;
            } else {
                r0 = 0;
            }
            if (this.tvw != null) {
                r0 += a.a.a.b.b.a.f(2, this.tvw);
            }
            if (this.tvx != null) {
                r0 += a.a.a.b.b.a.f(3, this.tvx);
            }
            if (this.tvy != null) {
                r0 += a.a.a.b.b.a.f(4, this.tvy);
            }
            if (this.tvz != null) {
                r0 += a.a.a.b.b.a.f(5, this.tvz);
            }
            r0 = (r0 + a.a.a.a.eL(6, this.tvA)) + a.a.a.a.eL(7, this.tvB);
            if (this.tvC != null) {
                r0 += a.a.a.b.b.a.f(8, this.tvC);
            }
            return r0 + a.a.a.a.eL(9, this.teT);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tvv == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.tvw == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.tvx != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThanksPicUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            pm pmVar = (pm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pmVar.tvv = aVar3.xmD.readString();
                    return 0;
                case 2:
                    pmVar.tvw = aVar3.xmD.readString();
                    return 0;
                case 3:
                    pmVar.tvx = aVar3.xmD.readString();
                    return 0;
                case 4:
                    pmVar.tvy = aVar3.xmD.readString();
                    return 0;
                case 5:
                    pmVar.tvz = aVar3.xmD.readString();
                    return 0;
                case 6:
                    pmVar.tvA = aVar3.xmD.mL();
                    return 0;
                case 7:
                    pmVar.tvB = aVar3.xmD.mL();
                    return 0;
                case 8:
                    pmVar.tvC = aVar3.xmD.readString();
                    return 0;
                case 9:
                    pmVar.teT = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
