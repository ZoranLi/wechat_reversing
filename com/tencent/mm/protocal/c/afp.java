package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class afp extends a {
    public int major;
    public String mry;
    public LinkedList<afr> tKM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mry != null) {
                aVar.e(1, this.mry);
            }
            aVar.eO(2, this.major);
            aVar.d(3, 8, this.tKM);
            return 0;
        } else if (i == 1) {
            if (this.mry != null) {
                r0 = a.a.a.b.b.a.f(1, this.mry) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.eL(2, this.major)) + a.a.a.a.c(3, 8, this.tKM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tKM.clear();
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
            afp com_tencent_mm_protocal_c_afp = (afp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_afp.mry = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afp.major = aVar3.xmD.mL();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_afr = new afr();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_afr.a(aVar4, com_tencent_mm_protocal_c_afr, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afp.tKM.add(com_tencent_mm_protocal_c_afr);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
