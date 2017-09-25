package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class sz extends a {
    public String msh;
    public int tAL;
    public String tAM;
    public String tAU;
    public String tgT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msh == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.tAU == null) {
                throw new b("Not all required fields were included: RecommendKey");
            } else {
                if (this.msh != null) {
                    aVar.e(1, this.msh);
                }
                if (this.tAU != null) {
                    aVar.e(2, this.tAU);
                }
                if (this.tgT != null) {
                    aVar.e(3, this.tgT);
                }
                aVar.eO(4, this.tAL);
                if (this.tAM == null) {
                    return 0;
                }
                aVar.e(5, this.tAM);
                return 0;
            }
        } else if (i == 1) {
            if (this.msh != null) {
                r0 = a.a.a.b.b.a.f(1, this.msh) + 0;
            } else {
                r0 = 0;
            }
            if (this.tAU != null) {
                r0 += a.a.a.b.b.a.f(2, this.tAU);
            }
            if (this.tgT != null) {
                r0 += a.a.a.b.b.a.f(3, this.tgT);
            }
            r0 += a.a.a.a.eL(4, this.tAL);
            if (this.tAM != null) {
                r0 += a.a.a.b.b.a.f(5, this.tAM);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msh == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.tAU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RecommendKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            sz szVar = (sz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    szVar.msh = aVar3.xmD.readString();
                    return 0;
                case 2:
                    szVar.tAU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    szVar.tgT = aVar3.xmD.readString();
                    return 0;
                case 4:
                    szVar.tAL = aVar3.xmD.mL();
                    return 0;
                case 5:
                    szVar.tAM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
