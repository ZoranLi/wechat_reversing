package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class art extends a {
    public int mOh;
    public LinkedList<asc> tWo = new LinkedList();
    public int tvL;
    public long tvM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tvL);
            aVar.O(2, this.tvM);
            aVar.d(3, 8, this.tWo);
            aVar.eO(4, this.mOh);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.eL(1, this.tvL) + 0) + a.a.a.a.N(2, this.tvM)) + a.a.a.a.c(3, 8, this.tWo)) + a.a.a.a.eL(4, this.mOh);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tWo.clear();
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
                art com_tencent_mm_protocal_c_art = (art) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_art.tvL = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_art.tvM = aVar3.xmD.mM();
                        return 0;
                    case 3:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_asc = new asc();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_asc.a(aVar4, com_tencent_mm_protocal_c_asc, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_art.tWo.add(com_tencent_mm_protocal_c_asc);
                        }
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_art.mOh = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
