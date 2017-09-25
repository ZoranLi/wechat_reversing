package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class kp extends a {
    public b tqU;
    public LinkedList<b> tqV = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tqU != null) {
                aVar.b(1, this.tqU);
            }
            aVar.d(2, 6, this.tqV);
            return 0;
        } else if (i == 1) {
            if (this.tqU != null) {
                r0 = a.a.a.a.a(1, this.tqU) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(2, 6, this.tqV);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.tqV.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            kp kpVar = (kp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kpVar.tqU = aVar3.cic();
                    return 0;
                case 2:
                    kpVar.tqV.add(aVar3.cic());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
