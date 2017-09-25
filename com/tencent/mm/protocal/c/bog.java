package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bog extends a {
    public b tgI;
    public long umI;
    public int unb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgI == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            }
            aVar.O(1, this.umI);
            if (this.tgI != null) {
                aVar.b(2, this.tgI);
            }
            aVar.eO(3, this.unb);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.umI) + 0;
            if (this.tgI != null) {
                r0 += a.a.a.a.a(2, this.tgI);
            }
            return r0 + a.a.a.a.eL(3, this.unb);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tgI != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: VoiceData");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bog com_tencent_mm_protocal_c_bog = (bog) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bog.umI = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bog.tgI = aVar3.cic();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bog.unb = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
