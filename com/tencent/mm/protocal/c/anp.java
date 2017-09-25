package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class anp extends a {
    public String jNj;
    public String jOp;
    public int leD;
    public int tAA;
    public int tLk;
    public String tSv;
    public String tjk;
    public String tsz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.leD);
            if (this.jOp != null) {
                aVar.e(2, this.jOp);
            }
            if (this.tjk != null) {
                aVar.e(3, this.tjk);
            }
            if (this.tsz != null) {
                aVar.e(4, this.tsz);
            }
            if (this.jNj != null) {
                aVar.e(5, this.jNj);
            }
            aVar.eO(6, this.tLk);
            aVar.eO(7, this.tAA);
            if (this.tSv != null) {
                aVar.e(8, this.tSv);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.leD) + 0;
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(2, this.jOp);
            }
            if (this.tjk != null) {
                r0 += a.a.a.b.b.a.f(3, this.tjk);
            }
            if (this.tsz != null) {
                r0 += a.a.a.b.b.a.f(4, this.tsz);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(5, this.jNj);
            }
            r0 = (r0 + a.a.a.a.eL(6, this.tLk)) + a.a.a.a.eL(7, this.tAA);
            if (this.tSv != null) {
                return r0 + a.a.a.b.b.a.f(8, this.tSv);
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
            anp com_tencent_mm_protocal_c_anp = (anp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_anp.leD = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anp.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_anp.tjk = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_anp.tsz = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_anp.jNj = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_anp.tLk = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_anp.tAA = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_anp.tSv = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
