package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ej extends a {
    public String mMa;
    public String ofd;
    public String ofe;
    public String rBT;
    public String tip;
    public String tiq;
    public String tir;
    public String tis;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tip != null) {
                aVar.e(1, this.tip);
            }
            if (this.rBT != null) {
                aVar.e(2, this.rBT);
            }
            if (this.ofd != null) {
                aVar.e(3, this.ofd);
            }
            if (this.ofe != null) {
                aVar.e(4, this.ofe);
            }
            if (this.mMa != null) {
                aVar.e(5, this.mMa);
            }
            if (this.tiq != null) {
                aVar.e(6, this.tiq);
            }
            if (this.tir != null) {
                aVar.e(7, this.tir);
            }
            if (this.tis == null) {
                return 0;
            }
            aVar.e(8, this.tis);
            return 0;
        } else if (i == 1) {
            if (this.tip != null) {
                r0 = a.a.a.b.b.a.f(1, this.tip) + 0;
            } else {
                r0 = 0;
            }
            if (this.rBT != null) {
                r0 += a.a.a.b.b.a.f(2, this.rBT);
            }
            if (this.ofd != null) {
                r0 += a.a.a.b.b.a.f(3, this.ofd);
            }
            if (this.ofe != null) {
                r0 += a.a.a.b.b.a.f(4, this.ofe);
            }
            if (this.mMa != null) {
                r0 += a.a.a.b.b.a.f(5, this.mMa);
            }
            if (this.tiq != null) {
                r0 += a.a.a.b.b.a.f(6, this.tiq);
            }
            if (this.tir != null) {
                r0 += a.a.a.b.b.a.f(7, this.tir);
            }
            if (this.tis != null) {
                r0 += a.a.a.b.b.a.f(8, this.tis);
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
            ej ejVar = (ej) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ejVar.tip = aVar3.xmD.readString();
                    return 0;
                case 2:
                    ejVar.rBT = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ejVar.ofd = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ejVar.ofe = aVar3.xmD.readString();
                    return 0;
                case 5:
                    ejVar.mMa = aVar3.xmD.readString();
                    return 0;
                case 6:
                    ejVar.tiq = aVar3.xmD.readString();
                    return 0;
                case 7:
                    ejVar.tir = aVar3.xmD.readString();
                    return 0;
                case 8:
                    ejVar.tis = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
