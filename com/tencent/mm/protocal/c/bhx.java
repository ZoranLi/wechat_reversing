package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bhx extends a {
    public int tce;
    public LinkedList<String> uhu = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tce);
            aVar.d(2, 1, this.uhu);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.eL(1, this.tce) + 0) + a.a.a.a.c(2, 1, this.uhu);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.uhu.clear();
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
                bhx com_tencent_mm_protocal_c_bhx = (bhx) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bhx.tce = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bhx.uhu.add(aVar3.xmD.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
