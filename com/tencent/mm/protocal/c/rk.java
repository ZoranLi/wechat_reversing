package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class rk extends a {
    public long twV;
    public long twW;
    public LinkedList<bfd> twX = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.twV);
            aVar.O(2, this.twW);
            aVar.d(3, 8, this.twX);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.N(1, this.twV) + 0) + a.a.a.a.N(2, this.twW)) + a.a.a.a.c(3, 8, this.twX);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.twX.clear();
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
                rk rkVar = (rk) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        rkVar.twV = aVar3.xmD.mM();
                        return 0;
                    case 2:
                        rkVar.twW = aVar3.xmD.mM();
                        return 0;
                    case 3:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a com_tencent_mm_protocal_c_bfd = new bfd();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bfd.a(aVar4, com_tencent_mm_protocal_c_bfd, a.a(aVar4))) {
                            }
                            rkVar.twX.add(com_tencent_mm_protocal_c_bfd);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
