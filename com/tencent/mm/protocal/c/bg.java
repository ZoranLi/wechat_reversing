package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bg extends a {
    public aif teG;
    public LinkedList<aig> teH = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.teG == null) {
                throw new b("Not all required fields were included: LogHead");
            }
            if (this.teG != null) {
                aVar.eQ(1, this.teG.aUk());
                this.teG.a(aVar);
            }
            aVar.d(2, 8, this.teH);
            return 0;
        } else if (i == 1) {
            if (this.teG != null) {
                r0 = a.a.a.a.eN(1, this.teG.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(2, 8, this.teH);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.teH.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.teG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LogHead");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bg bgVar = (bg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_aif;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aif = new aif();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aif.a(aVar4, com_tencent_mm_protocal_c_aif, a.a(aVar4))) {
                        }
                        bgVar.teG = com_tencent_mm_protocal_c_aif;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aif = new aig();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aif.a(aVar4, com_tencent_mm_protocal_c_aif, a.a(aVar4))) {
                        }
                        bgVar.teH.add(com_tencent_mm_protocal_c_aif);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
