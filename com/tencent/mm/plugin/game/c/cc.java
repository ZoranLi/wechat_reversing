package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class cc extends a {
    public String mse;
    public String msi;
    public String mvN;
    public String mvO;
    public String mvP;
    public boolean mvQ;
    public boolean mvR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msi != null) {
                aVar.e(1, this.msi);
            }
            if (this.mvN != null) {
                aVar.e(2, this.mvN);
            }
            if (this.mvO != null) {
                aVar.e(3, this.mvO);
            }
            if (this.mvP != null) {
                aVar.e(4, this.mvP);
            }
            if (this.mse != null) {
                aVar.e(5, this.mse);
            }
            aVar.an(6, this.mvQ);
            aVar.an(7, this.mvR);
            return 0;
        } else if (i == 1) {
            if (this.msi != null) {
                r0 = a.a.a.b.b.a.f(1, this.msi) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvN != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvN);
            }
            if (this.mvO != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvO);
            }
            if (this.mvP != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvP);
            }
            if (this.mse != null) {
                r0 += a.a.a.b.b.a.f(5, this.mse);
            }
            return (r0 + (a.a.a.b.b.a.cH(6) + 1)) + (a.a.a.b.b.a.cH(7) + 1);
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
            cc ccVar = (cc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccVar.msi = aVar3.xmD.readString();
                    return 0;
                case 2:
                    ccVar.mvN = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ccVar.mvO = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ccVar.mvP = aVar3.xmD.readString();
                    return 0;
                case 5:
                    ccVar.mse = aVar3.xmD.readString();
                    return 0;
                case 6:
                    ccVar.mvQ = aVar3.cib();
                    return 0;
                case 7:
                    ccVar.mvR = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
