package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class akp extends a {
    public String leO;
    public int tOk;
    public aiz tOl;
    public int tOm;
    public long tOn;
    public int tdM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tdM);
            aVar.eO(2, this.tOk);
            if (this.tOl != null) {
                aVar.eQ(3, this.tOl.aUk());
                this.tOl.a(aVar);
            }
            aVar.eO(4, this.tOm);
            if (this.leO != null) {
                aVar.e(5, this.leO);
            }
            aVar.O(6, this.tOn);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.tdM) + 0) + a.a.a.a.eL(2, this.tOk);
            if (this.tOl != null) {
                r0 += a.a.a.a.eN(3, this.tOl.aUk());
            }
            r0 += a.a.a.a.eL(4, this.tOm);
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(5, this.leO);
            }
            return r0 + a.a.a.a.N(6, this.tOn);
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
            akp com_tencent_mm_protocal_c_akp = (akp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_akp.tdM = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akp.tOk = aVar3.xmD.mL();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aiz = new aiz();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akp.tOl = com_tencent_mm_protocal_c_aiz;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akp.tOm = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akp.leO = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akp.tOn = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
