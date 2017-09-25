package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class cm extends a {
    public String msS;
    public String mvX;
    public String mvY;
    public String mvZ;
    public String mwa;
    public int mwb;
    public String mwc;
    public String mwd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msS != null) {
                aVar.e(1, this.msS);
            }
            if (this.mvX != null) {
                aVar.e(2, this.mvX);
            }
            if (this.mvY != null) {
                aVar.e(3, this.mvY);
            }
            if (this.mvZ != null) {
                aVar.e(4, this.mvZ);
            }
            if (this.mwa != null) {
                aVar.e(5, this.mwa);
            }
            aVar.eO(6, this.mwb);
            if (this.mwc != null) {
                aVar.e(7, this.mwc);
            }
            if (this.mwd == null) {
                return 0;
            }
            aVar.e(8, this.mwd);
            return 0;
        } else if (i == 1) {
            if (this.msS != null) {
                r0 = a.a.a.b.b.a.f(1, this.msS) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvX != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvX);
            }
            if (this.mvY != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvY);
            }
            if (this.mvZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvZ);
            }
            if (this.mwa != null) {
                r0 += a.a.a.b.b.a.f(5, this.mwa);
            }
            r0 += a.a.a.a.eL(6, this.mwb);
            if (this.mwc != null) {
                r0 += a.a.a.b.b.a.f(7, this.mwc);
            }
            if (this.mwd != null) {
                r0 += a.a.a.b.b.a.f(8, this.mwd);
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
            cm cmVar = (cm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmVar.msS = aVar3.xmD.readString();
                    return 0;
                case 2:
                    cmVar.mvX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    cmVar.mvY = aVar3.xmD.readString();
                    return 0;
                case 4:
                    cmVar.mvZ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    cmVar.mwa = aVar3.xmD.readString();
                    return 0;
                case 6:
                    cmVar.mwb = aVar3.xmD.mL();
                    return 0;
                case 7:
                    cmVar.mwc = aVar3.xmD.readString();
                    return 0;
                case 8:
                    cmVar.mwd = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
