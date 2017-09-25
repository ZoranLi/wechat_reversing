package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bfy extends a {
    public int ugr;
    public int ugs;
    public String ugt;
    public b ugu;
    public int ugv;
    public int ugw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ugr);
            aVar.eO(2, this.ugs);
            if (this.ugt != null) {
                aVar.e(3, this.ugt);
            }
            if (this.ugu != null) {
                aVar.b(4, this.ugu);
            }
            aVar.eO(5, this.ugv);
            aVar.eO(6, this.ugw);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.ugr) + 0) + a.a.a.a.eL(2, this.ugs);
            if (this.ugt != null) {
                r0 += a.a.a.b.b.a.f(3, this.ugt);
            }
            if (this.ugu != null) {
                r0 += a.a.a.a.a(4, this.ugu);
            }
            return (r0 + a.a.a.a.eL(5, this.ugv)) + a.a.a.a.eL(6, this.ugw);
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
            bfy com_tencent_mm_protocal_c_bfy = (bfy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bfy.ugr = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfy.ugs = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfy.ugt = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfy.ugu = aVar3.cic();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfy.ugv = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfy.ugw = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
