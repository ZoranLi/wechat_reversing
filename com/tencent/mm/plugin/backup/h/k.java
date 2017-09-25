package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class k extends a {
    public int jNh;
    public int jNi;
    public String jNj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNj == null) {
                throw new b("Not all required fields were included: UserName");
            }
            aVar.eO(1, this.jNh);
            aVar.eO(2, this.jNi);
            if (this.jNj != null) {
                aVar.e(3, this.jNj);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.jNh) + 0) + a.a.a.a.eL(2, this.jNi);
            if (this.jNj != null) {
                return r0 + a.a.a.b.b.a.f(3, this.jNj);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jNj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.jNh = aVar3.xmD.mL();
                    return 0;
                case 2:
                    kVar.jNi = aVar3.xmD.mL();
                    return 0;
                case 3:
                    kVar.jNj = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
