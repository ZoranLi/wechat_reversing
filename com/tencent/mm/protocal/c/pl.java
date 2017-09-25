package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class pl extends a {
    public String mvE;
    public String tvs;
    public String tvt;
    public String tvu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mvE == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.tvs == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.tvt == null) {
                throw new b("Not all required fields were included: Type");
            } else {
                if (this.mvE != null) {
                    aVar.e(1, this.mvE);
                }
                if (this.tvs != null) {
                    aVar.e(2, this.tvs);
                }
                if (this.tvt != null) {
                    aVar.e(3, this.tvt);
                }
                if (this.tvu == null) {
                    return 0;
                }
                aVar.e(4, this.tvu);
                return 0;
            }
        } else if (i == 1) {
            if (this.mvE != null) {
                r0 = a.a.a.b.b.a.f(1, this.mvE) + 0;
            } else {
                r0 = 0;
            }
            if (this.tvs != null) {
                r0 += a.a.a.b.b.a.f(2, this.tvs);
            }
            if (this.tvt != null) {
                r0 += a.a.a.b.b.a.f(3, this.tvt);
            }
            if (this.tvu != null) {
                r0 += a.a.a.b.b.a.f(4, this.tvu);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mvE == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.tvs == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.tvt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Type");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            pl plVar = (pl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    plVar.mvE = aVar3.xmD.readString();
                    return 0;
                case 2:
                    plVar.tvs = aVar3.xmD.readString();
                    return 0;
                case 3:
                    plVar.tvt = aVar3.xmD.readString();
                    return 0;
                case 4:
                    plVar.tvu = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
