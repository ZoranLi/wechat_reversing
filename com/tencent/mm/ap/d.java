package com.tencent.mm.ap;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> hNT = new LinkedList();
    public int hNU;
    public int hNV;
    public int hNW;
    public int hNX;
    public String hNY;
    public String hNZ;
    public int hOa;
    public int hOb;
    public int hOc;
    public int maxSize;
    public String name;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.hNT);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.eO(3, this.hNU);
            aVar.eO(4, this.hNV);
            aVar.eO(5, this.hNW);
            aVar.eO(6, this.hNX);
            if (this.hNY != null) {
                aVar.e(7, this.hNY);
            }
            if (this.hNZ != null) {
                aVar.e(8, this.hNZ);
            }
            aVar.eO(9, this.hOa);
            aVar.eO(10, this.hOb);
            aVar.eO(11, this.hOc);
            aVar.eO(12, this.maxSize);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.hNT) + 0;
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            r0 = (((r0 + a.a.a.a.eL(3, this.hNU)) + a.a.a.a.eL(4, this.hNV)) + a.a.a.a.eL(5, this.hNW)) + a.a.a.a.eL(6, this.hNX);
            if (this.hNY != null) {
                r0 += a.a.a.b.b.a.f(7, this.hNY);
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(8, this.hNZ);
            }
            return (((r0 + a.a.a.a.eL(9, this.hOa)) + a.a.a.a.eL(10, this.hOb)) + a.a.a.a.eL(11, this.hOc)) + a.a.a.a.eL(12, this.maxSize);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.hNT.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        dVar.hNT.add(eVar);
                    }
                    return 0;
                case 2:
                    dVar.name = aVar3.xmD.readString();
                    return 0;
                case 3:
                    dVar.hNU = aVar3.xmD.mL();
                    return 0;
                case 4:
                    dVar.hNV = aVar3.xmD.mL();
                    return 0;
                case 5:
                    dVar.hNW = aVar3.xmD.mL();
                    return 0;
                case 6:
                    dVar.hNX = aVar3.xmD.mL();
                    return 0;
                case 7:
                    dVar.hNY = aVar3.xmD.readString();
                    return 0;
                case 8:
                    dVar.hNZ = aVar3.xmD.readString();
                    return 0;
                case 9:
                    dVar.hOa = aVar3.xmD.mL();
                    return 0;
                case 10:
                    dVar.hOb = aVar3.xmD.mL();
                    return 0;
                case 11:
                    dVar.hOc = aVar3.xmD.mL();
                    return 0;
                case 12:
                    dVar.maxSize = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
