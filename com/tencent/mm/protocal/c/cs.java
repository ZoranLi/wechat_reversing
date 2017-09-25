package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class cs extends a {
    public String tfO;
    public String tfP;
    public String tfQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfO != null) {
                aVar.e(1, this.tfO);
            }
            if (this.tfP != null) {
                aVar.e(2, this.tfP);
            }
            if (this.tfQ == null) {
                return 0;
            }
            aVar.e(3, this.tfQ);
            return 0;
        } else if (i == 1) {
            if (this.tfO != null) {
                r0 = a.a.a.b.b.a.f(1, this.tfO) + 0;
            } else {
                r0 = 0;
            }
            if (this.tfP != null) {
                r0 += a.a.a.b.b.a.f(2, this.tfP);
            }
            if (this.tfQ != null) {
                r0 += a.a.a.b.b.a.f(3, this.tfQ);
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
            cs csVar = (cs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csVar.tfO = aVar3.xmD.readString();
                    return 0;
                case 2:
                    csVar.tfP = aVar3.xmD.readString();
                    return 0;
                case 3:
                    csVar.tfQ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
