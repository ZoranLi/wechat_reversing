package com.tencent.mm.b;

import com.tencent.mm.bd.a;

public final class b extends a {
    public String apkMd5;
    public int fuV;
    public String fuW;
    public int fuX;
    public String fuY;
    public String fuZ;
    public boolean fva;
    public int fvb;
    public boolean fvc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.apkMd5 == null) {
                throw new a.a.a.b("Not all required fields were included: apkMd5");
            }
            if (this.apkMd5 != null) {
                aVar.e(1, this.apkMd5);
            }
            aVar.eP(2, this.fuV);
            if (this.fuW != null) {
                aVar.e(3, this.fuW);
            }
            aVar.eP(4, this.fuX);
            if (this.fuY != null) {
                aVar.e(5, this.fuY);
            }
            if (this.fuZ != null) {
                aVar.e(6, this.fuZ);
            }
            aVar.an(7, this.fva);
            aVar.eP(8, this.fvb);
            aVar.an(9, this.fvc);
            return 0;
        } else if (i == 1) {
            if (this.apkMd5 != null) {
                r0 = a.a.a.a.f(1, this.apkMd5) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eM(2, this.fuV);
            if (this.fuW != null) {
                r0 += a.a.a.a.f(3, this.fuW);
            }
            r0 += a.a.a.a.eM(4, this.fuX);
            if (this.fuY != null) {
                r0 += a.a.a.a.f(5, this.fuY);
            }
            if (this.fuZ != null) {
                r0 += a.a.a.a.f(6, this.fuZ);
            }
            return ((r0 + a.a.a.a.Em(7)) + a.a.a.a.eM(8, this.fvb)) + a.a.a.a.Em(9);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.apkMd5 != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: apkMd5");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.apkMd5 = aVar3.cia();
                    return 0;
                case 2:
                    bVar.fuV = aVar3.chY();
                    return 0;
                case 3:
                    bVar.fuW = aVar3.cia();
                    return 0;
                case 4:
                    bVar.fuX = aVar3.chY();
                    return 0;
                case 5:
                    bVar.fuY = aVar3.cia();
                    return 0;
                case 6:
                    bVar.fuZ = aVar3.cia();
                    return 0;
                case 7:
                    bVar.fva = aVar3.cib();
                    return 0;
                case 8:
                    bVar.fvb = aVar3.chY();
                    return 0;
                case 9:
                    bVar.fvc = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
