package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class rp extends a {
    public String hjD;
    public String hjF;
    public String hjG;
    public String hjH;
    public String hjI;
    public String hjJ;
    public String hjK;
    public int tyZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hjD != null) {
                aVar.e(1, this.hjD);
            }
            aVar.eO(2, this.tyZ);
            if (this.hjG != null) {
                aVar.e(3, this.hjG);
            }
            if (this.hjH != null) {
                aVar.e(4, this.hjH);
            }
            if (this.hjF != null) {
                aVar.e(5, this.hjF);
            }
            if (this.hjI != null) {
                aVar.e(6, this.hjI);
            }
            if (this.hjJ != null) {
                aVar.e(7, this.hjJ);
            }
            if (this.hjK == null) {
                return 0;
            }
            aVar.e(8, this.hjK);
            return 0;
        } else if (i == 1) {
            if (this.hjD != null) {
                r0 = a.a.a.b.b.a.f(1, this.hjD) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tyZ);
            if (this.hjG != null) {
                r0 += a.a.a.b.b.a.f(3, this.hjG);
            }
            if (this.hjH != null) {
                r0 += a.a.a.b.b.a.f(4, this.hjH);
            }
            if (this.hjF != null) {
                r0 += a.a.a.b.b.a.f(5, this.hjF);
            }
            if (this.hjI != null) {
                r0 += a.a.a.b.b.a.f(6, this.hjI);
            }
            if (this.hjJ != null) {
                r0 += a.a.a.b.b.a.f(7, this.hjJ);
            }
            if (this.hjK != null) {
                r0 += a.a.a.b.b.a.f(8, this.hjK);
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
            rp rpVar = (rp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rpVar.hjD = aVar3.xmD.readString();
                    return 0;
                case 2:
                    rpVar.tyZ = aVar3.xmD.mL();
                    return 0;
                case 3:
                    rpVar.hjG = aVar3.xmD.readString();
                    return 0;
                case 4:
                    rpVar.hjH = aVar3.xmD.readString();
                    return 0;
                case 5:
                    rpVar.hjF = aVar3.xmD.readString();
                    return 0;
                case 6:
                    rpVar.hjI = aVar3.xmD.readString();
                    return 0;
                case 7:
                    rpVar.hjJ = aVar3.xmD.readString();
                    return 0;
                case 8:
                    rpVar.hjK = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
