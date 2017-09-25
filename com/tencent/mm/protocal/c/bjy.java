package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bjy extends a {
    public int ujy;
    public LinkedList<bjx> ujz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ujy);
            aVar.d(2, 8, this.ujz);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.eL(1, this.ujy) + 0) + a.a.a.a.c(2, 8, this.ujz);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.ujz.clear();
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
                bjy com_tencent_mm_protocal_c_bjy = (bjy) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_bjy.ujy = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_bjx = new bjx();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bjx.a(aVar4, com_tencent_mm_protocal_c_bjx, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bjy.ujz.add(com_tencent_mm_protocal_c_bjx);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
