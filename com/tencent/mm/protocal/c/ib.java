package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class ib extends a {
    public b tmu;
    public b tmv;
    public LinkedList<aym> tmw = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tmu == null) {
                throw new a.a.a.b("Not all required fields were included: Title");
            } else if (this.tmv == null) {
                throw new a.a.a.b("Not all required fields were included: ServiceUrl");
            } else {
                if (this.tmu != null) {
                    aVar.b(1, this.tmu);
                }
                if (this.tmv != null) {
                    aVar.b(2, this.tmv);
                }
                aVar.d(3, 8, this.tmw);
                return 0;
            }
        } else if (i == 1) {
            if (this.tmu != null) {
                r0 = a.a.a.a.a(1, this.tmu) + 0;
            } else {
                r0 = 0;
            }
            if (this.tmv != null) {
                r0 += a.a.a.a.a(2, this.tmv);
            }
            return r0 + a.a.a.a.c(3, 8, this.tmw);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tmw.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tmu == null) {
                throw new a.a.a.b("Not all required fields were included: Title");
            } else if (this.tmv != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: ServiceUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ib ibVar = (ib) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ibVar.tmu = aVar3.cic();
                    return 0;
                case 2:
                    ibVar.tmv = aVar3.cic();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_aym = new aym();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aym.a(aVar4, com_tencent_mm_protocal_c_aym, a.a(aVar4))) {
                        }
                        ibVar.tmw.add(com_tencent_mm_protocal_c_aym);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
