package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class alo extends a {
    public String fDC;
    public String ohq;
    public int tAL;
    public String tAM;
    public int tQs;
    public int tQt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.ohq == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else {
                aVar.eO(1, this.tQs);
                if (this.fDC != null) {
                    aVar.e(2, this.fDC);
                }
                if (this.ohq != null) {
                    aVar.e(3, this.ohq);
                }
                aVar.eO(4, this.tAL);
                if (this.tAM != null) {
                    aVar.e(5, this.tAM);
                }
                aVar.eO(6, this.tQt);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tQs) + 0;
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            if (this.ohq != null) {
                r0 += a.a.a.b.b.a.f(3, this.ohq);
            }
            r0 += a.a.a.a.eL(4, this.tAL);
            if (this.tAM != null) {
                r0 += a.a.a.b.b.a.f(5, this.tAM);
            }
            return r0 + a.a.a.a.eL(6, this.tQt);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.ohq != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            alo com_tencent_mm_protocal_c_alo = (alo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_alo.tQs = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alo.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alo.ohq = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alo.tAL = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alo.tAM = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_alo.tQt = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
