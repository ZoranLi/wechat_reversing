package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class gx extends a {
    public String khr;
    public String tkG;
    public int tkH;
    public String tkK;
    public String tkM;
    public String tkU;
    public int ver;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tkM != null) {
                aVar.e(1, this.tkM);
            }
            if (this.khr != null) {
                aVar.e(2, this.khr);
            }
            aVar.eO(3, this.ver);
            if (this.tkG != null) {
                aVar.e(4, this.tkG);
            }
            if (this.tkU != null) {
                aVar.e(5, this.tkU);
            }
            aVar.eO(6, this.tkH);
            if (this.tkK == null) {
                return 0;
            }
            aVar.e(7, this.tkK);
            return 0;
        } else if (i == 1) {
            if (this.tkM != null) {
                r0 = a.a.a.b.b.a.f(1, this.tkM) + 0;
            } else {
                r0 = 0;
            }
            if (this.khr != null) {
                r0 += a.a.a.b.b.a.f(2, this.khr);
            }
            r0 += a.a.a.a.eL(3, this.ver);
            if (this.tkG != null) {
                r0 += a.a.a.b.b.a.f(4, this.tkG);
            }
            if (this.tkU != null) {
                r0 += a.a.a.b.b.a.f(5, this.tkU);
            }
            r0 += a.a.a.a.eL(6, this.tkH);
            if (this.tkK != null) {
                r0 += a.a.a.b.b.a.f(7, this.tkK);
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
            gx gxVar = (gx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gxVar.tkM = aVar3.xmD.readString();
                    return 0;
                case 2:
                    gxVar.khr = aVar3.xmD.readString();
                    return 0;
                case 3:
                    gxVar.ver = aVar3.xmD.mL();
                    return 0;
                case 4:
                    gxVar.tkG = aVar3.xmD.readString();
                    return 0;
                case 5:
                    gxVar.tkU = aVar3.xmD.readString();
                    return 0;
                case 6:
                    gxVar.tkH = aVar3.xmD.mL();
                    return 0;
                case 7:
                    gxVar.tkK = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
