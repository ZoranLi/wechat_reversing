package com.tencent.mm.protocal.b.a;

import a.a.a.b;

public final class a extends com.tencent.mm.bd.a {
    public int actionType;
    public int id;
    public String tbd;
    public String tbe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tbd == null) {
                throw new b("Not all required fields were included: btnStr");
            }
            aVar.eO(1, this.id);
            aVar.eO(2, this.actionType);
            if (this.tbd != null) {
                aVar.e(3, this.tbd);
            }
            if (this.tbe != null) {
                aVar.e(4, this.tbe);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.id) + 0) + a.a.a.a.eL(2, this.actionType);
            if (this.tbd != null) {
                r0 += a.a.a.b.b.a.f(3, this.tbd);
            }
            if (this.tbe != null) {
                return r0 + a.a.a.b.b.a.f(4, this.tbe);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tbd != null) {
                return 0;
            }
            throw new b("Not all required fields were included: btnStr");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.id = aVar3.xmD.mL();
                    return 0;
                case 2:
                    aVar4.actionType = aVar3.xmD.mL();
                    return 0;
                case 3:
                    aVar4.tbd = aVar3.xmD.readString();
                    return 0;
                case 4:
                    aVar4.tbe = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
