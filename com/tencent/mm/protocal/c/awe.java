package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class awe extends a {
    public String tNy;
    public LinkedList<cj> tZw = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.tZw);
            if (this.tNy != null) {
                aVar.e(2, this.tNy);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.tZw) + 0;
            if (this.tNy != null) {
                return r0 + a.a.a.b.b.a.f(2, this.tNy);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tZw.clear();
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
            awe com_tencent_mm_protocal_c_awe = (awe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a cjVar = new cj();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awe.tZw.add(cjVar);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awe.tNy = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
