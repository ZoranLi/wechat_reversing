package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class rz extends a {
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;
    public boolean txb = false;
    public boolean txc = false;
    public boolean tzi = false;
    public boolean tzj = false;

    public final rz OM(String str) {
        this.title = str;
        this.txb = true;
        return this;
    }

    public final rz ON(String str) {
        this.desc = str;
        this.txc = true;
        return this;
    }

    public final rz OO(String str) {
        this.thumbUrl = str;
        this.tzi = true;
        return this;
    }

    public final rz OP(String str) {
        this.info = str;
        this.tzj = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.thumbUrl != null) {
                aVar.e(3, this.thumbUrl);
            }
            if (this.info == null) {
                return 0;
            }
            aVar.e(4, this.info);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(2, this.desc);
            }
            if (this.thumbUrl != null) {
                r0 += a.a.a.b.b.a.f(3, this.thumbUrl);
            }
            if (this.info != null) {
                r0 += a.a.a.b.b.a.f(4, this.info);
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
            rz rzVar = (rz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rzVar.title = aVar3.xmD.readString();
                    rzVar.txb = true;
                    return 0;
                case 2:
                    rzVar.desc = aVar3.xmD.readString();
                    rzVar.txc = true;
                    return 0;
                case 3:
                    rzVar.thumbUrl = aVar3.xmD.readString();
                    rzVar.tzi = true;
                    return 0;
                case 4:
                    rzVar.info = aVar3.xmD.readString();
                    rzVar.tzj = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
