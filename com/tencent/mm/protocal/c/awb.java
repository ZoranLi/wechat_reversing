package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class awb extends a {
    public int jNd;
    public String tGj;
    public String tVO;
    public String tVP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tGj != null) {
                aVar.e(1, this.tGj);
            }
            if (this.tVP != null) {
                aVar.e(2, this.tVP);
            }
            aVar.eO(3, this.jNd);
            if (this.tVO == null) {
                return 0;
            }
            aVar.e(4, this.tVO);
            return 0;
        } else if (i == 1) {
            if (this.tGj != null) {
                r0 = a.a.a.b.b.a.f(1, this.tGj) + 0;
            } else {
                r0 = 0;
            }
            if (this.tVP != null) {
                r0 += a.a.a.b.b.a.f(2, this.tVP);
            }
            r0 += a.a.a.a.eL(3, this.jNd);
            if (this.tVO != null) {
                r0 += a.a.a.b.b.a.f(4, this.tVO);
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
            awb com_tencent_mm_protocal_c_awb = (awb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_awb.tGj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awb.tVP = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awb.jNd = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awb.tVO = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
