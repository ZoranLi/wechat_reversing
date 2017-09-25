package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bbz extends a {
    public int tYQ;
    public int udd;
    public LinkedList<bbg> ude = new LinkedList();
    public int udf;
    public int udg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.udd);
            aVar.d(2, 8, this.ude);
            aVar.eO(3, this.udf);
            aVar.eO(4, this.tYQ);
            aVar.eO(5, this.udg);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.eL(1, this.udd) + 0) + a.a.a.a.c(2, 8, this.ude)) + a.a.a.a.eL(3, this.udf)) + a.a.a.a.eL(4, this.tYQ)) + a.a.a.a.eL(5, this.udg);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.ude.clear();
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
                bbz com_tencent_mm_protocal_c_bbz = (bbz) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_bbz.udd = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_bbg = new bbg();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bbg.a(aVar4, com_tencent_mm_protocal_c_bbg, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bbz.ude.add(com_tencent_mm_protocal_c_bbg);
                        }
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bbz.udf = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bbz.tYQ = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_bbz.udg = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
