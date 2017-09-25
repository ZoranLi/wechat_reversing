package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bhh extends a {
    public int tgJ;
    public int tgK;
    public String tuy;
    public b ugU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ugU == null) {
                throw new a.a.a.b("Not all required fields were included: EmojiBuffer");
            }
            if (this.tuy != null) {
                aVar.e(1, this.tuy);
            }
            aVar.eO(2, this.tgK);
            aVar.eO(3, this.tgJ);
            if (this.ugU == null) {
                return 0;
            }
            aVar.b(4, this.ugU);
            return 0;
        } else if (i == 1) {
            if (this.tuy != null) {
                r0 = a.a.a.b.b.a.f(1, this.tuy) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tgK)) + a.a.a.a.eL(3, this.tgJ);
            if (this.ugU != null) {
                r0 += a.a.a.a.a(4, this.ugU);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ugU != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: EmojiBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhh com_tencent_mm_protocal_c_bhh = (bhh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bhh.tuy = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhh.tgK = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhh.tgJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhh.ugU = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
