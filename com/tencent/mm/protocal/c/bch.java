package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bch extends avh {
    public int jNd;
    public LinkedList<avx> jNe = new LinkedList();
    public String muQ;
    public int tce;
    public int tdM;
    public long udq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tce);
            aVar.O(3, this.udq);
            if (this.muQ != null) {
                aVar.e(4, this.muQ);
            }
            aVar.eO(5, this.jNd);
            aVar.d(6, 8, this.jNe);
            aVar.eO(7, this.tdM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tce)) + a.a.a.a.N(3, this.udq);
            if (this.muQ != null) {
                r0 += a.a.a.b.b.a.f(4, this.muQ);
            }
            return ((r0 + a.a.a.a.eL(5, this.jNd)) + a.a.a.a.c(6, 8, this.jNe)) + a.a.a.a.eL(7, this.tdM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.jNe.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bch com_tencent_mm_protocal_c_bch = (bch) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bch.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bch.tce = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bch.udq = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bch.muQ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bch.jNd = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bch.jNe.add(emVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bch.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
