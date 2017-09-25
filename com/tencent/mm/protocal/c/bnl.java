package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bnl extends a {
    public LinkedList<bne> tDS = new LinkedList();
    public int tll;
    public boolean umy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.tDS);
            aVar.eO(2, this.tll);
            aVar.an(3, this.umy);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.c(1, 8, this.tDS) + 0) + a.a.a.a.eL(2, this.tll)) + (a.a.a.b.b.a.cH(3) + 1);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tDS.clear();
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
                bnl com_tencent_mm_protocal_c_bnl = (bnl) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_bne = new bne();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bne.a(aVar4, com_tencent_mm_protocal_c_bne, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bnl.tDS.add(com_tencent_mm_protocal_c_bne);
                        }
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bnl.tll = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bnl.umy = aVar3.cib();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
