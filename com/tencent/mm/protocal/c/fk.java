package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class fk extends a {
    public LinkedList<fj> tiV = new LinkedList();
    public fi tiW;
    public int tiX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.tiV);
            if (this.tiW != null) {
                aVar.eQ(2, this.tiW.aUk());
                this.tiW.a(aVar);
            }
            aVar.eO(3, this.tiX);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.tiV) + 0;
            if (this.tiW != null) {
                r0 += a.a.a.a.eN(2, this.tiW.aUk());
            }
            return r0 + a.a.a.a.eL(3, this.tiX);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tiV.clear();
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
            fk fkVar = (fk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a fjVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        fjVar = new fj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fjVar.a(aVar4, fjVar, a.a(aVar4))) {
                        }
                        fkVar.tiV.add(fjVar);
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        fjVar = new fi();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fjVar.a(aVar4, fjVar, a.a(aVar4))) {
                        }
                        fkVar.tiW = fjVar;
                    }
                    return 0;
                case 3:
                    fkVar.tiX = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
