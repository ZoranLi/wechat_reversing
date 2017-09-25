package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class gj extends a {
    public LinkedList<bqn> tkh = new LinkedList();
    public LinkedList<bqn> tki = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.tkh);
            aVar.d(2, 8, this.tki);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 8, this.tkh) + 0) + a.a.a.a.c(2, 8, this.tki);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tkh.clear();
                this.tki.clear();
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
                gj gjVar = (gj) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList En;
                int size;
                a com_tencent_mm_protocal_c_bqn;
                a.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            com_tencent_mm_protocal_c_bqn = new bqn();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_bqn.a(aVar4, com_tencent_mm_protocal_c_bqn, a.a(aVar4))) {
                            }
                            gjVar.tkh.add(com_tencent_mm_protocal_c_bqn);
                        }
                        return 0;
                    case 2:
                        En = aVar3.En(intValue);
                        size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            com_tencent_mm_protocal_c_bqn = new bqn();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_bqn.a(aVar4, com_tencent_mm_protocal_c_bqn, a.a(aVar4))) {
                            }
                            gjVar.tki.add(com_tencent_mm_protocal_c_bqn);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
