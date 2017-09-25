package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bkj extends a {
    public long tvM;
    public long ujT;
    public int ukb;
    public int ukc;
    public int ukd;
    public int uke;
    public b ukf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.ujT);
            aVar.O(2, this.tvM);
            aVar.eO(3, this.ukb);
            aVar.eO(4, this.ukc);
            aVar.eO(5, this.ukd);
            aVar.eO(6, this.uke);
            if (this.ukf != null) {
                aVar.b(7, this.ukf);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((((a.a.a.a.N(1, this.ujT) + 0) + a.a.a.a.N(2, this.tvM)) + a.a.a.a.eL(3, this.ukb)) + a.a.a.a.eL(4, this.ukc)) + a.a.a.a.eL(5, this.ukd)) + a.a.a.a.eL(6, this.uke);
            if (this.ukf != null) {
                return r0 + a.a.a.a.a(7, this.ukf);
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
            bkj com_tencent_mm_protocal_c_bkj = (bkj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bkj.ujT = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkj.tvM = aVar3.xmD.mM();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkj.ukb = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bkj.ukc = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bkj.ukd = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkj.uke = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bkj.ukf = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
