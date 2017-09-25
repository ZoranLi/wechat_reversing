package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ss extends a {
    public gq tAE;
    public LinkedList<gs> tkN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tAE != null) {
                aVar.eQ(1, this.tAE.aUk());
                this.tAE.a(aVar);
            }
            aVar.d(2, 8, this.tkN);
            return 0;
        } else if (i == 1) {
            if (this.tAE != null) {
                r0 = a.a.a.a.eN(1, this.tAE.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(2, 8, this.tkN);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tkN.clear();
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
            ss ssVar = (ss) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a gqVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        gqVar = new gq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = gqVar.a(aVar4, gqVar, a.a(aVar4))) {
                        }
                        ssVar.tAE = gqVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        gqVar = new gs();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = gqVar.a(aVar4, gqVar, a.a(aVar4))) {
                        }
                        ssVar.tkN.add(gqVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
