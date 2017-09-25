package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class ae extends a {
    public b jMQ;
    public int jNB;
    public String jOf;
    public int jOg;
    public int jOi;
    public int jOj;
    public int jOk;

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
            aVar.eO(3, this.jOi);
            aVar.eO(4, this.jOj);
            aVar.eO(5, this.jNB);
            aVar.eO(6, this.jOk);
            if (this.jMQ == null) {
                return 0;
            }
            aVar.b(7, this.jMQ);
            return 0;
        } else if (i == 1) {
            if (this.jOf != null) {
                r0 = a.a.a.b.b.a.f(1, this.jOf) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.eL(2, this.jOg)) + a.a.a.a.eL(3, this.jOi)) + a.a.a.a.eL(4, this.jOj)) + a.a.a.a.eL(5, this.jNB)) + a.a.a.a.eL(6, this.jOk);
            if (this.jMQ != null) {
                r0 += a.a.a.a.a(7, this.jMQ);
            }
            return r0;
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
            ae aeVar = (ae) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aeVar.jOf = aVar3.xmD.readString();
                    return 0;
                case 2:
                    aeVar.jOg = aVar3.xmD.mL();
                    return 0;
                case 3:
                    aeVar.jOi = aVar3.xmD.mL();
                    return 0;
                case 4:
                    aeVar.jOj = aVar3.xmD.mL();
                    return 0;
                case 5:
                    aeVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 6:
                    aeVar.jOk = aVar3.xmD.mL();
                    return 0;
                case 7:
                    aeVar.jMQ = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
