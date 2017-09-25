package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class p extends a {
    public String ID;
    public long jNA;
    public int jND;
    public int jNE;
    public int jNF;
    public long jNG;
    public long jNH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.eO(2, this.jND);
            aVar.eO(3, this.jNE);
            aVar.eO(4, this.jNF);
            aVar.O(5, this.jNA);
            aVar.O(6, this.jNG);
            aVar.O(7, this.jNH);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = a.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            return (((((r0 + a.a.a.a.eL(2, this.jND)) + a.a.a.a.eL(3, this.jNE)) + a.a.a.a.eL(4, this.jNF)) + a.a.a.a.N(5, this.jNA)) + a.a.a.a.N(6, this.jNG)) + a.a.a.a.N(7, this.jNH);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.ID = aVar3.xmD.readString();
                    return 0;
                case 2:
                    pVar.jND = aVar3.xmD.mL();
                    return 0;
                case 3:
                    pVar.jNE = aVar3.xmD.mL();
                    return 0;
                case 4:
                    pVar.jNF = aVar3.xmD.mL();
                    return 0;
                case 5:
                    pVar.jNA = aVar3.xmD.mM();
                    return 0;
                case 6:
                    pVar.jNG = aVar3.xmD.mM();
                    return 0;
                case 7:
                    pVar.jNH = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
