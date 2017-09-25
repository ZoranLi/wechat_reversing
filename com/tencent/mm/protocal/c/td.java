package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class td extends a {
    public sw tBf;
    public LinkedList<String> tBg = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tBf == null) {
                throw new b("Not all required fields were included: GameItem");
            }
            if (this.tBf != null) {
                aVar.eQ(1, this.tBf.aUk());
                this.tBf.a(aVar);
            }
            aVar.d(2, 1, this.tBg);
            return 0;
        } else if (i == 1) {
            if (this.tBf != null) {
                r0 = a.a.a.a.eN(1, this.tBf.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(2, 1, this.tBg);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tBg.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tBf != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GameItem");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            td tdVar = (td) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a swVar = new sw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = swVar.a(aVar4, swVar, a.a(aVar4))) {
                        }
                        tdVar.tBf = swVar;
                    }
                    return 0;
                case 2:
                    tdVar.tBg.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
