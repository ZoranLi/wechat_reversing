package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ru extends a {
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;
    public boolean txb = false;
    public boolean txc = false;
    public int type;
    public boolean tzi = false;
    public boolean tzj = false;
    public boolean tzk = false;

    public final ru Ow(String str) {
        this.title = str;
        this.txb = true;
        return this;
    }

    public final ru Ox(String str) {
        this.desc = str;
        this.txc = true;
        return this;
    }

    public final ru Oy(String str) {
        this.thumbUrl = str;
        this.tzi = true;
        return this;
    }

    public final ru Oz(String str) {
        this.info = str;
        this.tzj = true;
        return this;
    }

    public final ru yg(int i) {
        this.type = i;
        this.tzk = true;
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
            if (this.info != null) {
                aVar.e(4, this.info);
            }
            if (!this.tzk) {
                return 0;
            }
            aVar.eO(5, this.type);
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
            if (this.tzk) {
                r0 += a.a.a.a.eL(5, this.type);
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
            ru ruVar = (ru) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ruVar.title = aVar3.xmD.readString();
                    ruVar.txb = true;
                    return 0;
                case 2:
                    ruVar.desc = aVar3.xmD.readString();
                    ruVar.txc = true;
                    return 0;
                case 3:
                    ruVar.thumbUrl = aVar3.xmD.readString();
                    ruVar.tzi = true;
                    return 0;
                case 4:
                    ruVar.info = aVar3.xmD.readString();
                    ruVar.tzj = true;
                    return 0;
                case 5:
                    ruVar.type = aVar3.xmD.mL();
                    ruVar.tzk = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
