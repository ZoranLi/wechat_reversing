package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class dq extends a {
    public String scope;
    public int state;
    public String thc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            if (this.thc != null) {
                aVar.e(2, this.thc);
            }
            aVar.eO(3, this.state);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                r0 = a.a.a.b.b.a.f(1, this.scope) + 0;
            } else {
                r0 = 0;
            }
            if (this.thc != null) {
                r0 += a.a.a.b.b.a.f(2, this.thc);
            }
            return r0 + a.a.a.a.eL(3, this.state);
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
            dq dqVar = (dq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dqVar.scope = aVar3.xmD.readString();
                    return 0;
                case 2:
                    dqVar.thc = aVar3.xmD.readString();
                    return 0;
                case 3:
                    dqVar.state = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
