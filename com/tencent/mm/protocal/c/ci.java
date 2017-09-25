package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ci extends a {
    public String fNG;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fNG == null) {
                throw new b("Not all required fields were included: wording");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else {
                aVar.eO(1, this.type);
                if (this.fNG != null) {
                    aVar.e(2, this.fNG);
                }
                if (this.url != null) {
                    aVar.e(3, this.url);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.type) + 0;
            if (this.fNG != null) {
                r0 += a.a.a.b.b.a.f(2, this.fNG);
            }
            if (this.url != null) {
                return r0 + a.a.a.b.b.a.f(3, this.url);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.fNG == null) {
                throw new b("Not all required fields were included: wording");
            } else if (this.url != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ci ciVar = (ci) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ciVar.type = aVar3.xmD.mL();
                    return 0;
                case 2:
                    ciVar.fNG = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ciVar.url = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
