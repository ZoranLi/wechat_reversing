package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bmy extends a {
    public String msk;
    public LinkedList<sh> ums = new LinkedList();
    public String umt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.umt == null) {
                throw new b("Not all required fields were included: Charset");
            }
            aVar.d(1, 8, this.ums);
            if (this.umt != null) {
                aVar.e(2, this.umt);
            }
            if (this.msk != null) {
                aVar.e(3, this.msk);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.ums) + 0;
            if (this.umt != null) {
                r0 += a.a.a.b.b.a.f(2, this.umt);
            }
            if (this.msk != null) {
                return r0 + a.a.a.b.b.a.f(3, this.msk);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ums.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.umt != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Charset");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bmy com_tencent_mm_protocal_c_bmy = (bmy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a shVar = new sh();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = shVar.a(aVar4, shVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bmy.ums.add(shVar);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bmy.umt = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bmy.msk = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
