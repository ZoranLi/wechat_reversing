package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class b extends a {
    public String ofe;
    public LinkedList<c> rxG = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ofe != null) {
                aVar.e(1, this.ofe);
            }
            aVar.d(2, 8, this.rxG);
            return 0;
        } else if (i == 1) {
            if (this.ofe != null) {
                r0 = a.a.a.b.b.a.f(1, this.ofe) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(2, 8, this.rxG);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.rxG.clear();
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.ofe = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a cVar = new c();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        bVar.rxG.add(cVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
