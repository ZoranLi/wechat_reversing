package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class sf extends a {
    public String canvasPageXml;
    public String desc;
    public int hhv;
    public String thumbUrl;
    public String title;
    public boolean txb = false;
    public boolean txc = false;
    public boolean tyn = false;
    public String tzN;
    public boolean tzO = false;
    public int tzP;
    public boolean tzQ = false;
    public boolean tzR = false;
    public boolean tzi = false;

    public final sf OQ(String str) {
        this.title = str;
        this.txb = true;
        return this;
    }

    public final sf OR(String str) {
        this.desc = str;
        this.txc = true;
        return this;
    }

    public final sf OS(String str) {
        this.tzN = str;
        this.tzO = true;
        return this;
    }

    public final sf OT(String str) {
        this.thumbUrl = str;
        this.tzi = true;
        return this;
    }

    public final sf yk(int i) {
        this.tzP = i;
        this.tzQ = true;
        return this;
    }

    public final sf yl(int i) {
        this.hhv = i;
        this.tzR = true;
        return this;
    }

    public final sf OU(String str) {
        this.canvasPageXml = str;
        this.tyn = true;
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
            if (this.tzN != null) {
                aVar.e(3, this.tzN);
            }
            if (this.thumbUrl != null) {
                aVar.e(4, this.thumbUrl);
            }
            if (this.tzQ) {
                aVar.eO(5, this.tzP);
            }
            if (this.tzR) {
                aVar.eO(6, this.hhv);
            }
            if (this.canvasPageXml == null) {
                return 0;
            }
            aVar.e(7, this.canvasPageXml);
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
            if (this.tzN != null) {
                r0 += a.a.a.b.b.a.f(3, this.tzN);
            }
            if (this.thumbUrl != null) {
                r0 += a.a.a.b.b.a.f(4, this.thumbUrl);
            }
            if (this.tzQ) {
                r0 += a.a.a.a.eL(5, this.tzP);
            }
            if (this.tzR) {
                r0 += a.a.a.a.eL(6, this.hhv);
            }
            if (this.canvasPageXml != null) {
                r0 += a.a.a.b.b.a.f(7, this.canvasPageXml);
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
            sf sfVar = (sf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sfVar.title = aVar3.xmD.readString();
                    sfVar.txb = true;
                    return 0;
                case 2:
                    sfVar.desc = aVar3.xmD.readString();
                    sfVar.txc = true;
                    return 0;
                case 3:
                    sfVar.tzN = aVar3.xmD.readString();
                    sfVar.tzO = true;
                    return 0;
                case 4:
                    sfVar.thumbUrl = aVar3.xmD.readString();
                    sfVar.tzi = true;
                    return 0;
                case 5:
                    sfVar.tzP = aVar3.xmD.mL();
                    sfVar.tzQ = true;
                    return 0;
                case 6:
                    sfVar.hhv = aVar3.xmD.mL();
                    sfVar.tzR = true;
                    return 0;
                case 7:
                    sfVar.canvasPageXml = aVar3.xmD.readString();
                    sfVar.tyn = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
