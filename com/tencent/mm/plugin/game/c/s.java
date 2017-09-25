package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class s extends a {
    public c msc;
    public String msk;
    public LinkedList<x> mth = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msc == null) {
                throw new b("Not all required fields were included: AppItem");
            }
            if (this.msc != null) {
                aVar.eQ(1, this.msc.aUk());
                this.msc.a(aVar);
            }
            aVar.d(2, 8, this.mth);
            if (this.msk == null) {
                return 0;
            }
            aVar.e(3, this.msk);
            return 0;
        } else if (i == 1) {
            if (this.msc != null) {
                r0 = a.a.a.a.eN(1, this.msc.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.mth);
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(3, this.msk);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mth.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msc != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppItem");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            s sVar = (s) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a cVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        cVar = new c();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        sVar.msc = cVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        cVar = new x();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        sVar.mth.add(cVar);
                    }
                    return 0;
                case 3:
                    sVar.msk = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
