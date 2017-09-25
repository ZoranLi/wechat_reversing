package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class g extends a {
    public LinkedList<h> ryb = new LinkedList();
    public b ryc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.ryb);
            if (this.ryc != null) {
                aVar.b(2, this.ryc);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.ryb) + 0;
            if (this.ryc != null) {
                return r0 + a.a.a.a.a(2, this.ryc);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ryb.clear();
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
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a hVar = new h();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        gVar.ryb.add(hVar);
                    }
                    return 0;
                case 2:
                    gVar.ryc = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
