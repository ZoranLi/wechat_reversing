package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bqx extends a {
    public String mvX;
    public String mvZ;
    public String mwa;
    public int mwb;
    public String tky;
    public int uoT;
    public String uoU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.uoT);
            if (this.tky != null) {
                aVar.e(2, this.tky);
            }
            if (this.mvX != null) {
                aVar.e(3, this.mvX);
            }
            if (this.uoU != null) {
                aVar.e(4, this.uoU);
            }
            if (this.mvZ != null) {
                aVar.e(5, this.mvZ);
            }
            if (this.mwa != null) {
                aVar.e(6, this.mwa);
            }
            aVar.eO(7, this.mwb);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.uoT) + 0;
            if (this.tky != null) {
                r0 += a.a.a.b.b.a.f(2, this.tky);
            }
            if (this.mvX != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvX);
            }
            if (this.uoU != null) {
                r0 += a.a.a.b.b.a.f(4, this.uoU);
            }
            if (this.mvZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.mvZ);
            }
            if (this.mwa != null) {
                r0 += a.a.a.b.b.a.f(6, this.mwa);
            }
            return r0 + a.a.a.a.eL(7, this.mwb);
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
            bqx com_tencent_mm_protocal_c_bqx = (bqx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bqx.uoT = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqx.tky = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqx.mvX = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqx.uoU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqx.mvZ = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bqx.mwa = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bqx.mwb = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
