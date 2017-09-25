package com.tencent.mm.plugin.qqmail.b;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class i extends a {
    public String naK;
    public String name;
    public int ozH;
    public int ozI;
    public String ozJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.naK == null) {
                throw new b("Not all required fields were included: addr");
            } else {
                aVar.eO(1, this.ozH);
                if (this.name != null) {
                    aVar.e(2, this.name);
                }
                if (this.naK != null) {
                    aVar.e(3, this.naK);
                }
                aVar.eO(4, this.ozI);
                if (this.ozJ != null) {
                    aVar.e(5, this.ozJ);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.ozH) + 0;
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            if (this.naK != null) {
                r0 += a.a.a.b.b.a.f(3, this.naK);
            }
            r0 += a.a.a.a.eL(4, this.ozI);
            if (this.ozJ != null) {
                return r0 + a.a.a.b.b.a.f(5, this.ozJ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.naK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: addr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.ozH = aVar3.xmD.mL();
                    return 0;
                case 2:
                    iVar.name = aVar3.xmD.readString();
                    return 0;
                case 3:
                    iVar.naK = aVar3.xmD.readString();
                    return 0;
                case 4:
                    iVar.ozI = aVar3.xmD.mL();
                    return 0;
                case 5:
                    iVar.ozJ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
