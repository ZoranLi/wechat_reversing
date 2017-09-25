package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class by extends a {
    public String jNj;
    public int mvC;
    public long mvD;
    public String mvE;
    public boolean mvF;
    public int mvG;
    public String mvH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNj == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.jNj != null) {
                aVar.e(1, this.jNj);
            }
            aVar.eO(2, this.mvC);
            aVar.O(3, this.mvD);
            if (this.mvE != null) {
                aVar.e(4, this.mvE);
            }
            aVar.an(5, this.mvF);
            aVar.eO(6, this.mvG);
            if (this.mvH == null) {
                return 0;
            }
            aVar.e(7, this.mvH);
            return 0;
        } else if (i == 1) {
            if (this.jNj != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNj) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.mvC)) + a.a.a.a.N(3, this.mvD);
            if (this.mvE != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvE);
            }
            r0 = (r0 + (a.a.a.b.b.a.cH(5) + 1)) + a.a.a.a.eL(6, this.mvG);
            if (this.mvH != null) {
                r0 += a.a.a.b.b.a.f(7, this.mvH);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jNj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            by byVar = (by) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    byVar.mvC = aVar3.xmD.mL();
                    return 0;
                case 3:
                    byVar.mvD = aVar3.xmD.mM();
                    return 0;
                case 4:
                    byVar.mvE = aVar3.xmD.readString();
                    return 0;
                case 5:
                    byVar.mvF = aVar3.cib();
                    return 0;
                case 6:
                    byVar.mvG = aVar3.xmD.mL();
                    return 0;
                case 7:
                    byVar.mvH = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
