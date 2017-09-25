package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class rs extends a {
    public int fOd;
    public String fRX;
    public String label;
    public double lat;
    public double lng;
    public boolean tzd = false;
    public boolean tze = false;
    public boolean tzf = false;
    public boolean tzg = false;
    public boolean tzh = false;

    public final rs l(double d) {
        this.lng = d;
        this.tzd = true;
        return this;
    }

    public final rs m(double d) {
        this.lat = d;
        this.tze = true;
        return this;
    }

    public final rs yf(int i) {
        this.fOd = i;
        this.tzf = true;
        return this;
    }

    public final rs Ou(String str) {
        this.label = str;
        this.tzg = true;
        return this;
    }

    public final rs Ov(String str) {
        this.fRX = str;
        this.tzh = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tzd) {
                aVar.a(1, this.lng);
            }
            if (this.tze) {
                aVar.a(2, this.lat);
            }
            if (this.tzf) {
                aVar.eO(3, this.fOd);
            }
            if (this.label != null) {
                aVar.e(4, this.label);
            }
            if (this.fRX == null) {
                return 0;
            }
            aVar.e(5, this.fRX);
            return 0;
        } else if (i == 1) {
            if (this.tzd) {
                r0 = (a.a.a.b.b.a.cH(1) + 8) + 0;
            } else {
                r0 = 0;
            }
            if (this.tze) {
                r0 += a.a.a.b.b.a.cH(2) + 8;
            }
            if (this.tzf) {
                r0 += a.a.a.a.eL(3, this.fOd);
            }
            if (this.label != null) {
                r0 += a.a.a.b.b.a.f(4, this.label);
            }
            if (this.fRX != null) {
                r0 += a.a.a.b.b.a.f(5, this.fRX);
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
            rs rsVar = (rs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rsVar.lng = aVar3.xmD.readDouble();
                    rsVar.tzd = true;
                    return 0;
                case 2:
                    rsVar.lat = aVar3.xmD.readDouble();
                    rsVar.tze = true;
                    return 0;
                case 3:
                    rsVar.fOd = aVar3.xmD.mL();
                    rsVar.tzf = true;
                    return 0;
                case 4:
                    rsVar.label = aVar3.xmD.readString();
                    rsVar.tzg = true;
                    return 0;
                case 5:
                    rsVar.fRX = aVar3.xmD.readString();
                    rsVar.tzh = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
