package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class avo extends a {
    public int jOc;
    public LinkedList<avm> tZd = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jOc);
            aVar.d(2, 8, this.tZd);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.eL(1, this.jOc) + 0) + a.a.a.a.c(2, 8, this.tZd);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tZd.clear();
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
                avo com_tencent_mm_protocal_c_avo = (avo) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_avo.jOc = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_avm = new avm();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_avm.a(aVar4, com_tencent_mm_protocal_c_avm, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_avo.tZd.add(com_tencent_mm_protocal_c_avm);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
