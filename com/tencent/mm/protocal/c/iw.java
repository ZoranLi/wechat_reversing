package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class iw extends a {
    public String country;
    public String descriptor;
    public float fOb;
    public float fPF;
    public String gkB;
    public String gkC;
    public String hCE;
    public String kdW;
    public String kfu;
    public String name;
    public float tnX;
    public String tnY;
    public String tnZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.descriptor != null) {
                aVar.e(2, this.descriptor);
            }
            if (this.kdW != null) {
                aVar.e(3, this.kdW);
            }
            if (this.country != null) {
                aVar.e(4, this.country);
            }
            if (this.gkB != null) {
                aVar.e(5, this.gkB);
            }
            if (this.gkC != null) {
                aVar.e(6, this.gkC);
            }
            if (this.hCE != null) {
                aVar.e(7, this.hCE);
            }
            aVar.n(8, this.tnX);
            aVar.n(9, this.fPF);
            aVar.n(10, this.fOb);
            if (this.kfu != null) {
                aVar.e(11, this.kfu);
            }
            if (this.tnY != null) {
                aVar.e(12, this.tnY);
            }
            if (this.tnZ == null) {
                return 0;
            }
            aVar.e(13, this.tnZ);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                r0 = a.a.a.b.b.a.f(1, this.name) + 0;
            } else {
                r0 = 0;
            }
            if (this.descriptor != null) {
                r0 += a.a.a.b.b.a.f(2, this.descriptor);
            }
            if (this.kdW != null) {
                r0 += a.a.a.b.b.a.f(3, this.kdW);
            }
            if (this.country != null) {
                r0 += a.a.a.b.b.a.f(4, this.country);
            }
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(5, this.gkB);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(6, this.gkC);
            }
            if (this.hCE != null) {
                r0 += a.a.a.b.b.a.f(7, this.hCE);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cH(8) + 4)) + (a.a.a.b.b.a.cH(9) + 4)) + (a.a.a.b.b.a.cH(10) + 4);
            if (this.kfu != null) {
                r0 += a.a.a.b.b.a.f(11, this.kfu);
            }
            if (this.tnY != null) {
                r0 += a.a.a.b.b.a.f(12, this.tnY);
            }
            if (this.tnZ != null) {
                r0 += a.a.a.b.b.a.f(13, this.tnZ);
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
            iw iwVar = (iw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iwVar.name = aVar3.xmD.readString();
                    return 0;
                case 2:
                    iwVar.descriptor = aVar3.xmD.readString();
                    return 0;
                case 3:
                    iwVar.kdW = aVar3.xmD.readString();
                    return 0;
                case 4:
                    iwVar.country = aVar3.xmD.readString();
                    return 0;
                case 5:
                    iwVar.gkB = aVar3.xmD.readString();
                    return 0;
                case 6:
                    iwVar.gkC = aVar3.xmD.readString();
                    return 0;
                case 7:
                    iwVar.hCE = aVar3.xmD.readString();
                    return 0;
                case 8:
                    iwVar.tnX = aVar3.xmD.readFloat();
                    return 0;
                case 9:
                    iwVar.fPF = aVar3.xmD.readFloat();
                    return 0;
                case 10:
                    iwVar.fOb = aVar3.xmD.readFloat();
                    return 0;
                case 11:
                    iwVar.kfu = aVar3.xmD.readString();
                    return 0;
                case 12:
                    iwVar.tnY = aVar3.xmD.readString();
                    return 0;
                case 13:
                    iwVar.tnZ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
