package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class ab extends a {
    public int jMP;
    public b jMQ;
    public long jNA;
    public int jOq;
    public int jOr;
    public long jOs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jMP);
            if (this.jMQ != null) {
                aVar.b(2, this.jMQ);
            }
            aVar.eO(3, this.jOq);
            aVar.eO(4, this.jOr);
            aVar.O(5, this.jOs);
            aVar.O(6, this.jNA);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.jMP) + 0;
            if (this.jMQ != null) {
                r0 += a.a.a.a.a(2, this.jMQ);
            }
            return (((r0 + a.a.a.a.eL(3, this.jOq)) + a.a.a.a.eL(4, this.jOr)) + a.a.a.a.N(5, this.jOs)) + a.a.a.a.N(6, this.jNA);
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
            ab abVar = (ab) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abVar.jMP = aVar3.xmD.mL();
                    return 0;
                case 2:
                    abVar.jMQ = aVar3.cic();
                    return 0;
                case 3:
                    abVar.jOq = aVar3.xmD.mL();
                    return 0;
                case 4:
                    abVar.jOr = aVar3.xmD.mL();
                    return 0;
                case 5:
                    abVar.jOs = aVar3.xmD.mM();
                    return 0;
                case 6:
                    abVar.jNA = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
