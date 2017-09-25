package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aod extends a {
    public String desc;
    public String iNB;
    public String scope;
    public int tTm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.eO(3, this.tTm);
            if (this.iNB == null) {
                return 0;
            }
            aVar.e(4, this.iNB);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                r0 = a.a.a.b.b.a.f(1, this.scope) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(2, this.desc);
            }
            r0 += a.a.a.a.eL(3, this.tTm);
            if (this.iNB != null) {
                r0 += a.a.a.b.b.a.f(4, this.iNB);
            }
            return r0;
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
            aod com_tencent_mm_protocal_c_aod = (aod) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aod.scope = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aod.desc = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aod.tTm = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aod.iNB = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
