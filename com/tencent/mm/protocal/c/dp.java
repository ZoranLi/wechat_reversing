package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class dp extends a {
    public String msG;
    public String msh;
    public String muS;
    public String muU;
    public String tgZ;
    public int tgt;
    public String tha;
    public String thb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msh != null) {
                aVar.e(1, this.msh);
            }
            if (this.tgZ != null) {
                aVar.e(2, this.tgZ);
            }
            if (this.muU != null) {
                aVar.e(3, this.muU);
            }
            if (this.muS != null) {
                aVar.e(4, this.muS);
            }
            aVar.eO(5, this.tgt);
            if (this.msG != null) {
                aVar.e(6, this.msG);
            }
            if (this.tha != null) {
                aVar.e(7, this.tha);
            }
            if (this.thb == null) {
                return 0;
            }
            aVar.e(8, this.thb);
            return 0;
        } else if (i == 1) {
            if (this.msh != null) {
                r0 = a.a.a.b.b.a.f(1, this.msh) + 0;
            } else {
                r0 = 0;
            }
            if (this.tgZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.tgZ);
            }
            if (this.muU != null) {
                r0 += a.a.a.b.b.a.f(3, this.muU);
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(4, this.muS);
            }
            r0 += a.a.a.a.eL(5, this.tgt);
            if (this.msG != null) {
                r0 += a.a.a.b.b.a.f(6, this.msG);
            }
            if (this.tha != null) {
                r0 += a.a.a.b.b.a.f(7, this.tha);
            }
            if (this.thb != null) {
                r0 += a.a.a.b.b.a.f(8, this.thb);
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
            dp dpVar = (dp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dpVar.msh = aVar3.xmD.readString();
                    return 0;
                case 2:
                    dpVar.tgZ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    dpVar.muU = aVar3.xmD.readString();
                    return 0;
                case 4:
                    dpVar.muS = aVar3.xmD.readString();
                    return 0;
                case 5:
                    dpVar.tgt = aVar3.xmD.mL();
                    return 0;
                case 6:
                    dpVar.msG = aVar3.xmD.readString();
                    return 0;
                case 7:
                    dpVar.tha = aVar3.xmD.readString();
                    return 0;
                case 8:
                    dpVar.thb = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
