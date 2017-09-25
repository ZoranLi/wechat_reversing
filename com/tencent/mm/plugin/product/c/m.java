package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class m extends a {
    public String oqh;
    public String oqi;
    public LinkedList<h> oqj = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.oqh != null) {
                aVar.e(1, this.oqh);
            }
            if (this.oqi != null) {
                aVar.e(2, this.oqi);
            }
            aVar.d(3, 8, this.oqj);
            return 0;
        } else if (i == 1) {
            if (this.oqh != null) {
                r0 = a.a.a.b.b.a.f(1, this.oqh) + 0;
            } else {
                r0 = 0;
            }
            if (this.oqi != null) {
                r0 += a.a.a.b.b.a.f(2, this.oqi);
            }
            return r0 + a.a.a.a.c(3, 8, this.oqj);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.oqj.clear();
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
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.oqh = aVar3.xmD.readString();
                    return 0;
                case 2:
                    mVar.oqi = aVar3.xmD.readString();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a hVar = new h();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        mVar.oqj.add(hVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
