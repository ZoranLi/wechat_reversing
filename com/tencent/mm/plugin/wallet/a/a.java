package com.tencent.mm.plugin.wallet.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bd.a {
    public LinkedList<b> rxE = new LinkedList();
    public j rxF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.rxE);
            if (this.rxF != null) {
                aVar.eQ(2, this.rxF.aUk());
                this.rxF.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.rxE) + 0;
            if (this.rxF != null) {
                return r0 + a.a.a.a.eN(2, this.rxF.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.rxE.clear();
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
            LinkedList En;
            int size;
            com.tencent.mm.bd.a bVar;
            a.a.a.a.a aVar5;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        bVar = new b();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bd.a.a(aVar5))) {
                        }
                        aVar4.rxE.add(bVar);
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        bVar = new j();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bd.a.a(aVar5))) {
                        }
                        aVar4.rxF = bVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
