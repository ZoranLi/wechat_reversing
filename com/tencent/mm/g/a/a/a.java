package com.tencent.mm.g.a.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bd.a {
    public int fPC;
    public int fRW;
    public LinkedList<b> gMT = new LinkedList();
    public int gMU;
    public String gMV;
    public int gMW;
    public int status;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.gMT);
            aVar.eO(2, this.fRW);
            aVar.eO(3, this.type);
            aVar.eO(4, this.status);
            aVar.eO(5, this.gMU);
            if (this.gMV != null) {
                aVar.e(6, this.gMV);
            }
            aVar.eO(7, this.fPC);
            aVar.eO(8, this.gMW);
            return 0;
        } else if (i == 1) {
            r0 = ((((a.a.a.a.c(1, 8, this.gMT) + 0) + a.a.a.a.eL(2, this.fRW)) + a.a.a.a.eL(3, this.type)) + a.a.a.a.eL(4, this.status)) + a.a.a.a.eL(5, this.gMU);
            if (this.gMV != null) {
                r0 += a.a.a.b.b.a.f(6, this.gMV);
            }
            return (r0 + a.a.a.a.eL(7, this.fPC)) + a.a.a.a.eL(8, this.gMW);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gMT.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a bVar = new b();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bd.a.a(aVar5))) {
                        }
                        aVar4.gMT.add(bVar);
                    }
                    return 0;
                case 2:
                    aVar4.fRW = aVar3.xmD.mL();
                    return 0;
                case 3:
                    aVar4.type = aVar3.xmD.mL();
                    return 0;
                case 4:
                    aVar4.status = aVar3.xmD.mL();
                    return 0;
                case 5:
                    aVar4.gMU = aVar3.xmD.mL();
                    return 0;
                case 6:
                    aVar4.gMV = aVar3.xmD.readString();
                    return 0;
                case 7:
                    aVar4.fPC = aVar3.xmD.mL();
                    return 0;
                case 8:
                    aVar4.gMW = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
