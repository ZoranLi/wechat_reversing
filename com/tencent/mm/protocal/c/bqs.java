package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bqs extends a {
    public String fTO;
    public int type;
    public String uoL;
    public String uoM;
    public int uoN;
    public int uoO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.type);
            if (this.fTO != null) {
                aVar.e(2, this.fTO);
            }
            if (this.uoL != null) {
                aVar.e(3, this.uoL);
            }
            if (this.uoM != null) {
                aVar.e(4, this.uoM);
            }
            aVar.eO(5, this.uoN);
            aVar.eO(6, this.uoO);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.type) + 0;
            if (this.fTO != null) {
                r0 += a.a.a.b.b.a.f(2, this.fTO);
            }
            if (this.uoL != null) {
                r0 += a.a.a.b.b.a.f(3, this.uoL);
            }
            if (this.uoM != null) {
                r0 += a.a.a.b.b.a.f(4, this.uoM);
            }
            return (r0 + a.a.a.a.eL(5, this.uoN)) + a.a.a.a.eL(6, this.uoO);
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
            bqs com_tencent_mm_protocal_c_bqs = (bqs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bqs.type = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqs.fTO = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqs.uoL = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqs.uoM = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqs.uoN = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bqs.uoO = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
