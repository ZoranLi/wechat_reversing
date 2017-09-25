package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bon extends a {
    public int jNd;
    public int jOc;
    public String mvU;
    public int ogM;
    public int tQw;
    public String tfi;
    public int und;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mvU != null) {
                aVar.e(1, this.mvU);
            }
            aVar.eO(2, this.jOc);
            aVar.eO(3, this.jNd);
            aVar.eO(4, this.ogM);
            aVar.eO(5, this.tQw);
            if (this.tfi != null) {
                aVar.e(6, this.tfi);
            }
            aVar.eO(7, this.und);
            return 0;
        } else if (i == 1) {
            if (this.mvU != null) {
                r0 = a.a.a.b.b.a.f(1, this.mvU) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.eL(2, this.jOc)) + a.a.a.a.eL(3, this.jNd)) + a.a.a.a.eL(4, this.ogM)) + a.a.a.a.eL(5, this.tQw);
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(6, this.tfi);
            }
            return r0 + a.a.a.a.eL(7, this.und);
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
            bon com_tencent_mm_protocal_c_bon = (bon) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bon.mvU = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bon.jOc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bon.jNd = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bon.ogM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bon.tQw = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bon.tfi = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bon.und = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
