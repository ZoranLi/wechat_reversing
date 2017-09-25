package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bz extends a {
    public String hAE;
    public String hAF;
    public String hAM;
    public String jNj;
    public String mtg;
    public String tfs;
    public String tft;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hAM != null) {
                aVar.e(1, this.hAM);
            }
            if (this.hAE != null) {
                aVar.e(2, this.hAE);
            }
            if (this.hAF != null) {
                aVar.e(3, this.hAF);
            }
            if (this.mtg != null) {
                aVar.e(4, this.mtg);
            }
            if (this.jNj != null) {
                aVar.e(5, this.jNj);
            }
            if (this.tfs != null) {
                aVar.e(6, this.tfs);
            }
            if (this.tft == null) {
                return 0;
            }
            aVar.e(7, this.tft);
            return 0;
        } else if (i == 1) {
            if (this.hAM != null) {
                r0 = a.a.a.b.b.a.f(1, this.hAM) + 0;
            } else {
                r0 = 0;
            }
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(2, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(3, this.hAF);
            }
            if (this.mtg != null) {
                r0 += a.a.a.b.b.a.f(4, this.mtg);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(5, this.jNj);
            }
            if (this.tfs != null) {
                r0 += a.a.a.b.b.a.f(6, this.tfs);
            }
            if (this.tft != null) {
                r0 += a.a.a.b.b.a.f(7, this.tft);
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
            bz bzVar = (bz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzVar.hAM = aVar3.xmD.readString();
                    return 0;
                case 2:
                    bzVar.hAE = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bzVar.hAF = aVar3.xmD.readString();
                    return 0;
                case 4:
                    bzVar.mtg = aVar3.xmD.readString();
                    return 0;
                case 5:
                    bzVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 6:
                    bzVar.tfs = aVar3.xmD.readString();
                    return 0;
                case 7:
                    bzVar.tft = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
