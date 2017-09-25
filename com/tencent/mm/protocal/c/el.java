package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class el extends a {
    public String imei;
    public String tix;
    public String tiy;
    public String tiz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.imei != null) {
                aVar.e(1, this.imei);
            }
            if (this.tix != null) {
                aVar.e(2, this.tix);
            }
            if (this.tiy != null) {
                aVar.e(3, this.tiy);
            }
            if (this.tiz == null) {
                return 0;
            }
            aVar.e(4, this.tiz);
            return 0;
        } else if (i == 1) {
            if (this.imei != null) {
                r0 = a.a.a.b.b.a.f(1, this.imei) + 0;
            } else {
                r0 = 0;
            }
            if (this.tix != null) {
                r0 += a.a.a.b.b.a.f(2, this.tix);
            }
            if (this.tiy != null) {
                r0 += a.a.a.b.b.a.f(3, this.tiy);
            }
            if (this.tiz != null) {
                r0 += a.a.a.b.b.a.f(4, this.tiz);
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
            el elVar = (el) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    elVar.imei = aVar3.xmD.readString();
                    return 0;
                case 2:
                    elVar.tix = aVar3.xmD.readString();
                    return 0;
                case 3:
                    elVar.tiy = aVar3.xmD.readString();
                    return 0;
                case 4:
                    elVar.tiz = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
