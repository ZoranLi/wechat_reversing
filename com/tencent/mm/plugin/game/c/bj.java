package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bj extends a {
    public String fDC;
    public LinkedList<bk> mve = new LinkedList();
    public bl mvf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.fDC != null) {
                aVar.e(1, this.fDC);
            }
            aVar.d(2, 8, this.mve);
            if (this.mvf == null) {
                return 0;
            }
            aVar.eQ(3, this.mvf.aUk());
            this.mvf.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.mve);
            if (this.mvf != null) {
                r0 += a.a.a.a.eN(3, this.mvf.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mve.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.fDC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bj bjVar = (bj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a bkVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bjVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        bkVar = new bk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bkVar.a(aVar4, bkVar, a.a(aVar4))) {
                        }
                        bjVar.mve.add(bkVar);
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        bkVar = new bl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bkVar.a(aVar4, bkVar, a.a(aVar4))) {
                        }
                        bjVar.mvf = bkVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
