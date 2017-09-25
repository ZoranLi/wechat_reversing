package com.tencent.mm.plugin.location.a;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> naL = new LinkedList();
    public String naM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.naL);
            if (this.naM != null) {
                aVar.e(2, this.naM);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.naL) + 0;
            if (this.naM != null) {
                return r0 + a.a.a.b.b.a.f(2, this.naM);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.naL.clear();
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
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a aVar4 = new a();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        bVar.naL.add(aVar4);
                    }
                    return 0;
                case 2:
                    bVar.naM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
