package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ad extends a {
    public String jOf;
    public int jOg;
    public int jOi;
    public int jOj;
    public int jOl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jOf == null) {
                throw new b("Not all required fields were included: DataID");
            }
            if (this.jOf != null) {
                aVar.e(1, this.jOf);
            }
            aVar.eO(2, this.jOg);
            aVar.eO(3, this.jOi);
            aVar.eO(4, this.jOj);
            aVar.eO(5, this.jOl);
            return 0;
        } else if (i == 1) {
            if (this.jOf != null) {
                r0 = a.a.a.b.b.a.f(1, this.jOf) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.eL(2, this.jOg)) + a.a.a.a.eL(3, this.jOi)) + a.a.a.a.eL(4, this.jOj)) + a.a.a.a.eL(5, this.jOl);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jOf != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DataID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ad adVar = (ad) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    adVar.jOf = aVar3.xmD.readString();
                    return 0;
                case 2:
                    adVar.jOg = aVar3.xmD.mL();
                    return 0;
                case 3:
                    adVar.jOi = aVar3.xmD.mL();
                    return 0;
                case 4:
                    adVar.jOj = aVar3.xmD.mL();
                    return 0;
                case 5:
                    adVar.jOl = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
