package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bds extends a {
    public int ueY;
    public int ueZ;
    public LinkedList<ans> ufa = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ueY);
            aVar.eO(2, this.ueZ);
            aVar.d(3, 8, this.ufa);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.eL(1, this.ueY) + 0) + a.a.a.a.eL(2, this.ueZ)) + a.a.a.a.c(3, 8, this.ufa);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.ufa.clear();
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
                bds com_tencent_mm_protocal_c_bds = (bds) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_bds.ueY = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bds.ueZ = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_ans = new ans();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_ans.a(aVar4, com_tencent_mm_protocal_c_ans, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bds.ufa.add(com_tencent_mm_protocal_c_ans);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
