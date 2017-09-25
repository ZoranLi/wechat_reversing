package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bbp extends a {
    public int tdM;
    public int ucG;
    public avx ucH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ucG);
            if (this.ucH != null) {
                aVar.eQ(2, this.ucH.aUk());
                this.ucH.a(aVar);
            }
            aVar.eO(3, this.tdM);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.ucG) + 0;
            if (this.ucH != null) {
                r0 += a.a.a.a.eN(2, this.ucH.aUk());
            }
            return r0 + a.a.a.a.eL(3, this.tdM);
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
            bbp com_tencent_mm_protocal_c_bbp = (bbp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bbp.ucG = aVar3.xmD.mL();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avx = new avx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbp.ucH = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbp.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
