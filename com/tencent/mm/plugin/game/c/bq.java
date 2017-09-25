package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bq extends a {
    public int mvo;
    public String mvp;
    public String mvq;
    public boolean mvr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mvq == null) {
                throw new b("Not all required fields were included: MediaURL");
            }
            aVar.eO(1, this.mvo);
            if (this.mvp != null) {
                aVar.e(2, this.mvp);
            }
            if (this.mvq != null) {
                aVar.e(3, this.mvq);
            }
            aVar.an(4, this.mvr);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.mvo) + 0;
            if (this.mvp != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvp);
            }
            if (this.mvq != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvq);
            }
            return r0 + (a.a.a.b.b.a.cH(4) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mvq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: MediaURL");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bq bqVar = (bq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqVar.mvo = aVar3.xmD.mL();
                    return 0;
                case 2:
                    bqVar.mvp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bqVar.mvq = aVar3.xmD.readString();
                    return 0;
                case 4:
                    bqVar.mvr = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
