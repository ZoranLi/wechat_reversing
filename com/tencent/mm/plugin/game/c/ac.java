package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ac extends a {
    public String msG;
    public c msc;
    public String msg;
    public LinkedList<ad> mtA = new LinkedList();

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
            if (this.msg != null) {
                aVar.e(2, this.msg);
            }
            aVar.d(3, 8, this.mtA);
            if (this.msG == null) {
                return 0;
            }
            aVar.e(4, this.msG);
            return 0;
        } else if (i == 1) {
            if (this.msc != null) {
                r0 = a.a.a.a.eN(1, this.msc.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.msg != null) {
                r0 += a.a.a.b.b.a.f(2, this.msg);
            }
            r0 += a.a.a.a.c(3, 8, this.mtA);
            if (this.msG != null) {
                r0 += a.a.a.b.b.a.f(4, this.msG);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mtA.clear();
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
            ac acVar = (ac) objArr[1];
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
                        acVar.msc = cVar;
                    }
                    return 0;
                case 2:
                    acVar.msg = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        cVar = new ad();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        acVar.mtA.add(cVar);
                    }
                    return 0;
                case 4:
                    acVar.msG = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
