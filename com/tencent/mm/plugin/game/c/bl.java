package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bl extends a {
    public String fDC;
    public String mse;
    public String msi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msi == null) {
                throw new b("Not all required fields were included: IconURL");
            }
            if (this.msi != null) {
                aVar.e(1, this.msi);
            }
            if (this.fDC != null) {
                aVar.e(2, this.fDC);
            }
            if (this.mse == null) {
                return 0;
            }
            aVar.e(3, this.mse);
            return 0;
        } else if (i == 1) {
            if (this.msi != null) {
                r0 = a.a.a.b.b.a.f(1, this.msi) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            if (this.mse != null) {
                r0 += a.a.a.b.b.a.f(3, this.mse);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msi != null) {
                return 0;
            }
            throw new b("Not all required fields were included: IconURL");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bl blVar = (bl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    blVar.msi = aVar3.xmD.readString();
                    return 0;
                case 2:
                    blVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    blVar.mse = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
