package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class afx extends a {
    public LinkedList<afy> tLa = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).d(1, 8, this.tLa);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.c(1, 8, this.tLa) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tLa.clear();
                a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar2 = (a.a.a.a.a) objArr[0];
                afx com_tencent_mm_protocal_c_afx = (afx) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList En = aVar2.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_afy = new afy();
                            a.a.a.a.a aVar3 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_afy.a(aVar3, com_tencent_mm_protocal_c_afy, a.a(aVar3))) {
                            }
                            com_tencent_mm_protocal_c_afx.tLa.add(com_tencent_mm_protocal_c_afy);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
