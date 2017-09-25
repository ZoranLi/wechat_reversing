package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class uu extends a {
    public LinkedList<String> tCu = new LinkedList();
    public at tnu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.tCu);
            if (this.tnu != null) {
                aVar.eQ(2, this.tnu.aUk());
                this.tnu.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 1, this.tCu) + 0;
            if (this.tnu != null) {
                return r0 + a.a.a.a.eN(2, this.tnu.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tCu.clear();
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
            uu uuVar = (uu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    uuVar.tCu.add(aVar3.xmD.readString());
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a atVar = new at();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = atVar.a(aVar4, atVar, a.a(aVar4))) {
                        }
                        uuVar.tnu = atVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
