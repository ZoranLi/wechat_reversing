package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class j extends a {
    public int msO;
    public String mse;
    public String msi;
    public String msj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msj == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.msi == null) {
                throw new b("Not all required fields were included: IconURL");
            } else {
                aVar.eO(1, this.msO);
                if (this.msj != null) {
                    aVar.e(2, this.msj);
                }
                if (this.msi != null) {
                    aVar.e(3, this.msi);
                }
                if (this.mse != null) {
                    aVar.e(4, this.mse);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.msO) + 0;
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(2, this.msj);
            }
            if (this.msi != null) {
                r0 += a.a.a.b.b.a.f(3, this.msi);
            }
            if (this.mse != null) {
                return r0 + a.a.a.b.b.a.f(4, this.mse);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msj == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.msi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jVar.msO = aVar3.xmD.mL();
                    return 0;
                case 2:
                    jVar.msj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    jVar.msi = aVar3.xmD.readString();
                    return 0;
                case 4:
                    jVar.mse = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
