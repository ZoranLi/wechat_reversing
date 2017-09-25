package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class w extends a {
    public String ID;
    public b jMQ;
    public int jNB;
    public int jOa;
    public int jOb;
    public int jOc;
    public int jOd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new a.a.a.b("Not all required fields were included: ID");
            }
            aVar.eO(1, this.jOa);
            aVar.eO(2, this.jNB);
            if (this.ID != null) {
                aVar.e(3, this.ID);
            }
            if (this.jMQ != null) {
                aVar.b(4, this.jMQ);
            }
            aVar.eO(5, this.jOb);
            aVar.eO(6, this.jOc);
            aVar.eO(7, this.jOd);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.jOa) + 0) + a.a.a.a.eL(2, this.jNB);
            if (this.ID != null) {
                r0 += a.a.a.b.b.a.f(3, this.ID);
            }
            if (this.jMQ != null) {
                r0 += a.a.a.a.a(4, this.jMQ);
            }
            return ((r0 + a.a.a.a.eL(5, this.jOb)) + a.a.a.a.eL(6, this.jOc)) + a.a.a.a.eL(7, this.jOd);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wVar.jOa = aVar3.xmD.mL();
                    return 0;
                case 2:
                    wVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 3:
                    wVar.ID = aVar3.xmD.readString();
                    return 0;
                case 4:
                    wVar.jMQ = aVar3.cic();
                    return 0;
                case 5:
                    wVar.jOb = aVar3.xmD.mL();
                    return 0;
                case 6:
                    wVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 7:
                    wVar.jOd = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
