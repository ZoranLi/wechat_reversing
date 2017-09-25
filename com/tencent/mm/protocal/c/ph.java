package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ph extends a {
    public int jNd;
    public LinkedList<aip> jNe = new LinkedList();
    public String tup;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tup != null) {
                aVar.e(1, this.tup);
            }
            aVar.eO(2, this.jNd);
            aVar.d(3, 8, this.jNe);
            return 0;
        } else if (i == 1) {
            if (this.tup != null) {
                r0 = a.a.a.b.b.a.f(1, this.tup) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.eL(2, this.jNd)) + a.a.a.a.c(3, 8, this.jNe);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.jNe.clear();
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
            ph phVar = (ph) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    phVar.tup = aVar3.xmD.readString();
                    return 0;
                case 2:
                    phVar.jNd = aVar3.xmD.mL();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aip = new aip();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aip.a(aVar4, com_tencent_mm_protocal_c_aip, a.a(aVar4))) {
                        }
                        phVar.jNe.add(com_tencent_mm_protocal_c_aip);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
