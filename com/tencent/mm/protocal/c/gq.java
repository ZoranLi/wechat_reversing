package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class gq extends a {
    public String name;
    public String tkF;
    public String tkG;
    public int tkH;
    public int tkI;
    public String tkJ;
    public String tkK;
    public int type;
    public int ver;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tkF != null) {
                aVar.e(1, this.tkF);
            }
            aVar.eO(2, this.type);
            if (this.tkG != null) {
                aVar.e(3, this.tkG);
            }
            if (this.name != null) {
                aVar.e(4, this.name);
            }
            aVar.eO(5, this.ver);
            aVar.eO(6, this.tkH);
            aVar.eO(7, this.tkI);
            if (this.tkJ != null) {
                aVar.e(8, this.tkJ);
            }
            if (this.tkK == null) {
                return 0;
            }
            aVar.e(9, this.tkK);
            return 0;
        } else if (i == 1) {
            if (this.tkF != null) {
                r0 = a.a.a.b.b.a.f(1, this.tkF) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.type);
            if (this.tkG != null) {
                r0 += a.a.a.b.b.a.f(3, this.tkG);
            }
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(4, this.name);
            }
            r0 = ((r0 + a.a.a.a.eL(5, this.ver)) + a.a.a.a.eL(6, this.tkH)) + a.a.a.a.eL(7, this.tkI);
            if (this.tkJ != null) {
                r0 += a.a.a.b.b.a.f(8, this.tkJ);
            }
            if (this.tkK != null) {
                r0 += a.a.a.b.b.a.f(9, this.tkK);
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
            gq gqVar = (gq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gqVar.tkF = aVar3.xmD.readString();
                    return 0;
                case 2:
                    gqVar.type = aVar3.xmD.mL();
                    return 0;
                case 3:
                    gqVar.tkG = aVar3.xmD.readString();
                    return 0;
                case 4:
                    gqVar.name = aVar3.xmD.readString();
                    return 0;
                case 5:
                    gqVar.ver = aVar3.xmD.mL();
                    return 0;
                case 6:
                    gqVar.tkH = aVar3.xmD.mL();
                    return 0;
                case 7:
                    gqVar.tkI = aVar3.xmD.mL();
                    return 0;
                case 8:
                    gqVar.tkJ = aVar3.xmD.readString();
                    return 0;
                case 9:
                    gqVar.tkK = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
