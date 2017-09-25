package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;

public final class b extends a {
    public int jMP;
    public com.tencent.mm.bd.b jMQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jMP);
            if (this.jMQ != null) {
                aVar.b(2, this.jMQ);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.jMP) + 0;
            if (this.jMQ != null) {
                return r0 + a.a.a.a.a(2, this.jMQ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.jMP = aVar3.xmD.mL();
                    return 0;
                case 2:
                    bVar.jMQ = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
