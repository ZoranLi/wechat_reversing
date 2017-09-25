package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bpi extends a {
    public String fFW;
    public int tlI;
    public int unN;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.unN);
            aVar.eO(2, this.tlI);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.fFW != null) {
                aVar.e(4, this.fFW);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.unN) + 0) + a.a.a.a.eL(2, this.tlI);
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(3, this.url);
            }
            if (this.fFW != null) {
                return r0 + a.a.a.b.b.a.f(4, this.fFW);
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
            bpi com_tencent_mm_protocal_c_bpi = (bpi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bpi.unN = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpi.tlI = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bpi.url = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bpi.fFW = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
