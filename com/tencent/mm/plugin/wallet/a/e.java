package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bd.a;

public final class e extends a {
    public String rxJ;
    public String rxK;
    public String rxL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.rxJ != null) {
                aVar.e(1, this.rxJ);
            }
            if (this.rxK != null) {
                aVar.e(2, this.rxK);
            }
            if (this.rxL == null) {
                return 0;
            }
            aVar.e(3, this.rxL);
            return 0;
        } else if (i == 1) {
            if (this.rxJ != null) {
                r0 = a.a.a.b.b.a.f(1, this.rxJ) + 0;
            } else {
                r0 = 0;
            }
            if (this.rxK != null) {
                r0 += a.a.a.b.b.a.f(2, this.rxK);
            }
            if (this.rxL != null) {
                r0 += a.a.a.b.b.a.f(3, this.rxL);
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
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.rxJ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    eVar.rxK = aVar3.xmD.readString();
                    return 0;
                case 3:
                    eVar.rxL = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
