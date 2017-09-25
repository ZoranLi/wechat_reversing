package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ir extends a {
    public int kfr;
    public String text;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.kfr);
            if (this.text != null) {
                aVar.e(2, this.text);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.kfr) + 0;
            if (this.text != null) {
                r0 += a.a.a.b.b.a.f(2, this.text);
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
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ir irVar = (ir) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    irVar.kfr = aVar3.xmD.mL();
                    return 0;
                case 2:
                    irVar.text = aVar3.xmD.readString();
                    return 0;
                case 3:
                    irVar.url = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
