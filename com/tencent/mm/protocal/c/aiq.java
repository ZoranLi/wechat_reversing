package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aiq extends a {
    public String tID;
    public String tMA;
    public String tMy;
    public boolean tMz;
    public int tcm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tcm);
            if (this.tMy != null) {
                aVar.e(2, this.tMy);
            }
            aVar.an(3, this.tMz);
            if (this.tMA != null) {
                aVar.e(4, this.tMA);
            }
            if (this.tID != null) {
                aVar.e(5, this.tID);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tcm) + 0;
            if (this.tMy != null) {
                r0 += a.a.a.b.b.a.f(2, this.tMy);
            }
            r0 += a.a.a.b.b.a.cH(3) + 1;
            if (this.tMA != null) {
                r0 += a.a.a.b.b.a.f(4, this.tMA);
            }
            if (this.tID != null) {
                return r0 + a.a.a.b.b.a.f(5, this.tID);
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
            aiq com_tencent_mm_protocal_c_aiq = (aiq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aiq.tcm = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aiq.tMy = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aiq.tMz = aVar3.cib();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aiq.tMA = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aiq.tID = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
