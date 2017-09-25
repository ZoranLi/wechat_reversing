package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bw extends a {
    public c msc;
    public String msg;
    public boolean msq;
    public LinkedList<String> msr = new LinkedList();

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
            aVar.an(3, this.msq);
            aVar.d(4, 1, this.msr);
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
            return (r0 + (a.a.a.b.b.a.cH(3) + 1)) + a.a.a.a.c(4, 1, this.msr);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.msr.clear();
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
            bw bwVar = (bw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a cVar = new c();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        bwVar.msc = cVar;
                    }
                    return 0;
                case 2:
                    bwVar.msg = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bwVar.msq = aVar3.cib();
                    return 0;
                case 4:
                    bwVar.msr.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
