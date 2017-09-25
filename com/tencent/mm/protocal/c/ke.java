package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ke extends a {
    public String tql;
    public String tqm;
    public String tqn;
    public int tqo;
    public int tqp;
    public String tqq;
    public int tqr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tql != null) {
                aVar.e(1, this.tql);
            }
            if (this.tqm != null) {
                aVar.e(2, this.tqm);
            }
            if (this.tqn != null) {
                aVar.e(3, this.tqn);
            }
            aVar.eO(4, this.tqo);
            aVar.eO(5, this.tqp);
            if (this.tqq != null) {
                aVar.e(6, this.tqq);
            }
            aVar.eO(7, this.tqr);
            return 0;
        } else if (i == 1) {
            if (this.tql != null) {
                r0 = a.a.a.b.b.a.f(1, this.tql) + 0;
            } else {
                r0 = 0;
            }
            if (this.tqm != null) {
                r0 += a.a.a.b.b.a.f(2, this.tqm);
            }
            if (this.tqn != null) {
                r0 += a.a.a.b.b.a.f(3, this.tqn);
            }
            r0 = (r0 + a.a.a.a.eL(4, this.tqo)) + a.a.a.a.eL(5, this.tqp);
            if (this.tqq != null) {
                r0 += a.a.a.b.b.a.f(6, this.tqq);
            }
            return r0 + a.a.a.a.eL(7, this.tqr);
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
            ke keVar = (ke) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    keVar.tql = aVar3.xmD.readString();
                    return 0;
                case 2:
                    keVar.tqm = aVar3.xmD.readString();
                    return 0;
                case 3:
                    keVar.tqn = aVar3.xmD.readString();
                    return 0;
                case 4:
                    keVar.tqo = aVar3.xmD.mL();
                    return 0;
                case 5:
                    keVar.tqp = aVar3.xmD.mL();
                    return 0;
                case 6:
                    keVar.tqq = aVar3.xmD.readString();
                    return 0;
                case 7:
                    keVar.tqr = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
