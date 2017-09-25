package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bmb extends a {
    public String fDC;
    public String mQZ;
    public String msk;
    public String tVE;
    public int teT;
    public String tgW;
    public String ulO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC != null) {
                aVar.e(1, this.fDC);
            }
            if (this.tVE != null) {
                aVar.e(2, this.tVE);
            }
            if (this.mQZ != null) {
                aVar.e(3, this.mQZ);
            }
            if (this.msk != null) {
                aVar.e(4, this.msk);
            }
            if (this.ulO != null) {
                aVar.e(5, this.ulO);
            }
            aVar.eO(6, this.teT);
            if (this.tgW == null) {
                return 0;
            }
            aVar.e(7, this.tgW);
            return 0;
        } else if (i == 1) {
            if (this.fDC != null) {
                r0 = a.a.a.b.b.a.f(1, this.fDC) + 0;
            } else {
                r0 = 0;
            }
            if (this.tVE != null) {
                r0 += a.a.a.b.b.a.f(2, this.tVE);
            }
            if (this.mQZ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mQZ);
            }
            if (this.msk != null) {
                r0 += a.a.a.b.b.a.f(4, this.msk);
            }
            if (this.ulO != null) {
                r0 += a.a.a.b.b.a.f(5, this.ulO);
            }
            r0 += a.a.a.a.eL(6, this.teT);
            if (this.tgW != null) {
                r0 += a.a.a.b.b.a.f(7, this.tgW);
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
            bmb com_tencent_mm_protocal_c_bmb = (bmb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bmb.fDC = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bmb.tVE = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bmb.mQZ = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bmb.msk = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bmb.ulO = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bmb.teT = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bmb.tgW = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
