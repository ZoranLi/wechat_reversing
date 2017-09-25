package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class amb extends a {
    public String jNj;
    public int oTE;
    public int tQD;
    public String ttq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttq != null) {
                aVar.e(1, this.ttq);
            }
            if (this.jNj != null) {
                aVar.e(2, this.jNj);
            }
            aVar.eO(3, this.tQD);
            aVar.eO(4, this.oTE);
            return 0;
        } else if (i == 1) {
            if (this.ttq != null) {
                r0 = a.a.a.b.b.a.f(1, this.ttq) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            return (r0 + a.a.a.a.eL(3, this.tQD)) + a.a.a.a.eL(4, this.oTE);
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
            amb com_tencent_mm_protocal_c_amb = (amb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_amb.ttq = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amb.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amb.tQD = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_amb.oTE = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
