package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bpg extends a {
    public LinkedList<bpe> unI = new LinkedList();
    public boolean unJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.unI);
            aVar.an(2, this.unJ);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 8, this.unI) + 0) + (a.a.a.b.b.a.cH(2) + 1);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.unI.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                bpg com_tencent_mm_protocal_c_bpg = (bpg) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_bpe = new bpe();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bpe.a(aVar4, com_tencent_mm_protocal_c_bpe, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bpg.unI.add(com_tencent_mm_protocal_c_bpe);
                        }
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bpg.unJ = aVar3.cib();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
