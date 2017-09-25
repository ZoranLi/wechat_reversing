package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class amv extends a {
    public int tRo;
    public b tRp;
    public String tRq;
    public int tlr;
    public String tqb;
    public String tqc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tlr);
            aVar.eO(2, this.tRo);
            if (this.tRp != null) {
                aVar.b(3, this.tRp);
            }
            if (this.tRq != null) {
                aVar.e(4, this.tRq);
            }
            if (this.tqb != null) {
                aVar.e(5, this.tqb);
            }
            if (this.tqc != null) {
                aVar.e(6, this.tqc);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.tlr) + 0) + a.a.a.a.eL(2, this.tRo);
            if (this.tRp != null) {
                r0 += a.a.a.a.a(3, this.tRp);
            }
            if (this.tRq != null) {
                r0 += a.a.a.b.b.a.f(4, this.tRq);
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(5, this.tqb);
            }
            if (this.tqc != null) {
                return r0 + a.a.a.b.b.a.f(6, this.tqc);
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
            amv com_tencent_mm_protocal_c_amv = (amv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_amv.tlr = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amv.tRo = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amv.tRp = aVar3.cic();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_amv.tRq = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_amv.tqb = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_amv.tqc = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
