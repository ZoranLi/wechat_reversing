package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class i extends a {
    public String msK;
    public String msL;
    public String msM;
    public String msN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msK == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.msL == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.msM == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.msN == null) {
                throw new b("Not all required fields were included: Url");
            } else {
                if (this.msK != null) {
                    aVar.e(1, this.msK);
                }
                if (this.msL != null) {
                    aVar.e(2, this.msL);
                }
                if (this.msM != null) {
                    aVar.e(3, this.msM);
                }
                if (this.msN == null) {
                    return 0;
                }
                aVar.e(4, this.msN);
                return 0;
            }
        } else if (i == 1) {
            if (this.msK != null) {
                r0 = a.a.a.b.b.a.f(1, this.msK) + 0;
            } else {
                r0 = 0;
            }
            if (this.msL != null) {
                r0 += a.a.a.b.b.a.f(2, this.msL);
            }
            if (this.msM != null) {
                r0 += a.a.a.b.b.a.f(3, this.msM);
            }
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(4, this.msN);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msK == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.msL == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.msM == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.msN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.msK = aVar3.xmD.readString();
                    return 0;
                case 2:
                    iVar.msL = aVar3.xmD.readString();
                    return 0;
                case 3:
                    iVar.msM = aVar3.xmD.readString();
                    return 0;
                case 4:
                    iVar.msN = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
