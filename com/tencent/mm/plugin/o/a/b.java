package com.tencent.mm.plugin.o.a;

import com.tencent.mm.bd.a;

public final class b extends a {
    public String gku;
    public int mLW;
    public String mLX;
    public String mLY;
    public String mLZ;
    public String mMa;
    public String mMb;
    public String mMc;
    public String mMd;
    public String mMe;
    public String mMf;
    public String title;
    public String type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.mLW);
            if (this.type != null) {
                aVar.e(2, this.type);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.mLX != null) {
                aVar.e(4, this.mLX);
            }
            if (this.mLY != null) {
                aVar.e(5, this.mLY);
            }
            if (this.mLZ != null) {
                aVar.e(6, this.mLZ);
            }
            if (this.mMa != null) {
                aVar.e(7, this.mMa);
            }
            if (this.mMb != null) {
                aVar.e(8, this.mMb);
            }
            if (this.mMc != null) {
                aVar.e(9, this.mMc);
            }
            if (this.mMd != null) {
                aVar.e(10, this.mMd);
            }
            if (this.gku != null) {
                aVar.e(11, this.gku);
            }
            if (this.mMe != null) {
                aVar.e(12, this.mMe);
            }
            if (this.mMf != null) {
                aVar.e(13, this.mMf);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.mLW) + 0;
            if (this.type != null) {
                r0 += a.a.a.b.b.a.f(2, this.type);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(3, this.title);
            }
            if (this.mLX != null) {
                r0 += a.a.a.b.b.a.f(4, this.mLX);
            }
            if (this.mLY != null) {
                r0 += a.a.a.b.b.a.f(5, this.mLY);
            }
            if (this.mLZ != null) {
                r0 += a.a.a.b.b.a.f(6, this.mLZ);
            }
            if (this.mMa != null) {
                r0 += a.a.a.b.b.a.f(7, this.mMa);
            }
            if (this.mMb != null) {
                r0 += a.a.a.b.b.a.f(8, this.mMb);
            }
            if (this.mMc != null) {
                r0 += a.a.a.b.b.a.f(9, this.mMc);
            }
            if (this.mMd != null) {
                r0 += a.a.a.b.b.a.f(10, this.mMd);
            }
            if (this.gku != null) {
                r0 += a.a.a.b.b.a.f(11, this.gku);
            }
            if (this.mMe != null) {
                r0 += a.a.a.b.b.a.f(12, this.mMe);
            }
            if (this.mMf != null) {
                return r0 + a.a.a.b.b.a.f(13, this.mMf);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.mLW = aVar3.xmD.mL();
                    return 0;
                case 2:
                    bVar.type = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bVar.title = aVar3.xmD.readString();
                    return 0;
                case 4:
                    bVar.mLX = aVar3.xmD.readString();
                    return 0;
                case 5:
                    bVar.mLY = aVar3.xmD.readString();
                    return 0;
                case 6:
                    bVar.mLZ = aVar3.xmD.readString();
                    return 0;
                case 7:
                    bVar.mMa = aVar3.xmD.readString();
                    return 0;
                case 8:
                    bVar.mMb = aVar3.xmD.readString();
                    return 0;
                case 9:
                    bVar.mMc = aVar3.xmD.readString();
                    return 0;
                case 10:
                    bVar.mMd = aVar3.xmD.readString();
                    return 0;
                case 11:
                    bVar.gku = aVar3.xmD.readString();
                    return 0;
                case 12:
                    bVar.mMe = aVar3.xmD.readString();
                    return 0;
                case 13:
                    bVar.mMf = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
