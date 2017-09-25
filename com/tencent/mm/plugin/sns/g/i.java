package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<h> qaS = new LinkedList();
    public g qaT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.qaS);
            if (this.qaT != null) {
                aVar.eQ(2, this.qaT.aUk());
                this.qaT.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.qaS) + 0;
            if (this.qaT != null) {
                return r0 + a.a.a.a.eN(2, this.qaT.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.qaS.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a hVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        hVar = new h();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        iVar.qaS.add(hVar);
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        hVar = new g();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        iVar.qaT = hVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
