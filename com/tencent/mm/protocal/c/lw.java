package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class lw extends a {
    public String tsc;
    public String tsd;
    public LinkedList<als> tse = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tsc != null) {
                aVar.e(1, this.tsc);
            }
            if (this.tsd != null) {
                aVar.e(2, this.tsd);
            }
            aVar.d(3, 8, this.tse);
            return 0;
        } else if (i == 1) {
            if (this.tsc != null) {
                r0 = a.a.a.b.b.a.f(1, this.tsc) + 0;
            } else {
                r0 = 0;
            }
            if (this.tsd != null) {
                r0 += a.a.a.b.b.a.f(2, this.tsd);
            }
            return r0 + a.a.a.a.c(3, 8, this.tse);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tse.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            lw lwVar = (lw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lwVar.tsc = aVar3.xmD.readString();
                    return 0;
                case 2:
                    lwVar.tsd = aVar3.xmD.readString();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_als = new als();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_als.a(aVar4, com_tencent_mm_protocal_c_als, a.a(aVar4))) {
                        }
                        lwVar.tse.add(com_tencent_mm_protocal_c_als);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
