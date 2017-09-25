package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class afc extends a {
    public String tKr;
    public String tKs;
    public int tKt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tKr != null) {
                aVar.e(1, this.tKr);
            }
            if (this.tKs != null) {
                aVar.e(2, this.tKs);
            }
            aVar.eO(3, this.tKt);
            return 0;
        } else if (i == 1) {
            if (this.tKr != null) {
                r0 = a.a.a.b.b.a.f(1, this.tKr) + 0;
            } else {
                r0 = 0;
            }
            if (this.tKs != null) {
                r0 += a.a.a.b.b.a.f(2, this.tKs);
            }
            return r0 + a.a.a.a.eL(3, this.tKt);
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
            afc com_tencent_mm_protocal_c_afc = (afc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afc.tKr = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afc.tKs = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afc.tKt = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
