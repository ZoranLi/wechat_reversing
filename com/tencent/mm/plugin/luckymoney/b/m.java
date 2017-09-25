package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bd.a;

public final class m extends a {
    public long nmK;
    public String nmL;
    public String nmX;
    public String nmY;
    public String nmZ;
    public String nmp;
    public String nna;
    public String userName;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.nmX != null) {
                aVar.e(1, this.nmX);
            }
            if (this.nmY != null) {
                aVar.e(2, this.nmY);
            }
            aVar.O(3, this.nmK);
            if (this.nmL != null) {
                aVar.e(4, this.nmL);
            }
            if (this.nmZ != null) {
                aVar.e(5, this.nmZ);
            }
            if (this.nmp != null) {
                aVar.e(6, this.nmp);
            }
            if (this.nna != null) {
                aVar.e(7, this.nna);
            }
            if (this.userName == null) {
                return 0;
            }
            aVar.e(8, this.userName);
            return 0;
        } else if (i == 1) {
            if (this.nmX != null) {
                r0 = a.a.a.b.b.a.f(1, this.nmX) + 0;
            } else {
                r0 = 0;
            }
            if (this.nmY != null) {
                r0 += a.a.a.b.b.a.f(2, this.nmY);
            }
            r0 += a.a.a.a.N(3, this.nmK);
            if (this.nmL != null) {
                r0 += a.a.a.b.b.a.f(4, this.nmL);
            }
            if (this.nmZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.nmZ);
            }
            if (this.nmp != null) {
                r0 += a.a.a.b.b.a.f(6, this.nmp);
            }
            if (this.nna != null) {
                r0 += a.a.a.b.b.a.f(7, this.nna);
            }
            if (this.userName != null) {
                r0 += a.a.a.b.b.a.f(8, this.userName);
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
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.nmX = aVar3.xmD.readString();
                    return 0;
                case 2:
                    mVar.nmY = aVar3.xmD.readString();
                    return 0;
                case 3:
                    mVar.nmK = aVar3.xmD.mM();
                    return 0;
                case 4:
                    mVar.nmL = aVar3.xmD.readString();
                    return 0;
                case 5:
                    mVar.nmZ = aVar3.xmD.readString();
                    return 0;
                case 6:
                    mVar.nmp = aVar3.xmD.readString();
                    return 0;
                case 7:
                    mVar.nna = aVar3.xmD.readString();
                    return 0;
                case 8:
                    mVar.userName = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
