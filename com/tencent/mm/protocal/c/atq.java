package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class atq extends a {
    public int count;
    public int kBd;
    public LinkedList<atr> tXF = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.count);
            aVar.d(2, 8, this.tXF);
            aVar.eO(3, this.kBd);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.eL(1, this.count) + 0) + a.a.a.a.c(2, 8, this.tXF)) + a.a.a.a.eL(3, this.kBd);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tXF.clear();
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
                atq com_tencent_mm_protocal_c_atq = (atq) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_atq.count = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_atr = new atr();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_atr.a(aVar4, com_tencent_mm_protocal_c_atr, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_atq.tXF.add(com_tencent_mm_protocal_c_atr);
                        }
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_atq.kBd = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
