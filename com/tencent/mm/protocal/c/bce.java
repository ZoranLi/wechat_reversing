package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bce extends a {
    public int jNd;
    public LinkedList<avx> jNe = new LinkedList();
    public String muQ;
    public long udq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.udq);
            if (this.muQ != null) {
                aVar.e(2, this.muQ);
            }
            aVar.eO(3, this.jNd);
            aVar.d(4, 8, this.jNe);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.udq) + 0;
            if (this.muQ != null) {
                r0 += a.a.a.b.b.a.f(2, this.muQ);
            }
            return (r0 + a.a.a.a.eL(3, this.jNd)) + a.a.a.a.c(4, 8, this.jNe);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.jNe.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            bce com_tencent_mm_protocal_c_bce = (bce) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bce.udq = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bce.muQ = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bce.jNd = aVar3.xmD.mL();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avx = new avx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bce.jNe.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
