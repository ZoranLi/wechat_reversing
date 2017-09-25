package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class sh extends a {
    public int jNW;
    public String tAk;
    public long tAl;
    public String tAm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tAk == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.tAm == null) {
                throw new b("Not all required fields were included: MimeType");
            } else {
                if (this.tAk != null) {
                    aVar.e(1, this.tAk);
                }
                aVar.O(2, this.tAl);
                aVar.eO(3, this.jNW);
                if (this.tAm == null) {
                    return 0;
                }
                aVar.e(4, this.tAm);
                return 0;
            }
        } else if (i == 1) {
            if (this.tAk != null) {
                r0 = a.a.a.b.b.a.f(1, this.tAk) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.N(2, this.tAl)) + a.a.a.a.eL(3, this.jNW);
            if (this.tAm != null) {
                r0 += a.a.a.b.b.a.f(4, this.tAm);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tAk == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.tAm != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MimeType");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            sh shVar = (sh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    shVar.tAk = aVar3.xmD.readString();
                    return 0;
                case 2:
                    shVar.tAl = aVar3.xmD.mM();
                    return 0;
                case 3:
                    shVar.jNW = aVar3.xmD.mL();
                    return 0;
                case 4:
                    shVar.tAm = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
