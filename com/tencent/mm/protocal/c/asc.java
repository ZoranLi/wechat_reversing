package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class asc extends a {
    public int leR;
    public String leS;
    public int mNR;
    public String mNS;
    public int tVh;
    public int tWx;
    public int tWy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tVh);
            aVar.eO(2, this.tWy);
            aVar.eO(3, this.tWx);
            aVar.eO(4, this.leR);
            if (this.leS != null) {
                aVar.e(5, this.leS);
            }
            aVar.eO(6, this.mNR);
            if (this.mNS != null) {
                aVar.e(7, this.mNS);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.eL(1, this.tVh) + 0) + a.a.a.a.eL(2, this.tWy)) + a.a.a.a.eL(3, this.tWx)) + a.a.a.a.eL(4, this.leR);
            if (this.leS != null) {
                r0 += a.a.a.b.b.a.f(5, this.leS);
            }
            r0 += a.a.a.a.eL(6, this.mNR);
            if (this.mNS != null) {
                return r0 + a.a.a.b.b.a.f(7, this.mNS);
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
            asc com_tencent_mm_protocal_c_asc = (asc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_asc.tVh = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asc.tWy = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asc.tWx = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asc.leR = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asc.leS = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asc.mNR = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_asc.mNS = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
