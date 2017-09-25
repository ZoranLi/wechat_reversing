package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bm extends a {
    public String fDC;
    public String mtg;
    public LinkedList<bq> mvh = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.mtg == null) {
                throw new b("Not all required fields were included: Detail");
            } else {
                if (this.fDC != null) {
                    aVar.e(1, this.fDC);
                }
                aVar.d(2, 8, this.mvh);
                if (this.mtg == null) {
                    return 0;
                }
                aVar.e(3, this.mtg);
                return 0;
            }
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.mvh);
            if (this.mtg != null) {
                r0 += a.a.a.b.b.a.f(3, this.mtg);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mvh.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.mtg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Detail");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bm bmVar = (bm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bmVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a bqVar = new bq();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = bqVar.a(aVar4, bqVar, a.a(aVar4))) {
                        }
                        bmVar.mvh.add(bqVar);
                    }
                    return 0;
                case 3:
                    bmVar.mtg = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
