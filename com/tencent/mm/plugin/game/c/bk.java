package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bk extends a {
    public c msc;
    public String mvg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msc == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.mvg == null) {
                throw new b("Not all required fields were included: Rank");
            } else {
                if (this.msc != null) {
                    aVar.eQ(1, this.msc.aUk());
                    this.msc.a(aVar);
                }
                if (this.mvg == null) {
                    return 0;
                }
                aVar.e(2, this.mvg);
                return 0;
            }
        } else if (i == 1) {
            if (this.msc != null) {
                r0 = a.a.a.a.eN(1, this.msc.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvg != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvg);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msc == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.mvg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Rank");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bk bkVar = (bk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a cVar = new c();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        bkVar.msc = cVar;
                    }
                    return 0;
                case 2:
                    bkVar.mvg = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
