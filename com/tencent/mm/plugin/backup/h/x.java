package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class x extends a {
    public b jMQ;
    public String jOf;
    public int jOg;
    public int jOh;
    public int jOi;
    public int jOj;
    public int jOk;
    public int jOl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jOf == null) {
                throw new a.a.a.b("Not all required fields were included: DataID");
            }
            if (this.jOf != null) {
                aVar.e(1, this.jOf);
            }
            aVar.eO(2, this.jOg);
            aVar.eO(3, this.jOh);
            aVar.eO(4, this.jOi);
            aVar.eO(5, this.jOj);
            aVar.eO(6, this.jOk);
            if (this.jMQ != null) {
                aVar.b(7, this.jMQ);
            }
            aVar.eO(8, this.jOl);
            return 0;
        } else if (i == 1) {
            if (this.jOf != null) {
                r0 = a.a.a.b.b.a.f(1, this.jOf) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.eL(2, this.jOg)) + a.a.a.a.eL(3, this.jOh)) + a.a.a.a.eL(4, this.jOi)) + a.a.a.a.eL(5, this.jOj)) + a.a.a.a.eL(6, this.jOk);
            if (this.jMQ != null) {
                r0 += a.a.a.a.a(7, this.jMQ);
            }
            return r0 + a.a.a.a.eL(8, this.jOl);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jOf != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: DataID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xVar.jOf = aVar3.xmD.readString();
                    return 0;
                case 2:
                    xVar.jOg = aVar3.xmD.mL();
                    return 0;
                case 3:
                    xVar.jOh = aVar3.xmD.mL();
                    return 0;
                case 4:
                    xVar.jOi = aVar3.xmD.mL();
                    return 0;
                case 5:
                    xVar.jOj = aVar3.xmD.mL();
                    return 0;
                case 6:
                    xVar.jOk = aVar3.xmD.mL();
                    return 0;
                case 7:
                    xVar.jMQ = aVar3.cic();
                    return 0;
                case 8:
                    xVar.jOl = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
