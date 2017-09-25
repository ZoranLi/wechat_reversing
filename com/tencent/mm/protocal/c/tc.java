package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class tc extends a {
    public String fDC;
    public LinkedList<sw> tAY = new LinkedList();
    public LinkedList<te> tAZ = new LinkedList();
    public String tBa;
    public String tBb;
    public LinkedList<td> tBc = new LinkedList();
    public int tBd;
    public boolean tBe;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC != null) {
                aVar.e(1, this.fDC);
            }
            aVar.eO(2, this.type);
            aVar.d(3, 8, this.tAY);
            aVar.d(4, 8, this.tAZ);
            if (this.tBa != null) {
                aVar.e(5, this.tBa);
            }
            if (this.tBb != null) {
                aVar.e(6, this.tBb);
            }
            aVar.d(7, 8, this.tBc);
            aVar.eO(8, this.tBd);
            aVar.an(9, this.tBe);
            return 0;
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.eL(2, this.type)) + a.a.a.a.c(3, 8, this.tAY)) + a.a.a.a.c(4, 8, this.tAZ);
            if (this.tBa != null) {
                r0 += a.a.a.b.b.a.f(5, this.tBa);
            }
            if (this.tBb != null) {
                r0 += a.a.a.b.b.a.f(6, this.tBb);
            }
            return ((r0 + a.a.a.a.c(7, 8, this.tBc)) + a.a.a.a.eL(8, this.tBd)) + (a.a.a.b.b.a.cH(9) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tAY.clear();
            this.tAZ.clear();
            this.tBc.clear();
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
            tc tcVar = (tc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a swVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    tcVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    tcVar.type = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        swVar = new sw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = swVar.a(aVar4, swVar, a.a(aVar4))) {
                        }
                        tcVar.tAY.add(swVar);
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        swVar = new te();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = swVar.a(aVar4, swVar, a.a(aVar4))) {
                        }
                        tcVar.tAZ.add(swVar);
                    }
                    return 0;
                case 5:
                    tcVar.tBa = aVar3.xmD.readString();
                    return 0;
                case 6:
                    tcVar.tBb = aVar3.xmD.readString();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        swVar = new td();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = swVar.a(aVar4, swVar, a.a(aVar4))) {
                        }
                        tcVar.tBc.add(swVar);
                    }
                    return 0;
                case 8:
                    tcVar.tBd = aVar3.xmD.mL();
                    return 0;
                case 9:
                    tcVar.tBe = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
