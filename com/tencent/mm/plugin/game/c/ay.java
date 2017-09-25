package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;

public final class ay extends a {
    public String desc;
    public String hSW;
    public String muN;
    public String muO;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.hSW != null) {
                aVar.e(2, this.hSW);
            }
            if (this.muN != null) {
                aVar.e(3, this.muN);
            }
            if (this.desc != null) {
                aVar.e(4, this.desc);
            }
            if (this.muO == null) {
                return 0;
            }
            aVar.e(5, this.muO);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.hSW != null) {
                r0 += a.a.a.b.b.a.f(2, this.hSW);
            }
            if (this.muN != null) {
                r0 += a.a.a.b.b.a.f(3, this.muN);
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(4, this.desc);
            }
            if (this.muO != null) {
                r0 += a.a.a.b.b.a.f(5, this.muO);
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
            ay ayVar = (ay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayVar.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    ayVar.hSW = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ayVar.muN = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ayVar.desc = aVar3.xmD.readString();
                    return 0;
                case 5:
                    ayVar.muO = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
