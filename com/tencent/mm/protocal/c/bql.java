package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class bql extends a {
    public b tkC;
    public LinkedList<bqi> tkD = new LinkedList();
    public String uoB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.uoB == null) {
                throw new a.a.a.b("Not all required fields were included: WxaUserName");
            }
            if (this.uoB != null) {
                aVar.e(1, this.uoB);
            }
            if (this.tkC != null) {
                aVar.b(2, this.tkC);
            }
            aVar.d(3, 8, this.tkD);
            return 0;
        } else if (i == 1) {
            if (this.uoB != null) {
                r0 = a.a.a.b.b.a.f(1, this.uoB) + 0;
            } else {
                r0 = 0;
            }
            if (this.tkC != null) {
                r0 += a.a.a.a.a(2, this.tkC);
            }
            return r0 + a.a.a.a.c(3, 8, this.tkD);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tkD.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uoB != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: WxaUserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bql com_tencent_mm_protocal_c_bql = (bql) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bql.uoB = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bql.tkC = aVar3.cic();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bqi = new bqi();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bqi.a(aVar4, com_tencent_mm_protocal_c_bqi, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bql.tkD.add(com_tencent_mm_protocal_c_bqi);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
