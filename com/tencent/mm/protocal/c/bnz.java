package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bnz extends a {
    public LinkedList<Integer> umR = new LinkedList();
    public boolean umS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 2, this.umR);
            aVar.an(2, this.umS);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.c(1, 2, this.umR) + 0) + (a.a.a.b.b.a.cH(2) + 1);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.umR.clear();
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
                bnz com_tencent_mm_protocal_c_bnz = (bnz) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bnz.umR.add(Integer.valueOf(aVar3.xmD.mL()));
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bnz.umS = aVar3.cib();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
