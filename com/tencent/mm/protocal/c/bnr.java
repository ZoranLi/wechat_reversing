package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bnr extends a {
    public String fDC;
    public String opI;
    public String umH;
    public long umI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.umH == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.opI == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                if (this.umH != null) {
                    aVar.e(1, this.umH);
                }
                if (this.fDC != null) {
                    aVar.e(2, this.fDC);
                }
                if (this.opI != null) {
                    aVar.e(3, this.opI);
                }
                aVar.O(4, this.umI);
                return 0;
            }
        } else if (i == 1) {
            if (this.umH != null) {
                r0 = a.a.a.b.b.a.f(1, this.umH) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(3, this.opI);
            }
            return r0 + a.a.a.a.N(4, this.umI);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.umH == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.opI != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bnr com_tencent_mm_protocal_c_bnr = (bnr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bnr.umH = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnr.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bnr.opI = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bnr.umI = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
